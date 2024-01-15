package com.example.models;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the work_incident database table.
 * 
 */
@Entity
@Table(name="work_incident")
@NamedQuery(name="WorkIncident.findAll", query="SELECT w FROM WorkIncident w")
@NamedQuery(name = "findIncidentById", query = "SELECT w FROM WorkIncident w WHERE w.id = :id")
public class WorkIncident implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateReported;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateResolved;

	private String department;

	@Lob
	private String description;

	private String reportedBy;

	@Lob
	private String resolution;

	private String status;

	private String title;

	public WorkIncident() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getDateReported() {
		return this.dateReported;
	}

	public void setDateReported(Date dateReported) {
		this.dateReported = dateReported;
	}

	public Date getDateResolved() {
		return this.dateResolved;
	}

	public void setDateResolved(Date dateResolved) {
		this.dateResolved = dateResolved;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReportedBy() {
		return this.reportedBy;
	}

	public void setReportedBy(String reportedBy) {
		this.reportedBy = reportedBy;
	}

	public String getResolution() {
		return this.resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}