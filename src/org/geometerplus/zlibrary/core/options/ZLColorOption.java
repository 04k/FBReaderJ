package org.geometerplus.zlibrary.core.options;

import org.geometerplus.zlibrary.core.util.ZLColor;

/**
 * ����� ����� �����. ������ ����� ���� �������� ����� ������, ����� ���������
 * ������� �� ������ (� ��� ����! =)), �� ��������� � ���� ����� ��� �����
 * �������������� � ������� ������ ZLColor, ������� ��������� ����� ���������
 * RGB ������������� �����.
 * 
 * @author �������������
 * 
 */
public final class ZLColorOption extends ZLOption {
	private final ZLColor myDefaultValue;
	private ZLColor myValue;

	public ZLColorOption(String category, String group, String optionName, ZLColor defaultValue) {
		super(category, group, optionName);
		myDefaultValue = (defaultValue != null) ? defaultValue : new ZLColor(0);
		myValue = myDefaultValue;
	}

	public ZLColor getValue() {
		if (!myIsSynchronized) {
			String value = getConfigValue(null);
			if (value != null) {
				try {
					int intValue = Integer.parseInt(value);
					if (myValue.getIntValue() != intValue) {
						myValue = new ZLColor(intValue);
					}
				} catch (NumberFormatException e) {
					// System.err.println(e);
				}
			}
			myIsSynchronized = true;
		}
		return myValue;
	}

	public void setValue(ZLColor colorValue) {
		if (colorValue != null) {
			final boolean sameValue = myValue.equals(colorValue);
			if (myIsSynchronized && sameValue) {
				return;
			}
			if (!sameValue) {
				myValue = colorValue;
			}
			myIsSynchronized = true;
			if (myValue.equals(myDefaultValue)) {
				unsetConfigValue();
			} else {
				setConfigValue("" + myValue.getIntValue());
			}
		}
	}
}
