package com.veryworks.android.basiclist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnList, btnHolder, btnRecycler, btnCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnList = (Button) findViewById(R.id.btnList);
        btnHolder = (Button) findViewById(R.id.btnHolder);
        btnRecycler = (Button) findViewById(R.id.btnRecycler);
        btnCard = (Button) findViewById(R.id.btnCard);

        // 2. 리스너를 세팅한다.
        btnList.setOnClickListener(listener);
        btnHolder.setOnClickListener(listener);
        btnRecycler.setOnClickListener(listener);
        btnCard.setOnClickListener(listener);
    }

    // 1. 리스너를 정의한다.
    View.OnClickListener listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent = null;

            switch(v.getId()){
                case R.id.btnList:
                    intent = new Intent(MainActivity.this, ListActivity.class);
                    break;
                case R.id.btnHolder:
                    intent = new Intent(MainActivity.this, ListHolderActivity.class);
                    break;
                case R.id.btnRecycler:
                    intent = new Intent(MainActivity.this, RecyclerActivity.class);
                    break;
                case R.id.btnCard:
                    intent = new Intent(MainActivity.this, RecyclerCardActivity.class);
            }

            startActivity(intent);
        }
    };

}
