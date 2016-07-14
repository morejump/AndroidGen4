package com.project.phamhoang.recyclerview;

/**
 * Created by phamhoang on 7/14/16.
 */
public class GetItemData {
    private String name;
    private String age;
    private String birthday;
    private String birthplace;
    private String gender;
    private int list_length;

    public GetItemData(String name, String age, String birthday, String birthplace, String gender, int list_length) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.birthplace = birthplace;
        this.gender = gender;
        this.list_length = list_length;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setLength(int list_length) {this.list_length = list_length;}

    public String getName() {
        return name;
    }
    public String getAge() {
        return age;
    }
    public String getBirthday() {
        return birthday;
    }
    public String getBirthplace() {
        return birthplace;
    }
    public String getGender() {
        return gender;
    }
    public int getList_length() {return list_length;}
}
