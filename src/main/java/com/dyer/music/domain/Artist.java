package com.dyer.music.domain;

import java.util.List;
import java.util.stream.Stream;

/**
 * Immutable domain object representing an <code>Artist</code>.
 * @author Chris Dyer
 */
public final class Artist {
	
	private final List<String> members;
	
	private final String origin;
	
	private final String name;
	
	/**
	 * Public constructor accepts all fields.
	 * @param members the {@link List} of <code>String</code> members
	 * @param origin the <code>String</code> {@link Artist} origin
	 * @param name the <code>String</code> {@link Artist} name
	 */
	public Artist(List<String> members, String origin, String name) {
		this.members = members;
		this.origin = origin;
		this.name = name;
	}

	/**
	 * @return the members
	 */
	public Stream<String> getMembers() {
		return members.stream();
	}

	/**
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
}
