package com.vti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Department")
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "department_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "department_name")
	private String name;

	@Column(name = "total_member")
	private int total_member;

	@OneToMany(mappedBy = "department")
	private List<Employee> employees;

	@Column(name = "create_date")
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	private Date createDate;

}
