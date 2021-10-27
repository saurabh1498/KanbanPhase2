package com.cg.kanban.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "users_tbl")
public class User {
	@Id
	 @GeneratedValue( generator = "uid_Sequence")
    @SequenceGenerator(name = "uid_Sequence", sequenceName = "UID_SEQ",initialValue =2 , allocationSize = 1)
	@Column(name="user_id")
	private Integer id; 
	@Column(name="user_name",length = 30)
	private String name;
	@Column(name="user_email",length = 30)
	private String email;
	@Column(name="user_contact",length = 10)
	private String contact; 
	@Column(name="login_name",length = 30,unique = true)
	private String loginname;
	@Column(name="user_password",length = 30)
	private String password;
	@Column(name="user_status",length = 20)
	private String status;
	@Column(name="user_role",length = 20)
	private String role;
	public User() {
		super();
	}
	public User(Integer id, String name, String email, String contact, String loginname, String password, String status,
			String role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.loginname = loginname;
		this.password = password;
		this.status = status;
		this.role = role;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", contact=" + contact + ", loginname="
				+ loginname + ", password=" + password + ", status=" + status + ", role=" + role + "]";
	}
	
	
	
	
	
}
