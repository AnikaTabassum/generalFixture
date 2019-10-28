package smellProject;

public class TestMethod {

    private String methodName;
    private boolean hasSmell;
    public TestMethod(String methodName) {
        this.methodName = methodName;

    }

    public void setHasSmell(boolean hasSmell) {
        this.hasSmell = hasSmell;
    }

    public String getElementName() {
        return methodName;
    }

    public boolean getHasSmell() {
        return hasSmell;
    }

}
