package com.vti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Accounting")
@Inheritance(strategy = InheritanceType.JOINED)
public class Accounting {

	@Column(name = "accounting_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
	private Employee employee;
	
	@Column(name = "basic_salary")
	private int basic_salary;

	@Column(name = "money_for_meals")
	private int money_for_meals;

	@Column(name = "responsibility")
	private int responsibility;
	
	@Column(name = "seniority")
	private int seniority;
	
	@ManyToOne
	@JoinColumn(name = "position_id", referencedColumnName = "position_id")
	private Position positionId;
	
	@Column(name = "bonus")
	private int bonus;

	@Column(name = "total_working_hours")
	private int total_working_hours;
	
	@Column(name = "total_overtime_hours")
	private int total_overtime_hours;
	
	@Column(name = "personal_income_tax")
	private int personal_income_tax;

	@Column(name = "advance")
	private int advance;
	
	@Column(name = "total_salary")
	private int total_salary;
}
