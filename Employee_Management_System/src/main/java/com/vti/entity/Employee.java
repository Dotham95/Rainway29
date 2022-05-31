package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Employee")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "employee_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "employee_code", length = 50, nullable = false)
	private String employeecode;

	@Column(name = "email", length = 50, nullable = false, unique = true)
	private String email;

	@Column(name = "user_name", length = 50, nullable = false, unique = true)
	private String username;

	@Column(name = "full_name", length = 50, nullable = false, unique = true)
	private String fullname;

	@Column(name = "bithday")
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	private Date bithday;

	@Column(name = "address", length = 50, nullable = false, unique = true)
	private String address;

	@Column(name = "phone", length = 50, nullable = false, unique = true)
	private int phone;

	@Column(name = "id_card", length = 50, nullable = false, unique = true)
	private int idcard;

	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(name = "contract", length = 50, nullable = false, unique = true)
	private String contract;

	@Column(name = "`role`")
	@Enumerated(EnumType.STRING)
	private Role role;

	@Column(name = "password", length = 50, nullable = false, unique = true)
	private String password;

	@ManyToOne
	@JoinColumn(name = "department_id", referencedColumnName = "department_id")
	private Department department;

	@ManyToOne
	@JoinColumn(name = "position_id", referencedColumnName = "position_id")
	private Position position;

	@Column(name = "create_date")
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	private Date createDate;

	public enum Role {
		ADMIN, EMPLOYEE, MANAGER, ACCOUNTANT;
	}

	public enum Gender {
		MALE, FEMALE;
	}

}
