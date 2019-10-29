public class PersonAnikaController extends PersonAmarController{
List<Person>a;
PersonController b;
String x;
@Before
public void setUp() throws Exception {
System.out.println("anika");
a = new PersonUtility().getAllPerson("C://data//person.txt");
b = new PersonController();
x="anika";
}
@Test
public void testAddPerson() {
b.add(new DummyPerson());
List<Person>newPersonList = new PersonUtility().getAllPerson("C://data//person.txt");
x=x.reverse();
personList = new PersonUtility().getAllPerson("C://data//person.txt");
personController = new PersonController();
assertEquals(a.size()+1, newPersonList.size());

}
@Test
public void testDeletePerson() {
a = new PersonUtility().getAllPerson("C://data//person.txt");
b.delete(1);
List<Person>newPersonList = new PersonUtility().getAllPerson("C://data//person.txt");
x=x.reverse();
personList = new PersonUtility().getAllPerson("C://data//person.txt");
personController = new PersonController();
tyt=tyt.reverse();
anikaList = new PersonUtility().getAllPerson("C://data//person.txt");
anikaController.delete(1);
pop=pop.reverse();
assertEquals(a.size(), newPersonList.size()+1);
}
@Test
public void testAddPerson2() {
b.add(new DummyPerson());
List<Person>newPersonList = new PersonUtility().getAllPerson("C://data//person.txt");
int i;

i=x.lastlastIndexOf("a");
System.out.print("test "+i);
assertEquals(a.size()+1, newPersonList.size());
}
}