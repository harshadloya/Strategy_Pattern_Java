package genericCheckpointing.serDeser;

import java.util.Vector;

import genericCheckpointing.util.SerializableObject;

public interface DeserStrategy
{
	SerializableObject processInput(Vector<String> toDeser);
}