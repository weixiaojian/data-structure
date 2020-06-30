package io.imwj.link;

/**
 * 自定义链表
 * @author LANGAO
 * @date 2020-06-28 22:20:02
 */
public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", next=" + next +
                    '}';
        }
    }

    private Node head;

    private int size;

    public LinkedList(){
        head = null;
        size = 0;
    }

    /**
     * 获取size长度
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在链表头添加元素
     * 只需要把之前的head添加到新元素e.next后面即可
     * @param e
     */
    public void addFirst(E e){
        head = new Node(e, head);

        size ++;
    }

    /**
     * 在链表指定位置添加元素
     * 注意 要先把指定index后的元素添加到e.next 再把e添加到index前元素的next下
     * @param index
     * @param e
     */
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("add 添加元素失败 === index不合法！");
        }
        if(index == 0){
            addFirst(e);
        }

        Node prev = head;
        for(int i=0; i< index - 1; i++){
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);

        size++;
    }

    /**
     * 在链表尾部添加元素
     * @param e
     */
    public void addLast(E e){
        add(size, e);
    }


}
