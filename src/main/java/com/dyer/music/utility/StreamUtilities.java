package com.dyer.music.utility;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.dyer.music.domain.Album;
import com.dyer.music.domain.Artist;
import com.dyer.music.domain.Track;

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
	
	/**
	 * Count total number of members with the {@link Stream} of
	 * {@link Artist}s.
	 * @param artists the {@link Stream} of {@link Artist}s
	 * @return total count of all members
	 */
	public static int countTotalArtists(Stream<Artist> artists) {
		return artists.map(artist -> Long.valueOf(artist.getMembers().count()).intValue())
			.reduce(0, (accumulator, memberCount) -> accumulator + memberCount);
	}

	/**
	 * Count the lower case characters contained in a provided 
	 * <code>String</code>. This implementation ensures the <code>int</code>
	 * character representation is greater than ninety seven and less than
	 * one hundred and twenty two.
	 * @param input the provided <code>String</code>
	 * @return the count of lower case letters
	 */
	public static int countLowerCaseCharactersInString(String input){
		return Long.valueOf(input.chars()
				.filter(character -> (character >= 97) && (character <= 122))
				.count()).intValue();
	}
	
	/**
	 * Simple method to locate the <code>String</code> in a {@link List} of <code>String</code>s
	 * which has the largest number of lower case letters.
	 * @param inputs the {@link List} of <code>String</code>s
	 * @return an {@link Optional} representing the captured <code>String</code>
	 */
	public static Optional<String> findLargestNumberOfLowerCaseLetters(List<String> inputs) {
		return inputs.stream().max((input1, input2) -> Integer.valueOf(countLowerCaseCharactersInString(input1))
				.compareTo(Integer.valueOf(countLowerCaseCharactersInString(input2))));
	}
	
}
