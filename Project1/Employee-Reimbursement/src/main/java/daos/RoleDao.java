package daos;

import models.Role;

public interface RoleDao {

	Role getRoleByName(String user_role);
}