package com.consultas.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.joda.time.LocalDate;

@XmlRootElement(name = "paciente")
public class Paciente {

	private String name;
	private LocalDate dob;
	private double percentage;
	
	public Paciente() {
	}
	
	public Paciente(String name) {
		this.name = name;
	}

	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "dob")
	@XmlJavaTypeAdapter(type = LocalDate.class, value = com.consultas.springbatch.LocalDateXmlAdapter.class)
	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@XmlElement(name = "percentage")
	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	
}
