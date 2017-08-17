package us.supercheng.spring4.aop.spring.service;

import org.springframework.stereotype.Service;

@Service
public class CalImpl implements ICal {

    public double add(int a, int b) {
        double temp = a + b;
        this.printResult(temp);
        return temp;
    }

    public double sub(int a, int b) {
        double temp = a - b;
        this.printResult(temp);
        return temp;
    }

    public double mult(int a, int b) {
        double temp = a * b;
        this.printResult(temp);
        return temp;
    }

    public double div(int a, int b) {
        double temp = a / b;
        this.printResult(temp);
        return temp;
    }

    private void printResult(Double result) {
        System.out.println(result);
    }
}