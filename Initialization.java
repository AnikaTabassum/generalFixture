package smellProject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Initialization {
	
	public static String app;
	public static String testFilePath;
	public TestingFile testFile;
	public List<TestingFile> testFiles = new ArrayList<>();
	public SmellDetector mySmellDetector = new SmellDetector();
	private List<TestMethod> testMethods= new ArrayList<>();
	public Initialization(String app, String testFilePath) {
		this.app=app;
		this.testFilePath=testFilePath;
	}
	
	public void createTestFile() {
		
		testFile= new TestingFile(testFilePath);
		 testFiles.add(testFile);
		//System.out.println("done");
	}
    
    public void writeResult() throws Throwable    {
    	WriteHelper resultsWriter = new WriteHelper();
        List<String> columnNames= new ArrayList<>();;
        List<String> columnValues;

        //columnNames = testSmellDetector.getTestSmellNames();
        columnNames.add(0, "Test file name");
        columnNames.add(1, "Method name");
        columnNames.add(2, "Has smell");
        

        resultsWriter.writeOutput(columnNames);

        /*
          Iterate through all test files to detect smells and then write the output
        */
        TestingFile tempFile;
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date;
        
        tempFile = mySmellDetector.detectSmells(testFile);
        testMethods=mySmellDetector.getMethods();
        
        for (TestMethod t: testMethods) {
        	columnValues = new ArrayList<>();
        	System.out.println("oooooooooooooooooooooooooooo"+t.getElementName());
        	
        	columnValues.add(tempFile.getTestFileNameWithoutExtension());
        	columnValues.add(t.getElementName());
        	columnValues.add(String.valueOf(t.getHasSmell()));
        	resultsWriter.writeOutput(columnValues);
        }
        /*for (TestFile file : testFiles) {
            date = new Date();
            System.out.println(dateFormat.format(date) + " Processing: "+file.getTestFilePath());
            System.out.println("Processing: "+file.getTestFilePath());

            //detect smells
            tempFile = testSmellDetector.detectSmells(file);

            //write output
            columnValues = new ArrayList<>();
            columnValues.add(file.getApp());
            columnValues.add(file.getTagName());
            columnValues.add(file.getTestFilePath());
            columnValues.add(file.getProductionFilePath());
            columnValues.add(file.getRelativeTestFilePath());
            columnValues.add(file.getRelativeProductionFilePath());
            for (AbstractSmell smell : tempFile.getTestSmells()) {
                try {
                    columnValues.add(String.valueOf(smell.getHasSmell()));
                }
                catch (NullPointerException e){
                    columnValues.add("");
                }
            }
            resultsWriter.writeLine(columnValues);
        }*/

        System.out.println("end");
    	
    }
public void unnecessary() throws Throwable {

        

        /*
          Read the input file and build the TestFile objects
         */
        BufferedReader in = new BufferedReader(new FileReader(app));
        String str;

        String[] lineItem;
        
        
        
       /* while ((str = in.readLine()) != null) {
            // use comma as separator
            lineItem = str.split(";");
            System.out.println(str);
            //check if the test file has an associated production file
            if(lineItem.length ==2){
                testFile = new TestFile(lineItem[0], lineItem[1], "");
            }
            else{
            	String app="General fixture";
            	String testFilePath="F:\\6th_semester\\testing & quality assurance\\cs3-final-project-master\\cs3-final-project-master\\testFinalProject\\PersonControllerTest.java";
            	String productionFilePath="";
            	testFile= new TestFile(app, testFilePath, productionFilePath);
                //testFile = new TestFile(lineItem[0], lineItem[1], lineItem[2]);
            }
            
            //testFile="";
           
        }

        /*
          Initialize the output file - Create the output file and add the column names
         */
        
    }


}
