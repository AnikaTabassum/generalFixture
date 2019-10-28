package testFinalProject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import finalProject.finalProject.Contacts;
import sun.reflect.misc.FieldUtil;

class ContactTest {

	String businessName;
	String firstName;
	String lastName;
	String streetAddress;
	String email;
	String phoneNumber;
	
	final Contacts contact = new Contacts(businessName, firstName, lastName, streetAddress, email, phoneNumber);
	
	
	@Test
	public void testBusinessNameSetter() throws NoSuchFieldException, IllegalAccessException {
		contact.setBusinessName("anika");
        final java.lang.reflect.Field field = contact.getClass().getDeclaredField("businessName");
        field.setAccessible(true);
        assertEquals("anika", field.get(contact));
    }
	
	@Test
	public void testBusinessNamegetter()throws NoSuchFieldException, IllegalAccessException{
        final java.lang.reflect.Field field = contact.getClass().getDeclaredField("businessName");
        field.setAccessible(true);
        field.set(contact, "anika");
        final String result = contact.getBusinessName();
        assertEquals("anika", result);
	}

	
	@Test
	public void testFirstNameSetter() throws NoSuchFieldException, IllegalAccessException {
		contact.setFirstName("anika");
        final java.lang.reflect.Field field = contact.getClass().getDeclaredField("firstName");
        field.setAccessible(true);
        assertEquals("anika", field.get(contact));
    }
	@Test
	public void testFirstNamegetter()throws NoSuchFieldException, IllegalAccessException{
        final java.lang.reflect.Field field = contact.getClass().getDeclaredField("firstName");
        field.setAccessible(true);
        field.set(contact, "anika");
        final String result = contact.getFirstName();
        assertEquals("anika", result);
	}
	
	
	@Test
	public void testLastNameSetter() throws NoSuchFieldException, IllegalAccessException {
		contact.setLastName("tabassum");
        final java.lang.reflect.Field field = contact.getClass().getDeclaredField("lastName");
        field.setAccessible(true);
        assertEquals("tabassum", field.get(contact));
    }
	
	@Test
	public void testLastNamegetter()throws NoSuchFieldException, IllegalAccessException{
        final java.lang.reflect.Field field = contact.getClass().getDeclaredField("lastName");
        field.setAccessible(true);
        field.set(contact, "tabassum");
        final String result = contact.getLastName();
        assertEquals("tabassum", result);
	}
	
	@Test
	public void testAddressSetter() throws NoSuchFieldException, IllegalAccessException {
		contact.setStreetAddress("Dhaka");
        final java.lang.reflect.Field field = contact.getClass().getDeclaredField("streetAddress");
        field.setAccessible(true);
        assertEquals("Dhaka", field.get(contact));
    }
	
	
	@Test
	public void testAddressgetter()throws NoSuchFieldException, IllegalAccessException{
        final java.lang.reflect.Field field = contact.getClass().getDeclaredField("streetAddress");
        field.setAccessible(true);
        field.set(contact, "Dhaka");
        final String result = contact.getStreetAddress();
        assertEquals("Dhaka", result);
	}
	
	
	@Test
	public void testEmailSetter() throws NoSuchFieldException, IllegalAccessException {
		contact.setEmail("bsse0925@iit.du.ac.bd");
        final java.lang.reflect.Field field = contact.getClass().getDeclaredField("email");
        field.setAccessible(true);
        assertEquals("bsse0925@iit.du.ac.bd", field.get(contact));
    }
	
	
	@Test
	public void testEmailgetter()throws NoSuchFieldException, IllegalAccessException{
        final java.lang.reflect.Field field = contact.getClass().getDeclaredField("email");
        field.setAccessible(true);
        field.set(contact, "bsse0925@iit.du.ac.bd");
        final String result = contact.getEmail();
        assertEquals("bsse0925@iit.du.ac.bd", result);
	}
	
	
	@Test
	public void testPhoneSetter() throws NoSuchFieldException, IllegalAccessException {
		contact.setPhoneNumber("01911223344");
        final java.lang.reflect.Field field = contact.getClass().getDeclaredField("phoneNumber");
        field.setAccessible(true);
        assertEquals("01911223344", field.get(contact));
    }
	
	
	
	@Test
	public void testphonegetter()throws NoSuchFieldException, IllegalAccessException{
        final java.lang.reflect.Field field = contact.getClass().getDeclaredField("phoneNumber");
        field.setAccessible(true);
        field.set(contact, "01911223344");
        final String result = contact.getPhoneNumber();
        assertEquals("01911223344", result);
	}
}
