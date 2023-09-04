package edu.handong;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class WordCRUD implements  ICRUD{
    ArrayList<Word> list;
    Scanner s;
    final String fname = "Dictionary.txt";

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
        System.out.print("\n=> 난이도(1,2,3) & 새 단어 입력: ");
        int level = s.nextInt();
        String word = s.nextLine();

        System.out.print("=> 뜻 입력 : ");
        String meaning = s.nextLine();

        return new Word(0, level, word, meaning);
    }
    public void addItem(){
        Word one = (Word)add();
        list.add(one);
        System.out.println("\n새 단어가 단어장에 추가되었습니다 !!\n");
    }

    // 5번
    public ArrayList<Integer> listAll(String keyword) {
        ArrayList<Integer> idlist = new ArrayList<>();
        int j = 0;
        System.out.println("\n--------------------------------");
        for(int i = 0; i < list.size(); i++) {
            String word = list.get(i).getWord();
            if(!word.contains(keyword)) continue;
            System.out.print(j+1 + " ");
            System.out.println(list.get(i).toString());
            idlist.add(i);
            j++;
        }
        System.out.println("--------------------------------\n");
        return idlist;
    }

    public void updateItem() {
        System.out.print("=> 수정할 단어 검색 : ");
        String keyword = s.next();
        ArrayList<Integer> idlist = this.listAll(keyword);
        System.out.print("=> 수정할 번호 선택 : ");
        int id = s.nextInt();
        s.nextLine();
        System.out.print("=> 뜻 입력 : ");
        String meaning = s.nextLine();
        Word word = list.get(idlist.get(id-1));
        word.setMeaning(meaning);
        System.out.println("단어가 수정되었습니다. \n");
    }

    // 6번
    public void deleteItem() {
        System.out.print("=> 삭제할 단어 검색 : ");
        String keyword = s.next();
        ArrayList<Integer> idlist = this.listAll(keyword);
        System.out.print("=> 삭제할 번호 선택 : ");
        int id = s.nextInt();
        System.out.print("=> 정말로 삭제하시겠습니까?(Y/n) ");
        String ans = s.next();
        if(ans.equalsIgnoreCase("Y")){
            list.remove((int)idlist.get(id-1)); // 객체 혹은 정수 인덱스여야 삭제 가능
            System.out.println("단어가 삭제되었습니다.\n");
        }
        else
            System.out.println("취소되었습니다.\n");
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

    public void loadFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fname));
            String line;
            int count = 0;

            while(true) {
                line = br.readLine();
                if(line == null) break;
                String[] data = line.split("\\|");
                int level = Integer.parseInt(data[0]);
                String word = data[1];
                String meaning = data[2];

                list.add(new Word(0, level, word, meaning));
                count++;
            }
            br.close();
            System.out.println("==> " + count + "개 로딩 완료!!!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    // 7번
    public void saveFile() {
        try {
            PrintWriter pr = new PrintWriter(new FileWriter(fname));
            for(Word one: list) {
                pr.write(one.toFileString() + "\n");
            }
            pr.close();
            System.out.println("==> 데이터 저장 완료 !!!\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 2번
    public void listAll(int level) {
        int j = 0;
        System.out.println("\n--------------------------------");
        for (Word word : list) {
            int ilevel = word.getLevel();
            if (ilevel != level) continue;
            System.out.print(j + 1 + " ");
            System.out.println(word);
            j++;
        }
        System.out.println("--------------------------------\n");
    }
    public void searchLevel() {
        System.out.print("=> 원하는 레벨은? (1~3) ");
        int level = s.nextInt();
        listAll(level);
    }

    // 3번
    public void searchWord() {
        System.out.print("=> 원하는 단어는? ");
        String keyword = s.next();
        listAll(keyword);
    }
}
