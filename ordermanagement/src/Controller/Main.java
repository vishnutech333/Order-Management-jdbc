package Controller;
import java.sql.SQLException;
import java.util.Scanner;
import model.Login;
import model.Order;
import model.Product;
import model.Registration;
import dao.LoginDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import dao.RegistrationDAO;
public class Main {
	public static void main(String[] args)throws ClassNotFoundException, SQLException 

	{

		Scanner sc = new Scanner(System.in);

		int choice,product;

		Login l = new Login();
		
		Registration r= new Registration();

		LoginDAO ldao = new LoginDAO();

		Product p = new Product();

		ProductDAO pdao = new ProductDAO();
		
		RegistrationDAO rdao=new RegistrationDAO();
		
		Order o = new Order();
		
		OrderDAO odao = new OrderDAO();

		do
		{
			System.out.println("1. Seller\n2. Buyer\n3. Exit");
			System.out.println("*****************************************************");
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Seller Login!!!");
				System.out.println("Enter the username");
				String username = sc.next();
				System.out.println("Enter the password");
				String password = sc.next();
				l.setUsername(username);
				l.setPass(password);
				if(ldao.loginValidation(l))
				{
					System.out.println("Seller successfully logged in!!!");
					do
					{
						System.out.println("*****************************************************");
						System.out.println("1. Add Product\n2. Display Product\n3. PendingDelivery\n4. UpdateDeliveryStatus\n5. Logout");
						System.out.println("*****************************************************");
						System.out.println("Enter your choice");
						product = sc.nextInt();
						switch(product)
						{
						case 1:
							System.out.println("Add Products");
							System.out.println("Enter Product ID");
							int prodID = sc.nextInt();
							System.out.println("Enter Product Name");
							String prodName = sc.next();
							System.out.println("Enter Product Price");
							int price = sc.nextInt();
							System.out.println("Enter Product Quantity available in STOCK");
							int quan = sc.nextInt();
							System.out.println("Enter Product Category");
							String category=sc.next();
							p.setProdID(prodID);
							p.setProdName(prodName);
							p.setPrice(price);
							p.setQuan(quan);
							p.setCategory(category);
							pdao.addProduct(p);
							System.out.println("Product added Successfully!!!");
							break;
						case 2:
							System.out.println("Product details are below:");
							pdao.display();
							break;
						case 3:
							System.out.println("Undelivered order Details:");
							odao.pendingdelivery();
							break;
						case 4:
							odao.pendingdelivery();
							System.out.println("Enter the order_ID to be updated:");
							int f=sc.nextInt();
							odao.updatedelivery(f);
							break;
						case 5:
							System.out.println("Logged out successfully!!!");
							break;
						}
					}while(product!=5);
				}
				else
				{
					System.out.println("Seller failed to login!!!\nInvalid Username/Password");
				}
				break;
			case 2:
				System.out.println("Buyer Login!!!\n1. Login\n2. Create Account");
				int bl=sc.nextInt();
				switch(bl){
				case 1:	
				System.out.println("Enter the username");
				String username1 = sc.next();
				System.out.println("Enter the password");
				String password1 = sc.next();
				l.setUsername(username1);
				l.setPass(password1);
				if(ldao.loginValidation(l))
				{
					System.out.println("Buyer successfully logged in!!!");
					do
					{
						System.out.println("*****************************************************");
						System.out.println("1. Display Product\n2. Order\n3. Logout");
						System.out.println("*****************************************************");
						System.out.println("Enter your choice");
						product = sc.nextInt();
						switch(product)
						{
						case 1:
							System.out.println("Product details are below:");
							pdao.display();
							break;
						case 2:
							pdao.display();
							System.out.println("Enter the product_Id you want to order");
							int a=sc.nextInt();
							System.out.println("Enter the Quantity must be 1 or morethan 1");
							int a2=sc.nextInt();
							String a1=username1;
							o.setProdid(a);
							o.setQuantity(a2);
							o.setUsername(a1);
							odao.order(o);
							break;
						case 3:
							System.out.println("Logged out successfully!!!");
							break;
						}
					}while(product!=3);
				}
				else
				{
					System.out.println("Buyer failed to login!!!\nInvalid Username/Password");
				}
				break;
				
				case 2:
					System.out.println("Enter the email_Id");
					String username2 = sc.next();
					System.out.println("Enter the password");
					String password2 = sc.next();
					System.out.println("Enter your name");
					String username3 = sc.next();
					System.out.println("Enter the phone number");
					String phone = sc.next();
					System.out.println("Enter the city name");
					String address = sc.next();
					r.setUsername(username2);
					r.setPass(password2);
					r.setUser(username3);
					r.setPhone(phone);
					r.setAddress(address);
					rdao.register(r);
					System.out.println("Account created successfully now you can able to login");
					break;	
				}
			case 3:
				System.out.println("Exit");
				break;
			}
		}while(choice!=3);
		sc.close();
	}
}
