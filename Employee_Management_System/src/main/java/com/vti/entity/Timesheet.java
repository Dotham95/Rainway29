package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "Timesheet")
public class Timesheet implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "`date`")
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
	private Employee employee;
	
	@Column(name = "time_in")
	private int time_in;

	@Column(name = "time_out")
	private int time_out;

	@Column(name = "working_time")
	private int working_time;
	
	@Column(name = "overtime")
	private int overtime;
	
	@Column(name = "`status` ")
	private String status ;
}
