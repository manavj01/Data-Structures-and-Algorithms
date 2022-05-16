package com.dsa.oops;

public class ClassesAndObjects {

    public static class Person {
        int age;
        String name;

        void saysHi() {
            System.out.println(name + "[" + age + "] saysHi");
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.age = 10;
        p1.name = "A";
        p1.saysHi();

        Person p2 = new Person();
        p2.age = 20;
        p2.name = "B";
        p2.saysHi();
        Person p3 = p1;
        p3.age = 30;
        p3.saysHi();
        p1.saysHi();
    }
}
