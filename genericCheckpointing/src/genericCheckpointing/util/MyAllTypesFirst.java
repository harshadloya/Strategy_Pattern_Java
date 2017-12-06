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

	public int getMyInt() {
		return myInt;
	}

	public void setMyInt(int myIntIn) {
		myInt = myIntIn;
	}

	public int getMyOtherInt() {
		return myOtherInt;
	}

	public void setMyOtherInt(int myOtherIntIn) {
		myOtherInt = myOtherIntIn;
	}

	public long getMyLong() {
		return myLong;
	}

	public void setMyLong(long myLongIn) {
		myLong = myLongIn;
	}

	public long getMyOtherLong() {
		return myOtherLong;
	}

	public void setMyOtherLong(long myOtherLongIn) {
		myOtherLong = myOtherLongIn;
	}

	public String getMyString() {
		return myString;
	}

	public void setMyString(String myStringIn) {
		myString = myStringIn;
	}

	public boolean isMyBool() {
		return myBool;
	}

	public void setMyBool(boolean myBoolIn) {
		myBool = myBoolIn;
	}
}