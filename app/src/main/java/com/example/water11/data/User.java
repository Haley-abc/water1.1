package com.example.water11.data;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

public class User extends DataSupport {
    private int id;
    @Column(unique = true)
    private String account;
    private String password;
    private String nickName;
    private int level;
    private int coin;
    public String getAccount(){
        return account;
    }
    public void setAccount(String account){
        this.account=account;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getNickName(){return nickName;}
    public void setNickName(String nickName){this.nickName=nickName;}
    public int getLevel(){return level;}
    public void setLevel(int level){this.level=level;}
    public int getCoin(){return coin;}
    public void setCoin(int coin){this.coin=coin;}
    public int getId(){return id;}
}
