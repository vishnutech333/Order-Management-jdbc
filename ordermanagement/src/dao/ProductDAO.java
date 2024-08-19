package dao;
import java.sql.*;

import connectionManager.ConnectionManager;
import model.Product;
public class ProductDAO {
	public void addProduct(Product p) throws ClassNotFoundException, SQLException
	{
		int prodID=p.getProdID();
		String prodName=p.getProdName();
		int price=p.getPrice();
		int quan=p.getQuan();
		String category=p.getCategory();
		ConnectionManager conm = new ConnectionManager();
		Connection con = conm.establishConnection();
		
		String query = "insert into productdetails values (?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1,prodID);
		ps.setString(2, prodName);
		ps.setInt(3,price);
		ps.setInt(4,quan);
		ps.setString(5, category);
		ps.executeUpdate();
		
		conm.closeConnection();
	}
	public void display() throws ClassNotFoundException, SQLException
	{
		ConnectionManager conm = new ConnectionManager();
		Connection con = conm.establishConnection();
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from productdetails");
		while(rs.next())
		{
			System.out.println(rs.getInt("prodID")+" | "+rs.getString("prodName")+" | "+rs.getInt("price")+" | "+rs.getInt("quan")+" | "+rs.getString("category"));
		}
	}
}
