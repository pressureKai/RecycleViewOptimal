package com.key.recycleviewoptimal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.key.recycleviewoptimal.adapter.TestAdapter;
import com.key.recycleviewoptimal.widget.recyclerview.WgList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private WgList wgList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wgList = findViewById(R.id.wglist);
        List<Integer> list = new ArrayList<>();
        wgList.setAdapter(new TestAdapter(this));
        for(int i=0;i<100;i++){
            list.add(i);
        }
        wgList.handleData(list);
    }
}
