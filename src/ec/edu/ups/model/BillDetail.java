package ec.edu.ups.model;

public class BillDetail {
	
	private int detId;
	private int detAmount;
	private double detUnitPrice;
	private double detTotal;
	private boolean detDeleted;
	private Product detProduct;
	private BillHead detBillHead;
	
	public BillDetail() {
		
	}
	
	public int getDetId() {
		return detId;
	}
	
	public void setDetId(int detId) {
		this.detId = detId;
	}
	
	public int getDetAmount() {
		return detAmount;
	}
	
	public void setDetAmount(int detAmount) {
		this.detAmount = detAmount;
	}
	
	public double getDetUnitPrice() {
		return detUnitPrice;
	}
	
	public void setDetUnitPrice(double detUnitPrice) {
		this.detUnitPrice = detUnitPrice;
	}
	
	public double getDetTotal() {
		return detTotal;
	}
	
	public void setDetTotal(double detTotal) {
		this.detTotal = detTotal;
	}
	
	public boolean isDetDeleted() {
		return detDeleted;
	}
	
	public void setDetDeleted(boolean detDeleted) {
		this.detDeleted = detDeleted;
	}
	
	public Product getDetProduct() {
		return detProduct;
	}
	
	public void setDetProduct(Product detProduct) {
		this.detProduct = detProduct;
	}
	
	public BillHead getDetBillHead() {
		return detBillHead;
	}
	
	public void setDetBillHead(BillHead detBillHead) {
		this.detBillHead = detBillHead;
	}

	@Override
	public String toString() {
		return "BillDetail {detId=" + detId + ", detAmount=" + detAmount + ", detUnitPrice=" + detUnitPrice
				+ ", detTotal=" + detTotal + ", detDeleted=" + detDeleted + ", detProduct=" + detProduct
				+ ", detBillHead=" + detBillHead + "}";
	}
	
	public boolean calculateTotal() {
		try {
			double detTotal = getDetAmount() * getDetUnitPrice();
			setDetTotal(detTotal);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
