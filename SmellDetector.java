package smellProject;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SmellDetector {
	private List<TestMethod> testMethods= new ArrayList<>();
	private List<MethodDeclaration> methodList;
	List<String> smellyField;
	public TestingFile detectSmells(TestingFile testFile) throws IOException {
        CompilationUnit myComp=null;
        FileInputStream fis;
        String filePath=testFile.getTestFilePath();
        if(filePath!=null) {
            fis = new FileInputStream(filePath);
            //System.out.println("this line");
            System.out.println(filePath);
            myComp = JavaParser.parse(fis);
        }
        GeneralFixture gf= new GeneralFixture();
        gf.runAnalysis(myComp,testFile.getTestFileNameWithoutExtension());
        testMethods=gf.getMethods();
        smellyField=gf.getProblemField();
        methodList=gf.getMethodList();
        //System.out.println(gf.toString());
        return testFile;

    }
	public List<String>  getProblemField(){
    	return smellyField;
    }
	
	public List<MethodDeclaration> getMethodList(){
		for (MethodDeclaration m:methodList) {
    		System.out.println(m.getNameAsString());
    			
    	}
		return methodList;  	
    }
    

	public List<TestMethod> getMethods(){
		return testMethods;
    	
    }


}
