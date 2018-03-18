package com.alpaca.jisung.eib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView nameText;
    Button settingBtn,searchBtn;

    double lat,lng;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();//초기화





        settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this,SettingActivity.class);
                startActivity(intent);
            }
        });

        searchBtn.setOnClickListener(new View.OnClickListener() {//찾기버튼 클릭시 이벤트
            @Override
            public void onClick(View v) {
                getLocationData();//위치를 찾은 후

                intent = new Intent(MainActivity.this,MapsActivity.class);

                intent.putExtra("Lat",lat+0.0000001);
                intent.putExtra("Lng",lng+0.0000001);//값을 넘겨

                startActivity(intent);//엑티비티 실행
            }
        });
    }


    public void init( ){
        nameText = (TextView)findViewById(R.id.nameText);
        settingBtn = (Button)findViewById(R.id.settingBtn);
        searchBtn = (Button)findViewById(R.id.searchBtn);//id 값 찾기 (xml)

        nameText.setText(getIntent().getStringExtra("name"));//로그인에서 이름 정보가져와서 텍스트로 설정

    }


    public void getLocationData(){
        lat = 37.555744;
        lng = 126.970431;// 임시 설정값  gps 위치 값 넣을 것
    }//기기 위치 정보 찾는 함수


}
