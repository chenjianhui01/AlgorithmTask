/*
思路分析：

这道题其实考察的是数学思想，首先有多少瓶numBottles就喝了多少瓶酒，此刻空瓶emptyBottles，然后就是把这些空瓶去兑换酒，
那能兑换emptyBottles//numExchange瓶，必须是向下取整，现在还剩emptyBottles%numExchange+emptyBottles/numExchange个空瓶可以去兑换，
就这样循环下去，直到可换的瓶数少于换瓶的条件截止。

*/

/**
 * @PackageName: AlgorithmTask
 * @ClassName: WaterBottles
 * @Description: 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。
 * 你购入了 numBottles 瓶酒。如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。请你计算最多能喝到多少瓶酒。
 * @author: chenJianHui
 * @date: 2020/11/20
 */

public class WaterBottles {
    public static void main(String[] args) {
        /*测试
        int numBottles = 15;
        int numExchange = 4;
         */

        int numBottles = 9;
        int numExchange = 3;

        int reslut = numWaterBottles(numBottles, numExchange);
        System.out.println("你购买了 " + numBottles + " 瓶酒，" + numExchange + " 个空瓶子可以换一瓶新酒");
        System.out.println("你一共能喝到：" + reslut + " 瓶酒");

    }

    public static int numWaterBottles(int numBottles, int numExchange) {

        //代表此刻的空瓶数量
        int emptyBottles = numBottles;
        //代表到目前为止，总的喝酒瓶数
        int drinkNum = numBottles;

        while (emptyBottles >= numExchange) {

            // emptyBottles/numExchange代表的都是此刻拥有的可以喝的酒瓶的数量(本次换来的酒)
            drinkNum = drinkNum + emptyBottles / numExchange;
            //求的是此刻拥有的空瓶数量；
            emptyBottles = emptyBottles / numExchange + emptyBottles % numExchange;
        }

        return drinkNum;
    }
}




