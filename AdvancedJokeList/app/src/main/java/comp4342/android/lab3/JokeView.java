package comp4342.android.lab3;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class JokeView extends LinearLayout implements RadioGroup.OnCheckedChangeListener, View.OnClickListener{

	private Button m_vwExpandButton;
	private RadioButton m_vwLikeButton;
	private RadioButton m_vwDislikeButton;
	private RadioGroup m_vwLikeGroup;
	private TextView m_vwJokeText;
	private Joke m_joke;

	public static final String EXPAND = " - ";
	public static final String COLLAPSE = " + ";

	/**
	 * Basic Constructor that takes only takes in an application Context.
	 * 
	 * @param context
	 *            The application Context in which this view is being added. 
	 *            
	 * @param joke
	 * 			  The Joke this view is responsible for displaying.
	 */
	public JokeView(Context context, Joke joke) {
		 super(context);
		// TODO：搞明白这个LayoutInflater 又是个什么东东
		LayoutInflater inflater = (LayoutInflater)
				context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.joke_view,this,true); //????

		//下面就是对先前在joke_view.xml中各种控件的获取 (注意别忘了"(小括号类型转换)")
		m_vwExpandButton = (Button) findViewById(R.id.expandButton);
		m_vwJokeText = (TextView) findViewById(R.id.jokeTextView);

		m_vwDislikeButton = (RadioButton) findViewById(R.id.dislikeButton);
		m_vwLikeButton = (RadioButton) findViewById(R.id.likeButton);
		m_vwLikeGroup = (RadioGroup) findViewById(R.id.ratingRadioGroup);

		// 设置"喜欢"和"讨厌"按钮的字体颜色 (用colors.xml里面定义的name="text"项)
		m_vwLikeButton.setTextColor(getResources().getColor(R.color.text));
		m_vwDislikeButton.setTextColor(getResources().getColor(R.color.text));

		//给"展开"按钮 和 "喜欢/不喜欢"按钮组RadioGroup 分别添加监听
		m_vwExpandButton.setOnClickListener(this); //这里的this是...?
		m_vwLikeGroup.setOnClickListener(this);

		collapseJokeView(); // 这个方法会将笑话 设置成"折叠"状态

	}

	/**
	 * Mutator method for changing the Joke object this View displays. This View
	 * will be updated to display the correct contents of the new Joke.
	 * 
	 * @param joke
	 *            The Joke object which this View will display.
	 */
	public void setJoke(Joke joke) {
		// TODO
		m_joke = joke; //m_joke接收一个Joke对象
		m_vwJokeText.setText(m_joke.getJoke()); //调用Joke对象的getJoke()方法取得笑话文字内容，用于m_vwJokeText的Text展示中
		//设置展示的字体大小和颜色
		m_vwJokeText.setTextSize(23);
		m_vwJokeText.setTextColor(getResources().getColor(R.color.text));

		// 下面在干的活就是尝试获取"笑话本身"的评价，根据评价返回的值 设定 对应的单选按钮信息
		// 注意，在新版的Java中，case 的条件必须是一个 "提前订好的"常量 (不能动态变化的那种)
		switch (joke.getRating()) {
			case Joke.UNRATED:
				m_vwLikeGroup.clearCheck();
				break;
			case Joke.LIKE:
				m_vwLikeButton.setChecked(true);
				m_vwDislikeButton.setChecked(false);
				break;
			case Joke.DISLIKE:
				m_vwLikeButton.setChecked(false);
				m_vwDislikeButton.setChecked(true);
				break;
			// 别忘了case的最后还要加上一个default!
			default:
				break;
		}

	}

	/**
	 * This method encapsulates the logic necessary to update this view so that
	 * it displays itself in its "Expanded" form: 
	 * 	- Shows the complete text of the joke. 
	 *  - Brings the RadioGroup of rating Buttons back into view.
	 */
	private void expandJokeView() { //这个方法是"展开"笑话评价
		// TODO
		m_vwJokeText.setEllipsize(null);
		m_vwJokeText.setSingleLine(false);
		m_vwExpandButton.setText(JokeView.EXPAND); // "展开"状态时的按钮显示
		m_vwLikeGroup.setVisibility(View.VISIBLE); // "展开"装填，RatioGroup即应为可见状态
		m_vwJokeText.setPadding(1,1,1,16); // 这个好像看懂了，设置布局的"内边距" (左，上，右，下)
		requestLayout();

	}

	/**
	 * This method encapsulates the logic necessary to update this view so that
	 * it displays itself in its "Collapsed" form: 
	 * 	- Shows only the first line of text of the joke. 
	 *  - If the joke is longer than one line, it appends an ellipsis to the end. 
	 *  - Removes the RadioGroup of rating Buttons from view.
	 */
	private void collapseJokeView() { //这个方法是"折叠"笑话评价
		// TODO
		m_vwJokeText.setSingleLine(true); //Todo: 这里的setSinglelLine是个什么东西?
		m_vwJokeText.setEllipsize(TextUtils.TruncateAt.valueOf("END")); // Todo: 这有是个啥??
		m_vwExpandButton.setText(JokeView.COLLAPSE); // 这里的JokeView.COLLAPSE是一个定好的常量("+") 表示"折叠状态"时的按钮文字
		m_vwLikeGroup.setVisibility(View.GONE); //将 RatioGroup的可见性设置为"GONE" (不可见)
		requestLayout(); //Todo: 搞明白这里的 requestLayout() 是用来干啥的 (好像是View内本身就有的一个方法)
	}

	// 现在，我们来重写"监听事件"的onclick()方法 (implement View.OnclickListener)
	public void onClick(View v){
		// 里面实则是一个很简单的"展开or折叠"判断 (关键就在于第一行，按钮的值会先被赋给viewstate)
		// 然后根据viewstate此时存的值去判断 是要执行"展开"还是"关闭操作"
		String viewState = m_vwExpandButton.getText().toString();
		if(viewState.equals(JokeView.COLLAPSE)){
			expandJokeView();
		}else{
			collapseJokeView();
		}
	}

	// 然后是单选框相关的监听器事件onCheckedChanged() (implement RadioGroup.OnCheckedChangeListener)
	// Todo: 搞明白这里的 onCheckedChanged()
	public void  onCheckedChanged(RadioGroup rg, int checkedID){
		// 上面参数中的checkedID是在 RadioButton在选中时  获取到其的id名称，并以此来判断是哪个Radio选项被选了
		if(checkedID == m_vwLikeButton.getId()){ // "喜欢"按钮被选中，则设置对应 笑话的"后台评价"
			m_joke.setRating(Joke.LIKE);
		}
		if(checkedID == m_vwDislikeButton.getId()){ // 同上，这里是"不喜欢"的
			m_joke.setRating(Joke.DISLIKE);
		}
	}


}
