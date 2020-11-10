package Lv5;

import java.util.Iterator;

class MyList<T> {
    public Iterator iterator() {
        return new Itr();
    }

    // 写你的代码 支持增删查改
    class Itr implements Iterator<T> {
        // 这是你的迭代器
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }
    }
}
