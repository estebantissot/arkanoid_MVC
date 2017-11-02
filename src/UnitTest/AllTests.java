package UnitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Singleton.class, UnitTest.class, TestPausaRaqueta.class, TestPausaBola.class, TestModelo.class, TestCollision.class})
public class AllTests {

}
