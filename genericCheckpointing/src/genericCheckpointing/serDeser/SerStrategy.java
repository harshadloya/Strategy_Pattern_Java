package genericCheckpointing.serDeser;

import genericCheckpointing.util.SerializableObject;

public interface SerStrategy 
{
	void processInput(SerializableObject sObject);
}
