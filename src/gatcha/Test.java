package gatcha;

class Test {

	@org.junit.jupiter.api.Test
	void test() {
		FindDAO dc=new FindDAO();
		dc.findAll();
		ContorollDAO cd=new ContorollDAO();

		cd.delete(0);
	}

}
