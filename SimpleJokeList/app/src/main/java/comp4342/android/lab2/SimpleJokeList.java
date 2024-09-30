package comp4342.android.lab2;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class SimpleJokeList extends Activity {

	/** Contains the list Jokes the Activity will present to the user. */
	protected ArrayList<comp4342.android.lab2.Joke> m_arrJokeList;

	/** LinearLayout used for maintaining a list of Views that each display Jokes. */
	protected LinearLayout m_vwJokeLayout;

	/** EditText used for entering text for a new Joke to be added to m_arrJokeList. */
	protected EditText m_vwJokeEditText;

	/** Button used for creating and adding a new Joke to m_arrJokeList using the
	 * text entered in m_vwJokeEditText. */
	protected Button m_vwJokeButton;
	
	/** Background Color values used for alternating between light and dark rows
	 * of Jokes. */
	protected int m_nDarkColor;
	protected int m_nLightColor;

	@Override
	public void onCreate(Bundle savedInstanceState) { // 当Activity创建时
		super.onCreate(savedInstanceState);
		// TODO
		// 完成"笑话数组"Arraylist的初始化 (注册一个Arraylist对象，里面放的数据类型是Joke)
		m_arrJokeList = new ArrayList<Joke>();

		// 获取一下"/values/strings"里面定义的 笑话内容，存到这里的String[] 数组里面
		// 获取"大资源R"里面定义的一个"<string-array>"，对应下面的.getStringArray方法，"()"里面传R.array.名字 <... name="jokeList">
		String[] strArray = getResources().getStringArray(R.array.jokeList);

		// 调用"初始化layout布局"方法 (注意这里的顺序很重要，要先"创建了布局"，才能往布局里面"塞其他东西")
		initLayout();
	}
	
	/**
	 * Method used to encapsulate the code that initializes and sets the Layout
	 * for this Activity. 
	 */
	protected void initLayout() {
		// TODO
	}
	
	/**
	 * Method used to encapsulate the code that initializes and sets the Event
	 * Listeners which will respond to requests to "Add" a new Joke to the 
	 * list. 
	 */
	protected void initAddJokeListeners() {
		// TODO
	}

	/**
	 * Method used for encapsulating the logic necessary to properly initialize
	 * a new joke, add it to m_arrJokeList, and display it on screen.
	 * 
	 * @param strJoke
	 *            A string containing the text of the Joke to add.
	 */
	protected void addJoke(String strJoke) {
		// TODO
	}
}