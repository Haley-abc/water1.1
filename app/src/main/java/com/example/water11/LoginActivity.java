package com.example.water11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.water11.data.User;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private EditText etAccount;
    private EditText etPassword;
    String account;
    String password;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etAccount=(EditText)findViewById(R.id.et_account);
        etPassword=(EditText)findViewById(R.id.et_password);

        id=(int)MySharedPreferences.getId(LoginActivity.this);
        account=(String)MySharedPreferences.getName(LoginActivity.this);
        if(account!=null&&account.length()!=0){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("id",id);
            startActivity(intent);
        }

        Button btLogin=(Button)findViewById(R.id.bt_login);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account=etAccount.getText().toString();
                password=etPassword.getText().toString();
                if(TextUtils.isEmpty(account)||TextUtils.isEmpty(password)){
                    Toast.makeText(LoginActivity.this,"输入不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    List<User> users = DataSupport.where("account=?", account).find(User.class);
                    if(users.size()!=0) {
                        for (User user : users) {
                            if (user.getPassword().equals(password)) {
                                id=user.getId();
                                Boolean bool=MySharedPreferences.setName(user.getAccount(),LoginActivity.this);
                                MySharedPreferences.setPswd(user.getPassword(),LoginActivity.this);
                                MySharedPreferences.setId(user.getId(),LoginActivity.this);
                                if(bool){
                                    Toast.makeText(LoginActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    intent.putExtra("id",id);
                                    startActivity(intent);
                                }
                                else
                                    Toast.makeText(LoginActivity.this, "登录失败！", Toast.LENGTH_SHORT).show();

                            } else {
                                    Toast.makeText(LoginActivity.this, "密码输入错误", Toast.LENGTH_SHORT).show();
                                }
                        }
                    }else {
                        Toast.makeText(LoginActivity.this, "账号不存在", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        Button btRegisterAccount=(Button)findViewById(R.id.bt_register_account);
        btRegisterAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        Button btAboutWater=(Button)findViewById(R.id.bt_about_water);
        btAboutWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }//去掉默认菜单栏
    }
}
