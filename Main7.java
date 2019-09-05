public class Main7 {

    public static void main(String[] args) {
        testGraph();
    }

    private static void testGraph() {
        Graph graph = new Graph(12);
        graph.addVertex("Moscow");
        graph.addVertex("Tula");
        graph.addVertex("Ryazan");
        graph.addVertex("Kaluga");
        graph.addVertex("Lipetzk");
        graph.addVertex("Tambov");
        graph.addVertex("Orel");
        graph.addVertex("Saratov");
        graph.addVertex("Kursk");
        graph.addVertex("Voronezh");
        graph.addVertex("Vladivostok");
        graph.addVertex("Beijing");

        graph.addEdges("Moscow",
                "Tula",
                "Ryazan",
                "Kaluga");

        graph.addEdge("Tula", "Lipetzk");
        graph.addEdge("Lipetzk", "Voronezh");

        graph.addEdge("Ryazan", "Tambov");
        graph.addEdge("Tambov", "Saratov");
        graph.addEdge("Saratov", "Voronezh");

        graph.addEdge("Kaluga", "Orel");
        graph.addEdge("Orel", "Kursk");
        graph.addEdge("Kursk", "Voronezh");

        graph.addEdge("Vladivostok", "Beijing");

        graph.findShortestWay("Kursk", "Saratov");
        graph.findShortestWay("Moscow", "Voronezh");
        graph.findShortestWay("Moscow", "Beijing");
        graph.findShortestWay("Moscow", "Moscow");
    }

}