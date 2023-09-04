package edu.handong;

import java.util.ArrayList;
import java.util.Scanner;
public class WordCRUD implements  ICRUD{
    ArrayList<Word> list;
    Scanner s;

    WordCRUD(Scanner s){
        list = new ArrayList<>();
        this.s = s;
    }

    // 1번
    public void listAll() {
        System.out.println("\n--------------------------------");
        for(int i = 0; i < list.size(); i++) {
            System.out.print(i+1 + " ");
            System.out.println(list.get(i).toString());
        }
        System.out.println("--------------------------------\n");
    }


    // 4번
    @Override
    public Object add() {
        return null;
    }
    public void addItem(){

    }

    @Override
    public int update(Object obj) {
        return 0;
    }

    @Override
    public int delete(Object obj) {
        return 0;
    }

    @Override
    public void selectOne(int id) {
    }
}
