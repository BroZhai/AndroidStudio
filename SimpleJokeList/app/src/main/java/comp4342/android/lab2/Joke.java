package comp4342.android.lab2;

/**
 * This class encapsulates the data pertaining to a Joke.
 */
public class Joke {

	/** The three possible rating values for jokes. */
	public static final int UNRATED = 0;
	public static final int LIKE = 1;
	public static final int DISLIKE = 2;
	
	/** Contains the text of this joke. */
	private String m_strJoke;
	
	/** Contains the rating of this joke, should only be one of the constant
	 * rating values declared above. */
	private int m_nRating;
	
	/**
	 * Initializes a joke with an empty string and the default rating of 
	 * UNRATED.
	 */
	public Joke() {
		this.m_strJoke = new String("");
		m_nRating = UNRATED;

	}
	
	/**
	 * Initializes a joke with the string passed in and the default rating of 
	 * UNRATED.
	 * 
	 * @param strJoke		Joke String used to initialize the text of this 
	 * 						joke.
	 */
	public Joke(String strJoke) {
		m_strJoke = strJoke;
		m_nRating = UNRATED;


	}
	
	/**
	 * Initializes a joke with the string and rating values passed in.
	 * 
	 * @param strJoke	Joke String used to initialize the text of this 
	 * 					joke.
	 * 
	 * @param nRating	Rating value to initialize the rating of this joke.
	 */
	public Joke(String strJoke, int nRating) {
		m_strJoke = strJoke;
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
	 * @param strJoke	The text of this joke.
	 */
	public void setJoke(String strJoke) {
		m_strJoke = strJoke;
	}

	/**
	 * Accessor for the rating of this joke.
	 * 
	 * @return	An integer value containing one of the possible 
	 * 			rating constants.
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
	 * Returns only the text of the joke. This method should mimic getJoke().
	 * 
	 * @return	A string containing the text of the joke
	 */
	@Override
	public String toString() {
		return getJoke();
	}
	
	/**
	 * An Object is equal to this Joke, if the Object is a Joke and its text is
	 * the same as this Joke's text. Text equality is defined by 
	 * String.equals(...). The rating is ignored in the determination of 
	 * equality.
	 * 
	 * @return	True if the object passed in is a Joke with the same text as
	 * 			this one; False otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		return ((obj instanceof Joke) && obj.toString().equals(m_strJoke));
	}
}
