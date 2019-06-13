package org.hillel.homework.externalization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Products{

    protected String name = "appliances";

    public Products() {
        System.out.println("This is default Products constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Products{" +
                "name='" + name + '\'' +
                '}';
    }
}
