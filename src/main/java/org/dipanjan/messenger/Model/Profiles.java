package org.dipanjan.messenger.Model;

public class Profiles {
    private String username;
    private String name;
    private String email_id;
    
    public Profiles(){}

    public Profiles(String username, String name, String email_id) {
        this.username = username;
        this.name = name;
        this.email_id = email_id;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getEmail_id() {
        return email_id;
    }

}
