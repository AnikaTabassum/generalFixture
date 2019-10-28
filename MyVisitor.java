package smellProject;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.Node;
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
    private List<TestMethod> smellyMethodList= new ArrayList<>();
    private MethodDeclaration setupMethod= new MethodDeclaration();
    private List<MethodDeclaration> methodList= new ArrayList<>();
    
    private List<String> setupFields= new ArrayList<>();
    private List<FieldDeclaration> fieldList= new ArrayList<>();
    public String filePath;
    public MyVisitor(List<MethodDeclaration> methodList, MethodDeclaration setupMethod, List<String> setupFields,
            List<TestMethod> smellyMethodList, List<FieldDeclaration> fieldList, String filePath) {
                this.methodList=methodList;
                this.setupFields=setupFields;
                this.filePath=filePath;
                this.setupMethod=setupMethod;
                this.smellyMethodList=smellyMethodList;
                this.fieldList=fieldList;
    }
    public MyVisitor(String parentFilePath) {
    	this.filePath=parentFilePath;
		// TODO Auto-generated constructor stub
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
        
        NodeList <ClassOrInterfaceType>exte=n.getExtendedTypes();
        if (exte.isNonEmpty()) {
        CheckSubclasses cs= new CheckSubclasses(n, exte, filePath);
        try {
			cs.checkExtended();
			fieldList=cs.getFiledListForParent();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }
        
        /*Optional<Node> classes= n.getParentNode();
        String yu=classes.toString();
        if (yu.contains("class")&& yu.contains("public")&&yu.contains("test")&& !yu.contains("import")&& !yu.contains("package")){
        	System.out.println("this class "+yu+"for "+ n.getNameAsString());
        }*/
        
        /*for (ClassOrInterfaceType x: exte) {
        	System.out.println("3333333333333333333333333333333333333 "+x.toString()+" for "+n.getNameAsString());
        }*/
        
        
       while(i<bodymembers.size()){
    	   System.out.println(bodymembers.get(0));
           if (bodymembers.get(i) instanceof FieldDeclaration) {
               fieldList.add((FieldDeclaration) bodymembers.get(i));
           }
           
            if (bodymembers.get(i) instanceof MethodDeclaration) {
                declaredMethod = (MethodDeclaration) bodymembers.get(i);

                
                //System.out.println(declaredMethod.getNameAsString()+"lisaaaaaaaaaa"+methodLineNumber);
                if (MethodCheck.isValidSetupMethod(declaredMethod)) {
                    boolean flag=declaredMethod.getBody().isPresent();
                    if (flag==true) {
                        setupMethod = declaredMethod;
                        //System.out.println(setupMethod.toString());
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
                        //System.out.println("setup field "+seta);
                        if (!variableCount.contains(seta)) {
                            //System.out.println();
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