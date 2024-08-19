package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectionManager.ConnectionManager;
import model.Order;

public class OrderDAO {

	public void order(Order o)throws ClassNotFoundException, SQLException
	{
		String user_Id=o.getUsername();
		int prodID=o.getProid();
		int quan=o.getQuantity();
		String s="notdelivered";
		ConnectionManager conm = new ConnectionManager();
		Connection con = conm.establishConnection();
		
		String query = "insert into productorder(user_Id,prodID,quan) values (?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		
		String query1 = "insert into productorder(dstatus) values (?)";
		PreparedStatement ps1 = con.prepareStatement(query1);
		ps.setString(1, user_Id);
		ps.setInt(2, prodID);
		ps.setInt(3, quan);
		ps.executeUpdate();
		ps1.setString(1, s);
		ps.executeUpdate();
		conm.closeConnection();
	}
	public void pendingdelivery()throws ClassNotFoundException, SQLException{
		ConnectionManager conm = new ConnectionManager();
		Connection con = conm.establishConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select productorder.order_Id,productorder.user_Id,deliverystatus.dstatus from productorder join deliverystatus where productorder.order_Id = deliverystatus.order_Id and deliverystatus.dstatus = 'notdelivered'") ;
		while(rs.next())
		{
			System.out.println(rs.getInt("order_Id")+" | "+rs.getString("user_Id")+" | "+rs.getString("dstatus"));
		}
		conm.closeConnection();
	}
	
	public void updatedelivery(int id)throws ClassNotFoundException, SQLException{
		ConnectionManager conm = new ConnectionManager();
		Connection con = conm.establishConnection();
		String query = "update deliverystatus set dstatus='delivered' where order_id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id);
		ps.executeUpdate();
		conm.closeConnection();
	}

}
