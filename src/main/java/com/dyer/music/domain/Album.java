package com.dyer.music.domain;

import java.util.List;
import java.util.stream.Stream;

/**
 * Immutable domain <code>class</code> representing an 
 * <code>Album</code>.
 * @author Chris Dyer
 */
public final class Album {
	
	private final List<Artist> artists;
	
	private final List<Track> tracks;
	
	private final String name;
	
	/**
	 * Public constructor accepts all fields.
	 * @param artists the {@link List} of {@link Artist}s
	 * @param tracks the {@link List} of {@link Track}s
	 * @param name the <code>String</code> name
	 */
	public Album(List<Artist> artists, List<Track> tracks, 
			String name) {
		this.artists = artists;
		this.tracks = tracks;
		this.name = name;
	}

	/**
	 * @return the artists
	 */
	public Stream<Artist> getArtists() {
		return artists.stream();
	}
	
	/**
	 * @return the tracks
	 */
	public Stream<Track> getTracks() {
		return tracks.stream();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
