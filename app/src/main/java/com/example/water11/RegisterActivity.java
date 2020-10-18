package com.example.water11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.water11.data.User;

import org.litepal.crud.DataSupport;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    private EditText etAccountRegister;
    private EditText etPasswordRegister;
    private EditText etNickName;
    private EditText etPassword2;
    String account;
    String password;
    String nickName;
    String password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }//去掉默认菜单栏

        etAccountRegister=(EditText)findViewById(R.id.et_account_register);
        etPasswordRegister=(EditText)findViewById(R.id.et_password_register);
        etNickName=(EditText)findViewById(R.id.et_nickname_register);
        etPassword2=(EditText)findViewById(R.id.et_password2_register);

        Button btRegister=(Button)findViewById(R.id.bt_register);
        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account=etAccountRegister.getText().toString();
                password=etPasswordRegister.getText().toString();
                nickName=etNickName.getText().toString();
                password2=etPassword2.getText().toString();
                if(TextUtils.isEmpty(account)||TextUtils.isEmpty(password)||TextUtils.isEmpty(nickName)||TextUtils.isEmpty(password2)){
                    Toast.makeText(RegisterActivity.this,"输入不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    List<User> users = DataSupport.where("account=?", account).find(User.class);
                    if(users.size()==0){
                        if (password.equals(password2)) {
                            User user = new User();
                            user.setAccount(account);
                            user.setPassword(password);
                            user.setNickName(nickName);
                            user.setLevel(0);
                            user.setCoin(200);
                            user.save();
                            if(user.save()) {
                                Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(RegisterActivity.this, "两次输入密码不一致，请重新输入", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else Toast.makeText(RegisterActivity.this, "该账号已被注册，请重新输入", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
