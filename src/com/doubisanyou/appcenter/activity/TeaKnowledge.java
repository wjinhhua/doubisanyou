package com.doubisanyou.appcenter.activity;

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

public class TeaKnowledge extends Fragment {
	Context c;
	@Override
	public View onCreateView(LayoutInflater inflater,
			final ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);

		View chatView = inflater.inflate(R.layout.tea_search_fragment,
				container, false);
		c = container.getContext();
		GridView gridview = (GridView)chatView.findViewById(R.id.gridview);
		
		// 生成动态数组，并且转入数据
		ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < 6; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("ItemImage", R.drawable.ic_launcher);// 添加图像资源的ID
			map.put("ItemText", "NO." + String.valueOf(i));// 按序号做ItemText
			lstImageItem.add(map);
		}
		SimpleAdapter saImageItems = new SimpleAdapter(container.getContext(),lstImageItem,R.layout.night_item, new String[] { "ItemImage", "ItemText" },
				new int[] { R.id.ItemImage, R.id.ItemText });
		// 添加并且显示
		gridview.setAdapter(saImageItems);
		// 添加消息处理
		gridview.setOnItemClickListener(new ItemClickListener());

		/*
		 * Button bn = (Button) chatView.findViewById(R.id.rb);
		 * bn.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View source) { Intent intent = new
		 * Intent(container.getContext(), SearchSecondActivity.class);
		 * startActivity(intent); } });
		 */

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
				// 显示所选Item的ItemText
				Log.i("x", (String) item.get("ItemText"));
				
				 Intent intent =new Intent(c,SearchSecondActivity.class);
			        intent.putExtra("HERO", "redTea");
			        startActivity(intent);
		/*		  Button bn = (Button) chatView.findViewById(R.id.rb);
				  bn.setOnClickListener(new OnClickListener() {
				  
				  @Override public void onClick(View source) { Intent intent = new
				  Intent(container.getContext(), SearchSecondActivity.class);
				  startActivity(intent); } });*/
				 

			}
		}
	}