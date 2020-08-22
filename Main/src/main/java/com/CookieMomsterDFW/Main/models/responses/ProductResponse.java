package com.CookieMomsterDFW.Main.models.responses;

public class ProductResponse {

    private String name;
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductResponse() {
    }

    public ProductResponse(String name, Long id) {
        this.name = name;
        this.id = id;
    }
}
