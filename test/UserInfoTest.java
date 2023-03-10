import org.junit.jupiter.api.Test;
import user.UserVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

class UserInfoTest {
    Scanner sc = new Scanner(System.in);
    List<UserVo> userList = new ArrayList<>();

    @Test
    void signUp() {
        UserVo user = new UserVo();
        boolean flag = true;

        System.out.print("ID : ");
        String id = sc.next();
        //중복체크
        if(isDuplicate(id)){
            user.setId(id);
        }
        else {
            signUp();
        }

        System.out.print("PASSWORD : ");
        String password = sc.next();
        user.setPassword(password);

        System.out.print("이름 : ");
        String name = sc.next();
        user.setName(name);

        while (flag) {
            System.out.print("email : ");
            String email = sc.next();
            String pattern = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
            if (Pattern.matches(pattern, email)) {
                System.out.println("올바른 이메일 형식입니다. ");
                user.setEmail(email);
                flag = false;
            } else {
                System.out.println("올바른 이메일 형식이 아닙니다. 다시 입력하십시오.");
            }
        }

        userList.add(user);
    }

    @Test
    void signIn() {

//        user.UserVo usertest = new user.UserVo();
//        usertest.setId("test");
//        usertest.setPassword("1234");
//        userList.add(usertest);
        int cnt = 0;
        String[] idpassword = idPassword();
        for (UserVo user : userList) {
            if (idpassword[0].equals(user.getId()) && idpassword[1].equals(user.getPassword())) {
                System.out.printf("환영합니다 %s님! 수 많은 도서가 당신을 기다립니다!", user.getName());
                cnt++;
                break;
            }
        }
        if (cnt == 0) {
            System.out.println("아이디 또는 비밀번호를 잘못 입력하셨습니다.");
            System.out.println("다시 입력하여 주십시오.");
            signIn();
        }
    }

    @Test
    void modifyPassword() {
        int cnt = 0;

        String[] idpassword = idPassword();
        for (UserVo user : userList) {
            if (idpassword[0].equals(user.getId()) && idpassword[1].equals(user.getPassword())) {
                System.out.print("새로운 비밀번호를 입력하십시오 : ");
                String password = sc.next();
                user.setPassword(password);
                System.out.println("비밀번호 수정이 완료되었습니다!");
                cnt++;
                break;
            }
        }
        if (cnt == 0) {
            System.out.println("아이디 또는 비밀번호를 잘못 입력하셨습니다.");
            System.out.println("다시 입력하여 주십시오.");
            modifyPassword();
        }
    }

    @Test
    String[] idPassword() {
        System.out.print("아이디를 입력하십시오.");
        String id = sc.next();
        System.out.print("비밀번호를 입력하십시오.");
        String password = sc.next();
        String[] idpassword = {id, password};
        return idpassword;
    }
    @Test
    public boolean isDuplicate(String id) {
        boolean duplicate = true;
        for (UserVo userList : userList) {
            if (id.equals(userList.getId())) {
                System.out.println("중복된 아이디입니다. 다른 아이디를 입력하십시오.");
                duplicate = false;
                break;
            }
        }
        return duplicate;
    }
}