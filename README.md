# leetcode-solution

leetcode的题库非常庞大，想要全部做完几乎是不可能的，本着准备20届校招找工作的目的，还是希望能够尽可能的多刷一些题目，但是，仅仅只是做题还是不够，我相信，很多童鞋，刷过一定量的题目之后，会发现，大部分的题目还是有规律可以找的，所以，还是需要做一个总结。
​	
现在（2018 11 10），leetcode已经刷了40道（当然那些太难的直接跳过了），结合之前剑指offer上的题目，是时候，进行一些总结了。

## 先按照题号顺序做一个简单的排列

<table>
    <tr>
        <th>题目</th>
        <th> 题号</th>
        <th>标签</th>
    </tr>
    <tr>
        <th>001</th>
		<th><a href="note\title\_001\001.md">两数之和</a></th>
        <th>数组，哈希表</th>
    </tr>
    <tr>
        <th>002</th>
        <th>两数相加</th>
        <th>链表，数学</th>
    </tr>
    <tr>
        <th>003</th>
        <th>无重复字符的最长子串</th>
        <th>哈希表，双指针，字符串</th>
    </tr>
    <tr>
        <th>005</th>
        <th>最长回文子串</th>
        <th>字符串，动态规划</th>
    </tr>
    <tr>
        <th>006</th>
        <th>Z字形变换</th>
        <th>字符串</th>
    </tr>
    <tr>
        <th>007</th>
        <th>反转整数</th>
        <th>数学</th>
    </tr>
    <tr>
        <th>008</th>
        <th>字符串转整数</th>
        <th>数学，字符串</th>
    </tr>
    <tr>
        <th>009</th>
        <th>回文数</th>
        <th>数学</th>
    </tr>
    <tr>
        <th>010</th>
        <th><a href="note\title\_010\010.md">正则表达式匹配</a></th>
        <th>字符串，动态规划，回溯算法</th>
    </tr>
    <tr>
        <th>011</th>
        <th><a href="note\title\_011\011.md">盛水最多的容器</a></th>
        <th>数组，双指针</th>
    </tr>
    <tr>
        <th>012</th>
        <th>整数转罗马数字</th>
        <th>数学，字符串</th>
    </tr>
    <tr>
        <th>013</th>
        <th>罗马数字转整数</th>
        <th>数学，字符串</th>
    </tr>
    <tr>
        <th>014</th>
        <th>最长公共前缀</th>
        <th>字符串</th>
    </tr>
    <tr>
        <th>015</th>
        <th>三数之和</th>
        <th>数组，双指针</th>
    </tr>
    <tr>
        <th>016</th>
        <th>最接近的三数之和</th>
        <th>数组，双指针</th>
    </tr>
    <tr>
        <th>017</th>
        <th>电话号码的字母组合</th>
        <th>字符串，回溯算法</th>
    </tr>
    <tr>
        <th>018</th>
        <th>四数之和</th>
        <th>数组，哈希表，双指针</th>
    </tr>
    <tr>
        <th>019</th>
        <th>删除链表倒数第N个节点</th>
        <th>链表，双指针</th>
    </tr>
    <tr>
        <th>020</th>
        <th>有效括号</th>
        <th>栈，字符串</th>
    </tr>
    <tr>
        <th>021</th>
        <th>合并两个有序链表</th>
        <th>链表</th>
    </tr>
    <tr>
        <th>022</th>
        <th>括号生成</th>
        <th>字符串，回溯算法</th>
    </tr>
    <tr>
        <th>023</th>
        <th>合并K个排序链表</th>
        <th>堆，链表，分治算法</th>
    </tr>
    <tr>
        <th>025</th>
        <th>K个一组翻转链表</th>
        <th>链表</th>
    </tr>    
    <tr>
        <th>026</th>
        <th>删除排序数组中的重复项</th>
        <th>数组，双指针</th>
    </tr>    
    <tr>
        <th>027</th>
        <th>移除元素</th>
        <th>数组，双指针</th>
    </tr>    
    <tr>
        <th>028</th>
        <th>实现strStr()</th>
        <th>双指针，字符串</th>
    </tr>    
    <tr>
        <th>030</th>
        <th>与所有字母相关联的字串</th>
        <th>哈希表，双指针，字符串</th>
    </tr>    
    <tr>
        <th>031</th>
        <th>下一个排列</th>
        <th>数组</th>
    </tr>   
    <tr>
        <th>032</th>
        <th>最长有效括号</th>
        <th>字符串，动态规划</th>
    </tr>    
    <tr>
        <th>033</th>
        <th>搜索旋转排序数组</th>
        <th>数组，二分查找</th>
    </tr>    
    <tr>
        <th>034</th>
        <th>在排序数组中查找元素的第一个和最后一个位置</th>
        <th>数组，二分查找</th>
    </tr>    
    <tr>
        <th>035</th>
        <th>搜索插入位置</th>
        <th>数组，二分查找</th>
    </tr>    
    <tr>
        <th>036</th>
        <th>有效的数独</th>
        <th>哈希表</th>
    </tr>    
    <tr>
        <th>038</th>
        <th>报数</th>
        <th>字符串</th>
    </tr>    
    <tr>
        <th>039</th>
        <th>组合总和</th>
        <th>数组，回溯算法</th>
    </tr>    
    <tr>
        <th>040</th>
        <th>组合总和II</th>
        <th>数组，回溯算法</th>
    </tr>    
    <tr>
        <th>041</th>
        <th><a href="note\title\_041\041.md">缺失的第一个正数</a></th>
        <th>数组</th>
    </tr>
    <tr>
        <th>042</th>
        <th><a href="note\_042\042.md">接雨水</th>
        <th>栈，数组，双指针</th>
    </tr>
    <tr>
        <th>043</th>
        <th><a href="note\title\_043\043.md">字符串相乘</a></th>
        <th>数学，字符串</th>
    </tr>
    <tr>
        <th>044</th>
        <th><a href="note\title\_044\044.md">通配符匹配</a></th>
        <th>贪心算法，字符串，动态规划，回溯算法</th>
    </tr>
    <tr>
    	<th>045</th>
        <th><a href="note\title\_045\045.md">跳跃游戏II</a></th>
        <th>贪心算法，数组</th>
    </tr>
    <tr>
    	<th>046</th>
        <th><a href="note\title\_046\046.md">全排列</a></th>
        <th>回溯算法</th>
    </tr>
    <tr>
    	<th>047</th>
        <th><a href="note\title\_047\047.md">全排列II</a></th>
        <th>回溯算法</th>
    </tr>
    <tr>
    	<th>048</th>
        <th><a href="note\title\_048\048.md">旋转图像</a></th>
        <th>数组</th>
    </tr>
    <tr>
    	<th>049</th>
        <th><a href="note\title\_049\049.md">字母异位词分组</a></th>
        <th>哈希表，字符串</th>
    </tr>
    <tr>
       	<th>050</th>
        <th><a href="note\title\_050\050.md">Pow(x, n)</a></th>
        <th>数学，二分查找</th>
    </tr>
    <tr>
       	<th>051</th>
        <th><a href="note\title\_051\051.md">N皇后</a></th>
        <th>回溯算法</th>
    </tr>
    <tr>
       	<th>052</th>
        <th><a href="note\title\_052\052.md">N皇后II</a></th>
        <th>回溯算法</th>
    </tr>
     <tr>
       	<th>053</th>
        <th><a href="note\title\_053\053.md">最大子序和</a></th>
        <th>数组、分治算法、动态规划</th>
    </tr>
     <tr>
       	<th>054</th>
        <th><a href="note\title\_054\054.md">螺旋矩阵</a></th>
        <th>数组</th>
    </tr>
    <tr>
        <th>055</th>
        <th><a href="note\title\_055\055.md">跳跃游戏</a></th>
        <th>贪心算法、数组</th>
    </tr>
    <tr>
        <th>056</th>
        <th><a href="note\title\_056\056.md">合并区间</a></th>
        <th>排序、数组</th>
    </tr>
    <tr>
        <th>057</th>
        <th><a href="note\title\_057\057.md">插入区间</a></th>
        <th>排序、数组</th>
    </tr>
    <tr>
        <th>058</th>
        <th>最后一个单词的长度</th>
        <th>字符串</th>
    </tr>
    <tr>
        <th>059</th>
        <th><a href="note\title\_059\059.md">螺旋矩阵II</a></th>
        <th>数组</th>
    </tr>
    <tr>
        <th>060</th>
        <th>第k个排列</th>
        <th>数学，回溯算法</th>
    </tr>
    <tr>
        <th>061</th>
        <th><a href="note\title\_061\061.md">旋转链表</a></th>
        <th>链表，双指针</th>
    </tr>
    <tr>
        <th>062</th>
        <th><a href="note\summary\dp\path.md">不同路径</a></th>
        <th>数组，动态规划</th>
    </tr>
    <tr>
        <th>063</th>
        <th><a href="note\summary\dp\path.md">不同路径II</a></th>
        <th>数组，动态规划</th>
    </tr>
    <tr>
        <th>064</th>
        <th><a href="note\summary\dp\path.md">最小路径和</a></th>
        <th>数组，动态规划</th>
    </tr>
    <tr>
        <th>065</th>
        <th>有效数字</th>
        <th>数组，字符串</th>
    </tr>
     <tr>
        <th>066</th>
        <th><a href="note\title\_066\066.md">加一</a></th>
        <th>数组，数学</th>
    </tr>
    <tr>
         <th>067</th>
         <th><a href="note\title\_067\067.md">二进制求和</a></th>
         <th>数学，字符串</th>
    </tr>
    <tr>
         <th>068</th>
         <th>文本左右对齐</th>
         <th>字符串</th>
    </tr>
    <tr>
          <th>069</th>
          <th>x的平方根</th>
          <th>数学，二分查找</th>
    </tr>
