package model;

public class Registration {
	private String username2;
	private String username3;
	private String pass;
	private String phone;
	private String address;
	public void setUsername(String username2) {
		this.username2=username2;
	}
	public void setPass(String password2) {
		this.pass=password2;		
	}
	public void setPhone(String phone) {
		this.phone=phone;	
	}
	public void setUser(String username3) {	
		this.username3=username3;
	}
	public void setAddress(String address) {
		
		this.address=address;
	}
	public String getUsername() {
		return username2;
	}
	public String getUser() {
		return username3;
	}
	public String getPass() {
		return pass;
	}
	public String getAddress() {
		return address;
	}
	public String getPhone() {
		return phone;
	}

}
