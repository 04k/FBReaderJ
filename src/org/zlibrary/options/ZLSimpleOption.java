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
	public abstract ZLOptionType getType();
	
	/**
	 * �����������. ��������� ��� �� ��� � ����� �����
	 * @see ZLOption
	 */
	public ZLSimpleOption(ZLConfig config, String category, String group, String optionName){
		super(config, category, group, optionName);
	}
}
