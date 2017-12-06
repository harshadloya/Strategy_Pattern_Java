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

	public double getMyDoubleT() {
		return myDoubleT;
	}

	public void setMyDoubleT(double myDoubleTIn) {
		myDoubleT = myDoubleTIn;
	}

	public double getMyOtherDoubleT() {
		return myOtherDoubleT;
	}

	public void setMyOtherDoubleT(double myOtherDoubleTIn) {
		myOtherDoubleT = myOtherDoubleTIn;
	}

	public float getMyFloatT() {
		return myFloatT;
	}

	public void setMyFloatT(float myFloatTIn) {
		myFloatT = myFloatTIn;
	}

	public short getMyShortT() {
		return myShortT;
	}

	public void setMyShortT(short myShortTIn) {
		myShortT = myShortTIn;
	}

	public short getMyOtherShortT() {
		return myOtherShortT;
	}

	public void setMyOtherShortT(short myOtherShortTIn) {
		myOtherShortT = myOtherShortTIn;
	}

	public char getMyCharT() {
		return myCharT;
	}

	public void setMyCharT(char myCharTIn) {
		myCharT = myCharTIn;
	}
}