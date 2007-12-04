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
				try {
					Integer intValue = Integer.parseInt(value);
					myIntValue = intValue;
				} catch (NumberFormatException e) {
					//System.err.println(e);
				}
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
		if (myIntValue == myDefaultValue) {
            myConfig.unsetValue(myGroup, myOptionName);
		} else {
			myConfig.setValue(myGroup, myOptionName, "" + myIntValue, myCategory);
		}
	}	
}
