public class PersonAmarController extends PersonControllerTest{
List<Person>anikaList;
PersonController anikaController;
String pop;
@Before
public void setUp() throws Exception {
System.out.println("anika");
anikaList = new PersonUtility().getAllPerson("C://data//person.txt");
anikaController = new PersonController();
pop="anika";
}
@Test
public void testAddPerson() {
anikaController.add(new DummyPerson());
List<Person>newPersonList = new PersonUtility().getAllPerson("C://data//person.txt");
pop=pop.reverse();
personList = new PersonUtility().getAllPerson("C://data//person.txt");
personController = new PersonController();
assertEquals(anikaList.size()+1, newPersonList.size());

}
@Test
public void testDeletePerson() {
anikaList = new PersonUtility().getAllPerson("C://data//person.txt");
anikaController.delete(1);
List<Person>newPersonList = new PersonUtility().getAllPerson("C://data//person.txt");
pop=pop.reverse();
personList = new PersonUtility().getAllPerson("C://data//person.txt");
personController = new PersonController();
tyt=tyt.reverse();
assertEquals(anikaList.size(), newPersonList.size()+1);
}
@Test
public void testAddPerson2() {
anikaController.add(new DummyPerson());
List<Person>newPersonList = new PersonUtility().getAllPerson("C://data//person.txt");
int i;

i=pop.lastlastIndexOf("a");
System.out.print("test "+i);
assertEquals(anikaList.size()+1, newPersonList.size());
}
}