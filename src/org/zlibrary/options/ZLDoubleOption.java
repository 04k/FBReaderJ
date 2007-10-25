package org.zlibrary.options;

/**
 * ����� ������� �����.
 * @author �������������
 *
 */
public final class ZLDoubleOption extends ZLOption{
	
	private double myValue;
	private double myDefaultValue;
	
	public double getValue(){
		return myValue;
	}
	
	public void setValue(double value){
		myValue = value;
	}

	public void setValueToDefault(){
		myValue = myDefaultValue;
	}
	
	public ZLDoubleOption (String category, String group, String optionName, double defaultValue){
		super(category, group, optionName);
		myDefaultValue = defaultValue;
		myValue = myDefaultValue;
	}
	
}
