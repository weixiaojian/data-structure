package io.imwj.f_Binary_Tree;

/**
 * @author langao_q
 * @since 2021-03-02 17:34
 */
public class BST<E extends Comparable<E>> {

    class Node<E> {
        public E e;
        public Node left;
        public Node right;

        /**
         * 构造函数-toString方法
         * @param e
         */
        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        this.root = null;
        this.size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }


}
