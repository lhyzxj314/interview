package test_java_spec.clone;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;

public class TestClient {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // 使用clone方法实现深拷贝（较麻烦）
        Car car = new Car("Linkco");
        Person person = new Person("xiaojun", car);

        Person person1 = person.clone();
        person1.getCar().setBrand("Honda");

        System.out.println(person == person1);
        System.out.println(person.getCar().getBrand());
        System.out.println(person1.getCar().getBrand());

        // 使用序列化实现深拷贝（较方便）
        /*PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = new PipedOutputStream(pis);*/
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream(pos);

        ObjectOutputStream oos = new ObjectOutputStream(pos);
        oos.writeObject(person);

        ObjectInputStream ois = new ObjectInputStream(pis);
        Person person3 = (Person) ois.readObject();
        person3.getCar().setBrand("Toyota");
        System.out.println(person.getCar().getBrand());
        System.out.println(person3.getCar().getBrand());

    }
}
