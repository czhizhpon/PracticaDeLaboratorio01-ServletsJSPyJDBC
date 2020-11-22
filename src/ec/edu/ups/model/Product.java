package ec.edu.ups.model;

public class Product {

	private int proId;
	private String proName;
	private int proStock;
	private boolean proDeleted;
	private Category proCategory;
	private Company proCompany;
	
	public Product() {
		
	}
	
	public int getProId() {
		return proId;
	}
	
	public void setProId(int proId) {
		this.proId = proId;
	}
	
	public String getProName() {
		return proName;
	}
	
	public void setProName(String proName) {
		this.proName = proName;
	}
	
	public int getProStock() {
		return proStock;
	}
	
	public void setProStock(int proStock) {
		this.proStock = proStock;
	}
	
	public boolean isProDeleted() {
		return proDeleted;
	}
	
	public void setProDeleted(boolean proDeleted) {
		this.proDeleted = proDeleted;
	}
	
	public Category getProCategory() {
		return proCategory;
	}
	
	public void setProCategory(Category proCategory) {
		this.proCategory = proCategory;
	}
	
	public Company getProCompany() {
		return proCompany;
	}
	
	public void setProCompany(Company proCompany) {
		this.proCompany = proCompany;
	}

	@Override
	public String toString() {
		return "Product [proId=" + proId + ", proName=" + proName + ", proStock=" + proStock + ", proDeleted="
				+ proDeleted + ", proCategory=" + proCategory + ", proCompany=" + proCompany + "]";
	}
}
