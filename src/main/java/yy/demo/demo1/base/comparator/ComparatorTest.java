package yy.demo.demo1.base.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author yinmb
 * @Date 2019/2/26 10:29:34
 */
public class ComparatorTest {
    private final class CompareName implements Comparator<Milan> {
        boolean is_Ascend;

        public CompareName(boolean b) {
            // TODO Auto-generated constructor stub
            is_Ascend = b;
        }

        @Override
        public int compare(Milan o1, Milan o2) {
            // TODO Auto-generated method stub
            if (is_Ascend)
                return o1.getName().compareTo(o2.getName());
            else
                return o2.getName().compareTo(o1.getName());
        }
    }

    private final class CompareId implements Comparator<Milan> {
        boolean is_Ascend;

        public CompareId(boolean b) {
            // TODO Auto-generated constructor stub
            is_Ascend = b;
        }

        @Override
        public int compare(Milan o1, Milan o2) {
            // TODO Auto-generated method stub
            int a, b;
            if (is_Ascend) {
                a = o1.getAge();
                b = o2.getAge();
            } else {
                a = o2.getAge();
                b = o1.getAge();
            }

            if (a > b)
                return 1;
            else if (a == b)
                return 0;
            else
                return -1;
        }

    }
    public static void main(String[] args) {
        ComparatorTest t = new ComparatorTest();

        Milan p1 = new Milan(1, "Dida");
        Milan p2 = new Milan(2, "Cafu");
        Milan p3 = new Milan(3, "Maldini");
        Milan P4 = new Milan(6, "Baresi");
        Milan p5 = new Milan(9, "Inzaghi");
        Milan P6 = new Milan(10, "Costa");

        List<Milan> mList = new ArrayList<Milan>();
        mList.add(p1);
        mList.add(P6);
        mList.add(P4);
        mList.add(p2);
        mList.add(p5);
        mList.add(p3);

        System.out.println("初始顺序");
        System.out.println("姓名  |   号码");
        for (Milan p : mList) {
            System.out.println(p.getName() + " |   " + p.getAge());
        }
        System.out.println();
        System.out.println("对号码降序");
        System.out.println("姓名  |   号码");

        Collections.sort(mList, t.new CompareId(false));

        for (Milan p : mList) {
            System.out.println(p.getName() + " |   " + p.getAge());
        }
        System.out.println();
        System.out.println("对姓名升序");
        System.out.println("姓名  |   号码");

        Collections.sort(mList, t.new CompareName(true));

        for (Milan p : mList) {
            System.out.println(p.getName() + " |   " + p.getAge());
        }
    }
}
