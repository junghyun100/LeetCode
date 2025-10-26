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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        // 더미 노드 생성
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        // 두 개의 노드가 존재하는 동안 반복
        while (prev.next != null && prev.next.next != null) {
            // 바꿀 두 노드 지정
            ListNode first = prev.next;
            ListNode second = prev.next.next;
            
            // 노드 순서 바꾸기
            first.next = second.next;
            second.next = first;
            prev.next = second;
            
            // 다음 쌍을 위해 prev를 first로 이동
            prev = first;
        }
        
        return dummy.next;
    }
}