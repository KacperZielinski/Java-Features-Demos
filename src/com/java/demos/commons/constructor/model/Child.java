package com.java.demos.commons.constructor.model;

public class Child extends Parent {
    private String name;

    public Child() {
        System.out.println("Executing Child non-arg constructor");
    }

    /** It executes non-arg constructor of its (all!) parents.
     *  Begins from the root Object.
     *  End on the previous, here Parent, so Child non-arg isn't invoked.
     **/
    public Child(String name) {
        this.name = name;
        System.out.println("Executing Child arg constructor " + this.name);
    }

    @Override
    public String getName() {
        String parent = "I'm Child " + this.name;
        System.out.println(parent);

        return parent;
    }
}
