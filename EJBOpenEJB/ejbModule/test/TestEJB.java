package test;

public class TestEJB {

	public static void main(String[] args) throws Exception {
		PersonTest pt = new PersonTest();
		pt.setUp();
		pt.addPerson();
		pt.list();
		pt.remove();
		pt.tearDown();
	}
}