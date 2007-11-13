package org.test.zlibrary.options.example;

import java.io.File;

import org.zlibrary.options.config.ZLConfigInstance;
import org.zlibrary.options.config.reader.ZLConfigReaderFactory;

//TODO ��� ���� ��� ������ ����. ����� ������ MAIN, ����� �������� � ��������

/**
 * ������������� ����!!!!!
 * ����� 01 - ��� ����� �� 
 * @author �������������
 *
 */
public class Main {
	
	private static void readConfigFile (File file){
		ZLConfigReaderFactory myFactory = new ZLConfigReaderFactory();
		myFactory.createConfigReader().readFile(file);
	}
	
	public static void main(String[] args){
		//readConfigFile(new File("test/org/test/zlibrary/options/example/state.xml"));
		readConfigFile(new File("test/org/test/zlibrary/options/example/ui.xml"));
        System.out.println(ZLConfigInstance.getInstance());
	}
	
}
