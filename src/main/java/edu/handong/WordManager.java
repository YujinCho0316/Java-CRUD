package edu.handong;

import java.util.Scanner;
public class WordManager {
    Scanner s = new Scanner(System.in);
    WordCRUD wordCRUD;
    WordManager(){
        wordCRUD = new WordCRUD(s);
    }

    public void start() { // main 역할
        wordCRUD.loadFile();

        while(true) {
            int menu = selectMenu();
            if (menu == 0) {
                System.out.println("\n프로그램 종료! 다음에 만나요~");
                break;
            }
            if (menu == 4) { // create
                wordCRUD.addItem();
            } else if (menu == 1) { // list
                wordCRUD.listAll();
            } else if (menu == 5) { // update
                wordCRUD.updateItem();
            } else if (menu == 6) { // delete
                wordCRUD.deleteItem();
            } else if (menu == 7) { // save file
                wordCRUD.saveFile();
            }
        }
    }

    private int selectMenu() {
        System.out.print("	 *** 영단어 마스터 ***\r\n"
                + "*********************\r\n"
                + "1. 모든 단어 보기\r\n"
                + "2. 수준별 단어 보기\r\n"
                + "3. 단어 검색\r\n"
                + "4. 단어 추가\r\n"
                + "5. 단어 수정\r\n"
                + "6. 단어 삭제\r\n"
                + "7. 파일 저장\r\n"
                + "0. 나가기\r\n"
                + "*********************\r\n"
                + "=> 원하는 메뉴는? ");

        return s.nextInt();
    }


}
