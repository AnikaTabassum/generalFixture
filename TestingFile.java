package smellProject;
import java.util.ArrayList;
import java.util.List;

public class TestingFile {
    public String testFilePath;
    
    public TestingFile(String testFilePath) {
        this.testFilePath = testFilePath;
        
    }

    
    public String getTestFilePath() {
     return testFilePath;
 }
    public void setTestFileNameWithoutExtension(String h) {
    	testFilePath=h;
    }

    public String getTestFileNameWithoutExtension(){
    	
    	//return testFilePath;
    	int last = testFilePath.lastIndexOf("\\\\");
    	String fileName=testFilePath.substring(last+1,testFilePath.length());
        int lastIndex = fileName.lastIndexOf(".");
        return fileName.substring(0,lastIndex);
    }

}