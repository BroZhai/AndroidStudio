package comp4342.android.lab2;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

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
	protected int m_nTextColor;

	@Override
	public void onCreate(Bundle savedInstanceState) { // 当Activity创建时
		super.onCreate(savedInstanceState);
		// TODO
		// 调用"初始化layout布局"方法 (注意这里的顺序很重要，要先"创建了布局"，才能往布局里面"塞其他东西")
		initLayout();

		// 获取/values/colors.xml里面定义的'亮暗色'背景颜色，还有'文字显示颜色'
		m_nLightColor = getResources().getColor(R.color.light);
		m_nDarkColor = getResources().getColor(R.color.dark);
		m_nTextColor = getResources().getColor(R.color.text);

		// 完成"笑话数组"Arraylist的初始化 (注册一个Arraylist对象，里面放的数据类型是Joke)
		m_arrJokeList = new ArrayList<Joke>();

		// 获取一下"/values/strings"里面定义的 笑话内容，存到这里的String[] 数组里面
		// 获取"大资源R"里面定义的一个"<string-array>"，对应下面的.getStringArray方法，"()"里面传R.array.名字 <... name="jokeList">
		// 前面的getResources()则是获取"所有的资源类"
		String[] strArray = getResources().getStringArray(R.array.jokeList);

		// 遍历strArray数组中的每一个笑话'元素'，将其添加到m_arrJokeList中
		for(int i=0; i<strArray.length; i++){
			addJoke(strArray[i]);
		}



		// 初始化"添加笑话"的事件监听器 (目前还没有搞明白xwx)
		initAddJokeListeners();
	}
	
	/**
	 * Method used to encapsulate the code that initializes and sets the Layout
	 * for this Activity. 
	 */
	// 这个方法是用来"初始化layout布局"用的 (对应onCreate()里面的首行调用)
	protected void initLayout() {
		// TODO
		m_vwJokeLayout=new LinearLayout(getBaseContext()); // TODO: 待搞明白安卓的各种"布局规则"，这里用的是"LinearLayout"
		m_vwJokeLayout.setOrientation(LinearLayout.VERTICAL);

		// todo:待搞明白下面的ScrollView控件是干什么的...
		ScrollView sv=new ScrollView(getBaseContext()); //展示"笑话"的layout
		sv.addView(m_vwJokeLayout);

		// 新的UI要素，将会添加一个"输入框"和一个"AddJoke"按钮
		// todo: 搞明白这里的LinearLayout是个什么"布局"
		LinearLayout root = new LinearLayout(getBaseContext()); //这里是个最大最外的"根布局"
		root.setOrientation(LinearLayout.VERTICAL);

		LinearLayout addjokeArea = new LinearLayout(getBaseContext());
		addjokeArea.setOrientation(LinearLayout.HORIZONTAL);

		//往addjokeArea的LinearLayout中添加一个View组件(按钮)
		m_vwJokeButton = new Button(getBaseContext());
		m_vwJokeButton.setText("添加笑话"); //设置按钮字体
		addjokeArea.addView(m_vwJokeButton);//将该按钮添加到addjokeArea layout当中去

		//同样的，再往addjokeArea中添加一个"文字输入框"(EditText)组件
		m_vwJokeEditText = new EditText(getBaseContext());
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT
		);
		m_vwJokeEditText.setLayoutParams(params); //将上面创建的layout parameters 应用到EditText控件上
		addjokeArea.addView(m_vwJokeEditText); //将文字输入框添加到addjokeArea layout当中去

		// 将 添加笑话的layout “addjokeArea”, 和笑话展示区layout"sv", 添加到根layout "root"中
		root.addView(addjokeArea);
		root.addView(sv);

//		setContentView(sv); //这个能看懂，就是之前onCreate里面设置"布局样式"的时候用的
		setContentView(root); //由于我们创建了一个新的'总体layout' root, 这里就需要修改一下'展示整体'的layout为root了
		// root里面涵盖了 添加笑话layout 'addjokeArea' 和 笑话展示区layout 'sv'
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
	// 这里的addJoke()即为往"m_arrJokeList"动态数组中 追加Joke对象的方法
	// 上面写的for()就会反复的调用这里，并将笑话内容作为字符串传到这里的strJoke
	protected void addJoke(String strJoke) {
		// TODO
		// 调用Joke的对象构造函数，并塞到m_arrJokeList的尾部，
		Joke jokeAdd = new Joke(strJoke);
		m_arrJokeList.add(jokeAdd);

		// 除了将Joke对象加入到数组中去，咱也在完成它在界面TextView中的渲染(就直接拿上面传入的String就好了)
		TextView tv = new TextView(getBaseContext()); // 创建一个显示文字的TextView控件
		tv.setText(strJoke);
		tv.setTextSize(23); // 设置字体大小

		// 设定新加进去的"笑话"背景色是深色 还是 浅色(便于区分不同的笑话)
		// 这里的m_nLightColor和m_nDarkColor就是提前在/values/colors.xml中定好的颜色,在OnCreate()中导入了的 (偶亮奇暗)
		if(m_arrJokeList.size()%2==0){
			tv.setBackgroundColor(m_nLightColor);
		} else{
			tv.setBackgroundColor(m_nDarkColor);
		}
		tv.setTextColor(m_nTextColor); //别忘了还有"文字"的颜色

		m_vwJokeLayout.addView(tv); //将创建好的TextView控件追加到"m_vwJokeLayout"布局中去
	}
}