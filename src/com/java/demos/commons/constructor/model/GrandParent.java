package com.java.demos.commons.constructor.model;

public class GrandParent {
    private String name;

    public GrandParent() {
        System.out.println("Executing GrandParent non-arg constructor");
    }

    public GrandParent(String name) {
        this.name = name;
        System.out.println("Executing GrandParent arg constructor: " + this.name);
    }

    public String getName() {
        String parent = "I'm GrandParent " + this.name;
        System.out.println(parent);

        return parent;
    }
}
