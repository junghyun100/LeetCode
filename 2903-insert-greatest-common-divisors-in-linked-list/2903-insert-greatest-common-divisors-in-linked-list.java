/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode current = head;
        while (current != null && current.next != null) { 
            int gcd = calculateGCD(current.val, current.next.val); 
            // 사이에 추가
            ListNode newNode = new ListNode(gcd);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode;
            
            current = current.next;
        }

        return head;
    }

    private int calculateGCD(int a, int b) { // 최대공약수
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}