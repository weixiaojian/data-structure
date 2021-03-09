package io.imwj.g_Set_Map;

import io.imwj.util.FileOperation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author langao_q
 * @since 2021-03-09 17:47
 */
public class Main {

    public static void main(String[] args) {

        //1.使用list
        ArrayList<String> list = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt", list);
        System.out.println("Total size：" + list.size());

        //2.使用Set
        Set<String> set = new BSTSet<>();
        for(String str : list){
            set.add(str);
        }
        System.out.println("Total size：" + set.getSize());

    }

}
