package com.spring.wecare.service;

import com.spring.wecare.entities.Roles;

public interface RoleService {

	/**
	 * Retrieves the roles based on the specified role name.
	 *
	 * @param role The name of the role to retrieve.
	 * @return The roles corresponding to the given role name, or null if not found.
	 */
	Roles getRoles(String role);

}