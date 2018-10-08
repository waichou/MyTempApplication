package com.aaa.test.myapplication.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aaa.test.myapplication.R;
import com.aaa.test.myapplication.recyclerview.adapter.UserAdapter;
import com.aaa.test.myapplication.recyclerview.model.User;

public class RecyclerViewActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        UserAdapter adapter = new UserAdapter(this);
        recyclerView.setAdapter(adapter);

        adapter.getItems().add(new User("张三", 18));
        adapter.getItems().add(new User("李四", 28));
        adapter.getItems().add(new User("王五", 38));

    }
}
