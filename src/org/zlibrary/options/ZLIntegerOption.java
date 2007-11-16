package org.zlibrary.options;

import org.zlibrary.options.util.ZLFromStringConverter;
import org.zlibrary.options.util.ZLToStringConverter;

/**
 * ����� ������������� �����.
 * @author �������������
 *
 */
public final class ZLIntegerOption extends ZLOption{
	private long myValue;
	private final long myDefaultValue;
	
	public ZLIntegerOption (String category, String group, String optionName, long defaultValue) {
		super(category, group, optionName);
		myDefaultValue = defaultValue;
		myValue = myDefaultValue;
	}
	
	public long getValue() {
		if (!myIsSynchronized) {
			String strDefaultValue = ZLToStringConverter.convert(myDefaultValue);
			String value = myConfig.getValue(myCategory, myGroup, 
					myOptionName, strDefaultValue);
			myValue = ZLFromStringConverter.getLongValue(value);
			myIsSynchronized = true;
		}
		return myValue;
	}
	
	public void setValue(long value) {
		if (myIsSynchronized && (myValue == value)) {
			return;
		}
		myValue = value;
		myIsSynchronized = true;
		if (myValue == myDefaultValue) {
			myConfig.unsetValue(myCategory, myGroup, myOptionName);
		} else {
			String stringValue = ZLToStringConverter.convert(myValue);
			myConfig.setValue(myCategory, myGroup, myOptionName, stringValue);
		}
	}
}
