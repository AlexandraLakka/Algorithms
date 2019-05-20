/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testminmax;

import java.util.LinkedList;

/**
 *
 * @author User
 */
public class MinMaxSearch {

    private LinkedList<Node> nodes;

    public MinMaxSearch(LinkedList<Node> nodes) {
        this.nodes = nodes;
    }

    public int minMax(int depth, int h) {
        int value;
        Node parent;
        Node currentNode;
        boolean isMax;
        //store values of nodes to compare
        int[] nodeValues = new int[nodes.size()];
        //store parents of nodes in order to see if we can compare them
        //if they have the same parent then we can compare their values
        Node[] parents = new Node[nodes.size()];
        for (depth = 0; depth <= h; depth++) {
            if ((log2(nodes.size()) % 2) == 0) {
                isMax = false;
                for (int i = 0; i < nodes.size(); i++) {
                    currentNode = nodes.get(i);
                    value = currentNode.getValue();
                    parent = currentNode.getParent();
                    for (int j = 0; j < nodeValues.length; j++) {
                        for (int k = 0; k < parents.length; k++) {
                            nodeValues[j] = value;
                            parents[k] = parent;
                        }

                    }
                }
                nodeValues = chooseMin(isMax, nodeValues, parents);
                for (int x = 0; x < nodeValues.length / 2; x++) {
                    Node n1 = new Node();
                    nodes.add(x, nodes.get(x));
                    //set parents for the new nodes to be compared
                    nodes.get(x).setParent(n1);
                }
                for (int y = nodeValues.length / 2; y < nodeValues.length; y++) {
                    Node n1 = new Node();
                    nodes.add(y, nodes.get(y));
                    nodes.get(y).setParent(n1);
                }
            } else if ((log2(nodes.size()) % 2) == 1) {
                isMax = true;
                for (int i = 0; i < nodes.size(); i++) {
                    currentNode = nodes.get(i);
                    value = currentNode.getValue();
                    parent = currentNode.getParent();
                    for (int j = 0; j < nodeValues.length; j++) {
                        for (int k = 0; k < parents.length; k++) {
                            nodeValues[j] = value;
                            parents[k] = parent;
                        }

                    }

                }
                nodeValues = chooseMax(isMax, nodeValues, parents);
                for (int x = 0; x < nodeValues.length / 2; x++) {
                    Node n2 = new Node();
                    nodes.add(x, nodes.get(x));
                    nodes.get(x).setParent(n2);
                }
                for (int y = nodeValues.length / 2; y < nodeValues.length; y++) {
                    Node n3 = new Node();
                    nodes.add(y, nodes.get(y));
                    nodes.get(y).setParent(n3);
                }
            }

        }
        //return the first item of the list, which will be the root
        value = nodes.get(0).getValue();
        return value;
    }

    public int[] chooseMax(boolean isMax, int[] nodeValues, Node[] parents) {

        int[] newValues = new int[(nodeValues.length / 2)];

        if (isMax = true) {
            for (int i = 0; i < nodeValues.length; i++) {
                for (int j = 0; j < parents.length; j++) {
                    try {
                        //check if parents are the same to compare the values
                        if (parents[j].equals(parents[j + 1])) {
                            newValues[i] = Math.max(nodeValues[i], nodeValues[i + 1]);
                        }

                    } catch (ArrayIndexOutOfBoundsException ex) {
                        break;
                    }

                }
            }

        }

        return newValues;
    }

    public int[] chooseMin(boolean isMax, int[] nodeValues, Node[] parents) {

        int[] newValues = new int[nodeValues.length / 2];

        if (isMax = false) {
            for (int i = 0; i < nodeValues.length; i++) {
                for (int j = 0; j < parents.length; j++) {
                    try {
                        if (parents[j].equals(parents[j + 1])) {
                            newValues[i] = Math.min(nodeValues[i], nodeValues[i + 1]);
                        }
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        break;
                    }

                }
            }
        }

        return newValues;
    }

    //find height of tree
    public static int log2(int n) {
        return (n == 1) ? 0 : 1 + log2(n / 2);
    }
}
