package testFinalProject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ch05.collections.ArrayCollection;
import ch05.collections.LinkedCollection;
import finalProject.finalProject.Contacts;
import support.LLNode;

class LinkedCollectionTest {

	@Test
	<T> void add() {
		LinkedCollection<T> lc= new LinkedCollection<>();
		T target= (T) new Contacts("Livefish","Noll","Bembridge",
				"05219 Crescent Oaks Drive","nbembridgeqm@yandex.ru","9232121119");
		boolean actual=lc.add(target);
		boolean expected=true;
		assertEquals(expected, actual);
	}

	@Test
	<T> void find1() {
		LinkedCollection<T> lc= new LinkedCollection<>();
		T target= (T) new Contacts("Livefish","Noll","Bembridge",
				"05219 Crescent Oaks Drive","nbembridgeqm@yandex.ru","9232121119");
		lc.add(target);
		T actual=lc.find(target);
		T expected=target;
		assertEquals(expected, actual);
	}
	
	@Test
	<T> void size1() {
		LinkedCollection<T> lc= new LinkedCollection<>();
		T target= (T) new Contacts("Livefish","Noll","Bembridge",
				"05219 Crescent Oaks Drive","nbembridgeqm@yandex.ru","9232121119");
		lc.add(target);
		int actual=lc.size();
		int expected=1;
		assertEquals(expected, actual);
	}
	
	@Test
	<T> void size2() {
		LinkedCollection<T> lc= new LinkedCollection<>();
		int n = 55;
		for(int i=0;i<n;i++) {
			T target= (T) new Contacts("Livefish","Noll","Bembridge",
					"05219 Crescent Oaks Drive","nbembridgeqm@yandex.ru","9232121119");
			lc.add(target);
		}
		int actual=lc.size();
		int expected=55;
		assertEquals(expected, actual);
	}
	
	@Test
	<T> void size3() {
		LinkedCollection<T> lc= new LinkedCollection<>();
		int actual=lc.size();
		int expected=0;
		assertEquals(expected, actual);
	}
	
	@Test
	<T> void remove() {

		T target= (T) new Contacts("Livefish","Noll","Bembridge",
				"05219 Crescent Oaks Drive","nbembridgeqm@yandex.ru","9232121119");
		LinkedCollection<T> arr= new LinkedCollection<>();
		arr.add(target);
		boolean actual=arr.remove(target);
		boolean expected=true;
		assertEquals(expected, actual);
	}
	
	
	@Test
	<T> void contains() {

		T target= (T) new Contacts("Livefish","Noll","Bembridge",
				"05219 Crescent Oaks Drive","nbembridgeqm@yandex.ru","9232121119");
		LinkedCollection<T> arr= new LinkedCollection<>();
		arr.add(target);
		boolean actual=arr.contains(target);
		
		boolean expected=true;
		assertEquals(expected, actual);
	}

	
	@Test
	<T> void get1() {

		T target= (T) new Contacts("Livefish","Noll","Bembridge",
				"05219 Crescent Oaks Drive","nbembridgeqm@yandex.ru","9232121119");
		LinkedCollection<T> arr= new LinkedCollection<>();
		arr.add(target);
		T actual=arr.get(target);
		T expected=target;
		assertEquals(expected, actual);
	}
	

	@Test
	<T> void isFull() {
		int n=100;
		LinkedCollection<T> arr= new LinkedCollection<>();
		for (int i=0;i<n;i++) {
			T target= (T) new Contacts("Livefish","Noll","Bembridge",
					"05219 Crescent Oaks Drive","nbembridgeqm@yandex.ru","9232121119");
			arr.add(target);
		}
		
		boolean actual=arr.isFull();
		boolean expected=false;
		assertEquals(expected, actual);
	}
	
	@Test
	<T> void isFull2() {
		LinkedCollection<T> arr= new LinkedCollection<>();
		int n=55;
		for (int i=0;i<n;i++) {
			T target= (T) new Contacts("Livefish","Noll","Bembridge",
					"05219 Crescent Oaks Drive","nbembridgeqm@yandex.ru","9232121119");
			arr.add(target);
		}
		
		boolean actual=arr.isFull();
		boolean expected=false;
		assertEquals(expected, actual);
	}
	
