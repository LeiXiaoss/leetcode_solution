# 062 不同路径

## 难度

medium

## 描述

一个机器人位于一个 *m x n* 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？

**说明：**m 和 *n* 的值均不超过 100。

**示例 1:**

```
输入: m = 3, n = 2
输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
```

**示例 2:**

```
输入: m = 7, n = 3
输出: 28
```

## 思路

动态规划问题

状态转移方程式：`dp[i][j] = dp[i-1][j]+dp[i][j-1]`

其他没什么说的

## 代码

```java
public int uniquePaths(int m,int n){
        int[][] dp = new int[m][n];

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(i==0||j==0){
                    dp[i][j] = 1;
                }else {
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
```

# 063 不同路径II

## 难度

medium

## 描述

一个机器人位于一个 *m x n* 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

网格中的障碍物和空位置分别用 `1` 和 `0` 来表示。

**说明：***m* 和 *n* 的值均不超过 100。

**示例 1:**

```
输入:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
输出: 2
解释:
3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右
```

## 思路

与上一题的不同在于，路径中存在障碍，需要处理遇到障碍时的情况

状态转移方程式与上一题基本相同

## 代码

```Java
public int uniquePathsWithObstacles(int[][] obstacleGrid){
    int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

    if(obstacleGrid[0][0] == 1) {
        return 0;
    }else {
        dp[0][0] = 1;
    }

    for (int i=0;i<obstacleGrid.length;i++){
        for (int j=0;j<obstacleGrid[0].length;j++){
            if(i==0&&j!=0){
                dp[i][j] = (dp[i][j-1]==1&&obstacleGrid[i][j]!=1)?1:0;
            }else if(j==0&&i!=0){
                dp[i][j] = (dp[i-1][j]==1&&obstacleGrid[i][j]!=1)?1:0;
            }else if (i!=0&&j!=0){
                if (obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
    }
    return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
}
```

# 064 最小路径和

## 难度

medium

## 描述

给定一个包含非负整数的 *m* x *n* 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

**说明：**每次只能向下或者向右移动一步。

**示例:**

```
输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
```

## 思路

非左上边界的空格，可以从两个方向到达，取最小的就是当前空格的最小路径

状态转移方程:`dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];`

## 代码

```java 
public int minPathSum(int[][] grid){
        int[][] dp = new int[grid.length][grid[0].length];

        dp[0][0] = grid[0][0];
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if(i==0&&j!=0){
                    dp[i][j] = grid[i][j] + dp[i][j-1];
                }else if(j==0&&i!=0){
                    dp[i][j] = grid[i][j] + dp[i-1][j];
                }else if(i!=0&&j!=0){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
```

