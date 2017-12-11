package genericCheckpointing.serDeser;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Vector;

import genericCheckpointing.util.SerializableObject;

public class XMLDeserializationStrategy implements DeserStrategy
{

	@Override
	public SerializableObject processInput(Vector<String> toDeser)
	{
		String objectClassNameLine = toDeser.get(1);
		objectClassNameLine = objectClassNameLine.replaceAll("\">", "");
		String[] temp = objectClassNameLine.split("=\"");
		Class<?> deserObjClass = null;
		Object deserObj = null;
		
		try
		{
			deserObjClass = Class.forName(temp[1]);
			deserObj = deserObjClass.newInstance();
			for(int index = 2; index < toDeser.size()-1; index++)
			{
				String fieldNameLine = toDeser.get(index).trim();
				String fieldsTemp[] = fieldNameLine.split("<|>| ");

				String fieldName = fieldsTemp[1];
				Field fld = deserObjClass.getDeclaredField(fieldName);
				String methodName = "set" + fieldName;
				String value = fieldsTemp[3];

				Method setterMethod = deserObjClass.getDeclaredMethod(methodName, fld.getType());
				Object invokeVal = null;
				switch(fld.getType().getSimpleName())
				{
				case "int":
					invokeVal = Integer.parseInt(value);
					break;
				case "float":
					invokeVal = Float.parseFloat(value);
					break;
				case "long":
					invokeVal = Long.parseLong(value);
					break;
				case "double":
					invokeVal = Double.parseDouble(value);
					break;
				case "String":
					invokeVal = value;
					break;
				case "boolean":
					invokeVal = Boolean.parseBoolean(value);
					break;
				case "char":
					invokeVal = value.charAt(0);
					break;
				case "short":
					invokeVal = Short.parseShort(value);
					break;
				default:
					System.err.println("Oops, This Data Type was not handled in Deserialization.");
					break;
				}
				setterMethod.invoke(deserObj, invokeVal);
			}
		}
		catch (ClassNotFoundException e)
		{
			System.err.println("Class with such name does not exists, try another.");
			e.printStackTrace();
			System.exit(1);
		}
		catch (InstantiationException e)
		{
			System.err.println("Cannot Instantiate, try another.");
			e.printStackTrace();
			System.exit(1);
		}
		catch (NoSuchMethodException e)
		{
			System.err.println("The method trying to be called doesn't exists, check the method name again.");
			e.printStackTrace();
			System.exit(1);
		}
		catch (SecurityException e)
		{
			System.err.println("The method trying to be called can't be accessed.");
			e.printStackTrace();
			System.exit(1);
		}
		catch (IllegalAccessException e)
		{
			System.err.println("Illegal Access to the method being called.");
			e.printStackTrace();
			System.exit(1);
		}
		catch (IllegalArgumentException e)
		{
			System.err.println("Illegal Argument passed to the method trying to be called.");
			e.printStackTrace();
			System.exit(1);
		}
		catch (InvocationTargetException e)
		{
			System.err.println("The invocation target is invalid, try again.");
			e.printStackTrace();
			System.exit(1);
		}
		catch (NoSuchFieldException e)
		{
			System.err.println("Such a field does not exists in the respective bean class, try another.");
			e.printStackTrace();
			System.exit(1);
		}

		return (SerializableObject) deserObj;
	}
}