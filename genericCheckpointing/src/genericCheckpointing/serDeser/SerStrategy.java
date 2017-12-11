package genericCheckpointing.serDeser;

import java.util.Vector;

import genericCheckpointing.util.SerializableObject;

public interface SerStrategy 
{
	Vector<String> processInput(SerializableObject sObject);
}
