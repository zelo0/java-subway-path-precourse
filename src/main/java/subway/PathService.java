package subway;

public class PathService {
    
    private final InputTaker inputTaker;

    public PathService(InputTaker inputTaker) {
        this.inputTaker = inputTaker;
    }

    public void run() {
        while (true) {
            printPathMenu();
            String input = inputTaker.takeInput("## 원하는 기능을 선택하세요.");
//            if (input.equals("1")) {
//
//            }
            if (input.equals("B")) {
                break;
            }
        }
    }

    private void printPathMenu() {
    }
}
