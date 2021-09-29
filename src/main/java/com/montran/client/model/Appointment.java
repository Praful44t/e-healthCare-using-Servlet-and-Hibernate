package com.montran.client.model;

import javax.persistence.Column;
import javax.persistence.Table;

import com.montran.admin.model.Faculty;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
@Table(name="appointment",schema="hospital")
public class Appointment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="appointment_id")
	private int appointId;
	@Column(name="doa")
	private LocalDate date;
	@ManyToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="patient_id")
	private User user;
	@ManyToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="doc_id")
	private Faculty faculty;
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public int getAppointId() {
		return appointId;
	}
	
	
	
}
