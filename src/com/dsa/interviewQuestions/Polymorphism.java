package com.dsa.interviewQuestions;

public class Polymorphism {

    public static void main(String[] args) {
        A obj = new A();
        obj.print();
        C obj2 = new C();
        obj2.add(1,2);
        obj2.add(1,2,3);
    }
}
class A {
    void print() {
        System.out.println("Hello");
    }
}

class B extends A {
    void print() {
        System.out.println("Hi");
    }
}

class C {
    public int add(int a, int b) {
        System.out.println(a+b);
        return a + b;
    }

    public int add(int a, int b, int c) {
        System.out.println(a+b+c);
        return a + b + c;
    }
}
