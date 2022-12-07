package subway;

import subway.domain.ConditionShort;

public class PathService {

    private final InputTaker inputTaker;

    public PathService(InputTaker inputTaker) {
        this.inputTaker = inputTaker;
    }

    public void run() {
        GraphService graphService = new GraphService();

        while (true) {
            printPathMenu();
            String input = inputTaker.takeInput("## 원하는 기능을 선택하세요.");
            if (input.equals("1") || input.equals("2")) {
                String startStation = inputTaker.takeInput("## 출발역을 입력하세요.");
                String endStation = inputTaker.takeInput("## 도착역을 입력하세요.");
                if (!Validator.isDifferentNames(startStation, endStation)) {
                    continue;
                }
                // TODO 구현 필요
                if (!Validator.canGoThere(startStation, endStation)) {
                    continue;
                }

                graphService.printShortestPath(startStation, endStation, ConditionShort.getByValue(input));
                break;
            }
            if (input.equals("B")) {
                break;
            }
        }
    }

    private void printPathMenu() {
        System.out.println("## 경로 기준\n" +
                "1. 최단 거리\n" +
                "2. 최소 시간\n" +
                "B. 돌아가기");
    }
}
