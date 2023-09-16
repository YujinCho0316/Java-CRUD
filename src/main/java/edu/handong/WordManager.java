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
            if (menu == 1) { // list
                wordCRUD.listAll();
            } else if (menu == 2) { // search level
                wordCRUD.searchLevel();
            } else if (menu == 3) { // search word
                wordCRUD.searchWord();
            } else if (menu == 4) { // create
                wordCRUD.addItem();
            } else if (menu == 5) { // update
                wordCRUD.updateItem();
            } else if (menu == 6) { // delete
                wordCRUD.deleteItem();
            } else if (menu == 7) { // save file
                wordCRUD.saveFile();
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력하세요.\n");
            }
        }
    }

    private int selectMenu() {
        System.out.print("""
                	 \n*** 영단어 마스터 ***\r
                *********************\r
                1. 모든 단어 보기\r
                2. 수준별 단어 보기\r
                3. 단어 검색\r
                4. 단어 추가\r
                5. 단어 수정\r
                6. 단어 삭제\r
                7. 파일 저장\r
                0. 나가기\r
                *********************\r
                => 원하는 메뉴는?\s""");

        return s.nextInt();
    }


}
