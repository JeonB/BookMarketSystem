import book_market.Cart;
import book_market.CartVo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CartTest {
    List<CartVo> cartList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    @Test
    void menuCartItemList() {
        for (CartVo cart: cartList) {
            System.out.printf("%s, %d, %d \n",cart.getBook(),cart.getPrice(),cart.getBook_count());
        }
    }

    @Test
    void menuCartClear() {
        cartList.clear();
        System.out.println("장바구니를 비웠습니다!");
    }

    @Test
    void menuCartAddItem() {
        CartVo cart = new CartVo();
        //책, 가격, 개수 등록
        System.out.print("이름 : ");
        String book = sc.next();
        cart.setBook(book);

        System.out.print("가격 : ");
        int price = sc.nextInt();
        cart.setPrice(price);

        System.out.print("개수 : ");
        int count = sc.nextInt();
        cart.setBook_count(count);

        cartList.add(cart);

        System.out.print("추가 등록 하시겠습니까? 계속 진행하시려면 아무키나 누르십시오. 종료하시려면 n");
        String c = sc.next();
        if(!c.equals("n"))
            menuCartAddItem();
        sc.close();
    }

    @Test
    void menuCartRemoveItemCount() {
        System.out.print("개수를 줄일 책 입력 : ");
        String book = sc.next();
        for (CartVo cart : cartList) {
            if (book.equals(cart.getBook())) {
                System.out.print("바꿀 수량을 입력하세요 : ");
                int count = sc.nextInt();
                cart.setBook_count(count);
                System.out.print("추가로 작업 하시겠습니까? 계속 진행하시려면 아무키나 누르십시오. 종료하시려면 n");
                String c = sc.next();
                if (!c.equals("n"))
                    menuCartRemoveItemCount();
                else
                    break;
            }
        }
    }

    @Test
    void menuCartRemoveItem() {
        System.out.print("삭제하려는 책 입력 : ");
        String book = sc.next();
        for (CartVo cart : cartList) {
            if (book.equals(cart.getBook())) {
                if(cartList.remove(cart))
                    System.out.println("삭제 완료");
                else
                    System.out.println("삭제 실패!!");
                System.out.print("추가로 작업 하시겠습니까? 계속 진행하시려면 아무키나 누르십시오. 종료하시려면 n");
                String c = sc.next();
                if (!c.equals("n"))
                    menuCartRemoveItemCount();
                else
                    break;
            }
        }
    }

    @Test
    void menuCartBill() {
    }
}