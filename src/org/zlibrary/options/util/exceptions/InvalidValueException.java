package org.zlibrary.options.util.exceptions;

public class InvalidValueException extends Exception {
	static final long serialVersionUID = 0;
	
	/**
	 * ����������� ��� ������ ����
	 * @param s
	 */
	public InvalidValueException (String s){
		super("Invelid Value Exception - " + s);
	}
}
