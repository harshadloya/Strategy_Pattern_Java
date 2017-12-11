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

	@Override
	public String toString()
	{
		return "MyAllTypesFirst: myInt=" + myInt + ", myOtherInt=" + myOtherInt + ", myLong=" + myLong
				+ ", myOtherLong=" + myOtherLong + ", myString=" + myString + ", myBool=" + myBool;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (myBool ? 1231 : 1237);
		result = prime * result + myInt;
		result = prime * result + (int) (myLong ^ (myLong >>> 32));
		result = prime * result + myOtherInt;
		result = prime * result + (int) (myOtherLong ^ (myOtherLong >>> 32));
		result = prime * result + ((myString == null) ? 0 : myString.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyAllTypesFirst other = (MyAllTypesFirst) obj;
		if (myBool != other.myBool)
			return false;
		if (myInt != other.myInt)
			return false;
		if (myLong != other.myLong)
			return false;
		if (myOtherInt != other.myOtherInt)
			return false;
		if (myOtherLong != other.myOtherLong)
			return false;
		if (myString == null) {
			if (other.myString != null)
				return false;
		} else if (!myString.equals(other.myString))
			return false;
		return true;
	}
}