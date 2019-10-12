package smellProject;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import java.io.FileNotFoundException;
import java.util.*;

public class GeneralFixture {

    private List<TestMethod> smellyMethodList= new ArrayList<>();;
    
    private MethodDeclaration setupMethod;
    private List<MethodDeclaration> methodList= new ArrayList<>();;
    
    private List<String> setupFields= new ArrayList<>();;
    private List<FieldDeclaration> fieldList= new ArrayList<>();
    private List<TestMethod> testMethods= new ArrayList<>();
    
    public boolean getHasSmell() {
        return smellyMethodList.stream().filter(x -> x.getHasSmell()).count() >= 1;
    }
    
    
    public List<TestMethod> getMethods(){
    	
		return testMethods;
    	
    }

   // public void checkForSmell()
    public void runAnalysis(CompilationUnit testFileCompilationUnit, String testFileName) throws FileNotFoundException {
    	MyVisitor amarVisitor= new MyVisitor(methodList,setupMethod, setupFields,smellyMethodList, fieldList);
    	amarVisitor.visit(testFileCompilationUnit, null); //This call will populate the list of test methods and identify the setup method [visit(ClassOrInterfaceDeclaration n)]
    	testMethods=amarVisitor.getMethods();
        setupMethod=amarVisitor.getSetupMethod();
        fieldList=amarVisitor.getFieldList();
        setupFields=amarVisitor.getSetupFields();
        smellyMethodList=amarVisitor.getSmellyMethodList();
        methodList=amarVisitor.getMethodList();
        Optional<BlockStmt> blockStmt = setupMethod.getBody();            
        NodeList nodeList = blockStmt.get().getStatements();
        if (setupMethod==null) {
        	System.out.println("there is no setup method in the test class");
        }
        else {
            
            int i=0;
            while (i<nodeList.size()){
                int j=0;
                while(j<fieldList.size()){
                	NodeList<VariableDeclarator> variables=fieldList.get(j).getVariables();
                	int k=0;
                    while(k < variables.size()) {
                        if (nodeList.get(i) instanceof ExpressionStmt) {
                            ExpressionStmt expressionStmt = (ExpressionStmt) nodeList.get(i);
                            System.out.println(expressionStmt.toString());
                            if (expressionStmt.getExpression() instanceof AssignExpr) {
                                AssignExpr assignExpr = (AssignExpr) expressionStmt.getExpression();
                                String variableName=variables.get(k).getNameAsString();
                                String expressionName=assignExpr.getTarget().toString();
                                if (variableName.equals(expressionName)) {
                                    setupFields.add(expressionName);
                                }
                            }
                        }
                        k++;
                    }
                    j++;
                }
                i++;
            }
        }

        for (MethodDeclaration method : methodList) {
        	amarVisitor.visit(method, null);
        }
        smellPrint();
    }

    public void smellPrint() {
    	for (TestMethod val: smellyMethodList) {
    		System.out.println("anika" +val.getElementName());
    	}
    }
    public List<TestMethod> getSmellyElements() {
        return smellyMethodList;
    }

}