</table>






## 按照标签分组

<table>
    <tr>
        <th>标签</th>
        <th>题号</th>
        <th>总结</th>
    </tr>    
    <tr>
        <th>数组</th>
        <th>001,011,015,016,018,026,027,031,033,034,035,039,040,
            041,042,045,048,053,054,055,056,057,059</th>
        <th></th>
    </tr>
    <tr>
        <th>哈希表</th>
        <th>001,003,018,030,036,049</th>
        <th></th>
    </tr>
    <tr>
        <th>链表</th>
        <th>002,019,021,023,025,061</th>
        <th></th>
    </tr>
    <tr>
        <th>数学</th>
        <th>002,007,008,009,012,013,043,050,060</th>
        <th></th>
    </tr>
    <tr>
        <th>双指针</th>
        <th>003,011,015,016,018,019,026,027,028,030,042,
        	061</th>
        <th></th>
    </tr>
    <tr>
        <th>字符串</th>
        <th>003,005,006,008,010,012,013,014,017,020,022,
            028,030,032,038,043,044,049,058</th>
        <th></th>
    </tr>
    <tr>
        <th>回溯算法</th>
        <th>010,017,022,039,040,044,046,047,051,052,060</th>
        <th></th>
    </tr>
    <tr>
        <th>动态规划</th>
        <th>005,010,032,044,053</th>
        <th></th>
    </tr>
	<tr>
        <th>贪心算法</th>
        <th>044,045,055</th>
        <th></th>
    </tr>
    <tr>
        <th>分治算法</th>
        <th>023,053</th>
        <th></th>
    </tr>
    <tr>
        <th>堆</th>
        <th>023</th>
        <th></th>
    </tr>
    <tr>
        <th>栈</th>
        <th>020,042</th>
        <th></th>
    </tr>
    <tr>
        <th>二分查找</th>
        <th>050</th>
        <th></th>
    </tr>
    <tr>
        <th>排序</th>
        <th>056,057</th>
        <th></th>
    </tr>
</table>





