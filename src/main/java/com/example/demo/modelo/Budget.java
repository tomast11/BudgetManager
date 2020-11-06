package com.example.demo.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;



@Entity
@Table (name = "budget")
public class Budget implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nrotrans;
	@NotEmpty
	@NotNull
	private String concept;
	@NotNull
	private float amount;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@NotNull
	private Date date;
	@NotNull
	private String type;
	
	public Budget() {
		// TODO Auto-generated constructor stub
	}

	public Budget(String concept, float amount, Date date, String type) {
		super();
		this.concept = concept;
		this.amount = amount;
		this.date = date;
		this.type = type;
	}
	
	public int getNrotrans() {
		return nrotrans;
	}

	public void setNrotrans(int nrotrans) {
		this.nrotrans = nrotrans;
	}

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}