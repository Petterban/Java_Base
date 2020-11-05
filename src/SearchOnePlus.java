import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
在SearchOne类的基础上查找出现奇数次的数
 */
public class SearchOnePlus {
    public SearchOnePlus(){}

    //将字符串转换成整型数字的方法,与之前不同的是将字符串作为参数传入，会更方便
    public int[] createIntArr(@NotNull String str){
        String[] temp_string_arr = str.split(",");
        int[] retArr = null;
        if (temp_string_arr.length >0) {
            retArr = new int[temp_string_arr.length];
            for (int i = 0; i <temp_string_arr.length;i++){
                retArr[i] = Integer.parseInt(temp_string_arr[i]);//将字符串转换成整型的方法
            }
        }
        return retArr;
    }

    /*
    方法一：^异或位运算依然使用
    局限性：无法识别出现奇数次数字不存在的情况，以及出现奇数次的数字为0的情况
     */
    public int searchOdd_one(int @NotNull [] arr){
        int flag = 0;
        if (arr.length > 0){
            for (int k : arr){
                flag ^= k;
            }
        }
        return flag;
    }

    /*
    方法二：使用Map的特性，之前找出只出现一次的也可以使用该方法
    该方法可以找出所有出现奇数次或者偶数次的数字，稍作修改甚至可以找出特定次数的数字
     */
    public Set<Integer> searchOdd_two(@NotNull int[] arr){
        Set<Integer> ret = new HashSet<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int k: arr){
            countMap.merge(k, 1, Integer::sum);
            /*
            IDE推荐使用上面的方法来替换下面的代码
            if (count == null){
                countMap.put(k,1);
            }else
            {
                countMap.put(k,count+1);//会覆盖之前的value
            }
             */
        }
        //循环结束后，此时原本数据的值和出现的次数形成键值对

        /*
        Map.Entry<K,V> Map的嵌套接口，表示一对键值对
        entrySet()返回类型为java.util.Set<Map.Entry<K, V>>，就是Map.Entry<K, V>的数据集合
         */
        for (Map.Entry<Integer,Integer> kv : countMap.entrySet()){
            if (kv.getValue()%2 != 0){
                ret.add(kv.getKey());
            }
        }
        return ret;
    }
}

