package com.example.sinki.bai30_tabhost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TabHost tabHost;
    TextView txtA,txtB;
    Button btnCong;

    ListView lvHistory;
    ArrayList<String>dsHistory;
    ArrayAdapter<String>adapterCong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyPhepCong();
            }
        });
    }

    private void xuLyPhepCong() {
        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());

        String s = a+" + "+b+" = " + (a+b);
        dsHistory.add(s);
        adapterCong.notifyDataSetChanged();
        txtA.setText("");
        txtB.setText("");
    }

    private void addControls() {
        txtA = (TextView) findViewById(R.id.txtA);
        txtB = (TextView) findViewById(R.id.txtB);

        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();
        TabHost.TabSpec tab1 = tabHost.newTabSpec("t1");
        tab1.setIndicator("1. Phép cộng");
        tab1.setContent(R.id.tab1);
        tabHost.addTab(tab1);

        TabHost.TabSpec tab2 = tabHost.newTabSpec("t2");
        tab2.setIndicator("2. Lịch sử");
        tab2.setContent(R.id.tab2);
        tabHost.addTab(tab2);

        btnCong = (Button) findViewById(R.id.btnCong);
        lvHistory = (ListView) findViewById(R.id.lvHistory);
        dsHistory = new ArrayList<>();
        adapterCong=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,dsHistory);
        lvHistory.setAdapter(adapterCong);
    }
}
