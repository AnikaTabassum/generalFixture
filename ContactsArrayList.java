package testFinalProject;


import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.opentest4j.AssertionFailedError;

import finalProject.finalProject.ContactList;
import finalProject.finalProject.Contacts;
import finalProject.finalProject.ContactsArrayCollection;
import finalProject.finalProject.ContactsLinkedCollection;
import finalProject.finalProject.UsingContactsFile;

class ContactsArrayList {
	String businessName;
	String firstName;
	String lastName;
	String streetAddress;
	String email;
	String phoneNumber;
	String format = "%-10.10s %-15.15s %-15.15s %-15.15s %-30.30s %-30.30s %-20.20s%n";
	ContactsArrayCollection cac= new ContactsArrayCollection();
	String fileName = "MOCK_DATA.csv";
	UsingContactsFile contactsFile = new UsingContactsFile(fileName);
	ContactsLinkedCollection contactList = contactsFile.importContactListCSV();
	ContactsArrayCollection searchReturn = contactList.getAll("anika");
	
	@Test
	void getIndexTest1() {
		int i=1;
		String actual="";
		actual+=searchReturn.getIndex(i).getBusinessName()+" "+
	               searchReturn.getIndex(i).getFirstName()+" "+
	               searchReturn.getIndex(i).getLastName()+" "+
	               searchReturn.getIndex(i).getStreetAddress()+" "+
	               searchReturn.getIndex(i).getEmail()+" "+
	               searchReturn.getIndex(i).getPhoneNumber()+"\n";
		
		String expected="anika" + " "+ "anika"+" "+"tabassum"+" "+"123456"+" "+"3333"+" "+"2222"+"\n";
		assertEquals(expected, actual);
		
	}
	
	@Test
	void getIndexTest2() {
		ContactsArrayCollection searchReturn2 = contactList.getAll("Zoonder");
		int i=12;
		String actual="";
		actual+=searchReturn2.getIndex(i).getBusinessName()+" "+
	               searchReturn2.getIndex(i).getFirstName()+" "+
	               searchReturn2.getIndex(i).getLastName()+" "+
	               searchReturn2.getIndex(i).getStreetAddress()+" "+
	               searchReturn2.getIndex(i).getEmail()+" "+
	               searchReturn2.getIndex(i).getPhoneNumber()+"\n";
		
		System.out.println(actual);
		
		String expected="Zoonder" + " "+ "Germain"+" "+"Marder"+" "+"797 Derek Crossing"+" "+"gmarder1c@uol.com.br"+" "+"8163397146"+"\n";
		assertEquals(expected, actual);
		
	}
	
	@Test
	void getIndexTestMin() {
		ContactsArrayCollection searchReturn3 = contactList.getAll("Cogilith");
		int i=0;
		String actual="";
		actual+=searchReturn3.getIndex(i).getBusinessName()+" "+
	               searchReturn3.getIndex(i).getFirstName()+" "+
	               searchReturn3.getIndex(i).getLastName()+" "+
	               searchReturn3.getIndex(i).getStreetAddress()+" "+
	               searchReturn3.getIndex(i).getEmail()+" "+
	               searchReturn3.getIndex(i).getPhoneNumber()+"\n";
		
		System.out.println( actual);
		
		String expected="Cogilith" + " "+ "Sharona"+" "+"Marrion"+" "+"603 Oriole Court"+" "+"smarrionmf@gmpg.org"+" "+"5955567000"+"\n";
		assertEquals(expected, actual);
		
	}
	
	@Test
	void getIndexTestMinplus() {
		ContactsArrayCollection searchReturn3 = contactList.getAll("Cogilith");
		int i=1;
		String actual="";
		actual+=searchReturn3.getIndex(i).getBusinessName()+" "+
	               searchReturn3.getIndex(i).getFirstName()+" "+
	               searchReturn3.getIndex(i).getLastName()+" "+
	               searchReturn3.getIndex(i).getStreetAddress()+" "+
	               searchReturn3.getIndex(i).getEmail()+" "+
	               searchReturn3.getIndex(i).getPhoneNumber()+"\n";
		
		System.out.println( actual);
		
		String expected="Cogilith" + " "+ "Nicolea"+" "+"Chisnall"+" "+"4014 Reinke Pass"+" "+"nchisnallln@ftc.gov"+" "+"5722219238"+"\n";
		assertEquals(expected, actual);
		
	}
	
	@Test
	void getIndexTestMax() {
		ContactsArrayCollection searchReturn3 = contactList.getAll("Cogilith");
		int i=26;
		String actual="";
		actual+=searchReturn3.getIndex(i).getBusinessName()+" "+
	               searchReturn3.getIndex(i).getFirstName()+" "+
	               searchReturn3.getIndex(i).getLastName()+" "+
	               searchReturn3.getIndex(i).getStreetAddress()+" "+
	               searchReturn3.getIndex(i).getEmail()+" "+
	               searchReturn3.getIndex(i).getPhoneNumber()+"\n";
		
		System.out.println( actual);
		
		String expected="Cogilith" + " "+ "Maxie"+" "+"Brown"+" "+"858 Emmet Place"+" "+"mbrown1i@geocities.com"+" "+"9751159659"+"\n";
		assertEquals(expected, actual);
		
	}
	
