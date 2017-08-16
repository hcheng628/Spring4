package us.supercheng.spring4.aop.nonspring.service;

public class CalImpl implements ICal{

    public double add(int a, int b) {
        return a + b;
    }

    public double sub(int a, int b) {
        return a - b;
    }

    public double mult(int a, int b) {
        return a * b;
    }

    public double div(int a, int b) {
        return a / b;
    }
}