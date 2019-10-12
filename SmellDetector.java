package smellProject;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SmellDetector {
	private List<TestMethod> testMethods= new ArrayList<>();
	
	public TestingFile detectSmells(TestingFile testFile) throws IOException {
        CompilationUnit myComp=null;
        FileInputStream fis;
        String filePath=testFile.getTestFilePath();
        if(filePath!=null) {
            fis = new FileInputStream(filePath);
            System.out.println("this line");
            System.out.println(filePath);
            myComp = JavaParser.parse(fis);
        }
        GeneralFixture gf= new GeneralFixture();
        gf.runAnalysis(myComp,testFile.getTestFileNameWithoutExtension());
        testMethods=gf.getMethods();
        System.out.println(gf.toString());
        return testFile;

    }
	
	public List<TestMethod> getMethods(){
		return testMethods;
    	
    }


}
