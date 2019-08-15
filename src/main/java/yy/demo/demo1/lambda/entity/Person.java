package yy.demo.demo1.lambda.entity;

import lombok.Data;

/**
 * @author yinmb
 * @Date 2019/2/22 19:03:54
 */
@Data
public class Person {

    private String firstName, lastName, job, gender;
    private int salary, age;

    public Person(String firstName, String lastName, String job,
                  String gender, int age, int salary)       {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.job = job;
        this.salary = salary;
    }
// Getter and Setter
// . . . . .
}