package org.zlibrary.options;

/**
 * ����� ������� �����. ��������� �����, ����� ������� �� �����
 * �������� ����� ��� ����� ����� ��������
 * @author �������������
 *
 */
abstract class ZLSimpleOption extends ZLOption {
	/**
	 * �� ���� final ����������� ������ ���� �����,
	 * �������� ��� ����� ����������.
	 * @return
	 */
	public abstract OptionType getType();
	
	/**
	 * �����������. ��������� ��� �� ��� � ����� �����
	 * @see ZLOption
	 */
	public ZLSimpleOption(String category, String group, String optionName){
		super(category, group, optionName);
	}
}
