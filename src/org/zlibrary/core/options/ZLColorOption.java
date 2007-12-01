package org.zlibrary.core.options;

import org.zlibrary.core.options.util.*;

/**
 * ����� ����� �����. ������ ����� ���� �������� ����� ������,
 * ����� ��������� ������� �� ������ (� ��� ����! =)), �� ���������
 * � ���� ����� ��� ����� �������������� � ������� ������ ZLColor, �������
 * ��������� ����� ��������� RGB ������������� �����. 
 * @author �������������
 *
 */
public final class ZLColorOption extends ZLOption {
	private int myIntValue;
	private final int myDefaultValue;
	
	public ZLColorOption (String category, String group, String optionName, ZLColor defaultValue) {
		super(category, group, optionName);
		myDefaultValue = defaultValue.getIntValue();
		myIntValue = myDefaultValue;
	}
	
	public int getValue() {
		if (!myIsSynchronized) {
			String value = myConfig.getValue(myGroup, myOptionName, null);
			if (value != null) {
				myIntValue = ZLFromStringConverter.getIntegerValue(value);
			}
			myIsSynchronized = true;
		}
		return myIntValue;
	}
	
	public void setValue(ZLColor colorValue) {
		int value = colorValue.getIntValue();
		if (myIsSynchronized && (myIntValue == value)) {
			return;
		}
		myIntValue = value;
		myIsSynchronized = true;
		String stringValue = ((Integer)myIntValue).toString();
		myConfig.setValue(myGroup, myOptionName, stringValue, myCategory);
	}	
}
