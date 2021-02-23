package io.imwj.d_LinkedList;

/**
 * @author langao_q
 * @since 2021-02-22 17:44
 */
public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList();

        //赋值
        for(int i=0; i<5; i++){
            list.addFirst(i);
            System.out.println(list);
        }
        //向头部添加
        list.addLast(-1);
        System.out.println(list);

        //向指定位置添加
        list.add(2, 99);
        System.out.println(list);

        list.set(2, 88);
        System.out.println(list);

        //删除头/尾
        list.removeFirst();
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
    }
}
