package smellProject;

import java.util.HashMap;
import java.util.Map;

public class TestClass {

    private String className;
    private boolean hasSmell;
    private Map<String, String> data;

    public TestClass(String className) {
        this.className = className;
        data = new HashMap<>();
    }

    public void setHasSmell(boolean hasSmell) {
        this.hasSmell = hasSmell;
    }
    public boolean getHasSmell() {
        return hasSmell;
    }


    public void addDataItem(String name, String value) {
        data.put(name, value);
    }

    public String getElementName() {
        return className;
    }

    
    public Map<String, String> getData() {
        return data;
    }
}
