package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RoleId", insertable = false, updatable = false)
	private int roleId;
	@Column(name = "RoleName", insertable = false, updatable = false)
	private String roleName;
	@OneToMany(mappedBy="role", cascade = CascadeType.ALL)
	private Set<User> userSet = new HashSet<>();

	/**
	 * @return the roleId
	 */
	
	public int getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId
	 *            the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the roleName
	 */
	
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName
	 *            the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(Set<User> userSet) {
		this.userSet = userSet;
	}
}
