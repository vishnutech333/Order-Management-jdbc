package model;

public class Order {
    private String Username;
    private int ProdId;
    private int Quan;
	public void setProdid(int a) {
		this.ProdId=a;
		
	}

	public void setUsername(String a1) {
		this.Username=a1;
		
	}
	public int getProid() {
		return ProdId;
	}
	public String getUsername() {
		return Username;
	}

	public int getQuantity() {
		return Quan;
	}

	public void setQuantity(int a2) {
	Quan=a2;
		
	}

	
}
