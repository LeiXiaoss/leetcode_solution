package com.leixiao.leetcode.hard._068;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，
    // 且左右两端对齐的文本。
    //
    //你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。
    // 必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
    //
    //要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，
    // 则左侧放置的空格数要多于右侧的空格数。
    //
    //文本的最后一行应为左对齐，且单词之间不插入额外的空格。
    //
    //说明:
    //
    //单词是指由非空格字符组成的字符序列。
    //每个单词的长度大于 0，小于等于 maxWidth。
    //输入单词数组 words 至少包含一个单词。
    //示例:
    //
    //输入:
    //words = ["This", "is", "an", "example", "of", "text", "justification."]
    //maxWidth = 16
    //输出:
    //[
    //   "This    is    an",
    //   "example  of text",
    //   "justification.  "
    //]
    //示例 2:
    //
    //输入:
    //words = ["What","must","be","acknowledgment","shall","be"]
    //maxWidth = 16
    //输出:
    //[
    //  "What   must   be",
    //  "acknowledgment  ",
    //  "shall be        "
    //]
    //解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
    //     因为最后一行应为左对齐，而不是左右两端对齐。
    //     第二行同样为左对齐，这是因为这行只包含一个单词。
    //示例 3:
    //
    //输入:
    //words = ["Science","is","what","we","understand","well","enough","to","explain",
    //         "to","a","computer.","Art","is","everything","else","we","do"]
    //maxWidth = 20
    //输出:
    //[
    //  "Science  is  what we",
    //  "understand      well",
    //  "enough to explain to",
    //  "a  computer.  Art is",
    //  "everything  else  we",
    //  "do                  "
    //]

    public List<String> fullJustify(String[] words,int maxWidth){
        List<String> result = new ArrayList<>();
        int start=0,end=-1,sum=0;
        for (int i=0;i<words.length;i++){
            sum+=words[i].length();
            if(sum>maxWidth){
                i--;
                start = end+1;
                end = i;
                sum = 0;
                result.add(addLine(words,start,end,maxWidth));
                continue;
            }
            sum++;
        }

        if(sum>0){
            result.add(addLine(words,end+1,words.length-1,maxWidth));
        }
        return result;
    }

    private String addLine(String[] words,int start,int end,int maxWidth){
        StringBuilder sb=new StringBuilder();
        if(start==end)
            sb.append(words[start]);
        else if(end==words.length-1){
            for(int i=start;i<=end-1;i++)
                sb.append(words[i]+" ");
            sb.append(words[end]);
        }
        else{
            int spaceSum=maxWidth;
            for(int i=start;i<=end;i++)
                spaceSum-=words[i].length();
            int extra=spaceSum-(spaceSum/(end-start))*(end-start);
            for(int i=start;i<=end;i++){
                sb.append(words[i]);
                for(int j=0;j<spaceSum/(end-start)&&i!=end;j++)
                    sb.append(" ");
                if(extra-->0)
                    sb.append(" ");
            }
        }
        while(sb.length()<maxWidth)
            sb.append(" ");
        return sb.toString();
    }

    public static void main(String[] args){
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        Solution solution = new Solution();

        System.out.println(solution.fullJustify(words,16));
    }

}
