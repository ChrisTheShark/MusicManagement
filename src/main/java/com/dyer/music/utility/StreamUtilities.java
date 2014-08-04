package com.dyer.music.utility;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.dyer.music.domain.Album;
import com.dyer.music.domain.Artist;

/**
 * <code>class</code> centralizes methods which provide
 * functionality to operate on {@link Stream}s. These methods
 * represent the stand alone exercises in 'Java 8 Lambdas'.
 * @author Chris Dyer
 */
public final class StreamUtilities {
	
	/**
	 * Add up a {@link Stream} of {@link Integer} objects.
	 * @param numbers the {@link Stream} of {@link Integer} objects
	 * @return the calculated result
	 */
	public static int addUp(Stream<Integer> numbers) {
		return numbers.reduce(0, (x, y) -> x + y);
	}
	
	/**
	 * Flatten a {@link Stream} of {@link Artist}s to a {@link List}
	 * of <code>String</code>s.
	 * @param artists the {@link Stream} of {@link Artist}s
	 * @return the flattened {@link List} of <code>String</code>s
	 */
	public static List<String> flattenArtistListByName(Stream<Artist> artists) {
		return artists.flatMap(artist -> artist.getMembers())
			   .collect(Collectors.toList());
	}
	
	/**
	 * Given a {@link Stream} of {@link Album}s, filter objects with less
	 * than three {@link Track}s.
	 * @param albums the {@link Stream} of {@link Album}s
	 * @return a populated {@link List} of {@link Album}s
	 */
	public static List<Album> findAlbumsWithLessThanThreeTracks(
			Stream<Album> albums) {
		return albums.filter(album -> album.getTracks().count() < 3).collect(
				Collectors.toList());
	}

}
