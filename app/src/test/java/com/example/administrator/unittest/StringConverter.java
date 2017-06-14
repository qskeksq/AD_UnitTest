package com.example.administrator.unittest;

import android.content.Context;


public class StringConverter {
    Context context;

    public StringConverter(Context context) {
        this.context = context;
        httpConnect();
    }

    public String getString(int id){
        httpConnect();
        return context.getString(id);
    }

    public void httpConnect() {
        //http 통신하는 코드
        context.getSystemService(Context.NETWORK_STATS_SERVICE);
    }
}
