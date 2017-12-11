package genericCheckpointing.util;

public class MyAllTypesSecond extends SerializableObject
{
	private double myDoubleT;
	private double myOtherDoubleT;
	private float myFloatT;
	private short myShortT;
	private short myOtherShortT;
	private char myCharT;
	
	public MyAllTypesSecond()
	{
		super();
	}

	public MyAllTypesSecond(double myDoubleTIn, double myOtherDoubleTIn, float myFloatTIn, short myShortTIn, short myOtherShortTIn, char myCharTIn)
	{
		super();
		myDoubleT = myDoubleTIn;
		myOtherDoubleT = myOtherDoubleTIn;
		myFloatT = myFloatTIn;
		myShortT = myShortTIn;
		myOtherShortT = myOtherShortTIn;
		myCharT = myCharTIn;
	}

	public double getmyDoubleT() {
		return myDoubleT;
	}

	public void setmyDoubleT(double myDoubleTIn) {
		myDoubleT = myDoubleTIn;
	}

	public double getmyOtherDoubleT() {
		return myOtherDoubleT;
	}

	public void setmyOtherDoubleT(double myOtherDoubleTIn) {
		myOtherDoubleT = myOtherDoubleTIn;
	}

	public float getmyFloatT() {
		return myFloatT;
	}

	public void setmyFloatT(float myFloatTIn) {
		myFloatT = myFloatTIn;
	}

	public short getmyShortT() {
		return myShortT;
	}

	public void setmyShortT(short myShortTIn) {
		myShortT = myShortTIn;
	}

	public short getmyOtherShortT() {
		return myOtherShortT;
	}

	public void setmyOtherShortT(short myOtherShortTIn) {
		myOtherShortT = myOtherShortTIn;
	}

	public char getmyCharT() {
		return myCharT;
	}

	public void setmyCharT(char myCharTIn) {
		myCharT = myCharTIn;
	}

	@Override
	public String toString()
	{
		return "MyAllTypesSecond : myDoubleT=" + myDoubleT + ", myOtherDoubleT=" + myOtherDoubleT + ", myFloatT="
				+ myFloatT + ", myShortT=" + myShortT + ", myOtherShortT=" + myOtherShortT + ", myCharT=" + myCharT;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + myCharT;
		long temp;
		temp = Double.doubleToLongBits(myDoubleT);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(myFloatT);
		temp = Double.doubleToLongBits(myOtherDoubleT);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + myOtherShortT;
		result = prime * result + myShortT;
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
		MyAllTypesSecond other = (MyAllTypesSecond) obj;
		if (myCharT != other.myCharT)
			return false;
		if (Double.doubleToLongBits(myDoubleT) != Double.doubleToLongBits(other.myDoubleT))
			return false;
		if (Float.floatToIntBits(myFloatT) != Float.floatToIntBits(other.myFloatT))
			return false;
		if (Double.doubleToLongBits(myOtherDoubleT) != Double.doubleToLongBits(other.myOtherDoubleT))
			return false;
		if (myOtherShortT != other.myOtherShortT)
			return false;
		if (myShortT != other.myShortT)
			return false;
		return true;
	}
}