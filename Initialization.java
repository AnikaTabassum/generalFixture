package smellProject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.javaparser.ast.body.MethodDeclaration;

public class Initialization {
	
	public static String app;
	//public static String testFilePath;
	public TestingFile testFile;
	public List <String >testWithFullPath= new ArrayList<String>();
	ArrayList<String> testclasses = new ArrayList<String>();
	public List<TestingFile> allTestFiles = new ArrayList<>();
	public SmellDetector mySmellDetector = new SmellDetector();
	private List<TestMethod> testMethods= new ArrayList<>();
	WriteHelper resultsWriter ;
	public Initialization(List<String> testWithFullPath, ArrayList<String> testclasses) {
		this.testWithFullPath=testWithFullPath;
		this.testclasses=testclasses;
	}
	
	public void createTestFile() {
		for (String testFilePath: testWithFullPath) {
			System.out.println("init--------------" + testFilePath);
			testFile= new TestingFile(testFilePath);
			allTestFiles.add(testFile);
		}
		//System.out.println("done");
	}
	
	private List<MethodDeclaration> methodList;
    public void writeResult() throws Throwable    {
    	resultsWriter = new WriteHelper();
        List<String> columnNames= new ArrayList<>();;
        List<String> columnValues;

        //columnNames = testSmellDetector.getTestSmellNames();
        columnNames.add(0, "Test_file_name");
        columnNames.add(1, "Method_name");
        columnNames.add(2, "Has_smell");
        columnNames.add(3,"Line_no");
        columnNames.add(4,"smelly_variable");
        

        resultsWriter.writeOutput(columnNames);

        TestingFile tempFile;

        for (TestingFile anikaTestFile:allTestFiles) {
        	
        tempFile = mySmellDetector.detectSmells(anikaTestFile);
        boolean hasSetup=mySmellDetector.getHasSetup();
        testMethods=mySmellDetector.getMethods();
        methodList=mySmellDetector.getMethodList();
         List<String> smellyField;
         List <String> jjdjd= new ArrayList<>();
         List <String> jajaj= new ArrayList<>();
         Map<String, String> mymap= new HashMap<>();
         Map <String, String> tempMap=new HashMap<>();
         smellyField=mySmellDetector.getProblemField();
         for (String s:smellyField) {
        	 //System.out.println("ajaja"+s);
        	 int l=s.lastIndexOf("1variable ");
        	 String temp=s.substring(l+10);
        	 //System.out.println(s.substring(l+10));
        	 //smellyMethod.add(temp);
        	 
        		 jajaj.add(temp);
        	 
        	 l=s.lastIndexOf(" 9has");
        	 String fieldTemp=s.substring(0,l);
        	 //System.out.println(fieldTemp);
        	 jjdjd.add(fieldTemp);
        	 
        	
         }
         if (hasSetup==false) {
        	 columnValues = new ArrayList<>();
        	 columnValues.add(anikaTestFile.getTestFileNameWithoutExtension());
        	 columnValues.add("No setup method exists");
        	 resultsWriter.writeOutput(columnValues);
         }
         
        for (TestMethod t: testMethods) {
        	columnValues = new ArrayList<>();
        	//System.out.println("oooooooooooooooooooooooooooo"+t.getElementName());
        
        	columnValues.add(tempFile.getTestFileNameWithoutExtension());
        	columnValues.add(t.getElementName());
        	columnValues.add(String.valueOf(t.getHasSmell()));
        	for (MethodDeclaration m:methodList) {
        		if (m.getNameAsString().equals(t.getElementName())) {
        			int methodLineNumber = m.getBegin().get().line;
        			int methodEndNumber=m.getEnd().get().line;
        			if(t.getHasSmell()) {
        				columnValues.add("problem in line no "+methodLineNumber+" to "+methodEndNumber);
        			}
        		}
        			
        	}
        	String addin="";
        	for(int i=0;i<jajaj.size();i++) {
        		//System.out.println("kau"+jajaj.get(i));
        		
        		if (jjdjd.get(i).equals(t.getElementName())) {
        			addin+=jajaj.get(i)+"+-+-+";
        			        			//System.out.println("heon "+jajaj.get(i));
        		}
        			
        	}
        	//System.out.println("ad "+addin);
        	columnValues.add(addin);

        	
        	//columnValues.add(smellyField);
        	resultsWriter.writeOutput(columnValues);
        }
        }
        
    	
    }

}