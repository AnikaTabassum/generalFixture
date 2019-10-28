package smellProject;

public class TestClass {

    private String className;
    private boolean hasSmell;


    public TestClass(String className) {
        this.className = className;
        
    }

    public void setHasSmell(boolean hasSmell) {
        this.hasSmell = hasSmell;
    }
    public boolean getHasSmell() {
        return hasSmell;
    }
    public String getElementName() {
        return className;
    }

}
