import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    //给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
    //
    //你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。

    //给定 nums = [2, 7, 11, 15], target = 9
    //
    //因为 nums[0] + nums[1] = 2 + 7 = 9
    //所以返回 [0, 1]
    public int[] twoSum(int[] nums,int target){
        if(nums == null){
            return null;
        }

        Map<Integer,Integer> sumMap = new HashMap<>();

        for (int i=0;i<nums.length;i++){
            int complement = target - nums[i];
            if(sumMap.containsKey(complement)){
                return new int[]{sumMap.get(complement),i};
            }
            sumMap.put(nums[i],i);
        }

        throw new IllegalArgumentException("No two sum Solution");
    }

    public int[] twoSum2(int[] nums,int target){
        if(nums == null){
            return null;
        }

        Map<Integer,Integer> numMap = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            numMap.put(nums[i],i);
        }

        for (int i=0;i<nums.length;i++){
            int complement = target - nums[i];
            if(numMap.containsKey(complement) && numMap.get(complement)!=i){
                return new int[]{i,numMap.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum Solution");
    }

    //给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。
    // 将两数相加返回一个新的链表。
    //
    //你可以假设除了数字 0 之外，这两个数字都不会以零开头。

    //输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    //输出：7 -> 0 -> 8
    //原因：342 + 465 = 807
    public ListNode addTwoNumber(ListNode l1,ListNode l2){
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode result = new ListNode(0);
        ListNode current = result,p = l1,q = l2;
        int carry = 0;

        while(p!=null||q!=null){
            int x = (p!=null)?p.val:0;
            int y = (q!=null)?q.val:0;

            int sum = x + y + carry;

            if(sum > 9){
                current.next = new ListNode(sum%10);
                carry = 1;
            }else {
                current.next = new ListNode(sum);
                carry = 0;
            }

            current = current.next;
            if(p!=null) p = p.next;
            if(q!=null) q = q.next;
        }

        if (carry == 1){
            current.next = new ListNode(1);
        }

        return result.next;
    }

    //给定一个字符串，找出不含有重复字符的最长子串的长度。
    //
    //示例 1:
    //
    //输入: "abcabcbb"
    //输出: 3
    //解释: 无重复字符的最长子串是 "abc"，其长度为 3。
    //
    //示例 2:
    //
    //输入: "bbbbb"
    //输出: 1
    //解释: 无重复字符的最长子串是 "b"，其长度为 1。
    //
    //示例 3:
    //
    //输入: "pwwkew"
    //输出: 3
    //解释: 无重复字符的最长子串是 "wke"，其长度为 3。
    //     请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。

    //滑动窗口
    //时间复杂度O(2n)=O(n)
    //空间复杂度O(min(m,n))
    public int lengrhOfLongestSubstring1(String s){
        if (s == null) return 0;

        Set<Character> strSet = new HashSet<>();
        int i=0,j=0,ans=0;
        int n=s.length();

        while (i<n&&j<n){
            if(!strSet.contains(s.charAt(j))){
                strSet.add(s.charAt(j++));
                ans = Math.max(ans,j-i);
            }else {
                strSet.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    //优化滑动窗口
    //时间复杂度O(n)
    //空间复杂度O(min(m,n))
    public int lengthOfLongestSubstring(String s) {
        if(s == null) return 0;

        Map<Character,Integer> strMap = new HashMap<>();
        int n = s.length(),ans = 0;

        for(int i=0,j=0;j<n;j++){
            if(strMap.containsKey(s.charAt(j))){
                //如果字符重复，移动滑动窗口的end
                i = Math.max(strMap.get(s.charAt(j)),i);
            }
            ans = Math.max(ans,j-i+1);
            //map保存字符与重复字符的下一个下标
            strMap.put(s.charAt(j),j+1);
        }
        return ans;
    }

    //给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
    //
    //请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
    //
    //你可以假设 nums1 和 nums2 不同时为空。
    //
    //示例 1:
    //
    //nums1 = [1, 3]
    //nums2 = [2]
    //
    //中位数是 2.0
    //
    //示例 2:
    //
    //nums1 = [1, 2]
    //nums2 = [3, 4]
    //
    //中位数是 (2 + 3)/2 = 2.5

//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//
//    }

    //给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
    //
    //示例 1：
    //
    //输入: "babad"
    //输出: "bab"
    //注意: "aba"也是一个有效答案。
    //
    //示例 2：
    //
    //输入: "cbbd"
    //输出: "bb"

    //动态规划
    public String longestPalindrome(String s) {
        if(s.length() == 0||s==null) return s;

        int maxLen = 0;
        int start = 0;
        boolean[][] isPal = new boolean[s.length()][s.length()];

        for (int i=0;i<s.length();i++){
            int j = i;
            while (j>=0){
                if(s.charAt(i)==s.charAt(j)&&(i-j<2||isPal[j+1][i-1])){
                    isPal[j][i] = true;
                    if (maxLen <= i-j+1){
                        maxLen = i-j+1;
                        start = j;
                    }
                }
                j--;
            }
        }
        return s.substring(start,start+maxLen);
    }

    //将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
    //
    //P   A   H   N
    //A P L S I I G
    //Y   I   R
    //
    //之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"
    //
    //实现一个将字符串进行指定行数变换的函数:
    //
    //string convert(string s, int numRows);
    //
    //示例 1:
    //
    //输入: s = "PAYPALISHIRING", numRows = 3
    //输出: "PAHNAPLSIIGYIR"
    //
    //示例 2:
    //
    //输入: s = "PAYPALISHIRING", numRows = 4
    //输出: "PINALSIGYAHRPI"
    //解释:
    //
    //P0      I6       N12
    //A1   L5 S7    I11   G13
    //Y2 A4   H8 R10
    //P3      I9

    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        if(s == null || s.length() == 1) return s;

        StringBuilder sCov = new StringBuilder();
        int n = s.length();
        int len = numRows*2 -2;

        for (int i=0;i<numRows;i++){
            for (int j=0;j+i<n;j+=len){
                sCov.append(s.charAt(i+j));
                if(i!=0&&i!=numRows-1&&j+len-i<n){
                    sCov.append(s.charAt(j+len-i));
                }
            }
        }

        return sCov.toString();
    }

    //给定一个 32 位有符号整数，将整数中的数字进行反转。
    //
    //示例 1:
    //
    //输入: 123
    //输出: 321
    //
    // 示例 2:
    //
    //输入: -123
    //输出: -321
    //
    //示例 3:
    //
    //输入: 120
    //输出: 21
    //
    //注意:
    //
    //假设我们的环境只能存储 32 位有符号整数，
    // 其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。

    public int reverse(int x) {
        int rev = 0;

        while(x != 0){
            int pop = x%10;
            x = x/10;

            if(rev>Integer.MAX_VALUE/10||(rev==Integer.MAX_VALUE/10&&pop>7)) return 0;
            if(rev<Integer.MIN_VALUE/10||(rev==Integer.MIN_VALUE/10&&pop<-8)) return 0;

            rev = rev*10 + pop;
        }
        return rev;
    }

    //实现 atoi，将字符串转为整数。
    //
    //该函数首先根据需要丢弃任意多的空格字符，直到找到第一个非空格字符为止。
    //如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，
    //这部分字符即为整数的值。如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，
    //形成整数。
    //
    //字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
    //
    //当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；
    //或字符串仅包含空白字符时，则不进行转换。
    //
    //若函数不能执行有效的转换，返回 0。
    //
    //说明：
    //
    //假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。
    //如果数值超过可表示的范围，则返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
    //
    //示例 1:
    //
    //输入: "42"
    //输出: 42
    //
    //示例 2:
    //
    //输入: "   -42"
    //输出: -42
    //解释: 第一个非空白字符为 '-', 它是一个负号。
    //     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
    //
    //示例 3:
    //
    //输入: "4193 with words"
    //输出: 4193
    //解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
    //
    //示例 4:
    //
    //输入: "words and 987"
    //输出: 0
    //解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
    //     因此无法执行有效的转换。
    //
    //示例 5:
    //
    //输入: "-91283472332"
    //输出: -2147483648
    //解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
    //     因此返回 INT_MIN (−231) 。


    public int myAtoi(String str) {
        str = str.trim();

        if(str==null||str.length()==0) return 0;

        int sign = 1;
        int numberLen = 0;
        int base=0;

        if(str.charAt(0) == '-') {
            sign = -1;
            numberLen++;
        }
        else if(str.charAt(0) == '+'){
            sign = 1;
            numberLen++;
        }else if(str.charAt(0)>='0'&&str.charAt(0)<='9'){
            sign = 1;
        }
        else{
            return 0;
        }

        while(numberLen<str.length()&&str.charAt(numberLen)>='0'&&str.charAt(numberLen)<='9'){
            System.out.println(str.charAt(numberLen));
            if(base>Integer.MAX_VALUE/10||
                    (base==Integer.MAX_VALUE/10&&str.charAt(numberLen)-'0'>7)){
                if(sign == 1){
                    return Integer.MAX_VALUE;
                }else if(sign == -1){
                    return Integer.MIN_VALUE;
                }
            }

            base = base * 10 + (str.charAt(numberLen++)-'0');
        }
        return base*sign;
    }

    //判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
    //
    //示例 1:
    //
    //输入: 121
    //输出: true
    //
    //示例 2:
    //
    //输入: -121
    //输出: false
    //解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
    //
    //示例 3:
    //
    //输入: 10
    //输出: false
    //解释: 从右向左读, 为 01 。因此它不是一个回文数。
    //
    //进阶:
    //
    //你能不将整数转为字符串来解决这个问题吗？

    public boolean isPalindrome(int x) {
        if(x<0) return false;

        int temp1 = x,temp2 = x;
        int length = 0;
        while(temp1 != 0){
            temp1 = temp1/10;
            length++;
        }

        int[] xArr = new int[length];
        for (int i=0;i<length;i++){
            xArr[i] = temp2%10;
            temp2 = temp2/10;
        }

        int start = 0,end = length-1;
        while(start<=end){
            if (xArr[start] != xArr[end]){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

}
