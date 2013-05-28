package org.jboss.resteasy.resteasyXXX;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestRep {

	private String test;
	
	public TestRep() {
	}
	
	public TestRep(String test) {
		this.test = test;
	}
	
	public String getTest() {
		return test;
	}
	
	public void setTest(String test) {
		this.test = test;
	}
}
