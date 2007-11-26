package org.test.zlibrary.options.example;

import org.zlibrary.core.options.ZLStringOption;
import org.zlibrary.core.options.config.ZLConfigInstance;
import org.zlibrary.core.options.config.reader.ZLConfigReaderFactory;
import org.zlibrary.core.options.config.writer.*;

//TODO ��� ���� ��� ������ ����.

/**
 * ������������� ����!!!!!
 * ����� 01 - ��� ����� �� 
 * @author �������������
 *
 */
public class Main {
	
	public static void main(String[] args){
		//readConfigFile(new File("test/org/test/zlibrary/options/example/books.xml"));
		//readConfigFile(new File("test/org/test/zlibrary/options/example/options.xml"));
		// readConfigFile(new File("test/org/test/zlibrary/options/example/search.xml"));
		//readConfigFile(new File("test/org/test/zlibrary/options/example/state.xml"));
		//readConfigFile(new File("test/org/test/zlibrary/options/example/ui.xml"));
		//readConfigFile(new File("test/org/test/zlibrary/options/example/output/ui.xml"));
		
		String input = "test/org/test/zlibrary/options/example/";
		//String input = "test/org/test/zlibrary/options/example/";
		ZLConfigReaderFactory.createConfigReader(input).read();
		
		
		
		ZLStringOption myOption = new ZLStringOption("ui", "MYGROUP", 
				"length", "12312");
		myOption.setValue("I'M_CHANGED!");
		ZLStringOption myChangeableOption = new ZLStringOption("gruiu", "MYGROUP", 
				"lengthChangeable", "12312");
		myChangeableOption.setValue("I_COULD_CHANGE!");
		ZLConfigInstance.getInstance().unsetValue("MYGROUP", 
		"lengthChangeable");
		
		
		
		String output = "test/org/test/zlibrary/options/example/output/";
		ZLConfigWriterFactory.createConfigWriter(output).write();
	}
	
}
