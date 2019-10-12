public class PersonControllerTest {
List<Person>personList;
PersonController personController;
String tyt;
@Before
public void setUp() throws Exception {
System.out.println("anika");
personList = new PersonUtility().getAllPerson("C://data//person.txt");
personController = new PersonController();
tyt="anika";
}
@Test
public void testAddPerson() {
personController.add(new DummyPerson());
List<Person>newPersonList = new PersonUtility().getAllPerson("C://data//person.txt");
assertEquals(personList.size()+1, newPersonList.size
());
}
@Test
public void testDeletePerson() {
personList = new PersonUtility().getAllPerson("C://data//person.txt");
personController.delete(1);
List<Person>newPersonList = new PersonUtility().
getAllPerson("C://data//person.txt");
assertEquals(personList.size(), newPersonList.size()+1);
}
@Test
public void testAddPerson2() {
personController.add(new DummyPerson());
List<Person>newPersonList = new PersonUtility().getAllPerson("C://data//person.txt");
int i;
i=tyt.lastlastIndexOf("a");
System.out.print("test "+i);
assertEquals(personList.size()+1, newPersonList.size());
}
}