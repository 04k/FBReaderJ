package org.zlibrary.options.util;

import org.zlibrary.options.util.exceptions.*;

import java.awt.Color;

public class ZLColor {
	
	private byte myRed;
	private byte myGreen;
	private byte myBlue;
	
	public int getBlue() {
		return myBlue;
	}
	public int getGreen() {
		return myGreen;
	}
	public int getRed() {
		return myRed;
	}

	public void setBlue(byte mask) throws InvalidValueException{
		setColor(myRed, myGreen, mask);
	}
    
	public void setGreen(byte mask) throws InvalidValueException{
    	setColor(myRed, mask, myBlue);
	}
    
	public void setRed(byte mask) throws InvalidValueException{
		setColor(mask, myGreen, myBlue);
	}
	
	public boolean isInitialized(){
		return (myRed != -1);
	}
	/**
	 * ����������� ����� toString,
	 * �� ���� - ��������� � ���������� ������
	 */
	public String toString(){
		if (!isInitialized()){
			return "not initialized";
		} else {
			return "" + myRed + ", " + myGreen + ", " + myBlue;
		}
	}
	
	/**
	 * ����������� �� ��������� ������ ���� ������
	 */
	public ZLColor (){
		myRed = 0;
		myGreen = 0;
		myBlue = 0;
	}
	
	/**
	 * � �������������� ����� ���� ��������� ����� ���� ���� ��������
	 * ��� ������� � ��� ��� ���� �� ������� ������ ������ �������
	 * � ����� �������� ������ �����, �� ������� �� �� ��� ������
	 * �������� � ��� �� ����� �������� � ���������� � ����� �������
	 * �������� ���������� ���������� ����, ���� �� �� ���� ������
	 * ������� ���������� ���������� ����� �����, � ��������� ����� ����
	 * @param red
	 * @param green
	 * @param blue
	 */
	public void setColor (byte red, byte green, byte blue) throws InvalidValueException{
		if (! ((red >= -1) && (red < 256)) ){
			throw new InvalidValueException
					  (" Red Mask Value must stay between 0 and 255");
		}
		if (! ((green >= 0) && (green < 256)) ){
			throw new InvalidValueException
					  (" Green Mask Value must stay between 0 and 255");
		}
		if (! ((blue >= 0) && (blue < 256)) ){
			throw new InvalidValueException
					  (" Blue Mask Value must stay between 0 and 255");
		}
		myRed = red;
		myGreen = green;
		myBlue = blue;
		
	}
	/**
	 * ����������� � �����������
	 */
	public ZLColor (byte red, byte green, byte blue) throws InvalidValueException{
		setColor(red, green, blue);
	}
	
	/**
	 * ���� ����� ������� �������� ���������������
	 * ������ ���������. ����� ���������� ��� RGBColor ���� ��������
	 * �������� ��������� ��������� ��� ���� � ���-����
	 * @param color
	 */
	public void convertFromColor(Color color){
		myRed = (byte)color.getRed();
		myGreen = (byte)color.getGreen();
		myBlue = (byte)color.getBlue();
	}
	
	/**
	 * � ����������� �������������� ��� ��������
	 * @param color
	 * @throws InvalidValueException
	 */
	public ZLColor (Color color) throws InvalidValueException{
		setColor((byte)color.getRed(), (byte)color.getGreen(), (byte)color.getBlue());
	}
	
	/**
	 * @return ��� ���� ��� ������������ ���� �� awt
	 */
	public Color convertToColor(){
		return new Color(myRed, myGreen, myBlue);
	}
	
}
