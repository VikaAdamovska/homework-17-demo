package org.hillel.homework.externalization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Phone extends Products implements Externalizable {

    private transient int price;

    private String description;

    private int id;

    public Phone() {
        System.out.println("This is default Phone constructor");
    }

    public Phone(int price, String description, int id) {
        System.out.println("Constructor with parameters");
        this.price = price;
        this.description = description;
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(this.id);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int id_ = in.readInt();
        this.id = id_;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "price=" + price +
                ", description='" + description + '\'' +
                ", id=" + id +
                '}' + " Products{" +
                " name= '" + name + '\'' +
                '}';
    }
}
