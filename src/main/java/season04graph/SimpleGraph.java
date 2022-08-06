package season04graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 图的简单实现
 * https://www.bilibili.com/video/BV1B4411H76f?p=147&vd_source=b207e2778fe1a670e64a357fed1213a0
 */
public class SimpleGraph {

    private final ArrayList<String> vertexList; //存储顶点集合

    private final int[][] edges; //存储图对应的领结矩阵

    private final AtomicInteger numOfEdges = new AtomicInteger(0); //表示边的数目

    public SimpleGraph(int n){
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
    }

    //返回结点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }

    //得到边的数目
    public int getNumOfEdges(){
        return numOfEdges.get();
    }

    //返回结点i对应的数据
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    //返回v1和v2的权重
    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }

    //插入结点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    //添加边
    public void insertEdge(int v1, int v2, int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges.incrementAndGet();
    }

    //显示图对应的矩阵
    public void showGraph(){
        for(int[] link : edges){
            System.out.println(Arrays.toString(link));
        }

    }
}
