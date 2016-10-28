/**
 * Copyright(C) 2016 Luvina Software Company
 *
 * TeadsSponsoredContest2.java, Oct 19, 2016,  trung.tran
 */
package tests;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author trung.tran
 *
 */
public class TeadsSponsoredContest2 {
	public static class Node {
		private int id;
		private Set<Node> childrens;

		public Node(int value) {
			this.id = value;
			childrens = new HashSet<>();
		}

		public int getId() {
			return id;
		}

		public void addChildren(Node children) {
			childrens.add(children);
		}

		public void removeChildren(Node children) {
			childrens.remove(children);
		}

		public void removeThisFromChildren() {
			childrens.forEach(children -> children.removeChildren(this));
		}

		public boolean isLeaf() {
			return childrens.size() == 1;
		}
	}

	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); // the number of adjacency relations

		Map<Integer, Node> graph = new HashMap<>();
		for (int i = 0; i < n; i++) {
			Integer xi = Integer.valueOf(in.nextInt()); // the ID of a person
														// which is adjacent to
														// yi
			Integer yi = Integer.valueOf(in.nextInt()); // the ID of a person
														// which is adjacent to
														// xi
			Node xiNode = graph.computeIfAbsent(xi, key -> new Node(key));
			Node yiNode = graph.computeIfAbsent(yi, key -> new Node(key));
			xiNode.addChildren(yiNode);
			yiNode.addChildren(xiNode);
		}
		System.out.println(calculateMin(graph));
	}

	static int calculateMin(Map<Integer, Node> graph) {
		int min = 0;
		while (graph.size() > 1) {
			removeLeaf(graph);
			min++;
		}
		return min;
	}

	static void removeLeaf(Map<Integer, Node> graph) {
		Set<Node> leafs = graph.values().stream().filter(Node::isLeaf).collect(Collectors.toSet());
		leafs.forEach(leaf -> {
			graph.remove(leaf.id);
			leaf.removeThisFromChildren();
		});
	}
}
