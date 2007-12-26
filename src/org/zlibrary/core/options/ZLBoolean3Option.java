package org.zlibrary.core.options;

import org.zlibrary.core.util.ZLBoolean3;

/**
 * ����� ����� �� ��������� �� ����������� ������ �������� ������ "������",
 * "����" � "�� ����".
 * 
 * @author �������������
 * 
 */
public final class ZLBoolean3Option extends ZLOption implements ZLSimpleOption {

	private ZLBoolean3 myValue;

	private final ZLBoolean3 myDefaultValue;

	public ZLBoolean3Option(String category, String group, String optionName,
			ZLBoolean3 defaultValue) {
		super(category, group, optionName);
		if (defaultValue != null) {
			myDefaultValue = defaultValue;
		} else {
			myDefaultValue = ZLBoolean3.B3_UNDEFINED;
		}
		myValue = myDefaultValue;
	}

	public ZLOptionType getType() {
		return ZLOptionType.TYPE_BOOLEAN3;
	}

	public ZLBoolean3 getValue() {
		if (!myIsSynchronized) {
			String value = getConfigValue(null);
			if (value != null) {
				myValue = ZLBoolean3.getByString(value);
			}
			myIsSynchronized = true;
		}
		return myValue;
	}

	public void setValue(ZLBoolean3 value) {
		if (myIsSynchronized && (myValue == value)) {
			return;
		}
		if (value != null) {
			myValue = value;
			myIsSynchronized = true;

			if (myValue == myDefaultValue) {
				unsetConfigValue();
			} else {
				setConfigValue("" + myValue);
			}
		}
	}
}
