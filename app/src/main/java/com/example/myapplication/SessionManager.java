package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;

import java.util.HashMap;

@SuppressWarnings("ALL")
class SessionManager extends Fragment {

private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;


    public static final String PREF_NAME = "LOGIN";
    public static final String LOGIN = "IS_LOGIN";
    public static final String FNAME = "FNAME";
    public static final String LNAME = "LNAME";
    public static final String PHONE = "PHONE";
    public static final String EMAIl = "EMAIL";
    public static final String ID = "ID";


    public SessionManager(Context context){
        this.context = context;
        int PRIVATE_MODE = 0;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();

    }

    public void createSession(String email){
        editor.putBoolean(LOGIN, true);
        ///  editor.putString(FNAME, f_name);
        //    editor.putString(LNAME, l_name);
        editor.putString(EMAIl,email);
        //  editor.putString(ID, id);
        //editor.putString(PHONE, phone_number);
        editor.apply();
    }

    /*public void createSessionBar(String expiry_date){
        editor.putString(EXP_DATE,expiry_date);
    }*/

    public boolean isLoggin(){
        return sharedPreferences.getBoolean(LOGIN,false);
    }
    public void checkLogin(){
        if(!this.isLoggin()){
            Intent ab = new Intent(context, UserLogIn.class);
            context.startActivity(ab);

        }
    }

    public HashMap<String, String> getUserDetail(){
        HashMap<String, String> user = new HashMap<>();
        //    user.put(FNAME, sharedPreferences.getString(FNAME, null));
        //   user.put(LNAME, sharedPreferences.getString(LNAME, null));
        //   user.put(PHONE,sharedPreferences.getString(PHONE,null));
        user.put(EMAIl,sharedPreferences.getString(EMAIl,null));
        //   user.put(ID,sharedPreferences.getString(ID,null));

        return  user;

    }


    public void logout(){
        editor.clear();
        editor.commit();
        Intent lg  = new Intent(context, UserLogIn.class);
        context.startActivity(lg);
        ((UserLogIn)context).finish();
    }
}

