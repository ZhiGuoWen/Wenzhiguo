package com.wenzhiguo.wenzhiguo20170227;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshExpandableListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class FenleiFragment extends Fragment {

    private View inflate;
    private PullToRefreshExpandableListView expand;
    private List<Bean> list;
    public FenleiFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_fenlei, container, false);
        //找控件
        initView();
        return inflate;
    }

    private void initView() {
        list = new ArrayList<>();
        expand = (PullToRefreshExpandableListView) inflate.findViewById(R.id.expand);
        //请求数据
        setData();
    }

    private void setData() {
        RequestParams requestParams = new RequestParams("http://www.meirixue.com/api.php?c=category&a=getall");
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONArray jsonArray = new JSONArray(result);
                    for (int i = 0; i <jsonArray.length() ; i++) {
                        JSONObject jsonObject = jsonArray.optJSONObject(i);
                        Gson gson = new Gson();
                        Bean bean = gson.fromJson(jsonObject.toString(), Bean.class);
                        list.add(bean);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                MyBaseAdapter myBaseAdapter = new MyBaseAdapter(getActivity(),list);
                expand.getRefreshableView().setAdapter(myBaseAdapter);
            }
        });
    }


}
