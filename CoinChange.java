
/*
思路分析：

钞票面值：coins=[1,2,5,7,10]；金额：14 
dp[i]  代表金额 i 的最优解（即最小使用张数）

数组 dp[] 中存储金额 1 至金额 14 的最优解(最少使用钞票的数量）。

在计算 dp[i] 时，dp[0] 、dp[1]、dp[2]、…、dp[i-1]都是已知的;
而金额i可由:
金额 i-1 与 coins[0] (1) 组合
金额 i-2 与 coins [1] (2) 组合
金额 i-5 与 coins [2] (5) 组合
金额 i-7 与 coins [3] (7) 组合
金额 i-10 与 coins [4] (10) 组合

即状态可由状态 i-1、i-2、i-5、i-7、i-10,  5 个状态所转移到，
故 dp[i] = min (dp [i-1], dp [i-2], dp [i-5], dp [i-7], dp [i-10]) +1

 coins={1,2,5,7,10}

设 i 代表金额，coins[j]代表第 j 个面值的金额：
当 i - coins[j] >= 0 且 dp [i- coins [j]] != -1 时
 j = 0,1,2,3,4 ;  coins [j] = 1,2,5,7,10  
dp [i] = getmin (dp [i-coins[j]]) +1

*/

/**
 * @PackageName: AlgorithmTask
 * @ClassName: CoinChange
 * @Description: 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。你可以认为每种硬币的数量是无限的。
 * @author: chenJianHui
 * @date: 2020/11/20 
 */

public class CoinChange {
    public static void main(String[] args) {
        /*测试1
        int[] coins = {2};
        int amount = 3;
        */
        /*测试2
        int[] coins = {1};
        int amount = 2;
        */

        int[] coins = {1, 5, 2};
        int amount = 11;

        int result = coinChange(coins, amount);
		//打印结果
        System.out.println("钞票面额：");
        for (int coin : coins) {
            System.out.print(coin + "  ");
        }
        System.out.println();
        System.out.println("需要凑成的总金额：");
        System.out.println(amount);
        System.out.println("所需的最少的硬币个数:");
        System.out.println(result);

    }

    public static int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1) {
                    if (dp[i] == -1 || dp[i] > dp[i - coins[j]] + 1) {
                        dp[i] = dp[i - coins[j]] + 1;
                    }
                }
            }

        }
        return dp[amount];
    }


}