	@Test
	<T> void isEmpty() {
		LinkedCollection<T> arr= new LinkedCollection<>();
		boolean actual=arr.isEmpty();
		boolean expected=true;
		assertEquals(expected, actual);
	}
	
	@Test
	<T> void isEmpty2() {
		LinkedCollection<T> arr= new LinkedCollection<>();
		T target= (T) new Contacts("Livefish","Noll","Bembridge",
				"05219 Crescent Oaks Drive","nbembridgeqm@yandex.ru","9232121119");
		arr.add(target);
		boolean actual=arr.isEmpty();
		boolean expected=false;
		assertEquals(expected, actual);
	}
	
	@Test
	<T> void toString1() {
		LinkedCollection<T> arr= new LinkedCollection<>();
		T target= (T) new Contacts("Livefish","Noll","Bembridge",
				"05219 Crescent Oaks Drive","nbembridgeqm@yandex.ru","9232121119");
		arr.add(target);
		String actual=arr.toString2();
		String expected=target.toString()+" ";
		assertEquals(expected, actual);
	
	}
	
	@Test
	<T> void toString2() {
		LinkedCollection<T> arr= new LinkedCollection<>();
		T target= (T) new Contacts("Livefish","Noll","Bembridge",
				"05219 Crescent Oaks Drive","nbembridgeqm@yandex.ru","9232121119");
		arr.add(target);
		T target2= (T) new Contacts("Anika","koii","lalal","Dhaka",
				"abd@hgmail.com","0175921119");
		arr.add(target2);
		String actual=arr.toString2();
		String expected=target2.toString()+" "+target.toString()+" ";
		assertEquals(expected, actual);
	
	}
	
	@Test
	<T> void toString3() {
		LinkedCollection<T> arr= new LinkedCollection<>();
		String actual=arr.toString2();
		String expected="";
		assertEquals(expected, actual);
	
	}
	
	@Test
	<T> void count1() {
		LinkedCollection<T> arr= new LinkedCollection<>();

		T target= (T) new Contacts("Livefish","Noll","Bembridge",
				"05219 Crescent Oaks Drive","nbembridgeqm@yandex.ru","9232121119");
		
		LLNode<T> newNode = new LLNode<T>(target);
		arr.add(target);
		int actual=arr.counting(target);
		int expected=1;
		assertEquals(expected, actual);
	}
	
	@Test
	<T> void count2() {
		LinkedCollection<T> arr= new LinkedCollection<>();

		T target= (T) new Contacts("Livefish","Noll","Bembridge",
				"05219 Crescent Oaks Drive","nbembridgeqm@yandex.ru","9232121119");
		arr.add(target);
		T target2= (T) new Contacts("Anika","koii","lalal","Dhaka",
				"abd@hgmail.com","0175921119");
		arr.add(target2);
		int actual=arr.counting(target);
		int expected=1;
		assertEquals(expected, actual);
	}
	
	
	@Test
	<T> void count3() {
		LinkedCollection<T> arr= new LinkedCollection<>();
		int n=100;
		T target= (T) new Contacts("Livefish","Noll","Bembridge",
				"05219 Crescent Oaks Drive","nbembridgeqm@yandex.ru","9232121119");
		for (int i=0;i<n;i++) {
			arr.add(target);
		}
		int actual=arr.counting(target);
		
		int expected=n;
		
		assertEquals(expected, actual);
	}
	
	@Test
	<T> void count4() {
		LinkedCollection<T> arr= new LinkedCollection<>();
		int n=52;
		T target= (T) new Contacts("Livefish","Noll","Bembridge",
				"05219 Crescent Oaks Drive","nbembridgeqm@yandex.ru","9232121119");
		for (int i=0;i<n;i++) {
			arr.add(target);
		}
		T target2= (T) new Contacts("Anika","koii","lalal",
				"Dhaka","abd@hgmail.com","0175921119");
		int m=28;
		for (int i=0;i<m;i++) {
			arr.add(target2);
		}
		int actual=arr.counting(target2);
		
		int expected=m;
		
		assertEquals(expected, actual);
	}
	
}
