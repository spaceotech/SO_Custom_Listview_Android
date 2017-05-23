package com.spaceo.loadmorebutton;

import java.util.ArrayList;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.spaceo.loadmorebutton.adapter.ListViewAdapter;

public class MainActivity extends AppCompatActivity {


    ListView lv;
    int lastPosition;
    ArrayList<String> listItem;
    ListViewAdapter listViewAdapter;


    Button btnLoadMore;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listItem=new ArrayList<String>();
        lv = (ListView) findViewById(R.id.lv);

        listItem = new ArrayList<String>();
        popuLateList();
        listViewAdapter=new ListViewAdapter(this,listItem);
        lv.setAdapter(listViewAdapter);

         btnLoadMore = new Button(this);
        btnLoadMore.setText(getResources().getString(R.string.btnLoadMore));

        // Adding Load More button to lisview at bottom
        lv.addFooterView(btnLoadMore);


        btnLoadMore.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
             loadMoreItems();


            }
        });


    }

    private void loadMoreItems() {

        lastPosition = lv.getFirstVisiblePosition();
        for(int i=1;i<11;i++)
        {
            listItem.add("item");
        }
        setAdapter();
       lv.setSelection(lastPosition+1);


    }

    private void setAdapter() {
        listViewAdapter=new ListViewAdapter(this,listItem);
        lv.setAdapter(listViewAdapter);
    }


    private void popuLateList() {
        for(int i=1;i<11;i++)
        {
            listItem.add("item");
        }
        setAdapter();
    }


}