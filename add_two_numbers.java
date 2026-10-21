import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> first = new ArrayDeque<>();
        Deque<Integer> second = new ArrayDeque<>();

        for (ListNode node = l1; node != null; node = node.next) {
            first.push(node.val);
        }

        for (ListNode node = l2; node != null; node = node.next) {
            second.push(node.val);
        }

        int carry = 0;
        ListNode result = null;

        while (!first.isEmpty() || !second.isEmpty() || carry != 0) {
            int sum = carry;

            if (!first.isEmpty()) {
                sum += first.pop();
            }

            if (!second.isEmpty()) {
                sum += second.pop();
            }

            ListNode digit = new ListNode(sum % 10);
            digit.next = result;
            result = digit;
            carry = sum / 10;
        }

        return result;
    }
}
