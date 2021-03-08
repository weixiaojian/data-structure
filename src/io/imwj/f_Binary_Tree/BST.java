package io.imwj.f_Binary_Tree;

import com.sun.org.apache.regexp.internal.RE;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二分搜索树 元素E满足可以比较性Comparable
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
    private boolean containsByRecursive(Node node, E e){
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

    /**
     * 前序遍历
     */
    public void preOrder(){
        preOrderByRecursive(root);
    }

    /**
     * 递归的前序遍历
     * @param node
     */
    private void preOrderByRecursive(Node node){
        if(node == null){
            return ;
        }
        //可以执行具体操作：修改元素值等
        System.out.println(node.e);
        preOrderByRecursive(node.left);
        preOrderByRecursive(node.right);
    };

    /**
     * 中序遍历
     */
    public void inOrder(){
        inOrderByRecursive(root);
    }

    /**
     * 递归的中序遍历
     * @param node
     */
    public void inOrderByRecursive(Node node){
        if(node == null){
            return ;
        }
        inOrderByRecursive(node.left);
        System.out.println(node.e);
        inOrderByRecursive(node.right);
    }

    /**
     * 后序遍历
     */
    public void psotOrder(){
        psotOrderByRecursive(root);
    }

    /**
     * 递归的后序遍历
     * @param node
     */
    public void psotOrderByRecursive(Node node){
        if(node == null){
            return ;
        }
        psotOrderByRecursive(node.left);
        psotOrderByRecursive(node.right);
        System.out.println(node.e);
    }

    /**
     * 层序遍历
     */
    public void levelOrder(){
        Queue<Node> q = new LinkedList();
        q.add(root);
        while (!q.isEmpty()){
            Node cur = q.remove();
            System.out.println(cur.e);
            if(cur.left != null){
                q.add(cur.left);
            }
            if(cur.right != null){
                q.add(cur.right);
            }
        }
    }

    /**
     * 寻找元素中的最小值
     * @return
     */
    public E minnum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty!");
        }
        return (E) minnumByRecursive(root).e;
    }

    /**
     * 递归寻找元素中的最小值
     * @return
     */
    private Node minnumByRecursive(Node node){
        if(node.left == null){
            return node;
        }
        return minnumByRecursive(node.left);
    }

    /**
     * 寻找元素中的最大值
     * @return
     */
    public E maxxum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty!");
        }
        return (E) maxumnumByRecursive(root).e;
    }

    /**
     * 递归寻找元素中的最大值
     * @return
     */
    private Node maxumnumByRecursive(Node node){
        if(node.right == null){
            return node;
        }
        return maxumnumByRecursive(node.right);
    }

    /**
     * 删除最小元素
     * @return
     */
    public E  removeMin(){
        E ret = minnum();
        root = removeMinByRecursive(root);
        return ret;
    }

    /**
     * 递归删除最小元素  返回删除元素后的根
     * @param node
     */
    private Node removeMinByRecursive(Node node) {
        if(node.left == null){
            Node rightNode = node.right;
            node.left = null;
            size --;
            return rightNode;
        }
        node.left = removeMinByRecursive(node.left);
        return node;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        return res.toString();
    }

}
