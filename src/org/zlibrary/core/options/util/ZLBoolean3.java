package org.zlibrary.core.options.util;

/**
 * �������� "�������� ����������� ������"
 * @author �������������
 */
public enum ZLBoolean3 {
	B3_FALSE("false"),
	B3_TRUE("true"),
	B3_UNDEFINED("undefined");
	
	private String myStringValue;
	
	private ZLBoolean3(String stringValue){
		myStringValue = stringValue;
	}
	
	public String toString(){
		return myStringValue;
	}
}
