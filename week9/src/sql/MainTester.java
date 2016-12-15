package sql;

public class MainTester {

	public static void main(String[] args) {

		Client kamen = new Client("Kamen", 22);

		MySQLHelper db = new MySQLHelper("//localhost/TESTINGSQL", "guest", "123456");

//		db.insertInto("Clients", kamen);
//
//		db.deleteFrom("Clients", kamen.id);
//
//		db.update("Clients", kamen);
		
		
		System.out.println(db.selectFrom("MOVIESTAR"));
	}
}
