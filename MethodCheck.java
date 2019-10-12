package smellProject;

import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.MethodDeclaration;

public class MethodCheck {

    public static boolean isValidSetupMethod(MethodDeclaration md) {
        boolean validSetup = false;
        boolean isSetup=false;
        if (md.getAnnotationByName("Ignore").isPresent()) {
        	return false;
        }
        else{
            if (md.getAnnotationByName("Before").isPresent() )
            	isSetup=true;
            
            if(md.getNameAsString().equals("setUp")) 
            	isSetup=true;
           
            if (isSetup==true && md.getModifiers().contains(Modifier.PUBLIC)) {
                validSetup = true;
            }
            
        }

        return validSetup;
    }

  
    public static boolean checkValidityTestMethod(MethodDeclaration md) {
        
        boolean isTest=false;
        boolean validTest = false;
        if (md.getAnnotationByName("Ignore").isPresent()) {
        	return false;
        }
        else{
            if (md.getAnnotationByName("Test").isPresent())
            	isTest=true;          
            if ( md.getNameAsString().toLowerCase().startsWith("test")) 
            	isTest=true;
            if ( md.getNameAsString().toLowerCase().lastIndexOf("test")!=-1)
            	isTest=true;
            
            if (isTest==true && md.getModifiers().contains(Modifier.PUBLIC)) 
                    validTest = true;
                        
        }

        return validTest;
    }

}
