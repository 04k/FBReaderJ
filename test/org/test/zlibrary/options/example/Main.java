package org.test.zlibrary.options.example;

import java.io.File;

import org.zlibrary.options.config.reader.ZLConfigReaderFactory;

//TODO ��� ���� ��� ������ ����. ����� ������ MAIN, ����� �������� � ��������

/**
 * ������������� ����!!!!!
 * ����� 01 - ��� ����� �� 
 * @author �������������
 *
 */
public class Main {
	
	private static void testFileReading (File file){
		ZLConfigReaderFactory myFactory = new ZLConfigReaderFactory();
		System.out.println(myFactory.createConfigReader().readFile(file));
	}
	
	public static void main(String[] args){
		testFileReading(new File("test/org/test/zlibrary/options/example/state.xml"));
		testFileReading(new File("test/org/test/zlibrary/options/example/ui.xml"));
	}
	
}
