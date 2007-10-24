package org.zlibrary.options.util;

import java.awt.Color;

public class ZLColor {
	
	private int myRed;
	private int myGreen;
	private int myBlue;
	
	public int getBlue() {
		return myBlue;
	}
	public int getGreen() {
		return myGreen;
	}
	public int getRed() {
		return myRed;
	}

	public void setBlue(int mask){
		setColor(myRed, myGreen, mask);
	}
    
	public void setGreen(int mask){
    	setColor(myRed, mask, myBlue);
	}
    
	public void setRed(int mask){
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
	public void setColor (int red, int green, int blue){
		myRed = red;
		myGreen = green;
		myBlue = blue;
	}
	/**
	 * ����������� � �����������
	 */
	public ZLColor (int red, int green, int blue){
		setColor(red, green, blue);
	}
	
	/**
	 * ���� ����� ������� �������� ���������������
	 * ������ ���������. ����� ���������� ��� RGBColor ���� ��������
	 * �������� ��������� ��������� ��� ���� � ���-����
	 * @param color
	 */
	public void convertFromColor(Color color){
		myRed = (int)color.getRed();
		myGreen = (int)color.getGreen();
		myBlue = (int)color.getBlue();
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
	 * @return ��� ���� ��� ������������ ���� �� awt
	 */
	public Color convertToColor(){
		return new Color(myRed, myGreen, myBlue);
	}
	
	public int getIntValue(){
		//TODO ����������� ����� ����� ������
		return 0;
	}
}
