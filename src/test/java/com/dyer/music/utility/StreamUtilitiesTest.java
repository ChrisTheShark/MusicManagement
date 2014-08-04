package com.dyer.music.utility;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.dyer.music.domain.Album;
import com.dyer.music.domain.Artist;
import com.dyer.music.domain.Track;

/**
 * Testing for {@link StreamUtilities}.
 * @author Chris Dyer
 */
public class StreamUtilitiesTest {

	/**
	 * Testing for {@link StreamUtilities#addUp(java.util.stream.Stream)}.
	 */
	@Test
	public void testAddUp() {
		List<Integer> numbers = Arrays.asList(1, 2, 3);
		assertEquals(6, StreamUtilities.addUp(numbers.stream()));
	}
	
	/**
	 * Testing for {@link StreamUtilities#flattenArtistList(java.util.stream.Stream)}.
	 */
	@Test
	public void testFlattenArtistListByName() {
		Artist blackKeys = new Artist(Arrays.asList("Dan Auerbach", "Patrick Carney"), 
				"Akron, Ohio", "The Black Keys");
		List<String> expectedList = Arrays.asList("Dan Auerbach", 
				"Patrick Carney");
		assertEquals(expectedList, StreamUtilities.flattenArtistListByName(
				Arrays.asList(blackKeys).stream()));
	}
	
	/**
	 * Testing for {@link StreamUtilities#findAlbumsWithLessThanThreeTracks(java.util.stream.Stream)}.
	 */
	@Test
	public void testFindAlbumsWithLessThanThreeTracks() {
		Artist blackKeys = new Artist(Arrays.asList("Dan Auerbach", "Patrick Carney"), 
				"Akron, Ohio", "The Black Keys");
		Artist theBeatles = new Artist(Arrays.asList("John Lennon", "Paul McCartney", 
				"George Harrison", "Ringo Starr"), "Liverpool, UK", "The Beatles");

		/*
		 * <code>Album</code>s with abbreviated <code>Track</code> list.
		 */
		Album theWhiteAlbum = new Album(Arrays.asList(theBeatles),
				Arrays.asList(new Track("Back in the U.S.S.R."), 
						new Track("Dear Prudence"), new Track("Glass Onion"), 
						new Track("Ob-La-Di, Ob-La-Da")), "The Beatles");
		Album theBigComeUp = new Album(Arrays.asList(blackKeys),
				Arrays.asList(new Track("Busted"), new Track("Do the Rump")), 
				"The Big Come Up");
		
		List<Album> filteredList = StreamUtilities.findAlbumsWithLessThanThreeTracks(
				Arrays.asList(theWhiteAlbum, theBigComeUp).stream());
		assertEquals(1, filteredList.size());
		assertEquals(theBigComeUp.getName(), filteredList.get(0).getName());
	}

}