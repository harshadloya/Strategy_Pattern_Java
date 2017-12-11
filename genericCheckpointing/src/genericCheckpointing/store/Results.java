package genericCheckpointing.store;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import genericCheckpointing.util.FileDisplayInterface;
import genericCheckpointing.util.MyLogger;
import genericCheckpointing.util.StdoutDisplayInterface;

/**
 * Class that stores the result of operations performed on the referencer of this class.
 * <br>
 * This class also implements two interfaces used for displaying content in some file or on standard output
 * @author hloya
 *
 */
public class Results implements FileDisplayInterface, StdoutDisplayInterface
{
	/**
	 * Data member that stores the path of the output file in which results(data) stored in this class will be written
	 */
	//private String outputFilePath;
	
	/**
	 * Data member that stores the results(data) passed to this class  - required only within this class
	 */
	private HashMap<Integer, String> resultSetStrings;
	
	/**
	 * Counter used for storing result strings - required only within this class
	 */
	private int i;
	
	FileWriter writer = null;
	
	/**
	 * Default Constructor that initializes the data members
	 */
	public Results() 
	{
		super();
		MyLogger.writeMessage("Results class default constructor was called", MyLogger.DebugLevel.CONSTRUCTOR);
		resultSetStrings = new HashMap<Integer, String>();
		i = 0;
	}
	
	/**
	 * Parameterized constructor that initializes the data member to the specified paramter value.
	 * @param outputPath - provides the path of the output file in which results (data) will be written.
	 * @throws IOException 
	 */
	public Results(String outputPath) throws IOException
	{
		this();
		MyLogger.writeMessage("Results class parameterized constructor was called", MyLogger.DebugLevel.CONSTRUCTOR);
		writer = new FileWriter(outputPath, true);
	}

	@Override
	public void writeToScreen(String s)
	{
		//MyLogger.writeMessage(s, dLvl);
		System.out.println(s);
	}

	@Override
	public void writeScheduleToFile()
	{
		try 
		{
			/*String path = getOutputFilePath();
			String[] temp = path.split("output.tx");
			
			File tempOutputFile = new File(outputFilePath);
			String path = tempOutputFile.getAbsolutePath();
			String fileName = tempOutputFile.getName();
			String[] temp = path.split(fileName.substring(0, fileName.length()-1));
			
			File file = new File(temp[0]);
			boolean check = file.mkdirs();
			File outputFile = new File(path);*/
			
			/*if(check == true || file.exists())
			{
				if(outputFile.exists())
				{
					outputFile.delete();
				}
				else
				{
					outputFile.createNewFile();
				}*/
				
				for(int x = 0; x < resultSetStrings.size()-1; x++)
				{
					if(resultSetStrings.get(x) != null)
						writer.write(resultSetStrings.get(x) +"\n");
				}
				
				if(resultSetStrings.get(resultSetStrings.size()-1) != null)
					writer.write(resultSetStrings.get(resultSetStrings.size()-1));
				
				writer.flush();
				resultSetStrings.clear();
				i=0;
			/*}
			else
			{
				System.err.println("\nThe folders given in the path do not exist and cannot be created");
			}*/
		} 
		catch (IOException e) 
		{
			System.err.println("\nFile write cannot be completed");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void closeFile()
	{
		try
		{
			writer.close();
		}
		catch (IOException e)
		{
			System.err.println("\nFile close cannot be completed");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	/**
	 * Stores the result string passed into a data structure
	 * @param s - contains the count of words for which this method is called
	 */
	public void storeNewResult(String s)
	{
		resultSetStrings.put(i, s);
		i++;
	}

/*	*//**
	 * Accessor for output file's path
	 * @return path of output file
	 *//*
	public String getOutputFilePath() {
		return outputFilePath;
	}

	*//**
	 * Mutator for output file's path
	 * @param outputFilePath - specifies the path of the output file
	 *//*
	public void setOutputFilePath(String outputFilePath) {
		this.outputFilePath = outputFilePath;
	}*/
}
