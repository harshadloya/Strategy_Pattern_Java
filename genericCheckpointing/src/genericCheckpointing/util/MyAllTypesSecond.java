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
}