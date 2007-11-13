package org.zlibrary.options;

/**
 * ����� ������� �����. ��������� �����, ����� ������� �� �����
 * �������� ����� ��� ����� ����� ��������
 * @author �������������
 *
 */
abstract class ZLSimpleOption extends ZLOption {
    
    /**
     * �����������. ��������� ��� �� ��� � ����� �����
     * @see ZLOption
     */
    public ZLSimpleOption(String category, String group, String optionName){
        super(category, group, optionName);
    }
    
	/**
	 * �� ���� final ����������� ������ ���� �����,
	 * �������� ��� ����� ����������.
	 * @return
	 */
	public abstract ZLOptionType getType();
}
