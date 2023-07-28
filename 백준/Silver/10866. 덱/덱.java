import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque deque = new Deque();
		for (int i=0;i<N;i++) {
			String[] command = br.readLine().split(" ");
			if (command[0].equals("push_front")) {
				deque.addFirst(Integer.parseInt(command[1]));
			} else if (command[0].equals("push_back")) {
				deque.addLast(Integer.parseInt(command[1]));
			} else if (command[0].equals("pop_front")) {
				if (deque.size==0) System.out.println(-1);
				else System.out.println(deque.removeFirst());
			} else if (command[0].equals("pop_back")) {
				if (deque.size==0) System.out.println(-1);
				else System.out.println(deque.removeLast());
			} else if (command[0].equals("size")) {
				System.out.println(deque.size);
			} else if (command[0].equals("empty")) {
				if (deque.size==0) System.out.println(1);
				else System.out.println(0);
			} else if (command[0].equals("front")) {
				if (deque.size!=0) System.out.println(deque.head.data);
				else System.out.println(-1);
			} else if (command[0].equals("back")) {
				if (deque.size!=0) System.out.println(deque.tail.data);
				else System.out.println(-1);
			}
		}
	}

}

class Deque {
	
	Node head;
	Node tail;
	int size;
	
	class Node {
		
		int data;
		Node prev;
		Node next;
		
		Node(Node prev, Node next, int data) { 
			this.prev = prev;
			this.next = next;
			this.data = data; 
		}
	}
	
	public void addFirst(int i) {
		Node node = new Node(null, head, i);
		if (size==0) {
			tail=node;
		} else {
			head.prev=node;
		}
		head = node;
		size++;
	}
	
	public void addLast(int i) {
		Node node = new Node(tail, null, i);
		if (size==0) {
			head = node;
		} else {
			tail.next=node;
		}
		tail=node;
		size++;
	}
	
	public int removeFirst() {
		int result = head.data;
		if (size==1) {
			head=null;
			tail=null;
		} else {
			head = head.next;
			head.prev = null;
		}
		size--;
		return result;
	}
	
	public int removeLast() {
		int result = tail.data;
		if (size==1) {
			head=null;
			tail=null;
		} else {
			tail = tail.prev;
			tail.next=null;
		}
		size--;
		return result;
	}
	
	public int getFirst() {
		return head.data;
	}
	
	public int getLast() {
		return tail.data;
	}
	
	public void printInfo() {
		Node temp = head;
		System.out.println(head.data);
		System.out.println(tail.data);
		while (temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}
}