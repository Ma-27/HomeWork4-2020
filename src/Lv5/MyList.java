package Lv5;

import java.util.Arrays;
import java.util.Iterator;

class MyList<T> implements Iterable<T> {
    //默认容量
    private static final int DEFAULT_CAPACITY = 10;
    //记录数组的位置
    int index = 0;
    private Object[] variable;

    /**
     * 无参构造方法，调用这个则会使初始容量为 DEFAULT_CAPACITY
     */
    public MyList() {
        variable = new Object[DEFAULT_CAPACITY];
        //给每个元素初始化
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            variable[i] = new Object[i];
        }
    }

    /**
     * 规定长度的类数组
     * FIXME:暂未测试
     *
     * @param size 类数组的长度
     */
    public MyList(int size) {
        if (size < 0) {
            throw new IllegalStateException("该类数组的长度有问题");
        } else {
            //给variable 初始化
            variable = new Object[size];
            for (int i = 0; i < size; i++) {
                variable[i] = new Object[i];
            }
        }
    }

    /**
     * 调用iterator给Iterator类初始化
     *
     * @return 返回一个内部类itr的对象
     */
    public Iterator<T> iterator() {
        return new Itr();
    }


    // 写你的代码 支持增删查改

    /**
     * 在T中增加元素
     */
    public void add(T item) {
        //先进行扩容检查，如果index比当前对象数组长度小，不扩容
        if (variable.length <= index) {
            variable = addCapacity(index + 1);
        }
        variable[index++] = item;
    }

    /**
     * 在T中删除元素
     *
     * @param index 删除在index处的元素
     */
    public void remove(int index) {//删除index处的元素
        if (checkIndex(index)) {
            int moveNum = variable.length - index - 1;
            if (moveNum > 0) {
                System.arraycopy(variable, index + 1, variable, index, moveNum);
            }
        } else {
            System.out.println("参数不合法");
            System.exit(1);
        }
    }

    /**
     * 在T中查找元素
     *
     * @param index 要查找的元素的位置
     * @return 返回这个位置的对象
     */
    public Object get(int index) {
        if (checkIndex(index)) {
            return variable[index];
        } else {
            return null;
        }
    }

    /**
     * 在某个位置修改某元素
     *
     * @param index 要改变的元素的位置
     * @param obj   待插入的元素
     */
    public void set(int index, Object obj) {
        if (checkIndex(index)) {
            //设置新值
            variable[index] = obj;
        }
    }

    /**
     * 在扩容之前检查现有数组的容量
     *
     * @param neededCapacity 传入一个需要的容量
     */
    private Object[] addCapacity(int neededCapacity) {
        Object[] oldVariables;
        if (neededCapacity > variable.length) {
            oldVariables = variable;
            Object[] newVariable;
            newVariable = Arrays.copyOf(oldVariables, neededCapacity);
            return newVariable;
        } else {
            return variable;
        }
    }

    /**
     * 检查传入的参数是否合法，防止非法访问
     *
     * @param index 传入的位置参数
     */
    private boolean checkIndex(int index) {
        if (index < 0 || index >= variable.length) {
            System.out.println("参数非法，请重新输入要访问的参数,当前输入的参数为：" + index);
            //throw new IllegalArgumentException("参数非法");
            return false;
        } else {
            return true;
        }
    }


    class Itr implements Iterator {
        // 这是你的迭代器
        private int iteratorIndex = 0;

        @Override
        public boolean hasNext() {
            return iteratorIndex != variable.length;
        }

        @Override
        public T next() {
            return (T) get(iteratorIndex++);
        }
    }
}
