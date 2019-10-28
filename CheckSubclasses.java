package smellProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class CheckSubclasses {
	CompilationUnit myComp=null;
	ClassOrInterfaceDeclaration child;
	 NodeList<ClassOrInterfaceType> parent;
	String childFilePath;
	private List<FieldDeclaration> fieldList= new ArrayList<>();
	public CheckSubclasses(ClassOrInterfaceDeclaration child, NodeList<ClassOrInterfaceType> exte, String childfilePath) {
		this.child=child;
		System.out.println(child.getNameAsString());
		this.childFilePath=childfilePath;
		this.parent=exte;
	}
	
	FileInputStream fis;
	String childName;
	String parentName;
	int x;
	String parentFilePath;
	
	public void checkExtended() throws FileNotFoundException {
		for (ClassOrInterfaceType x: parent) {
        	//System.out.println("3333333333333333333333333333333333333 "+x.toString()+" for "+child.getNameAsString());
        	 parentName=x.getNameAsString();
        }
		childName=child.getNameAsString();
		x= childFilePath.lastIndexOf(childName);
	
		parentFilePath=childFilePath.substring(0, x);
		parentFilePath=parentFilePath+parentName+".java";
		//parentFilePath=parentFilePath.replace("\\\\\\", "\\\\");
		//parentFilePath="F:\\6th_semester\\testing & quality assurance\\cs3-final-project-master\\cs3-final-project-master\\testFinalProject\\PersonControllerTest.java";
		System.out.println("parent "+ parentFilePath);
		fis = new FileInputStream(parentFilePath);
        //System.out.println("this line");
        //System.out.println(filePath);
        myComp = JavaParser.parse(fis);
        GeneralFixture gf= new GeneralFixture(parentFilePath);
        if (gf.runAnalysis(myComp, parentName)) {
        	System.out.println("has setup for"+ parentName);
        	fieldList=gf.getFieldList();
        }
        for (FieldDeclaration f: fieldList) {
        	System.out.println("field "+f.toString());
        }
		//MyVisitor mv= new MyVisitor(parentFilePath);
		//mv.visit(myComp, null);
		
	}
	
	public List<FieldDeclaration> getFiledListForParent() {
		return fieldList;
	}
	
	
}
