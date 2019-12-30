package database;

import java.util.Vector;

public class College {
    //针对注册时填写学院信息的单纯的信息存储类
    private Vector v1 = new Vector();
    public College(){
        v1.addElement("请选择所属学院");
        v1.addElement("软件学院");
        v1.addElement("文学院");
        v1.addElement("历史与文博学院");
        v1.addElement("计算机与信息工程学院");
        v1.addElement("化学化工学院");
        v1.addElement("物理与电气工程学院");
        v1.addElement("政治与公共管理学院");
        v1.addElement("法学院");
        v1.addElement("外国语学院");
        v1.addElement("音乐学院");
        v1.addElement("美术学院");
        v1.addElement("数学与统计学院");
        v1.addElement("体育学院");
        v1.addElement("教育学院");
        v1.addElement("传媒学院");
        v1.addElement("建筑工程学院");
        v1.addElement("经济学院");
        v1.addElement("国际交流与教育学院");
        v1.addElement("创业学院");
        v1.addElement("马克思主义学院");
        v1.addElement("公共艺术教学部");
    }
    public Vector getV1(){
        return v1;
    }
}
