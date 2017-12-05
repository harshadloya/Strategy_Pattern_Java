
package genericCheckpointing.driver;

import java.io.File;
import java.util.Vector;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;

// import the other types used in this file

public class Driver 
{
	public static void main(String[] args) 
	{
		// FIXME: read the value of checkpointFile from the command line
		if(args.length != 3)
		{
			System.err.println("Invalid Arguments, There should be 3 arguments.");
			System.exit(1);
		}

		String mode = args[0];
		if(!mode.equalsIgnoreCase("serdeser") || !mode.equalsIgnoreCase("deser"))
		{
			System.err.println("Invalid Mode, It can be either serdeser or deser only.");
			System.exit(1);
		}

		String N = args[1];
		if(!N.matches("\\d+"))
		{
			System.err.println("Invalid N, It should a number only.");
			System.exit(1);
		}
		int NUM_OF_OBJECTS = Integer.parseInt(N);

		String checkpointFile = args[2];

		ProxyCreator pc = new ProxyCreator();
		StoreRestoreHandler handler = new StoreRestoreHandler();

		// create a proxy
		StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(new Class[] {StoreI.class, RestoreI.class}, new StoreRestoreHandler());

		// FIXME: invoke a method on the handler instance to set the file name for checkpointFile and open the file
		handler.setCheckpointFile(new File(checkpointFile));
		handler.openFile();

		MyAllTypesFirst myFirst;
		MyAllTypesSecond  mySecond;
		
		Vector<SerializableObject> serDeserObjects = new Vector<SerializableObject>(NUM_OF_OBJECTS);
		
		// Use an if/switch to proceed according to the command line argument
		switch(mode)
		{
		case "serdeser":
			// The code below is for "serdeser" mode
			// For "serdeser" mode, both the serialize and deserialize functionality should be called.

			// create a data structure to store the objects being serialized
			//Vector<SerializableObject> serDeserObjects = new Vector<SerializableObject>(NUM_OF_OBJECTS);
			// NUM_OF_OBJECTS refers to the count for each of MyAllTypesFirst and MyAllTypesSecond
			for (int i=0; i<NUM_OF_OBJECTS; i++) 
			{
				// FIXME: create these object instances correctly using an explicit value constructor
				// use the index variable of this loop to change the values of the arguments to these constructors
				myFirst = new MyAllTypesFirst();
				mySecond = new MyAllTypesSecond();

				// FIXME: store myFirst and mySecond in the data structure
				((StoreI) cpointRef).writeObj(myFirst, "XML");
				((StoreI) cpointRef).writeObj(mySecond, "XML");

			}
		// For deser, just deserliaze the input file into the data structure and then print the objects
		case "deser":
			SerializableObject myRecordRet;

			// create a data structure to store the returned objects
			for (int j=0; j<2*NUM_OF_OBJECTS; j++) {

				myRecordRet = ((RestoreI) cpointRef).readObj("XML");
				// FIXME: store myRecordRet in the vector
				serDeserObjects.add(j, myRecordRet);
			}
			break;
		
		default:
			System.err.println("Invalid Mode");
			break;
		}

		// FIXME: invoke a method on the handler to close the file (if it hasn't already been closed)
		handler.closeFile();

		// FIXME: compare and confirm that the serialized and deserialzed objects are equal. 
		// The comparison should use the equals and hashCode methods. Note that hashCode 
		// is used for key-value based data structures
	}
}