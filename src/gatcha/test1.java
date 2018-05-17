package gatcha;

import static org.junit.Assert.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class test1 {

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		sample s=new sample();
		assertNotSame(s.a(),s.b());
		assertNotEquals(s.f(),s.e());

	

	}

}
