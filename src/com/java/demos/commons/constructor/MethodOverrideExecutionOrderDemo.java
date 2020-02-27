package com.java.demos.commons.constructor;

import com.java.demos.commons.constructor.model.Child;
import com.java.demos.commons.constructor.model.GrandParent;
import com.java.demos.commons.constructor.model.Parent;

import org.junit.jupiter.api.Test;

/**
 * a) Every class without explicit constructor has one. (non-args)
 * b) During object construction non-args constructor of all parents are invoked (from root to child) regardless of left side type.
 */
public class MethodOverrideExecutionOrderDemo {

    @Test
    public void childConstructionTest() {
        Child child = new Child("test");
    }

    @Test
    public void parentChildConstructionTest() {
        Parent child = new Child("test");
    }

    @Test
    public void grandParentChildConstructionTest() {
        GrandParent child = new Child("test");
    }
}
