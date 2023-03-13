package book;

import java.util.ArrayList;

public interface BookMgmMenu {
    void showMenu();
    void choiceMenu();
    ArrayList<BookVo> addBook();
    void deleteBook();
    void modifyBook();
}
