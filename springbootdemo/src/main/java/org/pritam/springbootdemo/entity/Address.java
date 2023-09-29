package org.pritam.springbootdemo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Entity
@Table(name="Address")
@JsonInclude(Include.NON_NULL)
public class Address {
	@Id
	@Column(name="addressid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="area")
	private String area;
	
	@OneToOne
	@JoinColumn(name = "userid", referencedColumnName = "userid")
	@JsonBackReference
	User user;

	public Address() {
	}

	public Address(String area) {
		super();
		this.area = area;
	}
	
}
