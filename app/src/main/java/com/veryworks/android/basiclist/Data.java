package com.veryworks.android.basiclist;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by pc on 1/31/2017.
 */

public class Data {

    private ArrayList<User> datas;

    public ArrayList<User> get(){
        return datas;
    }

    public Data(){
        datas = new ArrayList<>();
        load();
    }

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
}
