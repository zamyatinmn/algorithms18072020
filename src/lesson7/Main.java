package lesson7;

public class Main {
    public static void main(String[] args) {

        MyGraph graph = new MyGraph(10);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(0, 6);
        graph.addEdge(1, 5);
        graph.addEdge(2, 7);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        graph.addEdge(7, 8);
        graph.addEdge(7, 9);
        graph.addEdge(8, 9);


        BreadthFirstPath bfp = new BreadthFirstPath(graph, 0);
        System.out.println("Путь " + bfp.pathTo(3));
        System.out.println("Длина пути " + bfp.shortestWay(3));
    }
}
