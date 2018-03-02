package com.vlad.retrofit;

/**
 * Created by Vlad on 01.03.2018.
 */

public class Message {
    private long id;
    private String name;
    private String email;
    private String home_page;
    private String ip_address;
    private String browser;
    private String message;
    private String file;
    private String created_at;
    private String updated_at;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {this.name = name; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomePage() {
        return home_page;
    }

    public void setHomePage(String home_page) {
        this.home_page = home_page;
    }

    public String getIpAddress() {
        return ip_address;
    }

    public void setIpAddress(String ip_address) {
        this.ip_address = ip_address;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdatedAt() { return updated_at;}

    public void setUpdatedAt(String updated_at) {
        this.updated_at = updated_at;
    }
}

