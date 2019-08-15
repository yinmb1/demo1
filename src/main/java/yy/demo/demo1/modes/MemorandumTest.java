package yy.demo.demo1.modes;

import yy.demo.demo1.modes.memorandum.GameRole;
import yy.demo.demo1.modes.memorandum.RoleStateMange;

import java.util.ArrayList;
import java.util.List;

/**
 * 备忘录模式
 * @author yinmb
 * @Date 2019/1/25 14:53:08
 */
public class MemorandumTest {
    public static void main(String[] args) {
        GameRole liaowp=new GameRole();
        liaowp.init();
        liaowp.show();
        RoleStateMange adminMange=new RoleStateMange();
        //保存
        adminMange.setMemento(liaowp.saveMemento());
        liaowp.fightBoss();
        liaowp.show();
        liaowp.recove(adminMange.getMemento());
        liaowp.show();
        List<String> applySerialNos = new ArrayList<>();

        System.out.println(applySerialNos.isEmpty());
    }
}
