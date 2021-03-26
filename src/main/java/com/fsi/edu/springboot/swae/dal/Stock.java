package com.fsi.edu.springboot.swae.dal;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stocks", schema = "swae")
public class Stock implements Serializable {

	private static final long serialVersionUID = -1382801072874543930L;

	@Id
	private String symbol;

	private String name;

	@Column(name = "ceo")
	private String chiefExecutiveOfficer;

	@Column(name = "year_founded")
	private Integer yearFounded;

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the ceo
	 */
	public String getChiefExecutiveOfficer() {
		return chiefExecutiveOfficer;
	}

	/**
	 * @param ceo the ceo to set
	 */
	public void setHullNumber(String ceo) {
		this.chiefExecutiveOfficer = ceo;
	}

	/**
	 * @return the yearFounded
	 */
	public Integer getYearFounded() {
		return yearFounded;
	}

	/**
	 * @param yearFounded the yearFounded to set
	 */
	public void setYearFounded(Integer yearFounded) {
		this.yearFounded = yearFounded;
	}

	@Override
	public int hashCode() {
		return Objects.hash(chiefExecutiveOfficer, name, symbol, yearFounded);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Stock other = (Stock) obj;
		return Objects.equals(chiefExecutiveOfficer, other.chiefExecutiveOfficer) && Objects.equals(name, other.name)
				&& Objects.equals(symbol, other.symbol) && Objects.equals(yearFounded, other.yearFounded);
	}

}
