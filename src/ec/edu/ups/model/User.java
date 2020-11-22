package ec.edu.ups.model;

public class User {

	private int useId;
	private String useUsername;
	private String usuEmail;
	private String usuPassword;
	private String usuName;
	private String usuLastname;
	private char usuRole;
	private boolean usuDeleted;
	private Company usuCompany;
	
	public int getUseId() {
		return useId;
	}
	
	public void setUseId(int useId) {
		this.useId = useId;
	}
	
	public String getUseUsername() {
		return useUsername;
	}
	
	public void setUseUsername(String useUsername) {
		this.useUsername = useUsername;
	}
	
	public String getUsuEmail() {
		return usuEmail;
	}
	
	public void setUsuEmail(String usuEmail) {
		this.usuEmail = usuEmail;
	}
	
	public String getUsuPassword() {
		return usuPassword;
	}
	
	public void setUsuPassword(String usuPassword) {
		this.usuPassword = usuPassword;
	}
	
	public String getUsuName() {
		return usuName;
	}
	
	public void setUsuName(String usuName) {
		this.usuName = usuName;
	}
	
	public String getUsuLastname() {
		return usuLastname;
	}
	
	public void setUsuLastname(String usuLastname) {
		this.usuLastname = usuLastname;
	}
	
	public char getUsuRole() {
		return usuRole;
	}
	
	public void setUsuRole(char usuRole) {
		this.usuRole = usuRole;
	}
	
	public boolean isUsuDeleted() {
		return usuDeleted;
	}
	
	public void setUsuDeleted(boolean usuDeleted) {
		this.usuDeleted = usuDeleted;
	}
	
	public Company getUsuCompany() {
		return usuCompany;
	}
	
	public void setUsuCompany(Company usuCompany) {
		this.usuCompany = usuCompany;
	}

	@Override
	public String toString() {
		return "User [useId=" + useId + ", useUsername=" + useUsername + ", usuEmail=" + usuEmail + ", usuPassword="
				+ usuPassword + ", usuName=" + usuName + ", usuLastname=" + usuLastname + ", usuRole=" + usuRole
				+ ", usuDeleted=" + usuDeleted + ", usuCompany=" + usuCompany + "]";
	}

}
