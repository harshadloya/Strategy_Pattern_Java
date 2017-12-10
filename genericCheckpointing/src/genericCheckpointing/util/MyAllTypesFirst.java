package genericCheckpointing.util;

public class MyAllTypesFirst extends SerializableObject
{
	private int myInt;
	private int myOtherInt;
	private long myLong;
	private long myOtherLong;
	private String myString;
	private boolean myBool;
	
	public MyAllTypesFirst()
	{
		super();
	}

	public MyAllTypesFirst(int myIntIn, int myOtherIntIn, long myLongIn, long myOtherLongIn, String myStringIn, boolean myBoolIn) 
	{
		super();
		myInt = myIntIn;
		myOtherInt = myOtherIntIn;
		myLong = myLongIn;
		myOtherLong = myOtherLongIn;
		myString = myStringIn;
		myBool = myBoolIn;
	}

	public int getmyInt() {
		return myInt;
	}

	public void setmyInt(int myIntIn) {
		myInt = myIntIn;
	}

	public int getmyOtherInt() {
		return myOtherInt;
	}

	public void setmyOtherInt(int myOtherIntIn) {
		myOtherInt = myOtherIntIn;
	}

	public long getmyLong() {
		return myLong;
	}

	public void setmyLong(long myLongIn) {
		myLong = myLongIn;
	}

	public long getmyOtherLong() {
		return myOtherLong;
	}

	public void setmyOtherLong(long myOtherLongIn) {
		myOtherLong = myOtherLongIn;
	}

	public String getmyString() {
		return myString;
	}

	public void setmyString(String myStringIn) {
		myString = myStringIn;
	}

	public boolean ismyBool() {
		return myBool;
	}

	public void setmyBool(boolean myBoolIn) {
		myBool = myBoolIn;
	}
}