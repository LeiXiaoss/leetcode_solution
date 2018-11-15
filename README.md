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
		<th><a href="note\_001\001.md">两数之和</a></th>
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
        <th>正则表达式匹配</th>
        <th>字符串，动态规划，回溯算法</th>
    </tr>
    <tr>
        <th>011</th>
        <th><a href="note\_011\011.md">盛水最多的容器</a></th>
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
        <th>堆，链表，回溯算法</th>
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
        <th><a href="note\_041\041.md">缺失的第一个正数</a></th>
        <th>数组</th>
    </tr>
    <tr>
        <th>042</th>
        <th><a href="note\_042\042.md">接雨水</th>
        <th>栈，数组，双指针</th>
    </tr>
    <tr>
        <th>043</th>
        <th><a href="note\_043\043.md">字符串相乘</a></th>
        <th>数学，字符串</th>
    </tr>
    <tr>
        <th></th>
        <th></th>
        <th></th>
    </tr>
</table>





## 按照标签分组

<table>
    <tr>
        <th>标签</th>
        <th>题号</th>
        <th>这一类问题的总结</th>
    </tr>    
    <tr>
        <th>数组</th>
        <th><a href="note\_001\001.md">001</a>,<a href="note\_011\011.md">011</a>,015,016,018,026,027,031,033,034,035,
            039,040,<a href="note\_041\041.md">041</a>,<a href="note\_042\042.md"/>042</a></th>
        <th></th>
    </tr>
    <tr>
        <th>哈希表</th>
        <th><a href="note\_001\001.md">001</a>,003,018,030,036</th>
        <th></th>
    </tr>
    <tr>
        <th>链表</th>
        <th>002,019,021,023,025</th>
        <th></th>
    </tr>
    <tr>
        <th>数学</th>
        <th>002,007,008,009,012,013,<a href="note\_043\043.md">043</a></th>
        <th></th>
    </tr>
    <tr>
        <th>双指针</th>
        <th>003,<a href="note\_011\011.md">011</a>,015,016,018,019,026,027,028,030,<a href="note\_042\042.md"/>042</a></th>
        <th></th>
    </tr>
    <tr>
        <th>字符串</th>
        <th>003,005,006,008,010,012,013,014,017,020,022,
            028,030,032,038,<a href="note\_043\043.md">043</a></th>
        <th></th>
    </tr>
    <tr>
        <th>回溯算法</th>
        <th>010,017,022,039,040</th>
        <th></th>
    </tr>
    <tr>
        <th>动态规划</th>
        <th>005,010,032</th>
        <th></th>
    </tr>
    <tr>
        <th>堆</th>
        <th>023</th>
        <th></th>
    </tr>
    <tr>
        <th>栈</th>
        <th>020,<a href="note\_042\042.md"/>042</a></th>
        <th></th>
    </tr>
</table>





