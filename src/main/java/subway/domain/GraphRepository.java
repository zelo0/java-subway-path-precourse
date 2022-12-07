package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.Collections;
import java.util.List;

public class GraphRepository {
    // 가중치가 거리인 그래프
    private static final WeightedMultigraph<String, DefaultWeightedEdge> graphByDistance
            = new WeightedMultigraph<>(DefaultWeightedEdge.class);
    // 가중치가 소요시간인 그래프
    private static final WeightedMultigraph<String, DefaultWeightedEdge> graphByTime
            = new WeightedMultigraph<>(DefaultWeightedEdge.class);

    // 그래프 초기화
    static {
        // 역 이름을 vertex로 추가
        List<Station> stations = StationRepository.stations();
        for (Station station : stations) {
            graphByDistance.addVertex(station.getName());
            graphByTime.addVertex(station.getName());
        }
        // 거리 가중치
        graphByDistance.setEdgeWeight(graphByDistance.addEdge("교대역", "강남역"), 2);
        graphByDistance.setEdgeWeight(graphByDistance.addEdge("강남역", "역삼역"), 2);
        graphByDistance.setEdgeWeight(graphByDistance.addEdge("교대역", "남부터미널역"), 3);
        graphByDistance.setEdgeWeight(graphByDistance.addEdge("남부터미널역", "양재역"), 6);
        graphByDistance.setEdgeWeight(graphByDistance.addEdge("양재역", "매봉역"), 1);
        graphByDistance.setEdgeWeight(graphByDistance.addEdge("강남역", "양재역"), 2);
        graphByDistance.setEdgeWeight(graphByDistance.addEdge("양재역", "양재시민의숲역"), 10);

        // 시간 가중치
        graphByTime.setEdgeWeight(graphByTime.addEdge("교대역", "강남역"), 3);
        graphByTime.setEdgeWeight(graphByTime.addEdge("강남역", "역삼역"), 3);
        graphByTime.setEdgeWeight(graphByTime.addEdge("교대역", "남부터미널역"), 2);
        graphByTime.setEdgeWeight(graphByTime.addEdge("남부터미널역", "양재역"), 5);
        graphByTime.setEdgeWeight(graphByTime.addEdge("양재역", "매봉역"), 1);
        graphByTime.setEdgeWeight(graphByTime.addEdge("강남역", "양재역"), 8);
        graphByTime.setEdgeWeight(graphByTime.addEdge("양재역", "양재시민의숲역"), 3);
    }

    public static WeightedMultigraph<String, DefaultWeightedEdge> getGraphByCondition(ConditionShort conditionShort) {
        if (conditionShort == ConditionShort.DISTANCE) {
            return graphByDistance;
        }
        return graphByTime;
    }

}
