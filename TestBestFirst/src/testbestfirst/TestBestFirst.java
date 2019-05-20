/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testbestfirst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author User
 */
public class TestBestFirst {

    /**
     * @param args the command line arguments
     */
    private PriorityQueue<Node> queue;
    static ArrayList<Node> nodes = new ArrayList<Node>();

    static class Node {

        private String data;
        //heuristic cost of node
        private int cost;
        boolean visited;
        List<Node> neighbours;

        Node(String data) {
            this.data = data;
            this.neighbours = new ArrayList<>();

        }

        Node(String data, int cost) {
            this.data = data;
            this.cost = cost;
            this.neighbours = new ArrayList<>();
        }

        public void addneighbours(Node neighbourNode) {
            this.neighbours.add(neighbourNode);
        }

        public List<Node> getNeighbours() {
            return neighbours;
        }

        public void setNeighbours(List<Node> neighbours) {
            this.neighbours = neighbours;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

    }
    //compare costs and return minimum
    static class NodePriority implements Comparator<Object>{
        @Override
        public int compare(Object t, Object t1) {
            Node n1 = (Node)t;
            Node n2 = (Node)t1;
            int returnCost = 0;
            
            if(n2.getCost() >  n1.getCost()){
                returnCost = n1.getCost();
            }else if(n2.getCost() <  n1.getCost()){
                returnCost = n2.getCost();
            }else if(n2.getCost() == n1.getCost()){
                returnCost = n1.getCost();
            }
            
            return returnCost;
        }
    }
    
    public TestBestFirst() {
        NodePriority strategy = new NodePriority();
        queue = new PriorityQueue<Node>(3, strategy);
    }
    
    public void bestFirst(Node node) {
        queue.add(node);
        node.visited = true;
        while (!queue.isEmpty()) {

            Node targetNode = new Node("G", 0);
            Node root = queue.element();
            if (root.equals(targetNode)) {
                System.out.println("The target node has been found.");
                break;
            }
            Node element = queue.remove();
            System.out.print(element.data);
            List<Node> neighbours = element.getNeighbours();
            NodePriority strategy = new NodePriority();
            
            for (int i = 0; i < neighbours.size(); i++) {
                Node n = neighbours.get(i);
                if (n != null && !n.visited) {
                    queue.add(n);
                    n.visited = true;
                    neighbours.sort(strategy);
                    if (n.equals(targetNode)) {
                        return;
                    }

                }

            }
        }
    }

    public static void main(String[] args) {
        Node nodeS = new Node("S", 4);
        Node nodeA = new Node("A", 2);
        Node nodeK = new Node("K", 5);
        Node nodeF = new Node("F", 4);
        Node nodeB = new Node("B", 3);
        Node nodeH = new Node("H", 3);
        Node nodeL = new Node("L", 6);
        Node nodeC = new Node("C", 4);
        Node nodeG = new Node("G", 0);
        Node nodeI = new Node("I", 2);
        Node nodeD = new Node("D", 5);
        Node nodeJ = new Node("J", 1);
        Node nodeE = new Node("E", 6);

        nodeS.addneighbours(nodeA);
        nodeS.addneighbours(nodeF);
        nodeS.addneighbours(nodeK);
        nodeA.addneighbours(nodeB);
        nodeF.addneighbours(nodeH);
        nodeK.addneighbours(nodeL);
        nodeB.addneighbours(nodeC);
        nodeB.addneighbours(nodeG);
        nodeH.addneighbours(nodeI);
        nodeI.addneighbours(nodeJ);
        nodeJ.addneighbours(nodeG);
        nodeC.addneighbours(nodeD);
        nodeD.addneighbours(nodeE);
        nodeD.addneighbours(nodeG);

        System.out.println("The traversal of the graph using best-first is: ");
        TestBestFirst bestFirst = new TestBestFirst();
        bestFirst.bestFirst(nodeS);
    }
}
