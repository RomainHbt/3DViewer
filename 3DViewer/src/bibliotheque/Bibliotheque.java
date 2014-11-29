package bibliotheque;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Bibliotheque {
	
	@SuppressWarnings("finally")
	protected static boolean addModel(String name, String path, String description, String keywords) throws ClassNotFoundException{
		Class.forName("org.sqlite.JDBC");
		Connection con = null;
		boolean good = true;
		try {
			con = DriverManager.getConnection("jdbc:sqlite:3DViewer");
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS modele (id SERIAL PRIMARY KEY, name STRING, path STRING, description STRING, keywords STRING, date_ajout DATETIME)");
			
			ResultSet rs = statement.executeQuery("SELECT MAX(id) FROM modele");
			int max;
			if(rs.next()){
				max = rs.getInt(1) + 1;
			} else {
				max = 1;
			}
			

			statement.executeUpdate("INSERT INTO modele VALUES("+max+", '"+name+"', '"+path+"', '"+description+"', '"+keywords+"', datetime())");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			good = false;
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
			return good;
		}
	}
	
	/**
	 * DEBUG FUNCTION
	 * @throws ClassNotFoundException
	 */
	public static void afficherTable() throws ClassNotFoundException{
		Class.forName("org.sqlite.JDBC");
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:sqlite:3DViewer");
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);
			
			ResultSet rs = statement.executeQuery("SELECT * FROM modele");
			
			while(rs.next()){
				System.out.println("-------------------------------------");
				System.out.println("id : "+rs.getString("id"));
				System.out.println("Name : "+rs.getString("name"));
				System.out.println("Path : "+rs.getString("path"));
				System.out.println("Description : "+rs.getString("description"));
				System.out.println("Keywords : "+rs.getString("keywords"));
				System.out.println("Date ajout : "+rs.getString("date_ajout"));
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
	}
	
}
