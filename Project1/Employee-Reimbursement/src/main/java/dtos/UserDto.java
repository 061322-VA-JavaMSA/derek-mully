package dtos;

import java.util.Objects;

import models.Role;
import models.User;

/*-
 * Data Transfer Objects
 */
public class UserDto {

	private int id;
	private String username;
	private Role role;
	
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserDto(User u) {
		id = u.getId();
		username = u.getUsername();
		role = u.getRole();
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, role, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDto other = (UserDto) obj;
		return id == other.id && role == other.role && Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + ", role=" + role + "]";
	}
}