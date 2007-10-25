package org.zlibrary.options;

/**
 * ����� ������������� ������������� �����. ���� ������� � ������
 * �������, ������� ��� �� � �����������.
 * @author �������������
 *
 */
public final class ZLIntegerRangeOption extends ZLOption{
	private long myValue;
	private long myDefaultValue;
	private long myMinValue;
	private long myMaxValue;
	
	public long getValue(){
		return myValue;
	}
	
	public long getMinValue(){
		return myMinValue;
	}
	
	public long getMaxValue(){
		return myMaxValue;
	}
	
	public void setValue(long value){
		if ((myMinValue <= value) && (myMaxValue >= value))
			myValue = value;
	}
	
	public void setValueToDefault(){
		myValue = myDefaultValue;
	}
	
	public ZLIntegerRangeOption (String category, String group, String optionName, long minValue, long maxValue, long defaultValue){
		super(category, group, optionName);
		myMinValue = minValue;
		myMaxValue = maxValue;
		//���������� �� ������ ������������ =)
		if ((myMinValue <= defaultValue) && (myMaxValue >= defaultValue))
			myDefaultValue = defaultValue;
		else
			myDefaultValue = myMinValue;
		myValue = myDefaultValue;
	}
	
}
