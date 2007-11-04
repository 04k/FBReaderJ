package org.test.zlibrary.options.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.zlibrary.options.config.reader.ZLConfigReaderFactory;

//TODO ��� ���� ��� ������ ����. ����� ������ MAIN, ����� �������� � ��������

/**
 * ������������� ����!!!!!
 * ����� 01 - ��� ����� �� 
 * @author �������������
 *
 */
public class Main {
	
	private static void testFileReading (String file){
		try {
			ZLConfigReaderFactory myFactory = new ZLConfigReaderFactory();
			System.out.println(myFactory.createConfigReader().read(
					new FileInputStream(file)));
		} catch (FileNotFoundException nf) {
			System.out.println(nf.getMessage());
		}
	}
	
	public static void main(String[] args){
		testFileReading("test/org/test/zlibrary/options/example/state.xml");
		testFileReading("test/org/test/zlibrary/options/example/ui.xml");
	}
	
}
