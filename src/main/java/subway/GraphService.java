package subway;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.ConditionShort;
import subway.domain.GraphRepository;

import java.util.List;

public class GraphService {

    public void printShortestPath(String sourceStation, String targetStation, ConditionShort conditionShort) {
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath = getShortestPathInstance(conditionShort);
        int sumOfWeight = (int) dijkstraShortestPath.getPath(sourceStation, targetStation).getWeight();
        List<String> shortestPath = dijkstraShortestPath.getPath(sourceStation, targetStation).getVertexList();

        int sumOfAnotherWeight = 0;

        System.out.println("## 조회 결과\n" +
                "[INFO] ---");
        // 거리가 기준이면 시간 계산, 시간이 기준이면 거리 계산
        WeightedMultigraph<String, DefaultWeightedEdge> graphByAnother = GraphRepository.getGraphByCondition(conditionShort);
        for (int i = 0; i < shortestPath.size() - 1; i++) {
            DefaultWeightedEdge edge = graphByAnother.getEdge(shortestPath.get(i), shortestPath.get(i + 1));
            sumOfAnotherWeight += (int) graphByAnother.getEdgeWeight(edge);
        }
        System.out.println("[INFO] 총 거리: " + sumOfWeight + "km");
        System.out.println("[INFO] 총 소요 시간: " + sumOfAnotherWeight + "분");
        System.out.println("[INFO] ---");
        for (String stationName : shortestPath) {
            System.out.println("[INFO] " + stationName);
        }
        System.out.println();
    }

    private DijkstraShortestPath<String, DefaultWeightedEdge> getShortestPathInstance(ConditionShort conditionShort) {
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath = null;
        if (conditionShort == ConditionShort.DISTANCE) {
            dijkstraShortestPath = new DijkstraShortestPath<>(GraphRepository.getGraphByCondition(conditionShort));
        }
        if (conditionShort == ConditionShort.TIME) {
            dijkstraShortestPath = new DijkstraShortestPath<>(GraphRepository.getGraphByCondition(conditionShort));
        }
        return dijkstraShortestPath;
    }

    // TODO 역에서 역으로 도달 가능한 지
    public void test() {
    }
}
