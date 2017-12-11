package genericCheckpointing.xmlStoreRestore;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Vector;

import genericCheckpointing.serDeser.SerStrategy;
import genericCheckpointing.serDeser.XMLSerializationStrategy;
import genericCheckpointing.store.Results;
import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;

public class StoreRestoreHandler implements InvocationHandler 
{
	private File checkpointFile;
	private FileProcessor checkpointFileProc;
	private Results checkpointFileRes;

	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable
	{
		//Use reflection to find type from args - could be either myalltypes1st or 2nd ?? Where/Why needed - not sure yet
		if(m.getName().equals("writeObj"))
		{
			System.out.println("Write Method Was Called");
			if(args[2].equals("XML"))
			{
				serializeData((SerializableObject) args[0], new XMLSerializationStrategy());
				checkpointFileRes.writeScheduleToFile();
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
		checkpointFileRes.storeNewResult("<DPSerialization>");
		String objectTypeStart = "\t<complexType xsi:type=\""+sObject.getClass().getName()+"\">";
		checkpointFileRes.storeNewResult(objectTypeStart);
		Vector<String> serializedStrings = sStrategy.processInput(sObject);
		for(int x = 0; x<serializedStrings.size(); x++)
		{
			checkpointFileRes.storeNewResult(serializedStrings.get(x));
		}
		checkpointFileRes.storeNewResult("\t</complexType>");
		checkpointFileRes.storeNewResult("</DPSerialization>");
	}

	public void openFile()
	{
		if(!checkpointFile.exists())
		{
			String path = checkpointFile.getAbsolutePath();
			String fileName = checkpointFile.getName();
			String[] temp = path.split(fileName.substring(0, fileName.length()-1));

			File file = new File(temp[0]);
			file.mkdirs();

			try
			{
				checkpointFile.createNewFile();
				checkpointFileRes = new Results(checkpointFile.getPath());
			}
			catch (IOException e) 
			{
				System.err.println("\nFile cannot be created");
				e.printStackTrace();
				System.exit(1);
			}
		}
		checkpointFileProc = new FileProcessor(checkpointFile.getPath());
	}

	public void closeFile()
	{
		if(checkpointFileRes != null)
		{
			checkpointFileRes.closeFile();
		}
		checkpointFileProc.closeFile();
	}

	public File getCheckpointFile()
	{
		return checkpointFile;
	}

	public void setCheckpointFile(File checkpointFileIn)
	{
		checkpointFile = checkpointFileIn;
	}
}