package io.imwj.link;

/**
 * @author LANGAO
 * @date 2020-07-01 22:24:04
 */
public class LinkedListMain {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 5; i++) {
            list.addFirst(i);
        }
        System.out.println(list.toString());

        list.add(3, "x");
        System.out.println(list.toString());
    }
}
