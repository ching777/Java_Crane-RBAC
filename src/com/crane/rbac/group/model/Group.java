package com.crane.rbac.group.model;

public class Group {

    

    private Integer group_id;
    private String  group_name;
    private String  market;
    private String peopleCount;



    public String getPeopleCount() {
        return this.peopleCount;
    }
    public void setPeopleCount(String peopleCount ) {
        this.peopleCount = peopleCount;
    }
    public Integer getGroup_id() {
        return this.group_id;
    }
    public void setGroup_id(Integer group_id ) {
        this.group_id = group_id;
    }
    public String getGroup_name() {
        return this.group_name;
    }
    public void setGroup_name(String group_name ) {
        this.group_name = group_name;
    }
    public String getMarket() {
        return this.market;
    }
    public void setMarket(String market ) {
        this.market = market;
    }
    @Override
    public String toString() {
        return "Group [group_id=" + this.group_id + ", group_name=" + this.group_name + ", market=" + this.market
                + ", peopleCount=" + this.peopleCount + "]";
    }
}
