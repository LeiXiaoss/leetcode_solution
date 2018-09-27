import java.util.HashMap;
import java.util.Map;

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

    //给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
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
}
