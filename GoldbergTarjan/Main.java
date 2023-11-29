public class Main {

    public static void main(String[] args) {
        // test 1
        // int nVertices = 6;
        // Graph g = new Graph(nVertices);
        // g.addEdge(0, 1, 5);
        // g.addEdge(0, 2, 8);
        // g.addEdge(1, 2, 3);
        // g.addEdge(1, 3, 2);
        // g.addEdge(2, 4, 6);
        // g.addEdge(3, 4, 1);
        // g.addEdge(3, 5, 7);
        // g.addEdge(4, 5, 4);

        //test 2
        // int nVertices = 7;
        // Graph g = new Graph(nVertices);
        // g.addEdge(0, 1, 8);
        // g.addEdge(0, 2, 5);
        // g.addEdge(1, 3, 4);
        // g.addEdge(1, 4, 2);
        // g.addEdge(2, 4, 3);
        // g.addEdge(3, 5, 7);
        // g.addEdge(4, 5, 6);
        // g.addEdge(5, 6, 8);

        // test 3
        // int nVertices = 5;
        // Graph g = new Graph(nVertices);
        // g.addEdge(0, 1, 10);
        // g.addEdge(0, 2, 5);
        // g.addEdge(1, 2, 15);
        // g.addEdge(1, 3, 5);
        // g.addEdge(2, 4, 10);
        // g.addEdge(3, 4, 10);

        // test 4
        int nVertices = 3;
        Graph g = new Graph(nVertices);
        g.addEdge(0, 1, 8);
        g.addEdge(0, 2, 6);
        g.addEdge(1, 2, 7);

        int s = 0;

        System.out.println("Fluxo máximo para esse grafo é " + g.goldbergTarjanAlgorithm(s));

    }
}
