package app0.com.ex04personagedb;

/**
 * Created by Administrator on 2018/6/3.
 */

public class Person {
    private String Name;
    private int    Age;

    public String getName() {
        return Name;
    }

    public Person setName(String name) {
        Name = name;
        return this;
    }

    public int getAge() {
        return Age;
    }

    public Person setAge(int age) {
        Age = age;
        return this;
    }
}
