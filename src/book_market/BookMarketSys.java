package book_market;

import static java.lang.System.exit;

import user.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class BookMarketSys extends UserInfo{
    public static void showMenu(){
        System.out.println("\n===================================================");
        System.out.println("1. 고객 정보 확인\t\t    4. 장바구니에 항목 추가");
        System.out.println("2. 장바구니 상품 목록 보기\t5. 장바구니에 항목 수량 줄이기");
        System.out.println("3. 장바구니 비우기\t\t    6. 장바구니의 항목 삭제");
        System.out.println("7. 영수증 출력\t\t    8. 종료");
        System.out.println("===================================================");
        choiceMenu();
    }

    public static void choiceMenu(){
        System.out.print("메뉴 선택: ");
        ArrayList<CartVo> cartList = new ArrayList<>();
        Cart cart = new Cart();
        int i = sc.nextInt();
        switch (i){
            case 1: printUserInfo(id);
                    showMenu();
            case 2: cart.menuCartItemList(cartList);
                    showMenu();
            case 3: cart.menuCartClear(cartList);
                    showMenu();
            case 4: cartList=cart.menuCartAddItem();
                    showMenu();
            case 5: cart.menuCartRemoveItemCount(cartList);
                    showMenu();
            case 6: cart.menuCartRemoveItem(cartList);
                    showMenu();
            case 7: cart.menuCartBill();
                    showMenu();
            case 8: exit(0);
        }
    }
}