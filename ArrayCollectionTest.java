package testFinalProject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ch05.collections.ArrayCollection;
import finalProject.finalProject.Contacts;

class ArrayCollectionTest {

	@Test
	<T> void add1() {
		
		T target= (T) new Contacts("Livefish","Noll","Bembridge","05219 Crescent Oaks Drive","nbembridgeqm@yandex.ru","9232121119");
		
		ArrayCollection<T> arr= new ArrayCollection<>();
		boolean actual=arr.add(target);
		
		boolean expected=true;
		assertEquals(expected, actual);
		
	}
	
	@Test
	<T> void find() {

		T target= (T) new Contacts("Livefish","Noll","Bembridge","05219 Crescent Oaks Drive","nbembridgeqm@yandex.ru","9232121119");
		ArrayCollection<T> arr= new ArrayCollection<>();
		arr.add(target);
		int actual=arr.find(target);
		
		int expected=0;
		assertEquals(expected, actual);
	}

	@Test
	<T> void find2() {
		String streetAddress="zzz";
		String phoneNumber="5555";
		String firstName = "naika";
		String lastName="koli";
		String businessName="ppp";
		String email="kikiki";
		
		T target2=(T) new Contacts(businessName, firstName, lastName, streetAddress, email, phoneNumber);
		ArrayCollection<T> arr= new ArrayCollection<>();
		int actual=arr.find(target2);
		
		int expected=-99999;
		assertEquals(expected, actual);
	}
	
	@Test
	<T> void find3() {
		String streetAddress="zzz";
		String phoneNumber="5555";
		String firstName = "naika";
		String lastName="koli";
		String businessName="ppp";
		String email="kikiki";
		T target= (T) new Contacts("Livefish","Noll","Bembridge","05219 Crescent Oaks Drive","nbembridgeqm@yandex.ru","9232121119");
		T target2=(T) new Contacts(businessName, firstName, lastName, streetAddress, email, phoneNumber);
		ArrayCollection<T> arr= new ArrayCollection<>();
		arr.add(target);
		arr.add(target2);
		int actual=arr.find(target2);
		
		int expected=1;
		assertEquals(expected, actual);
	}
	
	@Test
	<T> void find4() {
		int n=50;
		ArrayCollection<T> arr= new ArrayCollection<>();
		T target= (T) new Contacts("Livefish","Noll","Bembridge","05219 Crescent Oaks Drive","nbembridgeqm@yandex.ru","9232121119");
		for(int i=0;i<n;i++) {
			arr.add(target);
		}
		T target2=(T) new Contacts("anika", "anika","tabassum", "32 kha dhaka", "bsse0925@iit.du.ac.bd", "01955073646");
		arr.add(target2);
		int actual=arr.find(target2);
		int expected=50;
		assertEquals(expected, actual);
	}
	
	@Test
	<T> void remove() {

		T target= (T) new Contacts("Livefish","Noll","Bembridge","05219 Crescent Oaks Drive","nbembridgeqm@yandex.ru","9232121119");
		ArrayCollection<T> arr= new ArrayCollection<>();
		arr.add(target);
		boolean actual=arr.remove(target);
		boolean expected=true;
		assertEquals(expected, actual);
	}
	
	
	<T> void remove2() {

		T target= (T) new Contacts("Livefish","Noll","Bembridge","05219 Crescent Oaks Drive","nbembridgeqm@yandex.ru","9232121119");
		ArrayCollection<T> arr= new ArrayCollection<>();
		
		boolean actual=arr.remove(target);
		boolean expected=false;
		assertEquals(expected, actual);
	}

	@Test
	<T> void contains() {

		T target= (T) new Contacts("Livefish","Noll","Bembridge","05219 Crescent Oaks Drive","nbembridgeqm@yandex.ru","9232121119");
		ArrayCollection<T> arr= new ArrayCollection<>();
		arr.add(target);
		boolean actual=arr.contains(target);
		
		boolean expected=true;
		assertEquals(expected, actual);
	}
	
