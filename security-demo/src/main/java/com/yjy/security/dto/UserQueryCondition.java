package com.yjy.security.dto;

public class UserQueryCondition {

    private String username;
    private Integer age;
    private Integer ageTo;

    public String getUsername() {
        return username;
    }

    public UserQueryCondition setUsername(String username) {
        this.username = username;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserQueryCondition setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Integer getAgeTo() {
        return ageTo;
    }

    public UserQueryCondition setAgeTo(Integer ageTo) {
        this.ageTo = ageTo;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserQueryCondition{");
        sb.append("username='").append(username).append('\'');
        sb.append(", age=").append(age);
        sb.append(", ageTo=").append(ageTo);
        sb.append('}');
        return sb.toString();
    }
}
