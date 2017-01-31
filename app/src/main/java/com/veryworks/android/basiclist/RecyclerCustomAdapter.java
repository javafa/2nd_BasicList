package com.veryworks.android.basiclist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by pc on 1/31/2017.
 */

public class RecyclerCustomAdapter extends RecyclerView.Adapter<RecyclerCustomAdapter.CustomViewHolder> {

    ArrayList<User> datas;
    // 리스트 각 행에서 사용되는 레이아웃 xml의 아이디
    int itemLayout;

    public RecyclerCustomAdapter(ArrayList<User> datas, int itemLayout){
        this.datas = datas;
        this.itemLayout = itemLayout;
    }

    // View 를 생성해서 홀더에 저장하는 역할
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        CustomViewHolder cvh = new CustomViewHolder(view);
        return cvh;
    }

    // listView 에서의 getView() 함수를 대체
    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        User user = datas.get(position);

        holder.txtId.setText(user.id + "");
        holder.txtName.setText(user.name);
        holder.txtAge.setText(user.age + "");
    }

    // 데이터 총 개수
    @Override
    public int getItemCount() {
        return datas.size();
    }

    // Recycler 뷰에서 사용하는 뷰홀더
    // 이 뷰홀더를 사용하는 Adapter 는 generic으로 선언된 부모객체를 상속받아 구현해야 한다.
    public class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView txtId,txtName,txtAge;

        public CustomViewHolder(View view) {
            super(view);
            // 생성자가 호출되는 순간(즉 new 하는순간) 내부의 위젯을 생성해서 변수에 담아둔다
            txtId = (TextView) view.findViewById(R.id.txtId);
            txtName = (TextView) view.findViewById(R.id.txtName);
            txtAge = (TextView) view.findViewById(R.id.txtAge);
        }
    }
}
