package smellProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
public class MyVisitor extends VoidVisitorAdapter<Void> {
    private MethodDeclaration declaredMethod = null;
    private MethodDeclaration currentMethod = null;
    TestMethod amartestMethod;
    private Set<String> variableCount = new HashSet();
    private List<TestMethod> smellyMethodList;
    private MethodDeclaration setupMethod;
    private List<MethodDeclaration> methodList;
    
    private List<String> setupFields;
    private List<FieldDeclaration> fieldList;
    
    public MyVisitor(List<MethodDeclaration> methodList, MethodDeclaration setupMethod, List<String> setupFields,
			List<TestMethod> smellyMethodList, List<FieldDeclaration> fieldList) {
    			this.methodList=methodList;
    			this.setupFields=setupFields;
    			this.setupMethod=setupMethod;
    			this.smellyMethodList=smellyMethodList;
    			this.fieldList=fieldList;
	}
    public List<TestMethod> testMethods= new ArrayList<>();


    public List<MethodDeclaration> getMethodList(){
		return methodList;  	
    }
    
    public MethodDeclaration getSetupMethod() {
    	return setupMethod;
    }
    
    public List<String> getSetupFields(){
    	return setupFields;
    }
    
    public List<TestMethod> getSmellyMethodList(){
    	return smellyMethodList;
    }
    
    public List<FieldDeclaration> getFieldList(){
		return fieldList;
    	
    }
    
    public List<TestMethod> getMethods(){
		return testMethods;
    	
    }
    
	@Override
    public void visit(ClassOrInterfaceDeclaration n, Void arg) {
        NodeList<BodyDeclaration<?>> bodymembers = n.getMembers();
        int i=0;
       while(i<bodymembers.size()){
    	   if (bodymembers.get(i) instanceof FieldDeclaration) {
               fieldList.add((FieldDeclaration) bodymembers.get(i));
           }
    	   
            if (bodymembers.get(i) instanceof MethodDeclaration) {
            	declaredMethod = (MethodDeclaration) bodymembers.get(i);

                if (MethodCheck.isValidSetupMethod(declaredMethod)) {
                	boolean flag=declaredMethod.getBody().isPresent();
                    if (flag==true) {
                        setupMethod = declaredMethod;
                        System.out.println(setupMethod.toString());
                    }
                }
                
                if (MethodCheck.checkValidityTestMethod(declaredMethod)) {
                	
                    methodList.add(declaredMethod);
                }
            }

            
            i++;
        }
        //printAllMethods(methodList);
    }
    
    public void printAllMethods(List<MethodDeclaration> methodList) {
    	for (MethodDeclaration val:methodList) {
    		//System.out.println("aaaaaaaaannnnnnnnnnnnniiiiiiiiiiiiiiiiiiiiikkkkkkkkkkkkkkkkkaaaaaaaaaaaaaaaaaa"+methodList.size());
    		System.out.println(val.toString());
    	}
    }
    List<String> smellyField= new ArrayList<>();;
    Map<String, List<String> > mymap= new HashMap<>();
    public List<String>  getProblemField(){
    	return smellyField;
    }
    
    
    //Map <String, String> tempMap=new HashMap<>();
    @Override
    public void visit(MethodDeclaration md, Void arg) {
        if (MethodCheck.checkValidityTestMethod(md)) {
            currentMethod = md;
            super.visit(md, arg);
            amartestMethod = new TestMethod(md.getNameAsString());
            if (variableCount.size() != setupFields.size()) {
            	
            	amartestMethod.setHasSmell(true);
            	smellyMethodList.add(amartestMethod);
            	
	            	for (String seta:setupFields) {
	            		if (!variableCount.contains(seta)) {
	            			System.out.println();
	            			String pop = amartestMethod.getElementName()+" 9has smell for 1variable "+seta;
	            			
	            			smellyField.add(pop);
	            			//System.out.println(pop);
	            			mymap.put(seta, smellyField);
	            		}
	            	}
	            	
            	
            }
            
            testMethods.add(amartestMethod);
            //System.out.println(amartestMethod.getElementName()+" has "+amartestMethod.getHasSmell());
            
            currentMethod = null;
            variableCount = new HashSet();
            
        }
        
    }
    @Override
    public void visit(NameExpr ne, Void arg) {
    	if (currentMethod==null) {
    		System.out.println("Method is null");
    	}
    	else{
    		String fieldName=ne.getNameAsString();
            if (setupFields.contains(fieldName) &&!variableCount.contains(fieldName)) {
            	//System.out.println(fieldName);   
            	variableCount.add(fieldName);
                //System.out.println(currentMethod.getNameAsString() + " : " + n.getName().toString());
            }
            //System.out.println(amartestMethod.getElementName());
           
        }
    	

        super.visit(ne, arg);
    }
}
