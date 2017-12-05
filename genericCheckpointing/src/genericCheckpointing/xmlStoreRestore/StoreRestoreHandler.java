package genericCheckpointing.xmlStoreRestore;

import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import genericCheckpointing.serDeser.SerStrategy;
import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;

public class StoreRestoreHandler implements InvocationHandler 
{
	private File checkpointFile;
	private FileProcessor checkpointFileProc;
	
	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable
	{
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