	@Test
	<T> void contains2() {
		String streetAddress="zzz";
		String phoneNumber="5555";
		String firstName = "naika";
		String lastName="koli";
		String businessName="ppp";
		String email="kikiki";
		T target= (T) new Contacts("Livefish","Noll","Bembridge","05219 Crescent Oaks Drive","nbembridgeqm@yandex.ru","9232121119");
		T target2=(T) new Contacts(businessName, firstName, lastName, streetAddress, email, phoneNumber);
		ArrayCollection<T> arr= new ArrayCollection<>();
		
		arr.add(target);
		
		boolean actual=arr.contains(target2);	
		boolean expected=false;
		assertEquals(expected, actual);
	}
	
	
	@Test
	<T> void get1() {

		T target= (T) new Contacts("Livefish","Noll","Bembridge","05219 Crescent Oaks Drive","nbembridgeqm@yandex.ru","9232121119");
		ArrayCollection<T> arr= new ArrayCollection<>();
		arr.add(target);
		T actual=arr.get(target);
		System.out.println();
		T expected=target;
		assertEquals(expected, actual);
	}
	
	@Test
	<T> void get2() {
		String streetAddress="zzz";
		String phoneNumber="5555";
		String firstName = "naika";
		String lastName="koli";
		String businessName="ppp";
		String email="kikiki";
		T target= (T) new Contacts("Livefish","Noll","Bembridge","05219 Crescent Oaks Drive","nbembridgeqm@yandex.ru","9232121119");
		T target2= (T) new Contacts(businessName, firstName, lastName, streetAddress, email, phoneNumber);
		
		ArrayCollection<T> arr= new ArrayCollection<>();
		arr.add(target2);
		
		T actual=arr.get(target);
		T expected=null;
		assertEquals(expected, actual);
	}
	
	@Test
	<T> void isFull() {
		int n=100;
		ArrayCollection<T> arr= new ArrayCollection<>();
		for (int i=0;i<n;i++) {
			T target= (T) new Contacts("Livefish","Noll","Bembridge","05219 Crescent Oaks Drive","nbembridgeqm@yandex.ru","9232121119");
			arr.add(target);
		}
		
		boolean actual=arr.isFull();
		boolean expected=true;
		assertEquals(expected, actual);
	}
	
	@Test
	<T> void isFull2() {
		ArrayCollection<T> arr= new ArrayCollection<>();
		int n=55;
		for (int i=0;i<n;i++) {
			T target= (T) new Contacts("Livefish","Noll","Bembridge","05219 Crescent Oaks Drive","nbembridgeqm@yandex.ru","9232121119");
			arr.add(target);
		}
		
		boolean actual=arr.isFull();
		boolean expected=false;
		assertEquals(expected, actual);
	}
	
	@Test
	<T> void isEmpty() {
		ArrayCollection<T> arr= new ArrayCollection<>();
		boolean actual=arr.isEmpty();
		boolean expected=true;
		assertEquals(expected, actual);
	}
	
	@Test
	<T> void isEmpty2() {
		ArrayCollection<T> arr= new ArrayCollection<>();
		T target= (T) new Contacts("Livefish","Noll","Bembridge","05219 Crescent Oaks Drive","nbembridgeqm@yandex.ru","9232121119");
		arr.add(target);
		boolean actual=arr.isEmpty();
		boolean expected=false;
		assertEquals(expected, actual);
	}
	
	@Test
	<T> void size() {
		ArrayCollection<T> arr= new ArrayCollection<>();
		T target= (T) new Contacts("Livefish","Noll","Bembridge",
				"05219 Crescent Oaks Drive","nbembridgeqm@yandex.ru","9232121119");
		arr.add(target);
		int actual=arr.size();
		int expected=1;
		assertEquals(expected, actual);
	}
	
	
	@Test
	<T> void size2() {
		ArrayCollection<T> arr= new ArrayCollection<>();
		int n=50;
		for(int i=0;i<n;i++) {
			T target= (T) new Contacts("Livefish","Noll","Bembridge",
					"05219 Crescent Oaks Drive","nbembridgeqm@yandex.ru","9232121119");
			arr.add(target);
		}
		int actual=arr.size();
		int expected=50;
		assertEquals(expected, actual);
	}
	
	@Test
	<T> void size3() {
		ArrayCollection<T> arr= new ArrayCollection<>();
		int actual=arr.size();
		int expected=0;
		assertEquals(expected, actual);
	}
	
	@Test
	<T> void size4() {
		ArrayCollection<T> arr= new ArrayCollection<>();
		int n=100;
		T target= (T) new Contacts("Livefish","Noll","Bembridge",
				"05219 Crescent Oaks Drive","nbembridgeqm@yandex.ru","9232121119");
		for(int i=0;i<n;i++) {
			arr.add(target);
		}
		int actual=arr.size();
		int expected=100;
		assertEquals(expected, actual);
	}
}
