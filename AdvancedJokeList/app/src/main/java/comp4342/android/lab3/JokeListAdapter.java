package comp4342.android.lab3;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;

public class JokeListAdapter extends BaseAdapter {

	/**
	 * The application Context in which this JokeListAdapter is being used.
	 */
	private Context m_context;

	/**
	 * The dataset to which this JokeListAdapter is bound.
	 */
	private List<Joke> m_jokeList;

	/**
	 * The position in the dataset of the currently selected Joke.
	 */
	private int m_nSelectedPosition;

	/**
	 * Parameterized constructor that takes in the application Context in which
	 * it is being used and the Collection of Joke objects to which it is bound.
	 * m_nSelectedPosition will be initialized to Adapter.NO_SELECTION.
	 * 
	 * @param context
	 *            The application Context in which this JokeListAdapter is being
	 *            used.
	 * 
	 * @param jokeList
	 *            The Collection of Joke objects to which this JokeListAdapter
	 *            is bound.
	 */
	public JokeListAdapter(Context context, List<Joke> jokeList) {
		//本class的构造函数

		//TODO: 待具体搞明白这里的"Adapter"是个什么东西
		//说是好像和"数据存储"有关

		//赋值一开始定义的几个变量
		m_context = context; //m_context上面定义的Context对象
		m_jokeList = jokeList; //m_jokeList上面定义的List<Joke>对象
		m_nSelectedPosition = Adapter.NO_SELECTION;  //尚不明确
	}

	/**
	 * Accessor method for retrieving the position in the dataset of the
	 * currently selected Joke.
	 * 
	 * @return an integer representing the position in the dataset of the
	 *         currently selected Joke.
	 */
	public int getSelectedPosition() {
		//TODO
		//这里说是暂时先不写，一会再回来看
		return 0;
	}

	@Override
	public int getCount() { //返回dataset中的 元素个数
		// TODO Auto-generated method stub

		return 0;
	}

	@Override
	public Object getItem(int position) { //从dataset中的特定位置position取得一个Joke对象
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) { //取得Joke对象的id (但是这里好像直接用的就是Joke对象的'位置'当id，真懒(￣▽￣") )
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) { //取得dataset中特定位置position的某个Joke的 "JokeView"对象
		// TODO 搞明白最后面的"parent"参数是个什么东西
		return null;
	}
}
