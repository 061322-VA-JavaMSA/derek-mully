package Model;

public class User {
	private int id;
	private String username;
	private String password;
	private boolean isEmployee;
	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
		
	}
	
	public boolean getEmployee() {
		return isEmployee;
	}


}