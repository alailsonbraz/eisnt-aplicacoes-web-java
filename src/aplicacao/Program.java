package aplicacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DB.getConnection();

			// INSERT QUESTAO 4
			st = conn.prepareStatement("INSERT INTO seller "
					+ "(username, first_name, last_name, gender, password, status) " + "VALUES " + "(?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, "scaetano");
			st.setString(2, "susana");
			st.setString(3, "caetano");
			st.setString(4, "female");
			st.setString(5, "123456");
			st.setInt(6, 1);

			/*
			 * st = conn.prepareStatement( "INSERT INTO user_details " +
			 * "(username, first_name, last_name, gender, password, status) " + "VALUES " +
			 * "(?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			 * 
			 * st.setString(1, "rusty"); st.setString(2, "rui"); st.setString(3,
			 * "carvalho"); st.setString(4, "male"); st.setString(5, "85745465");
			 * st.setInt(6, 1);
			 */

			/*
			 * st = conn.prepareStatement( "INSERT INTO seller " +
			 * "(username, first_name, last_name, gender, password, status) " + "VALUES " +
			 * "(?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			 * 
			 * st.setString(1, "jonh88"); st.setString(2, "joão"); st.setString(3, "silva");
			 * st.setString(4, "male"); st.setString(5, "4576343541212"); st.setInt(6, 1);
			 */

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! Id: " + id);
				}
			} else {
				System.out.println("No rows affected!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}

		/*
		 * // UPDATE QUESTAO 5 try { conn = DB.getConnection();
		 * 
		 * st = conn.prepareStatement("UPDATE user_details " +
		 * "SET usename = username + ? " + "WHERE " + "(id = ?)");
		 * 
		 * st.setString(1, "marcus20"); st.setInt(2, 90);
		 * 
		 * 
		 * st = conn.prepareStatement( "UPDATE user_details " +
		 * "SET usename = username + ? " + "WHERE " + "(last_name = ?)");
		 * 
		 * st.setString(1, "sanders"); st.setString(2, "Morais");
		 * 
		 * 
		 * int rowsAffected = st.executeUpdate();
		 * 
		 * System.out.println("Done! Rows affected: " + rowsAffected); } catch
		 * (SQLException e) { e.printStackTrace(); } finally { DB.closeStatement(st);
		 * DB.closeConnection(); }
		 */

		
		//DELETE QUESTÃO 6
		/*
		 * try { conn = DB.getConnection();
		 * 
		 * st = conn.prepareStatement("DELETE FROM user_details " + "WHERE " + "first_name = ?");
		 * 
		 * st.String(1, "david");
		 * 
		 *
		 * st = conn.prepareStatement("DELETE FROM user_details " + "WHERE " + "id = ?");
		 * 
		 * st.Int(1, 15);
		 
		 * 
		 * int rowsAffected = st.executeUpdate();
		 * 
		 * System.out.println("Done! Rows affected: " + rowsAffected); } catch
		 * (SQLException e) { throw new DbIntegrityException(e.getMessage()); } finally
		 * { DB.closeStatement(st); DB.closeConnection(); }
		 */
	}
}