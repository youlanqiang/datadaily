package season04graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleGraphTest {

    @Test
    public void test1(){
        SimpleGraph graph = new SimpleGraph(5);
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");

        graph.showGraph();
    }


}