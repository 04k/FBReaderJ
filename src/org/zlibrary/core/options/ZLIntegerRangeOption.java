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
	private long myValue;
	private final long myDefaultValue;
	private final long myMinValue;
	private final long myMaxValue;
	
	public ZLIntegerRangeOption (String category, String group, String optionName, long minValue, long maxValue, long defaultValue) {
		super(category, group, optionName);
		myMinValue = minValue;
		myMaxValue = maxValue;
		myDefaultValue = Math.max(myMinValue, Math.min(myMaxValue, defaultValue));
		myValue = myDefaultValue;
	}
	
	public long getMinValue() {
		return myMinValue;
	}
	
	public long getMaxValue() {
		return myMaxValue;
	}
	
	public long getValue() {
		if (!myIsSynchronized) {
			String strDefaultValue = ZLToStringConverter.convert(myDefaultValue);
			String value = myConfig.getValue(myGroup, 
					myOptionName, strDefaultValue);
			myValue = ZLFromStringConverter.getLongValue(value);
			myIsSynchronized = true;
		}
		return myValue;
	}
	
	public void setValue(long value) {
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
