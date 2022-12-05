package subway;

public class MainService {

    private final InputTaker inputTaker;

    public MainService(InputTaker inputTaker) {
        this.inputTaker = inputTaker;
    }

    public void run() {
        while (true) {
            printMainMenu();
            String input = inputTaker.takeInput("## 원하는 기능을 선택하세요.");
            if (input.equals("1")) {
                PathService pathService = new PathService(inputTaker);
                pathService.run();
            }
            if (input.equals("B")) {
                break;
            }
        }
    }

    private void printMainMenu() {
        System.out.println("## 메인 화면\n" +
                "1. 경로 조회\n" +
                "Q. 종료");
    }



}
