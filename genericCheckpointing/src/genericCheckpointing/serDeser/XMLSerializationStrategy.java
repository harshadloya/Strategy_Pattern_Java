package genericCheckpointing.serDeser;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import genericCheckpointing.util.SerializableObject;

public class XMLSerializationStrategy implements SerStrategy
{
	@Override
	public void processInput(SerializableObject sObject) 
	{
		// all the code to create the output file with XML snippets for
		// an object
		System.out.println("kaam Karaychae aahe ikde");
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
				
				switch(fld.getType().getName())
				{
					case "int":
						System.out.println(invokeRet);
						break;
					case "long":
						System.out.println(invokeRet);
						break;
					case "String":
						System.out.println(invokeRet);
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
						break;
				}
				
				/*if(fld.getType() == int.class)
				{
					System.out.println(invokeRet);
				}
				else if(fld.getType() == long.class)
				{
					System.out.println(invokeRet);
				}
				else if(fld.getType() == String.class)
				{
					System.out.println(invokeRet);
				}
				else if(fld.getType() == boolean.class)
				{
					System.out.println(invokeRet);
				}
				else if(fld.getType() == double.class)
				{
					System.out.println(invokeRet);
				}
				else if(fld.getType() == float.class)
				{
					System.out.println(invokeRet);
				}
				else if(fld.getType() == short.class)
				{
					System.out.println(invokeRet);
				}
				else if(fld.getType() == char.class)
				{
					System.out.println(invokeRet);
				}*/
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
	}
}
