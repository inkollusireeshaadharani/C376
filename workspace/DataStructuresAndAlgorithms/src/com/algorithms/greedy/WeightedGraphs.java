package com.algorithms.greedy;

import java.util.*;
import java.util.LinkedList;

public class WeightedGraphs {
	static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
	static class Graph{
		int vertices;
        LinkedList<Edge> [] adjacencylist;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices];
            for (int i = 0; i <vertices ; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
        }
        
        public void addEgde(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            adjacencylist[source].addFirst(edge);
        }
        
        public static int[] dijkstra(Graph graph, int vertices, int source) {
        	int[] dist = new int[vertices];
        	Arrays.fill(dist, Integer.MAX_VALUE);
        	dist[source] = 0;
        	Queue<Integer> queue = new LinkedList<>();
        	queue.add(source);
        	while(!queue.isEmpty()) {
        		Integer front = queue.poll();
        		List<Edge> adjList = graph.adjacencylist[front];
        		for(int i = 0; i < adjList.size(); i++) {
        			Edge temp = adjList.get(i);
        			if(dist[front] + temp.weight < dist[temp.destination]) {
        				dist[temp.destination] = dist[front] + temp.weight;
        				queue.add(temp.destination);
        			}
        			
        		}
        	}
        	return dist;
        }
        
        public void printGraph(){
            for (int i = 0; i <vertices ; i++) {
                LinkedList<Edge> list = adjacencylist[i];
                for (int j = 0; j <list.size() ; j++) {
                    System.out.println("vertex-" + i + " is connected to " +
                            list.get(j).destination + " with weight " +  list.get(j).weight);
                }
            }
        }
        
        
        
        public static void main(String[] args) {
        	 int vertices = 6;
        	 Graph graph = new Graph(vertices);
        	 
        	 graph.addEgde(0, 1, 2);
        	 graph.addEgde(1, 0, 2);
        	 graph.addEgde(0, 3, 8);
        	 graph.addEgde(3, 0, 8);
        	 graph.addEgde(1, 3, 5);
        	 graph.addEgde(3, 1, 5);
        	 graph.addEgde(1, 4, 6);
        	 graph.addEgde(4, 1, 6);
        	 graph.addEgde(3, 4, 3);
        	 graph.addEgde(4, 3, 3);
        	 graph.addEgde(3, 5, 2);
        	 graph.addEgde(5, 3, 2);
        	 graph.addEgde(4, 5, 1);
        	 graph.addEgde(5, 4, 1);
        	 graph.addEgde(5, 2, 3);
        	 graph.addEgde(2, 5, 3);
        	 graph.addEgde(4, 2, 9);
        	 graph.addEgde(2, 4, 9);
        	 
        	 int[] res = dijkstra(graph,vertices, 0) ;
             for(int i = 0; i<res.length;i++) {
            	 System.out.println("Shortest Distance from 0 to "+i+" is "+res[i]);
             }
             
             //directed graph
//        	 graph.addEgde2(0, 1, 4);
//             graph.addEgde2(0, 2, 3);
//             graph.addEgde2(1, 3, 2);
//             graph.addEgde2(1, 2, 5);
//             graph.addEgde2(2, 3, 7);
//             graph.addEgde2(3, 4, 2);
//             graph.addEgde2(4, 0, 4);
//             graph.addEgde2(4, 1, 4);
//             graph.addEgde2(4, 5, 6);
        	 
//        	 int[] res = dijkstra2(graph,vertices, 0) ;
//             for(int i = 0; i<res.length;i++) {
//            	 System.out.println("Shortest Distance from A to "+i+" is "+res[i]);
//             }
        	
		}
	}
}
