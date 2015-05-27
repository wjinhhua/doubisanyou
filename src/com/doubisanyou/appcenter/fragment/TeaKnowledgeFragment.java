package com.doubisanyou.appcenter.fragment;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.doubisanyou.appcenter.R;
import com.doubisanyou.appcenter.activity.SearchSecondActivity;

public class TeaKnowledgeFragment extends Fragment {
	Context c;

	@Override
	public View onCreateView(LayoutInflater inflater,
			final ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);

		View chatView = inflater.inflate(R.layout.tea_search_fragment,
				container, false);
		c = container.getContext();
		GridView gridview = (GridView) chatView
				.findViewById(R.id.tea_knowledge_gridview);

		// 生成动态数组，并且转入数据
		ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
		// for (int i = 0; i < 6; i++) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("tea_knowledge_item_image", R.drawable.red_tea);// 添加图像资源的ID
		map.put("tea_knowledge_item_text", "红茶");// 按序号做ItemText
		lstImageItem.add(map);
		map = new HashMap<String, Object>();
		map.put("tea_knowledge_item_image", R.drawable.green_tea);// 添加图像资源的ID
		map.put("tea_knowledge_item_text", "绿茶");// 按序号做ItemText
		lstImageItem.add(map);
		map = new HashMap<String, Object>();
		map.put("tea_knowledge_item_image", R.drawable.balck_tea);// 添加图像资源的ID
		map.put("tea_knowledge_item_text", "黑茶");// 按序号做ItemText
		lstImageItem.add(map);
		map = new HashMap<String, Object>();
		map.put("tea_knowledge_item_image", R.drawable.white_tea);// 添加图像资源的ID
		map.put("tea_knowledge_item_text", "白茶");// 按序号做ItemText
		lstImageItem.add(map);
		map = new HashMap<String, Object>();
		map.put("tea_knowledge_item_image", R.drawable.yello_tea);// 添加图像资源的ID
		map.put("tea_knowledge_item_text", "黄茶");// 按序号做ItemText
		lstImageItem.add(map);
		map = new HashMap<String, Object>();
		map.put("tea_knowledge_item_image", R.drawable.cyan_tea);// 添加图像资源的ID
		map.put("tea_knowledge_item_text", "青茶");// 按序号做ItemText
		lstImageItem.add(map);
		map = new HashMap<String, Object>();
		map.put("tea_knowledge_item_image", R.drawable.health_care_tea);// 添加图像资源的ID
		map.put("tea_knowledge_item_text", "保健茶");// 按序号做ItemText
		lstImageItem.add(map);
		map = new HashMap<String, Object>();
		map.put("tea_knowledge_item_image", R.drawable.flower_tea);// 添加图像资源的ID
		map.put("tea_knowledge_item_text", "花茶");// 按序号做ItemText
		lstImageItem.add(map);
		// }
		SimpleAdapter saImageItems = new SimpleAdapter(container.getContext(),
				lstImageItem, R.layout.griditem_tea_knowledge,
				new String[] { "tea_knowledge_item_image",
						"tea_knowledge_item_text" }, new int[] {
						R.id.tea_knowledge_item_image,
						R.id.tea_knowledge_item_text });
		// 添加并且显示
		gridview.setAdapter(saImageItems);
		// 添加消息处理
		gridview.setOnItemClickListener(new ItemClickListener());

		return chatView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	class ItemClickListener implements OnItemClickListener {
		public void onItemClick(AdapterView<?> arg0,// The AdapterView where the
													// click happened
				View arg1,// The view within the AdapterView that was clicked
				int arg2,// The position of the view in the adapter
				long arg3// The row id of the item that was clicked
		) {
			HashMap<String, Object> item = (HashMap<String, Object>) arg0
					.getItemAtPosition(arg2);
			Intent intent = new Intent(c, SearchSecondActivity.class);
			intent.putExtra("HERO", "redTea");
			startActivity(intent);

		}
	}
}
