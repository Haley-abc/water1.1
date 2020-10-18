package com.example.water11.ui.Service.knowledge;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.water11.R;
import com.example.water11.ui.dashboard.advanced.AdvancedFragment;

public class KnowledgeFragment extends Fragment {

    private KnowledgeViewModel mViewModel;
    private ListView mListView;
    private  String[] names={"用户164","用户954","用户326","用户956","用户335","用户152","用户123","用户164","用户954","用户326","用户956","用户335","用户152","用户123"};
    private int[] icons={R.drawable.name,R.drawable.name,R.drawable.name,R.drawable.name,R.drawable.name,R.drawable.name,R.drawable.name,R.drawable.name,R.drawable.name,R.drawable.name,R.drawable.name,R.drawable.name,R.drawable.name,R.drawable.name};

    public static KnowledgeFragment newInstance() {
        return new KnowledgeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.knowledge_fragment, container, false);
        mListView=root.findViewById(R.id.list_know);
        mListView.setAdapter(new KnowledgeFragment.MyBaseAdapter());
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(KnowledgeViewModel.class);
        // TODO: Use the ViewModel
    }
    class MyBaseAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return names [position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {//组装数据
            View view=View.inflate(getActivity(),R.layout.list_knowledge,null);//在list_item中有两个id,现在要把他们拿过来
            TextView mTextView=(TextView) view.findViewById(R.id.tv_title);
            ImageView imageView=(ImageView)view.findViewById(R.id.picture);
            //组件一拿到，开始组装
            mTextView.setText(names[position]);
            imageView.setBackgroundResource(icons[position]);
            //组装玩开始返回
            return view;
        }
    }
}
