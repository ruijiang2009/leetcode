package com.programapprentice.app;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 8/2/14
 * Time: 3:37 PM
 */

import java.util.*;

/**

 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 *
 * Nodes are labeled uniquely.
 *
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 *
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 *
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * Visually, the graph looks like the following:
 *
 *    1
 *   / \
 *  /   \
 * 0 --- 2
 *      / \
 *      \_/
 */

public class CloneGraph {

    static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return null;
        }
        UndirectedGraphNode newNode = null;
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, Boolean> nodeMap = new HashMap<UndirectedGraphNode, Boolean>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> oldToNewMap= new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        queue.add(node);
        nodeMap.put(node, true);

        while(!queue.isEmpty()) {
            UndirectedGraphNode curNode = queue.remove();
            for(UndirectedGraphNode childNode : curNode.neighbors) {
                if(childNode != curNode && nodeMap.get(childNode) == null) {
                    queue.add(childNode);
                    nodeMap.put(childNode, true);
                }
            }

            UndirectedGraphNode cloneNode = null;
            if(newNode == null) {
                cloneNode = new UndirectedGraphNode(curNode.label);
                newNode = cloneNode;
                oldToNewMap.put(curNode, cloneNode);
            } else {
                cloneNode = oldToNewMap.get(curNode);
            }

            for(UndirectedGraphNode neighbor : curNode.neighbors) {
                if(oldToNewMap.get(neighbor) == null) {
                    UndirectedGraphNode nNode = new UndirectedGraphNode((neighbor.label));
                    cloneNode.neighbors.add(nNode);
                    oldToNewMap.put(neighbor, nNode);
                } else {
                    cloneNode.neighbors.add(oldToNewMap.get(neighbor));
                }
            }
        }
        return newNode;
    }

}
