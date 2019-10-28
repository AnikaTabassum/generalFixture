import java.util.concurrent.ThreadLocalRandom;
public class AnikaTest {
int anika;
float amiKisuParina;
String eijeAmi;
@Before
public void setUp() throws Exception {
anika=99;
amiKisuParina=98.256;
eijeAmi="Hridita";
}
@Test
public void testCheckInt() {
int checker=anika%2;
assertEquals(checker,1);
}
@Test
public void testCheckFloat() {
float tester=anika/2;
boolean flag=false;
if (tester<amiKisuParina){
	eijeAmi="newHridita";
}
assertEquals(eijeAmi, "newHridita");
}

}