package com.libapp;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ROLE")
public class Role {
private int roleId;
private String roleName;

public Role() {
	super();
	// TODO Auto-generated constructor stub
}

public Role(String roleName) {
	super();
	this.roleName = roleName;
}

@Id
@Column(name="RoleId")
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "c_generator")
@SequenceGenerator(name = "c_generator", sequenceName = "ROLE_SEQUENCE",allocationSize = 1,initialValue = 1)
public int getRoleId() {
	return roleId;
}

public void setRoleId(int roleId) {
	this.roleId = roleId;
}

@Column(name = "roleName")
public String getRoleName() {
	return roleName;
}

public void setRoleName(String roleName) {
	this.roleName = roleName;
}


}
