package testFinalProject;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ch05.collections.ArrayCollection;
import finalProject.finalProject.Contacts;
import finalProject.finalProject.ContactsLinkedCollection;
import finalProject.finalProject.UsingContactsFile;

class UsingContactFileTest {
	String fileName = "MOCK_DATA.csv";
	UsingContactsFile usf= new UsingContactsFile(fileName);
	private PrintStream writer;
	
	@Test
	void importCListTest() {
		ContactsLinkedCollection contactList= usf.importContactListCSV();		
		File file = new File(fileName);
	      Contacts newContact;
	      ContactsLinkedCollection contactList2 = new ContactsLinkedCollection();

	      try{
	         BufferedReader bufRdr = new BufferedReader(new FileReader(file));
	         String line = null;
	         while((line = bufRdr.readLine()) != null) {
	            String[] strings = line.split(",");
	            newContact = new Contacts(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5]);
	            contactList2.add(newContact);
	         }
	         
	         bufRdr.close();
	      } catch(Exception e) {
	         e.printStackTrace();      
	      }
	      int expected=contactList2.size();
	      int actual= contactList.size();
	      assertEquals(expected, actual);

	}
	
	
	
	@Test
	void writeToContactsCSVtest() throws Exception{
		
		ContactsLinkedCollection contactList=new ContactsLinkedCollection();

		Contacts cn= new Contacts("lolipop", "candy", "snickers", "1212", "5555", "9999");
		Contacts cn2= new Contacts("lolp", "cay", "snirs", "12", "5995", "121229");
		
		contactList.add(cn);
		contactList.add(cn2);
		boolean actual=usf.writeToContactsCSV(contactList);
		
		List<Contacts> searchResults= new ArrayList<>();
		searchResults.add(cn);
		searchResults.add(cn2);
		
		PrintStream writer = new PrintStream("test.csv");
		for(Contacts val: searchResults) {
	         writer.println(val.getBusinessName() + "," + val.getFirstName() + "," + 
	                        val.getLastName() + "," + val.getStreetAddress() + "," + 
	                        val.getEmail() + "," + val.getPhoneNumber());
	        
	      }
	     boolean expected=false;
	     
	     assertEquals(expected, actual);
	}

}
