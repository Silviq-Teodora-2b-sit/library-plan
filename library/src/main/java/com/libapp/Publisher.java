package com.libapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "Publisher.getByName", query = "from Publisher where publisherName=?")
@Table(name="PUBLISHER")
public class Publisher {

	private int publsherId;
	private String publisherName;
	
	
	@Id
	@Column(name="PublisherId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publisher_generator")
	@SequenceGenerator(name = "publisher_generator", sequenceName = "PUBLISHER_SEQUENCE",allocationSize = 1,initialValue = 1)
	public int getPublsherId() {
		return publsherId;
	}
	
	public void setPublsherId(int publsherId) {
		this.publsherId = publsherId;
	}
	
	@Column(name = "publisherName")
	public String getPublisherName() {
		return publisherName;
	}
	
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	
	public Publisher() {
		super();
		
	}
	

	@Override
	public String toString() {
		return "Publisher [publsherId=" + publsherId + ", publisherName=" + publisherName + "]";
	}

	
	public Publisher(String publisherName) {
		this.publisherName = publisherName;
	}
	
	
	
}
