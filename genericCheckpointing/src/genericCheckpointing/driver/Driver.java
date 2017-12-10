
package genericCheckpointing.driver;

import java.io.File;
import java.util.Random;
import java.util.Vector;

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
		if(!mode.equalsIgnoreCase("serdeser") && !mode.equalsIgnoreCase("deser"))
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
		StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(new Class[] {StoreI.class, RestoreI.class}, handler);

		// FIXME: invoke a method on the handler instance to set the file name for checkpointFile and open the file
		handler.setCheckpointFile(new File(checkpointFile));
		handler.openFile();

		MyAllTypesFirst myFirst;
		MyAllTypesSecond  mySecond;
		
		// Use an if/switch to proceed according to the command line argument
		switch(mode)
		{
		case "serdeser":
			// The code below is for "serdeser" mode
			// For "serdeser" mode, both the serialize and deserialize functionality should be called.

			// create a data structure to store the objects being serialized
			Vector<SerializableObject> serDeserObjects = new Vector<SerializableObject>(NUM_OF_OBJECTS);
			// NUM_OF_OBJECTS refers to the count for each of MyAllTypesFirst and MyAllTypesSecond
			Random r = new Random();
			for (int i=0; i<NUM_OF_OBJECTS; i++) 
			{
				// FIXME: create these object instances correctly using an explicit value constructor
				// use the index variable of this loop to change the values of the arguments to these constructors
				if(0 == i%2)
				{
					myFirst = new MyAllTypesFirst(i, i+20, i*1024, i*2048+i/8, "DesignPattern-"+i, true);
				}
				else
				{
					myFirst = new MyAllTypesFirst(i, i+20, i*1024, i*2048+i/8, "DesignPattern-"+i, false);
				}
				
				mySecond = new MyAllTypesSecond(i*10d, i*50+i/(10+r.nextDouble()), i*(i+r.nextFloat()), (short)(i+r.nextInt(1000)), (short)(i*+r.nextInt(1000)), (char)(48+r.nextInt(75)));

				// FIXME: store myFirst and mySecond in the data structure
				serDeserObjects.add(myFirst);
				serDeserObjects.add(mySecond);
				
				((StoreI) cpointRef).writeObj(myFirst, r.nextInt(9999), "XML");
				((StoreI) cpointRef).writeObj(mySecond, r.nextInt(9999), "XML");

			}
			
			SerializableObject myRecordRet;

			// create a data structure to store the returned objects
			Vector<SerializableObject> serDeserObjectsNew = new Vector<SerializableObject>(NUM_OF_OBJECTS);
			for (int j=0; j<2*NUM_OF_OBJECTS; j++)
			{
				myRecordRet = ((RestoreI) cpointRef).readObj("XML");
				// FIXME: store myRecordRet in the vector
				serDeserObjectsNew.add(j, myRecordRet);
			}
			break;
		// For deser, just deserliaze the input file into the data structure and then print the objects
		case "deser":
			
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