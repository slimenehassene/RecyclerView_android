package com.android.recyclerview_android;

public class Item {

    String name,ausweisNr;

    public Item(String name, String ausweisNr) {
        this.name = name;
        this.ausweisNr = ausweisNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAusweisNr() {
        return ausweisNr;
    }

    public void setAusweisNr(String ausweisNr) {
        this.ausweisNr = ausweisNr;
    }
}
