package comp4342.android.lab3;

/**
 * This class encapsulates the data pertaining to a Joke.
 */
//import android.content.res.Resources;
//import android.os.Bundle;

public class Joke {

	/** The three possible rating values for jokes **/
	public static final int UNRATED = 0;
	public static final int LIKE = 1;
	public static final int DISLIKE = 2;
	
	/** Contains the text of this joke **/
	private String m_strJoke;
	
	/** Contains the rating of this joke, should only be one of the constant rating values declared above. **/
	private int m_nRating;
	
	/** Contains the name of the Author of this joke. **/
	private String m_strAuthorName;
	
	/**
	 * Initializes a joke with an empty string and the default rating of UNRATED.
	 */

	
	public Joke() {
		m_strJoke = new String("");
		m_nRating = UNRATED;
		
	}
	
	/**
	 * Initializes a joke with the string passed in and the default rating of UNRATED.
	 * 
	 * @param strJoke		Joke String used to initialize the text of this joke.
	 */
	public Joke(String strJoke) {
		m_strJoke = strJoke;
		m_nRating = UNRATED;		
	}
	
	
	
	/**
	 * Initializes with the joke and author strings passed in and the default
	 * rating of UNRATED.
	 * 
	 * @param strJoke
	 *            Joke String used to initialize the text of this joke.
	 * 
	 * @param strAuthor
	 *            The name of the Author of this Joke.
	 */
	public Joke(String strJoke, String strAuthor) {
		// TODO
		m_strJoke = strJoke;
		m_strAuthorName = strAuthor;
		m_nRating = UNRATED;
		
	}

	/**
	 * Initializes with a joke and author string and rating value passed in.
	 * 
	 * @param strJoke
	 *            Joke String used to initialize the text of this joke.
	 * 
	 * @param strAuthor
	 *            The name of the Author of this Joke.
	 * 
	 * @param dLike
	 *            Rating value to initialize the rating of this joke.
	 */
	public Joke(String strJoke, String strAuthor, int nRating) {
		// TODO
		m_strJoke = strJoke;
		m_strAuthorName = strAuthor;
		m_nRating = nRating;	
	}
	
	
	/**
	 * Accessor for the text of this joke.
	 * 
	 * @return	A String value containing the text of this joke.
	 */
	public String getJoke() {
		return m_strJoke;
	}

	/**
	 * Mutator that changes the text of this joke.
	 *  
	 * @param mstrJoke	The text of this joke.
	 */
	public void setJoke(String mstrJoke) {
		m_strJoke = mstrJoke;
	}

	/**
	 * Accessor for the rating of this joke.
	 * 
	 * @return	An integer value containing one of the possible rating constants.
	 */
	public int getRating() {
		return m_nRating;
	}
	
	/**
	 * Mutator that changes the rating of this joke.
	 *  
	 * @param rating	One of the possible rating constants.
	 */
	public void setRating(int rating) {
		m_nRating = rating;
	}
	
	/**
	 * Accessor for the Author of this joke.
	 * 
	 * @return A String containing the Authors name.
	 */
	public String getAuthor() {
		// TODO
		return m_strAuthorName;
	}
	
	/**
	 * Mutator that changes the Author of this joke.
	 * 
	 * @param strAuthor
	 *            A String containing the Authors name.
	 */
	public void setAuthor(String strAuthor) {
		// TODO
		m_strAuthorName = strAuthor;
	}
	
	/**
	 * Returns only the text of the joke. This method should mimic getJoke().
	 * 
	 * @return	A string containing the text of the joke
	 */
	@Override
	public String toString() {
		return getJoke();
	}
	
	/**
	 * An Object is equal to this Joke if all items below are true:
	 * 
	 * 1) The Object is a Joke.
	 * 
	 * 2) The Joke's text is the same as this Joke's text. Whereby text equality
	 *    is defined by String.equals(...).
	 *    
	 * 3) the Author of the Joke is the same as this Joke's Author. Whereby
	 *    equality is defined by String.equals(...).
	 *    
	 * The rating is ignored in the determination of equality.
	 * 
	 * @return True if the object passed in is a Joke with the same text and 
	 * 		   Author as this one; False otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO
		Joke joke = (Joke) obj;
		return (joke.getJoke().equalsIgnoreCase(m_strJoke) 
				&& joke.getAuthor().equalsIgnoreCase(m_strAuthorName));
	}
	
	
}
