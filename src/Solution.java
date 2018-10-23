import java.util.*;

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

    //给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
    //
    //'.' 匹配任意单个字符。
    //'*' 匹配零个或多个前面的元素。
    //
    //匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
    //
    //说明:
    //
    //    s 可能为空，且只包含从 a-z 的小写字母。
    //    p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
    //
    //示例 1:
    //
    //输入:
    //s = "aa"
    //p = "a"
    //输出: false
    //解释: "a" 无法匹配 "aa" 整个字符串。
    //
    //示例 2:
    //
    //输入:
    //s = "aa"
    //p = "a*"
    //输出: true
    //解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
    //
    //示例 3:
    //
    //输入:
    //s = "ab"
    //p = ".*"
    //输出: true
    //解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
    //
    //示例 4:
    //
    //输入:
    //s = "aab"
    //p = "c*a*b"
    //输出: true
    //解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
    //
    //示例 5:
    //
    //输入:
    //s = "mississippi"
    //p = "mis*is*p*."
    //输出: false

    //1/递归条件匹配表
    //2/合并条件
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) {
            return s.isEmpty();
        }

        if(p.length() == 1 || p.charAt(1) != '*'){
            if(s.isEmpty() || (p.charAt(0) != s.charAt(0) &&
            p.charAt(0) != '.')){
                return false;
            }else {
                return isMatch(s.substring(1),p.substring(1));
            }
        }

        while (!s.isEmpty() && (p.charAt(0) == s.charAt(0)||
        p.charAt(0) == '.')){
            if(isMatch(s,p.substring(2))) {
                return true;
            }
            s = s.substring(1);
        }

        return isMatch(s,p.substring(2));
    }

    //还有dp解法

    //给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
    // 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
    // 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
    //
    //说明：你不能倾斜容器，且 n 的值至少为 2。
    //
    //图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水
    // （表示为蓝色部分）的最大值为 49。
    //
    //
    //
    //示例:
    //
    //输入: [1,8,6,2,5,4,8,3,7]
    //输出: 49

    //假设 am与an间的乘积最大，则m的左边不存在比am大的值，n右边不存在比an大的值
    public int maxArea(int[] height) {
        if(height.length == 2){
            return height[0]>height[1]?height[1]:height[0];
        }

        int start = 0,end = height.length-1;
        int maxValue = 0;

        while (start<end){
            maxValue = Math.max((end-start)*
                    Math.min(height[start],height[end]),maxValue);

            if(height[start]>height[end]){
                end--;
            }else {
                start++;
            }
        }

        return maxValue;
    }

    //罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
    //
    //字符          数值
    //I             1
    //V             5
    //X             10
    //L             50
    //C             100
    //D             500
    //M             1000
    //
    //例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。
    // 27 写做  XXVII, 即为 XX + V + II 。
    //
    //通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，
    // 例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
    // 所表示的数等于大数 5 减小数 1 得到的数值 4 。
    // 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
    //
    //    I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
    //    X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
    //    C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
    //
    //给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
    //
    //示例 1:
    //
    //输入: 3
    //输出: "III"
    //
    //示例 2:
    //
    //输入: 4
    //输出: "IV"
    //
    //示例 3:
    //
    //输入: 9
    //输出: "IX"
    //
    //示例 4:
    //
    //输入: 58
    //输出: "LVIII"
    //解释: C = 100, L = 50, XXX = 30, III = 3.
    //
    //示例 5:
    //
    //输入: 1994
    //输出: "MCMXCIV"
    //解释: M = 1000, CM = 900, XC = 90, IV = 4.

    public String intToRoman(int num) {
        String str = new String();

        String[] romanNum = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] value = {1000,900,500,400,100,90,50,40,10,9,5,4,1};

        for(int i=0;num>0;i++){
            while (num>=value[i]){
                num = num - value[i];
                str = str + romanNum[i];
            }
        }
        return str;
    }

    //罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
    //
    //字符          数值
    //I             1
    //V             5
    //X             10
    //L             50
    //C             100
    //D             500
    //M             1000
    //
    //例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
    //
    //通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
    // 所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
    //
    //    I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
    //    X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
    //    C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
    //
    //给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
    //
    //示例 1:
    //
    //输入: "III"
    //输出: 3
    //
    //示例 2:
    //
    //输入: "IV"
    //输出: 4
    //
    //示例 3:
    //
    //输入: "IX"
    //输出: 9
    //
    //示例 4:
    //
    //输入: "LVIII"
    //输出: 58
    //解释: L = 50, V= 5, III = 3.
    //
    //示例 5:
    //
    //输入: "MCMXCIV"
    //输出: 1994
    //解释: M = 1000, CM = 900, XC = 90, IV = 4.
    public int romanToInt(String s){
        int value = 0;

        int[] num  = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        for(int i=0;s.length()!=0;i++){
            while(s.substring(0,1).equals(roman[i])){
                value = value + num[i];
                s = s.substring(1,s.length());
                if(s.length()<1){
                    break;
                }
            }
            if(s.length()<=2){
                continue;
            }

            while(s.substring(0,2).equals(roman[i])){
                value = value + num[i];
                s = s.substring(2,s.length());
                if(s.length()<2){
                    break;
                }
            }
        }
        return value;
    }

    //编写一个函数来查找字符串数组中的最长公共前缀。
    //
    //如果不存在公共前缀，返回空字符串 ""。
    //
    //示例 1:
    //
    //输入: ["flower","flow","flight"]
    //输出: "fl"
    //
    //示例 2:
    //
    //输入: ["dog","racecar","car"]
    //输出: ""
    //解释: 输入不存在公共前缀。
    //
    //说明:
    //
    //所有输入只包含小写字母 a-z 。

    //从第一个字符串开始，依次判断是否为前缀，不是的话，减一
    //流弊！！！
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";

        String prefix = strs[1];

        for(int i=1;i<strs.length;i++){
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    //从第一个字符开始，纵向遍历
    public String longestCommonPrefix1(String[] strs){
        if(strs.length == 0 || strs == null) return "";

        for (int i=0;i<strs[0].length();i++){
            char c = strs[0].charAt(i);
            for (int j=0;j<strs.length;j++){
                if(i==strs[j].length()||strs[j].charAt(i)!=c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

    //分治法
    public String longestCommonPrefix2(String[] strs){
        if(strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs,0,strs.length-1);
    }

    public String longestCommonPrefix(String[] strs,int start,int end){
        if(start == end){
            return strs[start];
        }else {
            int middle = (end + start)/2;
            String leftStr = longestCommonPrefix(strs,start,middle);
            String rightStr = longestCommonPrefix(strs,middle+1,end);
            return common(leftStr,rightStr);
        }
    }

    public String common(String left,String right){
        int min = Math.min(left.length(),right.length());
        for (int i=0;i<min;i++){
            if(left.charAt(i) != right.charAt(i)){
                return left.substring(0,i);
            }
        }
        return left.substring(0,min);
    }

    //使用二分法，查找最短字符串的每一个字符
    public String longestCommonPrefix3(String[] strs){
        if(strs == null || strs.length == 0) return  "";

        int min = Integer.MAX_VALUE;
        for (String str : strs){
            min = Math.min(min,str.length());
        }

        int start = 0;
        int end = min-1;
        while (start<=end){
            int middle = (start+end)/2;
            if (isCommonPrefix(strs,middle)){
                start = middle+1;
            }else {
                end = middle-1;
            }
        }
        return strs[0].substring(0,start);
    }

    public boolean isCommonPrefix(String[] strs,int len){
        String str = strs[0].substring(0,len);
        for (int i=1;i<strs.length;i++){
            if(!strs[i].startsWith(str)){
                return false;
            }
        }
        return true;
    }

    //给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
    // 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
    //
    //注意：答案中不可以包含重复的三元组。
    //
    //例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
    //
    //满足要求的三元组集合为：
    //[
    //  [-1, 0, 1],
    //  [-1, -1, 2]
    //]

    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> sumList = new ArrayList<>();

        if(nums == null || nums.length == 0) return sumList;

        Arrays.sort(nums);

        for (int i=0;i<nums.length-2;i++){
            if(i!=0&&nums[i] == nums[i-1]){
                continue;
            }
            int start = i+1;
            int end = nums.length-1;

            while (start<end){
                if(nums[i]+nums[start]+nums[end]==0){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[start]);
                    temp.add(nums[end]);
                    sumList.add(temp);
                    start++;
                    end--;
                    while (start<end&&nums[start] == nums[start-1]){
                        start++;
                    }
                    while (start<end&&nums[end] == nums[end+1]){
                        end--;
                    }
                }else if(nums[i]+nums[start]+nums[end]<0){
                    start++;
                }else {
                    end--;
                }
            }
        }
        return sumList;
    }

    //给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
    // 找出 nums 中的三个整数，使得它们的和与 target 最接近。
    // 返回这三个数的和。假定每组输入只存在唯一答案。
    //
    //例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
    //
    //与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) return -1;

        Arrays.sort(nums);
        int bestSum = nums[0]+nums[1]+nums[2];

        for (int i=0;i<nums.length-2;i++){
            int start = i+1;
            int end = nums.length-1;
            while (start<end){
                int sum = nums[i]+nums[start]+nums[end];
                if(Math.abs(bestSum-target) > Math.abs(sum-target)){
                    bestSum = sum;
                }
                if(sum>target){
                    end--;
                }else if(sum<target){
                    start++;
                }else {
                    return target;
                }
            }
        }
        return bestSum;
    }

    //给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
    //
    //给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
    //2:abc,3:def,4:ghi,5:jkl,6:mno,7:pqrs,8:tuv,9:wxyz
    //
    //示例:
    //
    //输入："23"
    //输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

    //回溯法
    public List<String> letterCombinations(String digits) {
        List<String> strList = new ArrayList<>();

        if(digits == null || digits.length() == 0) return strList;

        String[] map  = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        letterCombinationsCore(strList,digits,map,"");
        return strList;
    }

    public void letterCombinationsCore(List<String> list,String digits,String[] map,String ans){
        if(digits.length() == ans.length()){
            list.add(ans);
            return;
        }

        for (char ch : map[digits.charAt(ans.length())-'2'].toCharArray()){
            letterCombinationsCore(list,digits,map,ans+ch);
        }
    }

    //根据队列不断拼接结果
    public List<String> letterCombinations1(String digits){
        List<String> strList = new LinkedList<String>();
        if(digits.isEmpty()) return Collections.emptyList();

        String[] map  = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        char[] charArray = digits.toCharArray();
        strList.add("");

        for (int i=0;i<charArray.length;i++){
            char ch = charArray[i];
            while (((LinkedList<String>) strList).getFirst().length()==i){
                String pop = ((LinkedList<String>) strList).removeFirst();
                for (char c : map[ch-'2'].toCharArray()){
                    strList.add(pop+c);
                }
            }
        }
        return strList;
    }

    //给定一个包含 n 个整数的数组 nums 和一个目标值 target，
    // 判断 nums 中是否存在四个元素 a，b，c 和 d ，
    // 使得 a + b + c + d 的值与 target 相等？
    // 找出所有满足条件且不重复的四元组。
    //
    //注意：
    //
    //答案中不可以包含重复的四元组。
    //
    //示例：
    //
    //给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
    //
    //满足要求的四元组集合为：
    //[
    //  [-1,  0, 0, 1],
    //  [-2, -1, 1, 2],
    //  [-2,  0, 0, 2]
    //]

    //在三数之和上改进
    public List<List<Integer>> fourSum(int[] nums,int target){
        if(nums.length<4) return Collections.emptyList();

        Arrays.sort(nums);
        int max = nums[nums.length-1];
        List<List<Integer>> sumList = new ArrayList<>();
        for (int i=0;i<nums.length-3;i++){

            if (nums[i]*4>target) break;
            if (nums[i]+3*max<target) continue;
            if (i!=0&&i<nums.length-3&&nums[i]==nums[i-1]) continue;

            for (int j=i+1;j<nums.length-2;j++){

                if (j!=i+1&&j<nums.length-2&&nums[j]==nums[j-1]) continue;
                if (nums[i]+nums[j]*3>target) break;
                if (nums[i]+nums[j]+max*2<target) continue;

                int start = j+1;
                int end = nums.length-1;
                while (start<end){
                    if(nums[i]+nums[j]+nums[start]+nums[end]==target){
                        List<Integer> numList = new ArrayList<>();
                        numList.add(nums[i]);
                        numList.add(nums[j]);
                        numList.add(nums[start]);
                        numList.add(nums[end]);
                        sumList.add(numList);
                        start++;
                        while (start<end&&nums[start]==nums[start-1]){
                            start++;
                        }
                        end--;
                        while (start<end&&nums[end]==nums[end+1]){
                            end--;
                        }
                    }else if(nums[i]+nums[j]+nums[start]+nums[end]<target){
                        start++;
                    }else {
                        end--;
                    }
                }
            }
        }
        return sumList;
    }

    //给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
    //
    //示例：
    //
    //给定一个链表: 1->2->3->4->5, 和 n = 2.
    //
    //当删除了倒数第二个节点后，链表变为 1->2->3->5.
    //
    //说明：
    //
    //给定的 n 保证是有效的。
    //
    //进阶：
    //
    //你能尝试使用一趟扫描实现吗？

    public ListNode removeNthFromEnd(ListNode head,int n){
        int length = 0;
        ListNode temp = head;
        while (temp!=null){
            temp = temp.next;
            length++;
        }

        int nthFromFirst = length - n;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        temp = dummy;

        while (nthFromFirst > 0){
            nthFromFirst--;
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return dummy.next;
    }

    public ListNode removeNthFromEnd1(ListNode head,int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        for (int i=0;i<n;i++){
            first = first.next;
        }

        while (first.next!=null){
            second = second.next;
            first = first.next;
        }

        second.next = second.next.next;

        return dummy.next;
    }

    //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
    //
    //有效字符串需满足：
    //
    //    左括号必须用相同类型的右括号闭合。
    //    左括号必须以正确的顺序闭合。
    //
    //注意空字符串可被认为是有效字符串。
    //
    //示例 1:
    //
    //输入: "()"
    //输出: true
    //
    //示例 2:
    //
    //输入: "()[]{}"
    //输出: true
    //
    //示例 3:
    //
    //输入: "(]"
    //输出: false
    //
    //示例 4:
    //
    //输入: "([)]"
    //输出: false
    //
    //示例 5:
    //
    //输入: "{[]}"
    //输出: true

    public boolean isValid(String s){
        char[] ch = s.toCharArray();
        Stack<Character> chStack = new Stack<>();

        for(int i=0;i<ch.length;i++){
            if(ch[i]=='{'||ch[i]=='['||ch[i]=='('){
                chStack.push(ch[i]);
            }else if(!chStack.isEmpty()) {
                if(chStack.peek()=='{'&&ch[i]=='}'){
                    chStack.pop();
                    continue;
                }else if(chStack.peek()=='['&&ch[i]==']'){
                    chStack.pop();
                    continue;
                }else if(chStack.peek()=='('&&ch[i]==')'){
                    chStack.pop();
                    continue;
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }
        if(!chStack.isEmpty()){
            return false;
        }
        return true;
    }
}
