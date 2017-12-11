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
				
				switch(fld.getType().getSimpleName())
				{
				case "int":
					int intVal = Integer.parseInt(invokeRet.toString());
					if(intVal < 10)
					{
						continue;	
					}
					break;
				case "float":
					float floatVal = Float.parseFloat(invokeRet.toString());
					if(floatVal < 10)
					{
						continue;	
					}
					break;
				case "long":
					long longVal = Long.parseLong(invokeRet.toString());
					if(longVal < 10)
					{
						continue;	
					}
					break;
				case "double":
					double doubleVal = Double.parseDouble(invokeRet.toString());
					if(doubleVal < 10)
					{
						continue;	
					}
					break;
				case "String":
					String stringVal = invokeRet.toString();
					if(stringVal.equals(""))
					{
						continue;	
					}
					break;
				case "boolean":
					//boolean boolVal = Boolean.parseBoolean(invokeRet.toString());
					break;
				case "char":
					//char charVal = invokeRet.toString().charAt(0);
					break;
				case "short":
					short shortVal = Short.parseShort(invokeRet.toString());
					if(shortVal < 10)
					{
						continue;	
					}
					break;
				default:
					System.err.println("Oops, This Data Type was not handled in Deserialization.");
					break;
				}
				
				processedInput.add(serializeHelper.serialize(invokeRet, fieldName, fld.getType().getSimpleName().toLowerCase()));	
				/*if(!((int)invokeRet < 10) && !((long)invokeRet < 10l) && !((double)invokeRet < 10.0d) && !((float)invokeRet < 10.0f) && !invokeRet.equals("") && !((short)invokeRet < 10))
				{
					processedInput.add(serializeHelper.serialize(invokeRet, fieldName, fld.getType().getSimpleName().toLowerCase()));
				}*/
			}
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
		return processedInput;
	}
}