package com.example.a2050531200222_levanlong_baiktth1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListCaSi extends AppCompatActivity {

    private ListView listView;
    ArrayList<CaSi> items = new ArrayList<>();
    CaSiAdapter adapter;
    Boolean kt=false;
    int j=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ca_si);

        listView = (ListView) findViewById(R.id.lvCaSi);
        items.add(new CaSi("Nguyễn Danh Trung","Trung Úy", "Việt Nam",5,R.drawable.police1)) ;
        items.add(new CaSi("Dương Thái Anh","Đại Úy", "Việt Nam",4,R.drawable.police2)) ;
        items.add(new CaSi("Lê Văn Anh Tuấn","Thiếu Tá", "Việt Nam",3,R.drawable.police3));
        items.add(new CaSi("Dương Bảo Ngọc","Thiếu Úy", "Việt Nam",4,R.drawable.police5));

        adapter = new CaSiAdapter(ListCaSi.this,items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                kt=true;
                Xacnhanxoa(i);
                return false;
            }
        });
    }
    public void Xacnhanxoa(final int pos){
        AlertDialog.Builder alertDiaLog = new AlertDialog.Builder(ListCaSi.this);
        alertDiaLog.setTitle("Thông báo");
        alertDiaLog.setIcon(R.mipmap.ic_launcher);
        alertDiaLog.setMessage("Bạn có muốn xóa");
        alertDiaLog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                items.remove(pos);
                adapter.notifyDataSetChanged();
            }
        });
        alertDiaLog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDiaLog.show();

    }
}