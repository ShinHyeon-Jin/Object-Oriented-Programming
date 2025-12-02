import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

/* db.txt 파일 내용 (파일이 실제 실행 환경에 존재한다고 가정합니다.)
ID, 비밀번호 쌍은 아래와 같습니다.
myId myPass
myId2 myPass2
myId3 myPass3
*/

public class Homework9 {

    public static void main(String[] args) {
        HashMap<String, String> userDb = new HashMap<>();

        try {
            Scanner fileScanner = new Scanner(new File("db.txt"));

            while (fileScanner.hasNext()) {
                String id = fileScanner.next();
                String password = fileScanner.next();
                userDb.put(id.trim(), password.trim());
            }
            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("db.txt 파일을 찾을 수 없습니다.");
            e.printStackTrace();
            return;
        }

        Scanner consoleScanner = new Scanner(System.in);

        while (true) {
            System.out.println("id와 password를 입력해주세요.");

            System.out.print("id : ");
            String enteredId = consoleScanner.nextLine().trim();

            if (!userDb.containsKey(enteredId)) {
                System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요.");
            }

            System.out.print("password: ");
            String enteredPass = consoleScanner.nextLine().trim();

            String correctPass = userDb.get(enteredId);

            if (enteredPass.equals(correctPass)) {
                System.out.println("id와 비밀번호가 일치합니다.");
                break;
            } else {
                System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
            }
        }
        consoleScanner.close();
    }
}