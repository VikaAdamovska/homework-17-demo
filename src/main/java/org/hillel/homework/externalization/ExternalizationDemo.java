package org.hillel.homework.externalization;

import java.io.*;
import java.util.Arrays;

public class ExternalizationDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Phone apple = new Phone(20000, "white", 161578);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

        apple.setId(44444);
        objectOutputStream.writeObject(apple);

        //output byte array to console
        System.out.println(Arrays.toString(byteArrayOutputStream.toByteArray()));

        //output object as String
        String objectPhoneAsString = new String(byteArrayOutputStream.toByteArray());
        System.out.println("Externalization object phone: " + objectPhoneAsString);

        //two default constructors will be called
        //brought to the console, what was recorded in the stream and what is initialized by default
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Phone restoredPhone = (Phone) objectInputStream.readObject();
        System.out.println(restoredPhone);
    }
}
