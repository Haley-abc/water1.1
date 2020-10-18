package com.example.water11.ui.dashboard;

public class Heads {
    private String name;
    private int imageId;
    public Heads(String name,int imageId){
        this.name=name;
        this.imageId=imageId;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
}
