package com.lce.model;

public class KnowledgeBase {

    private int id;
    private String name;
    private String introduction;
    private int creator_id;
    private Boolean is_public;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIntroduction() {
        return introduction;
    }
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    public int getCreator_id() {
        return creator_id;
    }
    public void setCreator_id(int creator_id) {
        this.creator_id = creator_id;
    }
    public Boolean getIs_public() {
        return is_public;
    }
    public void setIs_public(Boolean is_public) {
        this.is_public = is_public;
    }

}
