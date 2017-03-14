
package sql;

public class MainTester {

	public static void main(String[] args) {

		MySQLHelper db = new MySQLHelper("//localhost/CINEMA_RESERVATIONS", "guest", "123456");

//		db.insertInto("CLIENT", kamen);
//
//		db.deleteFrom("Clients", kamen.id);
//
//		db.update("Clients", kamen);
		

		
		System.out.println(db.selectFrom("Movies"));
		System.out.println(db.selectFrom("Reservations"));
	}
}
