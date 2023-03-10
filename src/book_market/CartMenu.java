package book_market;

import java.util.ArrayList;

public interface CartMenu {
//void menuGuestInfo() ;
void menuCartItemList(ArrayList<CartVo> cartList);
void menuCartClear(ArrayList<CartVo> cartList);
ArrayList<CartVo> menuCartAddItem();
void menuCartRemoveItemCount(ArrayList<CartVo> cartList);
void menuCartRemoveItem(ArrayList<CartVo> cartList);
void menuCartBill();

}
