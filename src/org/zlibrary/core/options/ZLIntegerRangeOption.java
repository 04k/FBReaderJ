package org.zlibrary.core.options;

import org.zlibrary.core.options.util.ZLFromStringConverter;
import org.zlibrary.core.options.util.ZLToStringConverter;

/**
 * ����� ������������� ������������� �����. ���� ������� � ������
 * �������, ������� ��� �� � �����������.
 * @author �������������
 *
 */
public final class ZLIntegerRangeOption extends ZLOption {
	private int myValue;
	private final int myDefaultValue;
	private final int myMinValue;
	private final int myMaxValue;
	
	public ZLIntegerRangeOption (String category, String group, String optionName, int minValue, int maxValue, int defaultValue) {
		super(category, group, optionName);
		myMinValue = minValue;
		myMaxValue = maxValue;
		myDefaultValue = Math.max(myMinValue, Math.min(myMaxValue, defaultValue));
		myValue = myDefaultValue;
	}
	
	public int getMinValue() {
		return myMinValue;
	}
	
	public int getMaxValue() {
		return myMaxValue;
	}
	
	public int getValue() {
		if (!myIsSynchronized) {
			String strDefaultValue = ZLToStringConverter.convert(myDefaultValue);
			String value = myConfig.getValue(myGroup, 
					myOptionName, strDefaultValue);
			myValue = ZLFromStringConverter.getIntegerValue(value);
			myIsSynchronized = true;
		}
		return myValue;
	}
	
	public void setValue(int value) {
		if ((value <= myMaxValue) && (value >= myMinValue)) {
			if (myIsSynchronized && (myValue == value)) {
				return;
			}
			myValue = value;
			myIsSynchronized = true;
			if (myValue == myDefaultValue) {
				myConfig.unsetValue(myGroup, myOptionName);
			} else {
				String stringValue = ZLToStringConverter.convert(myValue);
				myConfig.setValue(myGroup, myOptionName, stringValue, myCategory);
			}
		}
	}	
}
