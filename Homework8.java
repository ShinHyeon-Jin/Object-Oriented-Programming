import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Homework8 {
    public static void main(String[] args) {
        // 1. HashMap 생성 및 초기 데이터 저장 [cite: 631, 645]
        Map<String, String> map = new HashMap<>();

        // 문제 표에 주어진 ID와 비밀번호 쌍 저장 
        // (PDF에는 myld로 표기되어 있으나 일반적인 관례인 myId로 작성했습니다)
        map.put("myId", "myPass");
        map.put("myId2", "myPass2");
        map.put("myId3", "myPass3");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("id와 password를 입력해주세요.");

            // 2. ID 입력 및 공백 제거 
            System.out.print("id : ");
            String id = scanner.nextLine().trim();

            // 3. ID 존재 여부 확인 
            if (!map.containsKey(id)) {
                System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요.");
                continue; // 루프의 처음으로 돌아감
            }

            // 4. 비밀번호 입력 및 공백 제거 
            System.out.print("password: ");
            String password = scanner.nextLine().trim();

            // 5. 비밀번호 일치 여부 확인 [cite: 650, 978]
            if (map.get(id).equals(password)) {
                System.out.println("id와 비밀번호가 일치합니다.");
                break; // 로그인 성공 시 반복문 종료 [cite: 997]
            } else {
                System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
                // 비밀번호 불일치 시 다시 루프 반복 [cite: 993]
            }
        }

        scanner.close();
    }
}