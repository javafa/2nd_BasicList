package com.veryworks.android.basiclist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by pc on 1/31/2017.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CustomViewHolder> {

    ArrayList<User> datas;
    Context context; // 클릭처리, 애니메이션 등을 위해 시스템자원 사용이 필요

    public CardAdapter(ArrayList<User> datas, Context context){
        this.datas = datas;
        this.context = context;
    }

    // View 를 생성해서 홀더에 저장하는 역할
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_card_item, parent, false);
        CustomViewHolder cvh = new CustomViewHolder(view);
        return cvh;
    }

    // listView 에서의 getView() 함수를 대체
    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        final User user = datas.get(position);

        holder.txtId.setText(user.id + "");
        holder.txtName.setText(user.name);
        holder.txtAge.setText(user.age + "");

        // cardview 에 click 리스너를 달아서 동작시킨다
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("no", user.id);
                intent.putExtra("day", user.name);
                context.startActivity(intent);
            }
        });

        // cardview 애니메이션                                       // 속성이 정의되어 있는 애니메이션 xml
        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        // 뷰에 정의한 애니메이션을 세팅해준다
        holder.cardView.setAnimation(animation);
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
        CardView cardView;

        public CustomViewHolder(View view) {
            super(view);
            // 생성자가 호출되는 순간(즉 new 하는순간) 내부의 위젯을 생성해서 변수에 담아둔다
            txtId = (TextView) view.findViewById(R.id.txtId);
            txtName = (TextView) view.findViewById(R.id.txtName);
            txtAge = (TextView) view.findViewById(R.id.txtAge);

            cardView = (CardView) view.findViewById(R.id.cardView);
        }
    }
}
