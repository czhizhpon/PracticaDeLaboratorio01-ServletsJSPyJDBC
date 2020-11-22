package ec.edu.ups.model;

import java.util.Calendar;
import java.util.List;

public class BillHead {
	
	private int heaId;
	private double heaSubtotal;
	private double heaVat;
	private Calendar heaDate;
	private char heaStatus;
	private double heaTotal;
	private boolean heaDeleted;
	private User heaUser;
	private List<BillDetail> heaBillDetails;
	
	public BillHead() {
		
	}
	
	public int getHeaId() {
		return heaId;
	}
	
	public void setHeaId(int heaId) {
		this.heaId = heaId;
	}
	
	public double getHeaSubtotal() {
		return heaSubtotal;
	}
	
	public void setHeaSubtotal(double heaSubtotal) {
		this.heaSubtotal = heaSubtotal;
	}
	
	public double getHeaVat() {
		return heaVat;
	}
	
	public void setHeaVat(double heaVat) {
		this.heaVat = heaVat;
	}
	
	public Calendar getHeaDate() {
		return heaDate;
	}
	
	public void setHeaDate(Calendar heaDate) {
		this.heaDate = heaDate;
	}
	
	public char getHeaStatus() {
		return heaStatus;
	}
	
	public void setHeaStatus(char heaStatus) {
		this.heaStatus = heaStatus;
	}
	
	public double getHeaTotal() {
		return heaTotal;
	}
	
	public void setHeaTotal(double heaTotal) {
		this.heaTotal = heaTotal;
	}
	
	public boolean isHeaDeleted() {
		return heaDeleted;
	}
	
	public void setHeaDeleted(boolean heaDeleted) {
		this.heaDeleted = heaDeleted;
	}
	
	public User getHeaUser() {
		return heaUser;
	}
	
	public void setHeaUser(User heaUser) {
		this.heaUser = heaUser;
	}
	
	public List<BillDetail> getHeaBillDetails() {
		return heaBillDetails;
	}
	
	public void setHeaBillDetails(List<BillDetail> heaBillDetails) {
		this.heaBillDetails = heaBillDetails;
	}
	
	@Override
	public String toString() {
		return "BillHead [heaId=" + heaId + ", heaSubtotal=" + heaSubtotal + ", heaVat=" + heaVat + ", heaDate="
				+ heaDate + ", heaStatus=" + heaStatus + ", heaTotal=" + heaTotal + ", heaDeleted=" + heaDeleted
				+ ", heaUser=" + heaUser + ", heaBillDetails=" + heaBillDetails + "]";
	}
}
