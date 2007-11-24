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
	private long myIntValue;
	private final long myDefaultValue;
	
	public ZLColorOption (String category, String group, String optionName, ZLColor defaultValue) {
		super(category, group, optionName);
		myDefaultValue = defaultValue.getIntValue();
		myIntValue = myDefaultValue;
	}
	
	public long getValue() {
		if (!myIsSynchronized) {
			String strDefaultValue = ZLToStringConverter.convert(myDefaultValue);
			String value = myConfig.getValue(myGroup, myOptionName, strDefaultValue);
			myIntValue = ZLFromStringConverter.getIntegerValue(value);
			myIsSynchronized = true;
		}
		return myIntValue;
	}
	
	public void setValue(ZLColor colorValue) {
		long value = colorValue.getIntValue();
		if (myIsSynchronized && (myIntValue == value)) {
			return;
		}
		myIntValue = value;
		myIsSynchronized = true;
		if (myIntValue == myDefaultValue) {
			myConfig.unsetValue(myGroup, myOptionName);
		} else {
			String stringValue = ZLToStringConverter.convert(myIntValue);
			myConfig.setValue(myGroup, myOptionName, stringValue, myCategory);
		}
	}	
}
