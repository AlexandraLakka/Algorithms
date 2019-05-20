/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testminmax;

import java.util.LinkedList;
import static testminmax.MinMaxSearch.log2;

/**
 *
 * @author User
 */
public class TestMinMax {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Node> listOfNodes = new LinkedList<>();
        //parent nodes
        Node n4 = new Node();
        Node n5 = new Node();
        Node n6 = new Node();
        Node n7 = new Node();
        Node n8 = new Node();
        Node n9 = new Node();
        //the nodes to add to the list
        Node node1 = new Node(1, n4);
        Node node2 = new Node(2, n8);
        Node node3 = new Node(3, n8);
        Node node4 = new Node(4, n6);
        Node node5 = new Node(5, n5);
        Node node6 = new Node(6, n6);
        Node node7 = new Node(7, n6);
        Node node8 = new Node(8, n4);
        Node node9 = new Node(9, n7);
        Node node10 = new Node(10, n9);
        Node node11 = new Node(6, n9);
        Node node12 = new Node(2, n9);
        
        
       listOfNodes.add(node12);
       listOfNodes.add(node11);
       listOfNodes.add(node10);
       listOfNodes.add(node9);
       listOfNodes.add(node8);
       listOfNodes.add(node7);
       listOfNodes.add(node6);
       listOfNodes.add(node5);
       listOfNodes.add(node4);
       listOfNodes.add(node3);
       listOfNodes.add(node2);
       listOfNodes.add(node1);

       
       int n = listOfNodes.size();
       int h = log2(n);
       MinMaxSearch miniMax = new MinMaxSearch(listOfNodes);
       System.out.println("The best move is: " + miniMax.minMax(0, h));
    }
    
}
