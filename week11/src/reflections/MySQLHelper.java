package reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class MySQLHelper {

	private Connection conn;

	public MySQLHelper(String dbURL, String dbUser, String dbPass) {
		try {
			conn = DriverManager.getConnection("jdbc:mysql:" + dbURL, dbUser, dbPass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private String makeFirstLetterCapital(String s) {
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

	public boolean insertInto(String table, Object obj) {

		Field[] fields = obj.getClass().getDeclaredFields();

		try {
			LinkedList<String> fieldsList = new LinkedList<String>();
			for (Field f : fields) {
				fieldsList.add(
						(String) obj.getClass().getMethod("get" + makeFirstLetterCapital(f.getName())).invoke(obj));
			}

		//	String fieldsSQL = String.join(" , ", (String[]) fieldsSQL.toArray());

			//String sql = "INSERT INTO " + table + "(" + +") VALUES (" + fieldsSQL + ");";

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean deleteFrom(String table, int id) {
		return false;
	}

	public boolean update(String table, Object obj) {
		return false;
	}

	public List<List<String>> selectFrom(String table) {
		return selectFrom(table, "1");
	}

	public List<List<String>> selectFrom(String table, String where) {
		try {
			List<List<String>> result = new LinkedList<>();

			Statement stmt;
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM " + table + " WHERE " + where;
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				ResultSetMetaData md = rs.getMetaData();
				int columns = md.getColumnCount();

				List<String> row = new LinkedList<>();

				for (int i = 1; i <= columns; i++) {
					String colName = md.getColumnName(i);
					row.add(rs.getString(colName));
				}
				result.add(row);
			}
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

}
