package com.veryworks.android.basiclist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class ListHolderActivity extends AppCompatActivity {

    ArrayList<User> datas = new ArrayList<>();

    private void load(){
        // 특정범위의 무작위 난수를 생성해준다.
        Random random = new Random();

        // datas 에 100명의 User를 생성해서 담는다
        for(int i=0 ; i<100 ; i++) {
            User user = new User();
            user.id   = i+1;
            user.name = "홍길동 " + user.id;
            user.age = random.nextInt(80);

            Log.i("Random","number=" + user.age);

            datas.add(user);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_holder);
        load();

        // 1. 리스트 뷰 가져오기
        ListView listView = (ListView) findViewById(R.id.listView);
        // 2. 아답터 생성
        CustomHolderAdapter adapter = new CustomHolderAdapter(datas, this);
        // 3. 리스트 뷰에 아답터 세팅
        listView.setAdapter(adapter);
    }

    class CustomHolderAdapter extends BaseAdapter{
        ArrayList<User> datas;
        LayoutInflater inflater;

        public CustomHolderAdapter(ArrayList<User> datas, Context context) {
            this.datas = datas;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int position) {
            return datas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Holder holder;

            // 뷰행이 화면에 보여져서 생성된 적이 있다면 재사용
            if(convertView == null){
                convertView = inflater.inflate(R.layout.list_holder_item,null);
                // 생성한 위젯을 담아놓기 위한 임시 공간
                holder = new Holder();

                holder.txtNo = (TextView) convertView.findViewById(R.id.txtId);
                holder.txtName = (TextView) convertView.findViewById(R.id.txtName);
                holder.txtAge = (TextView) convertView.findViewById(R.id.txtAge);

                convertView.setTag(holder);
            }else{
                holder = (Holder) convertView.getTag();
            }

            // 사용할 데이터 instance를 ArrayList 에서 꺼낸다
            User user = datas.get(position);

            holder.txtNo.setText(user.id + "");
            holder.txtName.setText(user.name);
            holder.txtAge.setText(user.age + "");

            return convertView;
        }

        // 각행에서 사용되는 위젯을 재사용하기 위한 Holder클래스
        class Holder {
            public TextView txtNo;
            public TextView txtName;
            public TextView txtAge;
        }
    }

}
