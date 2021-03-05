package io.imwj.f_Binary_Tree;

/**
 * @author langao_q
 * @since 2021-03-05 16:49
 */
public class Main {

    public static void main(String[] args) {
        BST<Integer> b = new BST<>();
        int[] nums = {5,3,6,8,4,2};
        for(Integer num : nums){
           b.add(num);
        }
        //5 3 2 6 4 8
        b.preOrder();

        //2 3 4 5 6 8
        b.inOrder();

        //2 4 3 8 6 5
        b.psotOrder();
    }

}
