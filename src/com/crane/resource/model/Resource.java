package com.crane.resource.model;

public class Resource implements  java.io.Serializable {
    
    @Override
    public String toString() {
        return "Resource [resource_id=" + this.resource_id + ", resource_name=" + this.resource_name + ", parent_id="
                + this.parent_id + ", url=" + this.url + ", icon=" + this.icon + "]";
    }
    private Integer resource_id;
    private String resource_name;
    private Integer parent_id;
    private String url;
    private String icon;
    public Integer getResource_id() {
        return this.resource_id;
    }
    public void setResource_id(Integer resource_id ) {
        this.resource_id = resource_id;
    }
    public String getResource_name() {
        return this.resource_name;
    }
    public void setResource_name(String resource_name ) {
        this.resource_name = resource_name;
    }
    public Integer getParent_id() {
        return this.parent_id;
    }
    public void setParent_id(Integer parent_id ) {
        this.parent_id = parent_id;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url ) {
        this.url = url;
    }
    public String getIcon() {
        return this.icon;
    }
    public void setIcon(String icon ) {
        this.icon = icon;
    }
    
}
