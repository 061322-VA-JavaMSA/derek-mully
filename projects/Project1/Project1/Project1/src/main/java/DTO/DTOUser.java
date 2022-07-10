package DTO;

import java.util.Objects;

import Models.User;

public class DTOUser {
	private int id;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private int roleId;
	
	public DTOUser() {
		super();
	}
	
	public DTOUser(User u) {
		id = u.getId();
		userName = u.getUsername();
		firstName = u.getFirstName();
		lastName = u.getLastName();
		email = u.getEmail();
		roleId = u.getRoleId();
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, id, lastName, roleId, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DTOUser other = (DTOUser) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName) && roleId == other.roleId
				&& Objects.equals(userName, other.userName);
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", roleId=" + roleId + "]";
	}

	public static Object add(DTOUser dtoUser) {
		return dtoUser;
	}
	
}