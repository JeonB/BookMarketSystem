package book;

import book_market.Cart;
import book_market.CartVo;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class BookMgm implements BookMgmMenu{
    Scanner sc = new Scanner(System.in);
    ArrayList<BookVo> bookList = new ArrayList<>();
    @Override
    public void showMenu() {
        System.out.println("도서 관리 메뉴");
        System.out.println("==========================");
        System.out.println("1. 도서 등록\t\t    2. 도서 수정");
        System.out.println("3. 도서 삭제\t\t    4. 종료");
        System.out.println("==========================");
        choiceMenu();
    }
    public void choiceMenu(){
        System.out.print("메뉴 선택: ");
        int i = sc.nextInt();
        switch (i){
            case 1:addBook();
                showMenu();
            case 2: modifyBook();
                showMenu();
            case 3: deleteBook();
                showMenu();
            case 4: exit(0);
        }
    }
    @Override
    public ArrayList<BookVo> addBook() {

            BookVo book = new BookVo();

            System.out.print("이름 : ");
            String bookname = sc.nextLine();
            book.setBookName(bookname);

            System.out.print("작가 : ");
            String author = sc.nextLine();
            book.setAuthor(author);

            System.out.print("ISBN : ");
            String isbn = sc.next();
            book.setIsbn(isbn);

            System.out.print("가격 : ");
            int price = sc.nextInt();
            book.setPrice(price);

            System.out.print("개수 : ");
            int count = sc.nextInt();
            book.setCount(count);

            bookList.add(book);

            System.out.print("추가 등록 하시겠습니까? 계속 진행하시려면 아무키나 누르십시오. 종료하시려면 n: ");
            String c = sc.next();
            if(!c.equals("n")){
                sc.nextLine();
                addBook();
            }

            return bookList;
    }

    @Override
    public void deleteBook() {

    }

    @Override
    public void modifyBook() {

    }
}
