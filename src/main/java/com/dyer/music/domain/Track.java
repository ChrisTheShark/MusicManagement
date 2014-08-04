package com.dyer.music.domain;

/**
 * Immutable domain <code>class</code> representing a 
 * <code>Track</code>.
 * @author Chris Dyer
 */
public final class Track {
	
	private final String name;
	
	/**
	 * Public constructor accepts all fields.
	 * @param name
	 */
	public Track(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
}
