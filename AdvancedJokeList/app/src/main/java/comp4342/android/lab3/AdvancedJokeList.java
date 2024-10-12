package comp4342.android.lab3;

import java.util.ArrayList;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import comp4342.android.lab3.Joke;
import comp4342.android.lab3.R;

public class AdvancedJokeList extends Activity  implements OnClickListener, OnKeyListener {

	/**
	 * Contains the name of the Author for the jokes.
	 */
	protected String m_strAuthorName;

	/**
	 * Contains the list of Jokes the Activity will present to the user.
	 **/
	protected ArrayList<Joke> m_arrJokeList;

	/**
	 * Adapter used to bind an AdapterView to List of Jokes.
	 */
	protected JokeListAdapter m_jokeAdapter;

	/**
	 * ViewGroup used for maintaining a list of Views that each display Jokes.
	 **/
	protected LinearLayout m_vwJokeLayout;

	/**
	 * EditText used for entering text for a new Joke to be added to
	 * m_arrJokeList.
	 **/
	protected EditText m_vwJokeEditText;

	/**
	 * Button used for creating and adding a new Joke to m_arrJokeList using the
	 * text entered in m_vwJokeEditText.
	 **/
	protected Button m_vwJokeButton;

	/**
	 * Background Color values used for alternating between light and dark rows
	 * of Jokes.
	 */
	protected int m_nDarkColor;
	protected int m_nLightColor;
	protected int m_nText;
		
	/**
	 * Context-Menu MenuItem ID's
	 * IMPORTANT: You must use these when creating your MenuItems or the tests
	 * used to grade your submission will fail.
	 */
	protected static final int REMOVE_JOKE_MENUITEM = Menu.FIRST;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// TODO
		// Let's do this!
		initLayout();
		
		Resources resources = getResources();
		
		m_nDarkColor = resources.getColor(R.color.dark);
		m_nLightColor= resources.getColor(R.color.light);
		m_nText=resources.getColor(R.color.text);
		m_strAuthorName = resources.getString(R.string.author_name);
		
		String[] strArray = resources.getStringArray(R.array.jokeList);
		for (int i=0; i<strArray.length; i++){
			Joke newjoke = new Joke(strArray[i],m_strAuthorName);
			addJoke(newjoke);
		}
		
		initAddJokeListeners();	
	}

	/**
	 * Method is used to encapsulate the code that initializes and sets the
	 * Layout for this Activity.
	 */
	protected void initLayout() {
		// 这里"根据需求"删除了一大段原来的代码
		setContentView(R.layout.advanced); //这里应用的是我们在layout里面新写的advanced.xml
		// (直接去写布局文件了，而不是去像上面那样hardcode XD)
		m_vwJokeLayout = (LinearLayout) findViewById(R.id.jokelayout); // 最上面已经声明过该项是一个Linear Layout对象了，直接通过ID找对应layout组件即可
		//下面的同理，都是已经在advanced里面写好的
		m_vwJokeEditText = (EditText) findViewById(R.id.newJokeEditText); //EditText控件
		m_vwJokeButton = (Button) findViewById(R.id.addJokeButton); //Button按钮控件

		m_arrJokeList = new ArrayList<Joke>(); //初始化笑话的"动态数组"
	}

	/**
	 * Method is used to encapsulate the code that initializes and sets the
	 * Event Listeners which will respond to requests to "Add" a new Joke to the
	 * list.
	 */
	protected void initAddJokeListeners() {
		// TODO
		m_vwJokeButton.setOnClickListener(this);
		m_vwJokeEditText.setOnKeyListener(this);
	}

	/**
	 * Method used for encapsulating the logic necessary to properly add a new
	 * Joke to m_arrJokeList, and display it on screen.
	 * 
	 * @param joke
	 *            The Joke to add to list of Jokes.
	 */
	protected void addJoke(Joke joke) {
		// TODO
		m_arrJokeList.add(joke);

		// 这里创建了一个JokeView对象，不仅仅是展示笑话内容本身，还有我们额外加进去的"折叠菜单"评价系统
		JokeView jv = new JokeView(getBaseContext(),joke);

		//这里是让为了笑话的背景颜色交替显示，偶数行是浅色，奇数行是深色 (和之前一致)
		if (m_arrJokeList.size()%2==0) {
            jv.setBackgroundColor(m_nLightColor);
        } else {
			jv.setBackgroundColor(m_nDarkColor);
		}
		
		m_vwJokeLayout.addView(jv); //这里的JokeView本身就是一个View对象，所以可以直接添加到Layout里面
		// 因为它extends了LinearLayout，所以可以直接addView
	}
	
	
//	@Override
	@SuppressLint("NewApi")
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String jokeText = m_vwJokeEditText.getText().toString();
	    if (!jokeText.isEmpty()) {
	            Joke newjoke = new Joke(jokeText,m_strAuthorName);
	    		addJoke(newjoke);
	            m_vwJokeEditText.setText("");

	            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
	            imm.hideSoftInputFromWindow(m_vwJokeEditText.getWindowToken(), 0);
	    }
	}

	@Override
	public boolean onKey(View arg0, int arg1, KeyEvent arg2) {
		// TODO Auto-generated method stub
    	String jokeText = m_vwJokeEditText.getText().toString();
        if ((arg2.getAction()==KeyEvent.ACTION_UP)&&(arg1==KeyEvent.KEYCODE_ENTER)){
        	Joke newjoke = new Joke(jokeText.substring(0, jokeText.length()-1),m_strAuthorName);
			addJoke(newjoke);
            m_vwJokeEditText.setText("");

            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(m_vwJokeEditText.getWindowToken(), 0);
        }
        return false;
	}
}