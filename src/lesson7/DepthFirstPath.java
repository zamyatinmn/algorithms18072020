package lesson7;

import java.util.LinkedList;

public class DepthFirstPath extends Path {

    public DepthFirstPath(MyGraph g, int source) {
        this.source = source;
        marked = new boolean[g.getVertexCount()];
        edgeTo = new int[g.getVertexCount()];

        dfs(g, source);
    }

    private void dfs(MyGraph g, int v) {
        marked[v] = true;
        for (int w : g.getAdjList(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }
}
