
/*
思路分析：
根据题目，我们可以把获得的路径看成是一个有向图，该有向图只有一个终点，即所有路径会汇聚到一点。
要找出这个终点，我们只需要在这个有向图中找出出度为0的点即可。

*/

/**
 * @PackageName: AlgorithmTask
 * @ClassName: DestinationOfTheJourney
 * @Description: 给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，其中 paths[i] = [cityAi, cityBi]
 * 表示该线路将会从 cityAi 直接前往 cityBi。请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
 * 题目数据保证线路图会形成一条不存在循环的线路，因此只会有一个旅行终点站。
 * @author: chenJianHui
 * @date: 2020/11/20 
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DestinationOfTheJourney {

    public static void main(String[] args) {

        ArrayList<List<String>> paths = new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();
		
        //添加路线信息
        list1.add("London");
        list1.add("New York");
        list2.add("New York");
        list2.add("Lima");
        list3.add("Lima");
        list3.add("Sao Paulo");
        paths.add(list1);
        paths.add(list2);
        paths.add(list3);
		//打印结果
        System.out.println("旅游路线图：");
        System.out.println(paths);
        String result = destCity(paths);
        System.out.println("旅游终点站：");
        System.out.println(result);


    }
    
    //可以把它看成一个有向图，我们需要在这个有向图中找出度为0的点即可。
    public static String destCity(List<List<String>> paths) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < paths.size(); i++) {
            String from = paths.get(i).get(0);
            map.put(from, 1);
        }
        for (int i = 0; i < paths.size(); i++) {
            String to = paths.get(i).get(1);
            if (!map.containsKey(to)) {
                return to;
            }
        }
        return "";
    }
}


