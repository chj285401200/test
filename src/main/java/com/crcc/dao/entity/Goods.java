package com.crcc.dao.entity;

public class Goods {
    private Integer id;

    private String name;

    private String pic;

    public Goods(Integer id, String name, String pic) {
        this.id = id;
        this.name = name;
        this.pic = pic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }
}