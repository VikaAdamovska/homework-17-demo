package org.hillel.homework.serialization;

import java.io.*;
import java.util.Arrays;

public class SerializationDemo {
    /*1) придумать любую класс - сущность и наполнить ее тестовыми свойствами
      сохранить ее в файл используя Serializable
      считать из файла
      сохранить в файл используя ExternalizationDemo
      считать из файла*/

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        StudentFromDSU petrov = new StudentFromDSU("Petrov Alexander", "mathematical", 22, 2598775);

        //serialization
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        petrov.setAge(21);
        petrov.setName("Petrov Alex");

        //Student implements Serializable - Therefore, we will see the modified variable in the console.
        petrov.setRating("low");
        oos.writeObject(petrov);

        //output byte array to console
        System.out.println(Arrays.toString(baos.toByteArray()));

        //output object as String
        String objectStudentAsString = new String(baos.toByteArray());
        System.out.println(objectStudentAsString);

        //deserialization
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        StudentFromDSU restoredStudent = (StudentFromDSU) ois.readObject();
        System.out.println(restoredStudent);

    }
}
