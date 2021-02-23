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

    private Node dummyHead;

    private int size;

    public LinkedList(){
        dummyHead = new Node(null, null);
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
     * 在链表指定位置添加元素
     * 注意 要先把指定index后的元素添加到e.next 再把e添加到index前元素的next下
     * @param index
     * @param e
     */
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("add 添加元素失败 === index不合法！");
        }

        Node prev = dummyHead;
        for(int i=0; i< index; i++){
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);

        size++;
    }

    /**
     * 在链表头添加元素
     * 只需要把之前的head添加到新元素e.next后面即可
     * @param e
     */
    public void addFirst(E e){
        add(0, e);
    }

    /**
     * 在链表尾部添加元素
     * @param e
     */
    public void addLast(E e){
        add(size, e);
    }

    /**
     * 获取指定位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("get 添加元素失败 === index不合法！");
        }
        Node cur = dummyHead.next;
        for(int i=0; i < size; i++){
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获取最后一个元素
     * @return
     */
    public E getLast(){
        return get(size);
    }

    /**
     * 修改指定位置的元素
     * 问题：这种方式会不会导致index位置元素后的next没了呢？ 传入e的next是没有值的
     * 解决方法：参考setTo
     * @param index
     * @param e
     */
    public void set(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("set 添加元素失败 === index不合法！");
        }
        Node cur = dummyHead.next;
        for(int i=0; i<index; i++){
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 修改指定位置的元素
     * @param index
     * @param e
     */
    public void setTo(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("set 添加元素失败 === index不合法！");
        }
        Node cur = dummyHead;
        for(int i=0; i<index; i++){
            cur = cur.next;
        }
        //1.先把index位置元素的next保存下来loadNext  Node loadNext = cur.next;
        //2.把loadNext放到e.next中  Node node = new Node(e, loadNext);
        //3.把e放到cur.nect中  cur.next = node;
        cur.next = new Node(e, cur.next);
    }

    /**
     * 判断链表中是否存在指定元素
     * @param e
     * @return
     */
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur.e != null){
            if(e.equals(cur.e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null){
            str.append(cur.e + " -> ");
            cur = cur.next;
        }
        str.append("NULL");
        return str.toString();
    }
}
