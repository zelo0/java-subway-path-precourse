package subway;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import subway.domain.ConditionShort;
import subway.domain.GraphRepository;

import java.util.List;

public class GraphService {

    public void printShortestPath(String sourceStation, String targetStation, ConditionShort conditionShort) {
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath = getShortestPathInstance(conditionShort);
        int sumOfWeight = (int) dijkstraShortestPath.getPath(sourceStation, targetStation).getWeight();
        List<String> shortestPath = dijkstraShortestPath.getPath(sourceStation, targetStation).getVertexList();
        for (String stationName : shortestPath) {
            System.out.println("[INFO] " + stationName);
        }
    }

    private DijkstraShortestPath<String, DefaultWeightedEdge> getShortestPathInstance(ConditionShort conditionShort) {
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath = null;
        if (conditionShort == ConditionShort.TIME) {
            dijkstraShortestPath = new DijkstraShortestPath<>(GraphRepository.getGraphByTime());
        }
        if (conditionShort == ConditionShort.DISTANCE) {
            dijkstraShortestPath = new DijkstraShortestPath<>(GraphRepository.getGraphByDistance());
        }
        return dijkstraShortestPath;
    }
}
