package com.slashidea.commuteassist.model;

public class User {

    private Long id;
    private String name;
    private boolean driver = false;

    public User(Long id, String name, boolean driver) {
        this.id = id;
        this.name = name;
        this.driver = driver;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDriver() {
        return driver;
    }

    public void setDriver(boolean driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", driver=" + driver + "]";
    }

}
