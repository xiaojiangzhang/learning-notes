//Given a non-negative integer num represented as a string, remove k digits from
// the number so that the new number is the smallest possible.
// 
//
// Note: 
// 
// The length of num is less than 10002 and will be ≥ k. 
// The given num does not contain any leading zero. 
// 
//
// 
//
// Example 1:
// 
//Input: num = "1432219", k = 3
//Output: "1219"
//Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 w
//hich is the smallest.
// 
// 
//
// Example 2:
// 
//Input: num = "10200", k = 1
//Output: "200"
//Explanation: Remove the leading 1 and the number is 200. Note that the output 
//must not contain leading zeroes.
// 
// 
//
// Example 3:
// 
//Input: num = "10", k = 2
//Output: "0"
//Explanation: Remove all the digits from the number and it is left with nothing
// which is 0.
// 
// Related Topics 栈 贪心算法 
// 👍 471 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        int remain = num.length() - k;
        for (int i = 0; i < num.length(); i++) {
            while ((stack.peek() > (int) num.charAt(i)) && k > 0 && stack.empty()) {
                stack.pop();
                k -= 1;

            }
            stack.push((int)num.charAt(i));
        }
        int ans = 0;
        for (int i = 0; i <= remain; i++){
            ans = ans * 10 +stack.pop();
        }
        return String.valueOf(ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
