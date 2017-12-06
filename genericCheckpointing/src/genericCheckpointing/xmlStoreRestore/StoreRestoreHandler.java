package genericCheckpointing.xmlStoreRestore;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import genericCheckpointing.serDeser.SerStrategy;
import genericCheckpointing.serDeser.XMLSerializationStrategy;
import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;

public class StoreRestoreHandler implements InvocationHandler 
{
	private File checkpointFile;
	private FileProcessor checkpointFileProc;

	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable
	{
		//Use reflection to find type from args - could be either myalltypes1st or 2nd ?? Where/Why needed - not sure yet
		if(m.getName().equals("writeObj"))
		{
			System.out.println("Write Method Was Called");
			if(args[2].equals("XML"))
			{
				serializeData((SerializableObject) args[0], new XMLSerializationStrategy());
				System.out.println("Thamba");
			}
		}
		else if(m.getName().equals("readObj"))
		{
			System.out.println("Read Method Was Called");
		}
			
		return null;
		// if the method is write
		// if the wireFormat is XML
		//  call serializeData(args[0], new XMLSerializationStrategy());

		// if statements to check if it is the read method so that
		// deserialization can be done ... 
	}

	public void serializeData(SerializableObject sObject, SerStrategy sStrategy) 
	{
		sStrategy.processInput(sObject);
	}

	public void openFile()
	{
		if(!checkpointFile.exists())
		{
			String path = checkpointFile.getAbsolutePath();
			String[] temp = path.split("output.*.tx");

			File file = new File(temp[0]);
			file.mkdirs();

			try
			{
				checkpointFile.createNewFile();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		checkpointFileProc = new FileProcessor(checkpointFile.getPath());
	}

	public void closeFile()
	{
		checkpointFileProc.closeFile();
	}

	public File getCheckpointFile() {
		return checkpointFile;
	}

	public void setCheckpointFile(File checkpointFileIn) {
		checkpointFile = checkpointFileIn;
	}
}