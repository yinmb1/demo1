package yy.demo.demo1.lambda.filter;

import yy.demo.demo1.lambda.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author yinmb
 * @Date 2019/2/26 09:24:06
 */
public class FilterTest {
    List<Person> javaProgrammers = new ArrayList<Person>() {
        {
            add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
            add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
            add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
            add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
            add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
            add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
            add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
            add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
            add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
        }
    };

    List<Person> phpProgrammers = new ArrayList<Person>() {
        {
            add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
            add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
            add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));
            add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
            add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));
            add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));
            add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));
            add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));
            add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));
        }
    };

    /**
     * 集合过滤 FirstName不为 Jarrod 的程序员
     */
    public void filter01() {
        System.out.println("集合过滤 FirstName不为 Jarrod 的程序员:");
        phpProgrammers.stream().filter(p ->
                !p.getFirstName().equals("Jarrod")
        ).collect(Collectors.toList());

        phpProgrammers = phpProgrammers.stream().filter(p ->
                p.getFirstName().equals("Jarrod")
        ).collect(Collectors.toList());
        phpProgrammers.forEach(p -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

    }

    /**
     * 自定义过滤
     */
    public void filter02() {
        // 定义 filters
        Predicate<Person> ageFilter = (p) -> (p.getAge() > 25);
        Predicate<Person> salaryFilter = (p) -> (p.getSalary() > 1400);
        Predicate<Person> genderFilter = (p) -> ("female".equals(p.getGender()));

        System.out.println("下面是年龄大于 24岁且月薪在$1,400以上的女PHP程序员:");
        phpProgrammers.stream()
                .filter(ageFilter)
                .filter(salaryFilter)
                .filter(genderFilter)
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

        // 重用filters
        System.out.println("年龄大于 24岁的女性 Java programmers:");
        javaProgrammers.stream()
                .filter(ageFilter)
                .filter(genderFilter)
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
    }

    /**
     * 自定义过滤
     */
    public void filter0201() {
        // 定义 filters
        Predicate<Person> ageFilter = (p) -> (p.getAge() != 25);
        Predicate<Person> nameFilter = (p) -> (!p.getFirstName().equals("Jarrod"));

        System.out.println("下面是年龄不为 25 且 姓 不为Jarrod的PHP程序员:");
        phpProgrammers.stream()
                .filter(ageFilter)
                .filter(nameFilter)
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

        // 重用filters
        System.out.println();
        System.out.println("下面是年龄不为 25 PHP programmers:");
        phpProgrammers.stream()
                .filter(ageFilter)
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
    }

    public static void main(String[] args) {
        FilterTest filterTest = new FilterTest();
        filterTest.filter01();

    }
}
