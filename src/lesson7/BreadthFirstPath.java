package lesson7;

import java.util.LinkedList;

public class BreadthFirstPath extends Path {
    private int[] shortestWay;

    public BreadthFirstPath(MyGraph g, int source) {
        this.source = source;
        marked = new boolean[g.getVertexCount()];
        edgeTo = new int[g.getVertexCount()];
        shortestWay = new int[g.getVertexCount()];
        bfs(g, source);
        for (int i = 0; i < shortestWay.length; i++) {
            shortestWay[i] = pathTo(i).size();
        }
    }

    public int shortestWay(int destination){
        return shortestWay[destination];
    }

    private void bfs(MyGraph g, int source) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(source);
        marked[source] = true;

        while (!queue.isEmpty()) {
            int vertex = queue.removeFirst();
            for (int w : g.getAdjList(vertex)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = vertex;
                    queue.addLast(w);
                }
            }
        }
    }
}
