package algorithm;

import org.junit.Test;

public class ReverseList {

	class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	
	public ListNode reverseRecursive(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode p = head.next;
		ListNode q = reverseRecursive(head.next);
		p.next = head;
		head.next = null;
		return q;
	}
	
	public ListNode reverseNonRecursive(ListNode head) {
		if(head==null || head.next == null) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = head.next, last = head, q = p.next;
		while(p!=null) {
			q = p.next;
			p.next = last;
			last = p;
			dummy.next = p;
			p = q;
		}
		head.next = null;
		return dummy.next;
	}
	
	public void printList(ListNode head) {
		ListNode p = head;
		while(p!=null) {
			System.out.print(p.val + " ");
			p = p.next;
		}
		System.out.println();
	}
	
	@Test
	public void testReverse() {
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(3);
		p1.next = p2;
		p2.next = p3;
		printList(p1);
		p1 = reverseNonRecursive(p1);
		printList(p1);
		p1 = reverseRecursive(p1);
		printList(p1);
	}
}
