package com.java.demos.commons.constructor.model;

public class Parent extends GrandParent {

    private String name;

    public Parent() {
        System.out.println("Executing Parent non-arg constructor");
    }

    public Parent(String name) {
        this.name = name;
        System.out.println("Executing Parent arg constructor: " + this.name);
    }

    @Override
    public String getName() {
        String parent = "I'm Parent " + this.name;
        System.out.println(parent);

        return parent;
    }
}
