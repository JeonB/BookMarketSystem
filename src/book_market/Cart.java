package book_market;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart extends CartVo implements CartMenu {
    ArrayList<CartVo> cartList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    //2. 장바구니 목록 보기
    @Override
    public void menuCartItemList(ArrayList<CartVo> cartList) {
        for (CartVo cart: cartList) {
            System.out.printf("%s, %d, %d \n",cart.getBook(),cart.getPrice(),cart.getBook_count());
        }
    }
    
    // 3. 장바구니 비우기
    @Override
    public void menuCartClear(ArrayList<CartVo> cartList) {
        cartList.clear();
        System.out.println("장바구니를 비웠습니다!");
    }

    //4. 장바구니 항목추가
    @Override
    public ArrayList<CartVo> menuCartAddItem() {
        CartVo cart = new Cart();
        //책, 가격, 개수 등록
        System.out.print("이름 : ");
        String book = sc.nextLine();
        cart.setBook(book);

        System.out.print("가격 : ");
        int price = sc.nextInt();
        cart.setPrice(price);

        System.out.print("개수 : ");
        int count = sc.nextInt();
        cart.setBook_count(count);

        cartList.add(cart);

        System.out.print("추가 등록 하시겠습니까? 계속 진행하시려면 아무키나 누르십시오. 종료하시려면 n: ");
        String c = sc.nextLine();
        sc.close();
        if(!c.equals("n")){
            menuCartAddItem();
        }

        return cartList;
    }
    
    //5.장바구니 수량 줄이기
    @Override
    public void menuCartRemoveItemCount(ArrayList<CartVo> cartList) {
        System.out.print("개수를 줄일 책 입력 : ");
        String book = sc.next();
        for (CartVo cart : cartList) {
            if (book.equals(cart.getBook())) {
                int pre_count = cart.getBook_count();
                System.out.print("바꿀 수량을 입력하세요 : ");
                int count = sc.nextInt();
                cart.setBook_count(count);
                System.out.printf("수정 완료! 수정 전 수량: %d -> 수정 후 수량: %d\n",pre_count,count);
                System.out.print("추가로 작업 하시겠습니까? 계속 진행하시려면 아무키나 누르십시오. 종료하시려면 n");
                String c = sc.next();
                sc.close();
                if (!c.equals("n")){
                    menuCartRemoveItemCount(cartList);
                }
                else{
                    break;
                }
            }
        }
    }

    //6. 장바구니 항목 삭제
    @Override
    public void menuCartRemoveItem(ArrayList<CartVo> cartList) {
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
                    menuCartRemoveItem(cartList);
                else
                    break;
            }
        }
    }

    @Override
    public void menuCartBill() {

    }
}