	@Test
	void getIndexTestNominal() {
		ContactsArrayCollection searchReturn3 = contactList.getAll("Cogilith");
		int i=searchReturn3.size()/2;
		String actual="";
		actual+=searchReturn3.getIndex(i).getBusinessName()+" "+
	               searchReturn3.getIndex(i).getFirstName()+" "+
	               searchReturn3.getIndex(i).getLastName()+" "+
	               searchReturn3.getIndex(i).getStreetAddress()+" "+
	               searchReturn3.getIndex(i).getEmail()+" "+
	               searchReturn3.getIndex(i).getPhoneNumber()+"\n";
		
		System.out.println( actual);
		
		String expected="Cogilith" + " "+ "Rog"+" "+"Buxam"+" "+"16 Clyde Gallagher Trail"+" "+"rbuxam21@paypal.com"+" "+"5582474808"+"\n";
		assertEquals(expected, actual);
		
	}
	
	@Test
	void getIndexTestMaxminus() {
		ContactsArrayCollection searchReturn3 = contactList.getAll("Cogilith");
		int i=searchReturn3.size()-2;
		String actual="";
		actual+=searchReturn3.getIndex(i).getBusinessName()+" "+
	               searchReturn3.getIndex(i).getFirstName()+" "+
	               searchReturn3.getIndex(i).getLastName()+" "+
	               searchReturn3.getIndex(i).getStreetAddress()+" "+
	               searchReturn3.getIndex(i).getEmail()+" "+
	               searchReturn3.getIndex(i).getPhoneNumber()+"\n";
		String expected="Cogilith" + " "+ "Albina"+" "+"Cordery"+" "+"301 Rowland Point"+" "+"acordery1u@google.de"+" "+"5242086325"+"\n";
		assertEquals(expected, actual);
		
	}
	
	
	@Test
	void getIndexTestMaxPlus() throws NullPointerException{
		ContactsArrayCollection searchReturn3 = contactList.getAll("Cogilith");
		int i=searchReturn3.size();
		assertNull(searchReturn3.getIndex(i));
	}
	
	
	
	
	@Test
	void sortElementTest1() {

		searchReturn.sortElements(1,1);
		String actual = "";
		for(int i = 0; i < searchReturn.size(); i++) {
    	   actual+=searchReturn.getIndex(i).getBusinessName()+" "+
                   searchReturn.getIndex(i).getFirstName()+" "+
                   searchReturn.getIndex(i).getLastName()+" "+
                   searchReturn.getIndex(i).getStreetAddress()+" "+
                   searchReturn.getIndex(i).getEmail()+" "+
                   searchReturn.getIndex(i).getPhoneNumber()+"\n";
         }
		String expected="anika" + " "+ "anika"+" "+"tabassum"+" "+"123456"+" "+"3333"+" "+"2222"+"\n"+
				"anikaHr" + " "+ "anika"+" "+"hridita"+" "+"99999"+" "+"12345"+" "+"77777"+"\n";
		
		assertEquals(expected, actual);
	}
	//ContactsArrayCollection searchReturn2 = contactList.getAll("anika");
	@Test
	void sortElementTest2() {
		
		searchReturn.sortElements(1,2);
		String actual = "";
       for(int i = 0; i < searchReturn.size(); i++) {
    	   actual+=searchReturn.getIndex(i).getBusinessName()+" "+
                   searchReturn.getIndex(i).getFirstName()+" "+
                   searchReturn.getIndex(i).getLastName()+" "+
                   searchReturn.getIndex(i).getStreetAddress()+" "+
                   searchReturn.getIndex(i).getEmail()+" "+
                   searchReturn.getIndex(i).getPhoneNumber()+"\n";
         }
		String expected="anikaHr" + " "+ "anika"+" "+"hridita"+" "+"99999"+" "+"12345"+" "+"77777"+"\n"+
				"anika" + " "+ "anika"+" "+"tabassum"+" "+"123456"+" "+"3333"+" "+"2222"+"\n";
		assertEquals(expected, actual);
	}
	
