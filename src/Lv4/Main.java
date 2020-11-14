package Lv4;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        OperateMe operateMe = null;
        Class<?> reflectionClass = null;
        Field modifyPrivacyField = null;

        //建一个对应于OperateMe类的class对象
        try {
            reflectionClass = Class.forName("Lv4.OperateMe");
        } catch (ClassNotFoundException e) {
            System.out.println("未找到这个类");
            //e.printStackTrace();
        }

        //获取reflection类的实例,并展示其中需要修改的变量
        try {
            operateMe = (OperateMe) reflectionClass.newInstance();
            //用对象访问其中的方法
            operateMe.showValue();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        //获取方法，并调用
        try {
            //获取方法
            Method setter = reflectionClass.getMethod("setValue1", String.class);
            Method getter = reflectionClass.getMethod("getValue1");
            try {
                //调用，传入一个class类的对象
                System.out.println("用反射把value1修改为 闪电五连鞭！（马保国np");
                setter.invoke(operateMe, "闪电五连鞭！");
                System.out.println("打印修改后的结果");
                System.out.println(getter.invoke(operateMe));
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            System.out.println("没有此方法");
            e.printStackTrace();
        }

        try {
            System.out.println();
            if (operateMe != null) {
                System.out.println("目前要修改的变量的值为：" + operateMe.getModifyPrivacy());
            }

            modifyPrivacyField = reflectionClass.getDeclaredField("modifyPrivacy");
            modifyPrivacyField.setAccessible(true);

            try {
                modifyPrivacyField.set(operateMe, "修改后的值");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            if (operateMe != null) {
                System.out.println("修改后的值为:" + operateMe.getModifyPrivacy());
            }

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
}
