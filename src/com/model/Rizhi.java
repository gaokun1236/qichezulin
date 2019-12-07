package com.model;

import java.sql.Timestamp;

/**
 * Rizhi entity. @author MyEclipse Persistence Tools
 */

public class Rizhi implements java.io.Serializable {

	// Fields

	private Integer rizhiId;
	private String rizhiName;
	private String dengluIp;
	private Timestamp date;

	// Constructors

	/** default constructor */
	public Rizhi() {
	}

	/** full constructor */
	public Rizhi(String rizhiName, String dengluIp, Timestamp date) {
		this.rizhiName = rizhiName;
		this.dengluIp = dengluIp;
		this.date = date;
	}

	// Property accessors

	public Integer getRizhiId() {
		return this.rizhiId;
	}

	public void setRizhiId(Integer rizhiId) {
		this.rizhiId = rizhiId;
	}

	public String getRizhiName() {
		return this.rizhiName;
	}

	public void setRizhiName(String rizhiName) {
		this.rizhiName = rizhiName;
	}

	public String getDengluIp() {
		return this.dengluIp;
	}

	public void setDengluIp(String dengluIp) {
		this.dengluIp = dengluIp;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

}