package genericCheckpointing.util;

public class SerializeTypes
{
	/*public String serializeInt(int value, String tagName)
	{
		return "<"+ tagName +"xsi:type=\"xsd:int\">"+value+"</" + tagName + ">";
	}
	
	public String serializeLong(long value, String tagName)
	{
		return "<"+ tagName +"xsi:type=\"xsd:int\">"+value+"</" + tagName + ">";
	}
	
	public String serializeBool(boolean value, String tagName)
	{
		return "<"+ tagName +"xsi:type=\"xsd:int\">"+value+"</" + tagName + ">";
	}*/
	
	public String serialize(Object value, String tagName, String valueType)
	{
		return "\t\t<"+ tagName +" xsi:type=\"xsd:"+valueType+"\">"+value+"</" + tagName + ">";
	}
}