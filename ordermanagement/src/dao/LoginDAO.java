package dao;
import java.sql.*;
import connectionManager.ConnectionManager;
import model.Login;
public class LoginDAO {
	public boolean loginValidation(Login l) throws ClassNotFoundException, SQLException
	{
		String username = l.getUsername();
		String password = l.getPass();
		
		ConnectionManager conm = new ConnectionManager();
		Connection con = conm.establishConnection();
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from logindetails");
		while(rs.next())
		{
			if(username.equals(rs.getString("user_Id")) && password.equals(rs.getString("pass")))
			{
				conm.closeConnection();
				return true;
			}
		}
		conm.closeConnection();
		return false;
        }
	
	
	
	
	
	
	}