	@Test
	void sortElementTest3() {
		
		searchReturn.sortElements(2,1);
		String actual = "";
       for(int i = 0; i < searchReturn.size(); i++) {
    	   actual+=searchReturn.getIndex(i).getBusinessName()+" "+
                   searchReturn.getIndex(i).getFirstName()+" "+
                   searchReturn.getIndex(i).getLastName()+" "+
                   searchReturn.getIndex(i).getStreetAddress()+" "+
                   searchReturn.getIndex(i).getEmail()+" "+
                   searchReturn.getIndex(i).getPhoneNumber()+"\n";
         }
		String expected="anikaHr" + " "+ "anika"+" "+"hridita"+" "+"99999"+" "+"12345"+" "+"77777"+"\n"+
				"anika" + " "+ "anika"+" "+"tabassum"+" "+"123456"+" "+"3333"+" "+"2222"+"\n";
		assertEquals(expected, actual);
	}
	@Test
	void sortElementTest4() {

		searchReturn.sortElements(2,2);
		
		String actual = "";
	   for(int i = 0; i < searchReturn.size(); i++) {
		   actual+=searchReturn.getIndex(i).getBusinessName()+" "+
	               searchReturn.getIndex(i).getFirstName()+" "+
	               searchReturn.getIndex(i).getLastName()+" "+
	               searchReturn.getIndex(i).getStreetAddress()+" "+
	               searchReturn.getIndex(i).getEmail()+" "+
	               searchReturn.getIndex(i).getPhoneNumber()+"\n";
	     }
		String expected="anika" + " "+ "anika"+" "+"tabassum"+" "+"123456"+" "+"3333"+" "+"2222"+"\n"+
				"anikaHr" + " "+ "anika"+" "+"hridita"+" "+"99999"+" "+"12345"+" "+"77777"+"\n";
		assertEquals(expected, actual);
	}
	
	@Test
	void removeElementTest() {
		int expected=searchReturn.size()-1;
		int actual=searchReturn.removeElementByIndex(0);
		assertEquals(expected, actual);
	}
	
	@Test
	void filterElementsTest1() {
		searchReturn.filterElements(1, "anika");
		String actual="";
		for(int i = 0; i < searchReturn.size(); i++) {
			   actual+=searchReturn.getIndex(i).getBusinessName()+" "+
		               searchReturn.getIndex(i).getFirstName()+" "+
		               searchReturn.getIndex(i).getLastName()+" "+
		               searchReturn.getIndex(i).getStreetAddress()+" "+
		               searchReturn.getIndex(i).getEmail()+" "+
		               searchReturn.getIndex(i).getPhoneNumber()+"\n";
		     }
		String expected="anikaHr" + " "+ "anika"+" "+"hridita"+" "+"99999"+" "+"12345"+" "+"77777"+"\n"+
		"anika" + " "+ "anika"+" "+"tabassum"+" "+"123456"+" "+"3333"+" "+"2222"+"\n";
				;
		assertEquals(expected, actual);
	}
	
	@Test
	void filterElementsTest2() {
		searchReturn.filterElements(1, "anikaHr");
		String actual="";
		for(int i = 0; i < searchReturn.size(); i++) {
			   actual+=searchReturn.getIndex(i).getBusinessName()+" "+
		               searchReturn.getIndex(i).getFirstName()+" "+
		               searchReturn.getIndex(i).getLastName()+" "+
		               searchReturn.getIndex(i).getStreetAddress()+" "+
		               searchReturn.getIndex(i).getEmail()+" "+
		               searchReturn.getIndex(i).getPhoneNumber()+"\n";
		     }

		String expected="anikaHr" + " "+ "anika"+" "+"hridita"+" "+"99999"+" "+"12345"+" "+"77777"+"\n";	
		assertEquals(expected, actual);
	}
	
	@Test
	void filterElementsTest3() {
		searchReturn.filterElements(2, "tabassum");
		String actual="";
		for(int i = 0; i < searchReturn.size(); i++) {
			   actual+=searchReturn.getIndex(i).getBusinessName()+" "+
		               searchReturn.getIndex(i).getFirstName()+" "+
		               searchReturn.getIndex(i).getLastName()+" "+
		               searchReturn.getIndex(i).getStreetAddress()+" "+
		               searchReturn.getIndex(i).getEmail()+" "+
		               searchReturn.getIndex(i).getPhoneNumber()+"\n";
		     }
		String expected="anika" + " "+ "anika"+" "+"tabassum"+" "+"123456"+" "+"3333"+" "+"2222"+"\n";
		assertEquals(expected, actual);
	}
	
	@Test
	void filterElementsTest4() {
		searchReturn.filterElements(2, "hridita");
		String actual="";
		for(int i = 0; i < searchReturn.size(); i++) {
			   actual+=searchReturn.getIndex(i).getBusinessName()+" "+
		               searchReturn.getIndex(i).getFirstName()+" "+
		               searchReturn.getIndex(i).getLastName()+" "+
		               searchReturn.getIndex(i).getStreetAddress()+" "+
		               searchReturn.getIndex(i).getEmail()+" "+
		               searchReturn.getIndex(i).getPhoneNumber()+"\n";
		     }
		String expected="anikaHr" + " "+ "anika"+" "+"hridita"+" "+"99999"+" "+"12345"+" "+"77777"+"\n";
		assertEquals(expected, actual);
	}
	


}
