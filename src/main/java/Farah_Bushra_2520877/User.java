package Farah_Bushra_2520877;

import java.io.Serializable;

public abstract class User implements Serializable {

    private final String userId;
    private String name;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public final String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract String getUserType();
}