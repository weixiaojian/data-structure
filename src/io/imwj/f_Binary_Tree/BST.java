package io.imwj.f_Binary_Tree;

/**
 * 二分搜索树 元素E满足可以比较性Comparable
 *
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
         *
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

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向二分搜索树中添加元素
     * @param e
     */
    public void add(E e) {
        root = addByRecursive(root, e);
    }

    /**
     * 在二分搜索树中查找指定元素
     * @param e
     * @return
     */
    public boolean contains(E e){
        return containsByRecursive(root, e);
    }


    /**
     * 递归的向node中添加元素e
     * 返回插入新节点后二分搜索树的根
     * @param node
     * @param e
     */
    private Node addByRecursive(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo((E) node.e) < 0) {
            node.left = addByRecursive(node.left, e);
        } else {
            node.right = addByRecursive(node.right, e);
        }
        return node;
    }

    /**
     * 递归的向node中查找元素e
     * @param node
     * @param e
     */
    public boolean containsByRecursive(Node node, E e){
        if(node == null){
            return false;
        }
        if(e.compareTo((E) node.e) == 0){
            return true;
        }else if(e.compareTo((E) node.e) < 0){
            return containsByRecursive(node.left, e);
        }else{
            return containsByRecursive(node.right, e);
        }
    }


}
