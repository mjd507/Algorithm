package LeetCode.JavaCodes;
/**
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */

/**
 * Definition for singly-linked list.
 */
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { 
		val = x;
	}
}

public class _002_AddTwoNums {

	public static void main(String[] args) {
		ListNode listNode = new ListNode(2);listNode.next = new ListNode(4);
		ListNode listNode2 = new ListNode(5);listNode2.next = new ListNode(6);
		ListNode node = getSum(listNode, listNode2);
		while(node != null){
			System.out.println(node.val);
			node = node.next;
		}
	}

	private static ListNode getSum(ListNode l1, ListNode l2){
		if(l1 == null && l2 == null) {
			return null;
		}
		ListNode head = new ListNode(0);
		ListNode point = head;
		int carry = 0;
		while(l1 != null && l2!=null){
			int sum = carry + l1.val + l2.val;
			point.next = new ListNode(sum % 10);
			carry = sum / 10;
			l1 = l1.next;
			l2 = l2.next;
			point = point.next;
		}

		while(l1 != null) {
			int sum =  carry + l1.val;
			point.next = new ListNode(sum % 10);
			carry = sum /10;
			l1 = l1.next;
			point = point.next;
		}

		while(l2 != null) {
			int sum =  carry + l2.val;
			point.next = new ListNode(sum % 10);
			carry = sum /10;
			l2 = l2.next;
			point = point.next;
		}

		if (carry != 0) {
			point.next = new ListNode(carry);
		}
		return head.next;
	}

}

