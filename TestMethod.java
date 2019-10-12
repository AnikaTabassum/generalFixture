package smellProject;

import java.util.HashMap;
import java.util.Map;

public class TestMethod {

    private String methodName;
    private boolean hasSmell;
    private Map<String, String> data;

    public TestMethod(String methodName) {
        this.methodName = methodName;
        data = new HashMap<>();
    }

    public void setHasSmell(boolean hasSmell) {
        this.hasSmell = hasSmell;
    }

    public void addDataItem(String name, String value) {
        data.put(name, value);
    }

    public String getElementName() {
        return methodName;
    }

    public boolean getHasSmell() {
        return hasSmell;
    }

    public Map<String, String> getData() {
        return data;
    }
}
