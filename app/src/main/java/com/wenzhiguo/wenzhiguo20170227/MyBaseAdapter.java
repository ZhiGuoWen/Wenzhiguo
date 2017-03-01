package com.wenzhiguo.wenzhiguo20170227;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dell on 2017/2/27.
 */

public class MyBaseAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<Bean> list;
    public MyBaseAdapter(FragmentActivity activity, List<Bean> list) {
        this.context = activity;
        this.list = list;
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return list.get(groupPosition).getNodes().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        convertView = View.inflate(context,R.layout.group_item,null);
        TextView text =(TextView) convertView.findViewById(R.id.group_item);
        text.setText(list.get(groupPosition).getCname());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        convertView = View.inflate(context,R.layout.child_item,null);
        TextView text =(TextView) convertView.findViewById(R.id.child_item);
        text.setText(list.get(groupPosition).getNodes().get(childPosition).getCategory_name());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
