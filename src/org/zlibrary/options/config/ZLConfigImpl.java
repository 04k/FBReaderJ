package org.zlibrary.options.config;

import java.util.*;
import org.zlibrary.options.ZLConfig;

/**
 * ����� ������. ��� ������������ ��������� �����.
 * �������� ���� myData �������� ������ �����, �������
 * � �������� ������ �������������� �� �����.
 * @author �������������
 *
 */
/*package*/ class ZLConfigImpl implements ZLConfig {
	// public abstract void unsetValue(String group, String name);

	// public abstract  boolean isAutoSavingSupported() const = 0;
	// public abstract  void startAutoSave(int seconds) = 0;
    private Map<String, ZLCategory> myData;
    
    public ZLConfigImpl (){
        myData = new HashMap<String, ZLCategory>();
    }
    
    public ZLConfigImpl (Map<String, ZLCategory> map){
        myData = map;
    }
    
    public void removeGroup(String category, String group){
        myData.get(category).removeGroup(group);
    }

    public String getValue(String Category, String group, String name, String defaultValue){
        if (myData.get(Category) != null){
            return myData.get(Category).getValue(group, name, defaultValue);
        } else{
            return defaultValue;
        }
    }
    
    public void setValue(String category, String group, String name, String value){
        if (myData.get(category) != null){
            myData.get(category).setValue(group, name, value);
        } else {
            ZLCategory newCategory = new ZLCategory();
            newCategory.setValue(group, name, value);
            myData.put(category, newCategory);
        }
    }
    
    public void unsetValue(String Category, String group, String name){
        myData.get(Category).unsetValue(group, name);
    }
    
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for (String categoryName : myData.keySet()){
            sb.append("" + categoryName + "\n\n" + myData.get(categoryName) + "\n");
        }
        return sb.toString();
    }   
}
