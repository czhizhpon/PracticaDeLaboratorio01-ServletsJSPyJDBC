package ec.edu.ups.model;

import java.util.List;

public class Company {

	private int comId;
	private String comName;
	private boolean comDeleted;
	private List<User> comUsers;
	private List<Product> comProducts;
	
	public int getComId() {
		return comId;
	}
	
	public void setComId(int comId) {
		this.comId = comId;
	}
	
	public String getComName() {
		return comName;
	}
	
	public void setComName(String comName) {
		this.comName = comName;
	}
	
	public boolean isComDeleted() {
		return comDeleted;
	}
	
	public void setComDeleted(boolean comDeleted) {
		this.comDeleted = comDeleted;
	}
	
	public List<User> getComUsers() {
		return comUsers;
	}
	
	public void setComUsers(List<User> comUsers) {
		this.comUsers = comUsers;
	}
	
	public List<Product> getComProducts() {
		return comProducts;
	}
	
	public void setComProducts(List<Product> comProducts) {
		this.comProducts = comProducts;
	}

	@Override
	public String toString() {
		return "Company [comId=" + comId + ", comName=" + comName + ", comDeleted=" + comDeleted + ", comUsers="
				+ comUsers + ", comProducts=" + comProducts + "]";
	}
}
