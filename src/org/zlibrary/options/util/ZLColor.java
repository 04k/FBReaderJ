package org.zlibrary.options.util;

import java.awt.Color;

/**
 * �������� "����". ������������� ����� - ����������� RGB ����������
 * @author �������������
 *
 */
public class ZLColor {
	
	private int myRed = 0;
	private int myGreen = 0;
	private int myBlue = 0;
	
	/**
	 * ����������� ����� toString,
	 * �� ���� - ��������� � ���������� ������
	 */
	public String toString(){
		return "" + myRed + ", " + myGreen + ", " + myBlue;
	}
	
	/**
	 * �������� �� ����� ���������� ��������� ���������� ��� �����.
	 */
	private boolean isCorrectComponent(int value){
		return (value >=0 && value <= 255);
	}
	/**
	 * ������������� ������ �� ����������, ������� ������ ���������,
	 * �� ���� �������� ��������������� ������ < 256
	 */
	public void setColor (int red, int green, int blue){
		if (isCorrectComponent(red))
			myRed = red;
	    if (isCorrectComponent(green))
			myGreen = green;
		if (isCorrectComponent(blue))	
			myBlue = blue;
	}
	
	/**
	 * ��������������� � ������� ����.
	 * @param color
	 */
	//TODO ������ ����� �� ��� ������
	public void convertFromColor(Color color){
		myRed = (int)color.getRed();
		myGreen = (int)color.getGreen();
		myBlue = (int)color.getBlue();
	}
	
	public Color convertToColor(){
		return new Color(myRed, myGreen, myBlue);
	}
	
	/**
	 * � ����������� �������������� ��� ��������
	 * @param color
	 * @throws InvalidValueException
	 */
	public ZLColor (Color color){
		setColor((int)color.getRed(), (int)color.getGreen(), (int)color.getBlue());
	}

	/**
	 * @return ���� ����� ������, ����� ������� � ������ ������ =)
	 */	
	public int getIntValue(){
		return myRed*1000000 + myGreen*1000 + myBlue;
	}
	
	/**
	 * ����������� �� ��������� ������ ���� ������
	 */
	public ZLColor (){
	}
	
	/**
	 * ����������� � �����������
	 */
	public ZLColor (int red, int green, int blue){
		setColor(red, green, blue);
	}
	
	
}
