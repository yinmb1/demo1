package yy.demo.demo1.lambda;

import yy.demo.demo1.mybaits.entity.OutBoundApply;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author yinmb
 * @Date 2019/2/21 11:13:48
 */
public class Test {
    /**
     * 简介
     * (译者注:虽然看着很先进，其实Lambda表达式的本质只是一个"语法糖",由编译器推断并帮你转换包装为常规的代码,因此你可以使用更少的代码来实现同样的功能。本人建议不要乱用,因为这就和某些很高级的黑客写的代码一样,简洁,难懂,难以调试,维护人员想骂娘.)
     * Lambda表达式是Java SE 8中一个重要的新特性。lambda表达式允许你通过表达式来代替功能接口。 lambda表达式就和方法一样,它提供了一个正常的参数列表和一个使用这些参数的主体(body,可以是一个表达式或一个代码块)。
     * Lambda表达式还增强了集合库。 Java SE 8添加了2个对集合数据进行批量操作的包: java.util.function 包以及java.util.stream 包。 流(stream)就如同迭代器(iterator),但附加了许多额外的功能。 总的来说,lambda表达式和 stream 是自Java语言添加泛型(Generics)和注解(annotation)以来最大的变化。 在本文中,我们将从简单到复杂的示例中见认识lambda表达式和stream的强悍。
     * 环境准备
     * 如果还没有安装Java 8,那么你应该先安装才能使用lambda和stream(译者建议在虚拟机中安装,测试使用)。 像NetBeans 和IntelliJ IDEA 一类的工具和IDE就支持Java 8特性,包括lambda表达式,可重复的注解,紧凑的概要文件和其他特性。
     * 下面是Java SE 8和NetBeans IDE 8的下载链接:
     * Java Platform (JDK 8): 从Oracle下载Java 8,也可以和NetBeans IDE一起下载
     * NetBeans IDE 8: 从NetBeans官网下载NetBeans IDE
     * Lambda表达式的语法
     * 基本语法:
     * (parameters) -> expression
     * 或
     * (parameters) ->{ statements; }
     */
    // 1. 不需要参数,返回值为 5
    // () -> 5

    // 2. 接收一个参数(数字类型),返回其2倍的值
    // x -> 2 * x

    // 3. 接受2个参数(数字),并返回他们的差值
    // (x, y) -> x – y

    // 4. 接收2个int型整数,返回他们的和
    //  (int x, int y) -> x + y

    // 5. 接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void)
    // (String s) -> System.out.print(s)
    public void test01() {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer", "Roger Federer",
                "Andy Murray", "Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players = Arrays.asList(atp);

        // 以前的循环方式
        for (String player : players) {
            System.out.print(player + "; ");
        }

        // 使用 lambda 表达式以及函数操作(functional operation)
        players.forEach((player) -> System.out.print(player + "; "));

        // 在 Java 8 中使用双冒号操作符(double colon operator)
        players.forEach(System.out::println);
    }

    public List<OutBoundApply> init01() {
        OutBoundApply outBoundApply1 = new OutBoundApply();
        OutBoundApply outBoundApply2 = new OutBoundApply();
        OutBoundApply outBoundApply3 = new OutBoundApply();
        outBoundApply1.setApplyLocation("1111111111");
        outBoundApply2.setApplyLocation("2222222222");
        outBoundApply3.setApplyLocation("3333333333");

        outBoundApply1.setApplySerialNo("111111");
        outBoundApply2.setApplySerialNo("111111");
        outBoundApply3.setApplySerialNo("111111");
        List<OutBoundApply> list = new ArrayList<>();
        list.add(outBoundApply1);
        list.add(outBoundApply2);
        list.add(outBoundApply3);

        outBoundApply2.setApplySerialNo("hahah");
        System.out.println(list.get(1).getApplySerialNo());
        return list;

    }

    public void test02() {
        List<OutBoundApply> outBoundApplies = init01();
        outBoundApplies.forEach(outBoundApply ->
                System.out.println(outBoundApply.getApplyLocation())
        );

        outBoundApplies.forEach(outBoundApply -> {
            outBoundApply.setLocationType(outBoundApply.getApplySerialNo());
            System.out.println("66666677777777");
            if (true) {
                System.out.println("222222");
            }
            outBoundApplies.forEach(outBoundApply1 ->
                    System.out.println(outBoundApply1.getLocationType())
            );
        });

        outBoundApplies.forEach(outBoundApply ->
                System.out.println(outBoundApply.getLocationType())
        );
    }

    public void test03() {
        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};

        // 1.1 使用匿名内部类根据 name 排序 players
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.compareTo(s2));
            }
        });
        List<String> playerList = Arrays.asList(players);
        playerList.forEach(player -> System.out.println(player));
        // 1.2 使用 lambda expression 排序 players
        Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));
        Arrays.sort(players, sortByName);
        System.out.println("----------------------------------------");
       // playerList.stream().filter(player ->player.equals("John Isner"));

        playerList.forEach(player -> System.out.println(player));
        // 1.3 也可以采用如下形式:
        Arrays.sort(players, (String s1, String s2) -> (s1.compareTo(s2)));
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.init01();
    }

}
