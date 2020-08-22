package com.CookieMomsterDFW.Main.models.requests;

public class ProductRequest {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductRequest() {
    }

    public ProductRequest(String name) {
        this.name = name;
    }
}
