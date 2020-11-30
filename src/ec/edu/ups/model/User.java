package ec.edu.ups.model;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int useId;
	private String useUsername;
	private String useEmail;
	private String usePassword;
	private String useName;
	private String useLastname;
	private char useRole;
	private boolean useDeleted;
	private Company useCompany;
	
	public User() {

	}
	
	public User(int useId, String useUsername, String useEmail, 
				String usePassword, String useName, String useLastname, 
				char useRole, boolean useDeleted, Company useCompany) {
		super();
		this.useId = useId;
		this.useUsername = useUsername;
		this.useEmail = useEmail;
		this.usePassword = usePassword;
		this.useName = useName;
		this.useLastname = useLastname;
		this.useRole = useRole;
		this.useDeleted = useDeleted;
		this.useCompany = useCompany;
	}
	
	public User(String useUsername, String useEmail, String usePassword, 
				String useName, String useLastname, char useRole) {
		super();
		this.useUsername = useUsername;
		this.useEmail = useEmail;
		this.usePassword = usePassword;
		this.useName = useName;
		this.useLastname = useLastname;
		this.useRole = useRole;
	}

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

	public String getUseEmail() {
		return useEmail;
	}

	public void setUseEmail(String useEmail) {
		this.useEmail = useEmail;
	}

	public String getUsePassword() {
		return usePassword;
	}

	public void setUsePassword(String usePassword) {
		this.usePassword = usePassword;
	}

	public String getUseName() {
		return useName;
	}

	public void setUseName(String useName) {
		this.useName = useName;
	}

	public String getUseLastname() {
		return useLastname;
	}

	public void setUseLastname(String useLastname) {
		this.useLastname = useLastname;
	}

	public char getUseRole() {
		return useRole;
	}

	public void setUseRole(char useRole) {
		this.useRole = useRole;
	}

	public boolean isUseDeleted() {
		return useDeleted;
	}

	public void setUseDeleted(boolean useDeleted) {
		this.useDeleted = useDeleted;
	}

	public Company getUseCompany() {
		return useCompany;
	}

	public void setUseCompany(Company useCompany) {
		this.useCompany = useCompany;
	}

	@Override
	public String toString() {
		return "User [useId=" + useId + ", useUsername=" + useUsername + ", useEmail=" + useEmail + ", usePassword="
				+ usePassword + ", useName=" + useName + ", useLastname=" + useLastname + ", useRole=" + useRole
				+ ", useDeleted=" + useDeleted + ", useCompany=" + useCompany + "]";
	}

}
