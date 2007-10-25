package org.zlibrary.options;

import org.zlibrary.options.util.*;

/**
 * ����� ����� �����. ������ ����� ���� �������� ����� ������,
 * ����� ��������� ������� �� ������ (� ��� ����! =)), �� ���������
 * � ���� ����� ��� ����� �������������� � ������� ������ ZLColor, �������
 * ��������� ����� ��������� RGB ������������� �����. 
 * @author �������������
 *
 */
public final class ZLColorOption extends ZLOption{
	
	private long myIntValue;
	private long myDefaultIntValue;
	
	public long getValue(){
		return myIntValue;
	}
	
	public void setValue(ZLColor value){
		myIntValue = value.getIntValue();
	}

	public void setValueToDefault(){
		myIntValue = myDefaultIntValue;
	}
	
	public ZLColorOption (String category, String group, String optionName, ZLColor defaultValue){
		super(category, group, optionName);
		myDefaultIntValue = defaultValue.getIntValue();
		myIntValue = myDefaultIntValue;
	}
	
}
