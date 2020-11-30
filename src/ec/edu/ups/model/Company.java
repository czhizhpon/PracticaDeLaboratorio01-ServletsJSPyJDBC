package ec.edu.ups.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Company implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int comId;
	private String comName;
	private boolean comDeleted;
	private List<User> comUsers;
	private List<Product> comProducts;
	
	public Company() {

	}
	
	public Company(int comId, String comName, boolean comDeleted, List<User> comUsers, List<Product> comProducts) {
		super();
		this.comId = comId;
		this.comName = comName;
		this.comDeleted = comDeleted;
		this.comUsers = comUsers;
		this.comProducts = comProducts;
	}

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
	
	/**
	 * Agrega un nuevo producto a la empresa
	 * @param product
	 */
	public void addProduct(Product product) {
		if (this.comProducts != null) {
			this.comProducts = new ArrayList<Product>();
			this.comProducts.add(product);
		} else {
			this.comProducts.add(product);
		}
	}
	
	// Cambiar a composicion
	
	/**
	 * Crea un nuevo usuario para agregarlo a la empresa
	 * @param username
	 * @param email
	 * @param password
	 * @param name
	 * @param lastname
	 * @param role
	 */
	public void addUser(String username, String email, String password, 
						String name, String lastname, char role) {
		if (this.comUsers != null) {
			this.comUsers = new ArrayList<User>();
			this.comUsers.add(new User(username, email, password, name, lastname, role));
		} else {
			this.comUsers.add(new User(username, email, password, name, lastname, role));
		}
	}

	@Override
	public String toString() {
		return "Company [comId=" + comId + ", comName=" + comName + ", comDeleted=" + comDeleted + ", comUsers="
				+ comUsers + ", comProducts=" + comProducts + "]";
	}
}
