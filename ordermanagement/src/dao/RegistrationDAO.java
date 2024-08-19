package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connectionManager.ConnectionManager;
import model.Registration;

public class RegistrationDAO {
public void register(Registration r) throws ClassNotFoundException, SQLException{
		String user_Id =r.getUsername();
		String pass =r.getPass();
		String user_name =r.getUser();
		String phone_no =r.getPhone();
		String address =r.getAddress();
		
		ConnectionManager conm = new ConnectionManager();
		Connection con = conm.establishConnection();
		
		String query = "insert into logindetails values (?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, user_Id);
		ps.setString(2, pass);
		ps.executeUpdate();
		
		
		String query1 = "insert into userdetails values (?,?,?,?)";
		PreparedStatement ps1 = con.prepareStatement(query1);
		ps1.setString(1, user_Id);
		ps1.setString(2, user_name);
		ps1.setString(3, phone_no);
		ps1.setString(4, address);
        ps1.executeUpdate();
		
		conm.closeConnection();
		
	}
}
