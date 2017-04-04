package com.tcs.FirstHibernate;

import java.util.Set;

public class Vendor {

	public Vendor() {
		
	}
	
	private int vendorID;
	private String vendorName;
	@SuppressWarnings("rawtypes")
	private Set Children;
	public int getVendorID() {
		return vendorID;
	}
	public void setVendorID(int vendorID) {
		this.vendorID = vendorID;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	@SuppressWarnings("rawtypes")
	public Set getChildren() {
		return Children;
	}
	@SuppressWarnings("rawtypes")
	public void setChildren(Set children) {
		Children = children;
	}
	

}
