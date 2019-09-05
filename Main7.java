public class Main7 {

    public static void main(String[] args) {
        testGraph();
    }

    private static void testGraph() {
        Graph graph = new Graph(12);
        graph.addVertex("������");
        graph.addVertex("����");
        graph.addVertex("������");
        graph.addVertex("������");
        graph.addVertex("������");
        graph.addVertex("������");
        graph.addVertex("����");
        graph.addVertex("�������");
        graph.addVertex("�����");
        graph.addVertex("�������");
        graph.addVertex("�����������");
        graph.addVertex("�����");

        graph.addEdges("������",
                "����",
                "������",
                "������");

        graph.addEdge("����", "������");
        graph.addEdge("������", "�������");

        graph.addEdge("������", "������");
        graph.addEdge("������", "�������");
        graph.addEdge("�������", "�������");

        graph.addEdge("������", "����");
        graph.addEdge("����", "�����");
        graph.addEdge("�����", "�������");

        graph.addEdge("�����������", "�����");

        graph.findShortestWay("�����", "�������");
        graph.findShortestWay("������", "�������");
        graph.findShortestWay("������", "�����");
        graph.findShortestWay("������", "������");
    }

}