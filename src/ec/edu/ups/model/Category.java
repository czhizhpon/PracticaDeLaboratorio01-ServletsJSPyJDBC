package ec.edu.ups.model;

import java.util.List;

public class Category {
	
	private int catId;
	private String catName;
	private boolean catDeleted;
	private List<Product> catProducts;
	private Company catCompany;

	
	public Category() {
		
	}
	
	public int getCatId() {
		return catId;
	}
	
	public void setCatId(int catId) {
		this.catId = catId;
	}
	
	public String getCatName() {
		return catName;
	}
	
	public void setCatName(String catName) {
		this.catName = catName;
	}
	
	public boolean isCatDeleted() {
		return catDeleted;
	}
	
	public void setCatDeleted(boolean catDeleted) {
		this.catDeleted = catDeleted;
	}
	
	public List<Product> getCatProducts() {
		return catProducts;
	}
	
	public void setCatProducts(List<Product> catProducts) {
		this.catProducts = catProducts;
	}

	public Company getCatCompany() {
		return catCompany;
	}

	public void setCatCompany(Company catCompany) {
		this.catCompany = catCompany;
	}

	@Override
	public String toString() {
		return "Category [catId=" + catId + ", catName=" + catName + ", catDeleted=" + catDeleted + ", catProducts="
				+ catProducts + ", catCompany=" + catCompany + "]";
	}



}
