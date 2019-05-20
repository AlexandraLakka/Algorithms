/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testbreadthfirst;

/**
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TestBreadthFirst {

    /**
     * @param args the command line arguments
     */
    private Queue<Node> queue;
    static ArrayList<Node> nodes = new ArrayList<Node>();

    static class Node {

        private String data;
        boolean visited;
        List<Node> neighbours;

        Node(String data) {
            this.data = data;
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
    }

    public TestBreadthFirst() {
        queue = new LinkedList<Node>();
    }

    public void bfs(Node node) {
        queue.add(node);
        node.visited = true;
        while (!queue.isEmpty()) {
            Node targetNode = new Node("G");
            if (node.equals(targetNode)) {
                System.out.println("The target node has been found.");
                break;
            }
            Node element = queue.remove();
            System.out.print(element.data);
            List<Node> neighbours = element.getNeighbours();

            for (int i = 0; i < neighbours.size(); i++) {
                Node n = neighbours.get(i);
                if (n != null && !n.visited) {
                    queue.add(n);
                    n.visited = true;
                    if (n.equals(targetNode)) {
                        return;
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        Node nodeS = new Node("S");
        Node nodeA = new Node("A");
        Node nodeK = new Node("K");
        Node nodeF = new Node("F");
        Node nodeB = new Node("B");
        Node nodeH = new Node("H");
        Node nodeL = new Node("L");
        Node nodeC = new Node("C");
        Node nodeG = new Node("G");
        Node nodeI = new Node("I");
        Node nodeD = new Node("D");
        Node nodeJ = new Node("J");
        Node nodeE = new Node("E");

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
        System.out.println("The BFS traversal of the graph is: ");
        TestBreadthFirst bfsExample = new TestBreadthFirst();
        bfsExample.bfs(nodeS);

    }
}
