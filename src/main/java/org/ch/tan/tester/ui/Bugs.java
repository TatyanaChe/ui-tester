package org.ch.tan.tester.ui;

public enum Bugs {
	CHECKBOX("checkbox"),
	LINKS("links");
	
	private String bugName;

	private Bugs(String bugName) {
		this.bugName = bugName;
	}
	
	public String bugName() {
		return bugName;
	}

}
