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
				if(!invokeRet.equals(0) && !invokeRet.equals(0l) && !invokeRet.equals(0.0d) && !invokeRet.equals(0.0f) && !invokeRet.equals("") && !invokeRet.equals((short)0))
				{
					processedInput.add(serializeHelper.serialize(invokeRet, fieldName, fld.getType().getSimpleName().toLowerCase()));
				}
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