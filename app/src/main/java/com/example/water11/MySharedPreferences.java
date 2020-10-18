package com.example.water11;
import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreferences {

    //创建一个SharedPreferences    类似于创建一个数据库，库名为 data
    public static SharedPreferences share(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("date", Context.MODE_PRIVATE);
        return sharedPreferences;
    }

    //name 账号
    //调用上面的 share(Context context) 方法 获取标识为 "name" 的数据
    public static Object getName(Context context){
        return share(context).getString("number",null);
    }
    //调用上面的 share(Context context) 方法 将数据存入，并标识为 "name"
    //使用 commit() 方法保存会给出反应（保存成功或失败）
    public static boolean setName(String number, Context context){
        SharedPreferences.Editor e = share(context).edit();
        e.putString("number",number);
        Boolean bool = e.commit();
        return bool;
    }

    //pswd 密码
    public static String getPswd(Context context){
        return share(context).getString("pswd",null);
    }
    //这里使用的是 apply() 方法保存，将不会有返回值
    public static void setPswd(String pswd, Context context){
        SharedPreferences.Editor e = share(context).edit();
        e.putString("pswd",pswd);
        e.apply();
    }

    //ID
    public static int getId(Context context){
        return share(context).getInt("id",0);
    }
    //这里使用的是 apply() 方法保存，将不会有返回值
    public static void setId(int id, Context context){
        SharedPreferences.Editor e = share(context).edit();
        e.putInt("id",id);
        e.apply();
    }
}
