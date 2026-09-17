package DijkstraAlgoritm;

import java.security.InvalidParameterException;
import java.util.*;

public class DijkstraAlgoritm {

    private int[][] vertices;

    public DijkstraAlgoritm(final int verticesNum) {
        vertices = new int[verticesNum][verticesNum];
    }

    public void createEdge(final int originNode, final int destinationNode, final int weight) {
        if (weight >= 1) {
            vertices[originNode][destinationNode] = weight;
            vertices[destinationNode][originNode] = weight;
        } else {
            throw new InvalidParameterException("O peso do no origin [" + originNode + "] para  o no destino [" + destinationNode + "] não pode ser negativo");
        }
    }

    private int getClosest(final int costList[], final Set<Integer> unvisited) {
        int minDistance = Integer.MAX_VALUE;
        int closestNode = 0;

        for (Integer i : unvisited) {
            if (costList[i] < minDistance) {
                minDistance = costList[i];
                closestNode = i;
            }
        }


        return closestNode;
    }


    private List<Integer> getNeighbor(final int node) {
        List<Integer> neighbors = new ArrayList<Integer>();
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[node][i] > 0) {
                neighbors.add(i);
            }
        }
        return neighbors;
    }


    private int getCost(final int originNode, final int destinationNode) {
        return vertices[originNode][destinationNode];
    }

    public List<Integer> minWay(final int originNode, final int destinationNode) {
        int cost[] = new int[vertices.length];
        int predecessor[] = new int[vertices.length];
        Set<Integer> closest = new HashSet<Integer>();

        cost[originNode] = 0;


        for (int v = 0; v < vertices.length; v++) {
            if (v != originNode) {
                cost[v] = Integer.MAX_VALUE;
            }

            predecessor[v] = -1;
            closest.add(v);
        }

        while (!closest.isEmpty()) {
            int closestNode = getClosest(cost, closest);

            closest.remove(closestNode);

            for (Integer neightbor : getNeighbor(closestNode)) {
                int totalCost = cost[closestNode] + getCost(closestNode, neightbor);

                if (totalCost < cost[neightbor]) {
                    cost[neightbor] = totalCost;
                    predecessor[neightbor] = closestNode;
                }

            }
            if (closestNode == destinationNode) {
                return cloesestWay(predecessor, closestNode);
            }
        }
        return null;
    }

    public List<Integer> cloesestWay(final int predecessor[], int closestNode) {
        List<Integer> wayIntegers = new ArrayList<Integer>();

        while (predecessor[closestNode] != -1) {
            wayIntegers.add(predecessor[closestNode]);
            closestNode = predecessor[closestNode];
        }
        Collections.reverse(wayIntegers);
        return wayIntegers;
    }

}
