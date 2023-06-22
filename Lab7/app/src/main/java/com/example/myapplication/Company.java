package com.example.myapplication;

public class Company {
    private String id;
    private String name;
    private String[] websites;
    private Address address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getWebsite() {
        return websites;
    }

    public void setWebsites(String[] website) {
        this.websites = website;
//        for(int i = 0; i< website.length;i++){
//            this.websites[i] = website[i];
//        }
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString(){
//        StringBuilder sb = new StringBuilder();
//
//        sb.append("\n id:" + this.id);
//        sb.append("\n name:"+ this.name);
//        if(this.websites !=null){
//            sb.append("\n website: ");
//            for(String website : this.websites){
//                sb.append(website + ", ");
//            }
//        }
//        if(this.address !=null){
//            sb.append("\n address:" + this.address);
//        }
//        return sb.toString();
        String s = "";
        s += "id:"+this.id+"\n";
        s += "name:"+this.name+"\n";
        if(this.websites != null){
            s += "websites: \n";
            for(int i = 0; i <this.websites.length ; i++){
                s += websites[i] +",\n ";
            }
        }
        if(this.address != null){
            s+="address: " + this.address+"\n";
        }
        return s;
    }
}

