package testFinalProject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ch05.collections.ArrayCollection;
import finalProject.finalProject.Contacts;
import support.LLNode;

class TestLLNode<T> {
	Contacts actual= new Contacts("lolipop", "candy", "snickers", "1212", "5555", "9999");
	LLNode<T> link=new LLNode((T) actual);
	T info= (T) new ArrayCollection<>();
	@Test
	void getInfoTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		final java.lang.reflect.Field field = link.getClass().getDeclaredField("info");
		field.setAccessible(true);

        field.set(link, actual);
        T expected=link.getInfo();
        assertEquals(actual, expected);
	}

	@Test
	public void setInfoTest() throws NoSuchFieldException, IllegalAccessException {
		link.setInfo((T)actual);
        final java.lang.reflect.Field field = link.getClass().getDeclaredField("info");
        field.setAccessible(true);
        assertEquals(actual, field.get(link));
    }
	
	@Test
	void getLinkTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		final java.lang.reflect.Field field = link.getClass().getDeclaredField("link");
		field.setAccessible(true);
        field.set(link, link);
        T expected=link.getInfo();
        assertEquals(actual, expected);
	}
	
	@Test
	void setLinkTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		link.setLink(link);
        final java.lang.reflect.Field field = link.getClass().getDeclaredField("link");
        field.setAccessible(true);
        assertEquals(link, field.get(link));
	}
}
