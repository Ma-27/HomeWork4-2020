package Lv5;

import java.util.Scanner;

public class Main {
    //设该list的默认初始值为10
    static int INITIALIZE_SIZE = 3;

    public static void main(String[] args) {
        //增加一点可玩性，让你们自己增删查改节点
        int node = 0;
        MyList<String> list = new MyList<>();
        Scanner scanner = new Scanner(System.in);

        /*
        //本来想做动态输入，做不来
        System.out.println("请输入要增加的节点");
        String temp = scanner.nextLine();
        while (true){
            if (temp.trim().equalsIgnoreCase("exit")){
                break;
            }else {
                list.add(scanner.nextLine());
            }
        }
        scanner.close();
         */

        //也可以随意添加一点内容进去
        for (int i = 0; i < 10; i++) {
            list.add("初始化节点" + i);
            System.out.println("已初始化节点" + i);
        }

        Scanner others = new Scanner(System.in);

        //删除
        System.out.println("请输入要删除的节点");
        node = others.nextInt();
        list.remove(node);
        if (list.get(node) != null) {
            printList(list);
        }

        //查找
        System.out.println("请输入要查找的节点");
        node = others.nextInt();
        Object temp = list.get(node);
        System.out.println("查找到的节点为");
        if (temp != null) {
            System.out.println(temp.toString());
        }


        //修改
        System.out.println("请输入要修改的节点");
        node = others.nextInt();
        list.set(node, "将第" + node + "个修改了");
        if (list.get(node) != null) {
            printList(list);
        }
    }

    private static void printList(MyList<String> list) {
        //输出自己写的list

        /*
        for(int i = 0;i<10;i++){
            Object obj = list.get(i);
            System.out.println(obj.toString());
        }
         */


        //使用for each 遍历
        for (String s :
                list) {
            System.out.println(((Object) s).toString());
        }

    }
}
