package user;

import book_market.Cart;

import static java.lang.System.exit;

public class UserMgmSys extends UserInfo {
    static UserMgmSys userInfo =new UserMgmSys();
    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu(){
        System.out.println("==========================");
        System.out.println("1. 회원 가입\t\t    2. 로그인");
        System.out.println("3. 비밀번호 수정\t    4. 종료");
        System.out.println("==========================");
        choiceMenu();
    }

    public static void choiceMenu(){
        System.out.print("메뉴 선택: ");
        Cart cart = new Cart();
        int i = sc.nextInt();
        switch (i){
            case 1:signUp();
                showMenu();
            case 2: userInfo.signIn();
                showMenu();
            case 3: modifyPassword();
                showMenu();
            case 4: exit(0);
        }
    }
}
