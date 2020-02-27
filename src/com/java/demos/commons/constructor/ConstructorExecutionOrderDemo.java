package com.java.demos.commons.constructor;

import com.java.demos.commons.constructor.model.Child;
import com.java.demos.commons.constructor.model.GrandParent;
import com.java.demos.commons.constructor.model.Parent;

import org.junit.jupiter.api.Test;

/**
 * a) Every class without explicit constructor has one. (non-args)
 * b) During object construction non-args constructor of all parents are invoked (from root to child) regardless of left side type.
 * c) It is due to the fact that every constructor has implicit super() method invocation.
 * d) If we override it e.g super("test") only arg constructor will be called.
 */
public class ConstructorExecutionOrderDemo {

    @Test
    public void childConstructionTest() {
        Child child = new Child("test");
        System.out.println("---------------");
        child.getName();
    }

    @Test
    public void parentChildConstructionTest() {
        Parent child = new Child("test");
        System.out.println("---------------");
        child.getName();
    }

    @Test
    public void grandParentChildConstructionTest() {
        GrandParent child = new Child("test");
        System.out.println("---------------");
        child.getName();
    }
}
