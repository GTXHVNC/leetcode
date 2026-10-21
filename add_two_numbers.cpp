#include <stack>

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        std::stack<int> first;
        std::stack<int> second;

        for (ListNode* node = l1; node != nullptr; node = node->next) {
            first.push(node->val);
        }
        for (ListNode* node = l2; node != nullptr; node = node->next) {
            second.push(node->val);
        }

        int carry = 0;
        ListNode* result = nullptr;

        while (!first.empty() || !second.empty() || carry != 0) {
            int sum = carry;
            if (!first.empty()) {
                sum += first.top();
                first.pop();
            }
            if (!second.empty()) {
                sum += second.top();
                second.pop();
            }

            ListNode* digit = new ListNode(sum % 10);
            digit->next = result;
            result = digit;
            carry = sum / 10;
        }

        return result;
    }
};
