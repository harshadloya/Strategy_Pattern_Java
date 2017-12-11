package genericCheckpointing.serDeser;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Vector;

import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.SerializeTypes;

public class XMLSerializationStrategy implements SerStrategy
{
	@Override
	public Vector<String> processInput(SerializableObject sObject) 
	{
		// all the code to create the output file with XML snippets for
		// an object
		System.out.println("kaam Karaychae aahe ikde");
		Vector<String> processedInput = new Vector<String>();
		SerializeTypes serializeHelper = new SerializeTypes();
		
		Class<?> cls = sObject.getClass();
		Field[] fields = cls.getDeclaredFields();
		try
		{
			for(Field fld : fields)
			{
				String fieldName = fld.getName();
				String methodName = "";
				if(!fieldName.equals("myBool"))
				{
					methodName = "get" + fieldName;
				}
				else
				{
					methodName = "is" + fieldName;
				}
				
				Method getterMethod = cls.getMethod(methodName);
				Object invokeRet = getterMethod.invoke(sObject);
				
				/*switch(fld.getType().getName())
				{
					case "int":
						System.out.println(invokeRet);
						processedInput.add(serializeHelper.serialize(invokeRet, fieldName));
						break;
					case "long":
						System.out.println(invokeRet);
						processedInput.add(serializeHelper.serialize(invokeRet, fieldName));
						break;
					case "String":
						System.out.println(invokeRet);
						processedInput.add(serializeHelper.serialize(invokeRet, fieldName));
						break;
					case "boolean":
						System.out.println(invokeRet);
						break;
					case "double":
						System.out.println(invokeRet);
						break;
					case "float":
						System.out.println(invokeRet);
						break;
					case "short":
						System.out.println(invokeRet);
						break;
					case "char":
						System.out.println(invokeRet);
						break;
					default:
						System.out.println("Oops, Kuch toh Handle karna Bhul Gya.");
						break;
				}*/
				processedInput.add(serializeHelper.serialize(invokeRet, fieldName));
			}
		}
		catch (NoSuchMethodException e)
		{
			e.printStackTrace();
		}
		catch (SecurityException e)
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		catch (InvocationTargetException e)
		{
			e.printStackTrace();
		}
		return processedInput;
	}
}