package UnitTest;

import static org.junit.Assert.*;
import org.junit.Test;
import Heart.HeartModel;
public class Singleton {

	@Test
	public void test() {
		HeartModel aux = HeartModel.getInstance();
		assertEquals(aux, HeartModel.getInstance());
		assertEquals(aux, HeartModel.getInstance());
		assertEquals(aux, HeartModel.getInstance());
		assertEquals(aux, HeartModel.getInstance());

	}
	
}
