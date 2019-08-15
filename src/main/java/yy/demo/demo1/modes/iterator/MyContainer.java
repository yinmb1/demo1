package yy.demo.demo1.modes.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yinmb
 * @Date 2019/1/24 09:48:31
 */
public class MyContainer extends Container {
    private List<Object> list;

    public MyContainer() {
        this.list = new ArrayList<Object>();
    }

    @Override
    public Iterator iterator() {
        return new MyIterator(list);
    }

    @Override
    public void put(Object obj) {
        this.list.add(obj);
    }
}
