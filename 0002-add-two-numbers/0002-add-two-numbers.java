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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // 더미 헤드 노드
        ListNode current = dummyHead;
        int carry = 0; // 올림값
        while (l1 != null || l2 != null || carry != 0) {
            // 현재 자리수 값들을 구하기 (null이면 0으로 처리)
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            
            // 현재 자리수의 합계 계산
            int sum = val1 + val2 + carry;
            carry = sum / 10;    // 다음 자리로 넘길 올림값
            int digit = sum % 10; // 현재 자리에 저장할 값
            
            // 새 노드 생성하여 결과 리스트에 추가
            current.next = new ListNode(digit);
            current = current.next;
            
            // 다음 노드로 이동 (null이 아닌 경우에만)
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummyHead.next;
    }
}