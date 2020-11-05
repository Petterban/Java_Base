import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/*
* 学习如何使用递归解决问题
* */
public class UseRecursion {


    //第一个方法，使用递归解决欧几里得算法
    //gcd:Greatest common divisor
    public int MyGcd(int a,int b){
        if (b == 0){
            //基线条件，结束递归的条件，0与其他任意整数的公约数，就是另一个数本身
            return a;
        }else {
            return MyGcd(b,a%b);
            //递归条件，继续进行递归的条件
        }
    }

    //第二个方法，使用递归完成数组的求和
    //已知条件：数组名

    public int arr_sum(int[] arr,int arr_length_left){
        if (arr_length_left == 0){
            return 0;
        }else {
            return arr[arr_length_left - 1 ] + arr_sum(arr,arr_length_left - 1);
        }

    }

    //方法三求最大值
    //刚写出来的时候我自己都没懂，按照IDE的要求解除error就完成了
    public int get_int_Max(int[] arr, int arr_length){
        if (arr_length == 1){
            return arr[0];
        }else {
            return Math.max(arr[arr_length - 1], get_int_Max(arr, arr_length - 1));
            /*
            每次将最后一个值与前面的值进行比较
            集成环境推荐使用上面的方法替代下面的代码
            if (arr[arr_length - 1] > get_int_Max(arr,arr_length -1)){
                return arr[arr_length -1];
            }else
            {
                return get_int_Max(arr,arr_length-1);
            }
             */
        }
    }

    //第四个方法，使用递归实现二分法查找
    public Integer getAddrByBinarySearch(int @NotNull [] arr, int num){
        Integer retMessage = null;
        if (arr.length > 0) {
            Arrays.sort(arr);
            retMessage = binary_Search(arr, arr.length - 1, 0, num);
        }
        return retMessage;
    }

    public Integer binary_Search(int[] arr,int high,int low,int num){
        if(high < low){
            return null;
        }else{
            int middle =  (high+low) / 2;
            if (num == arr[middle]){
                return middle;
            }else if (num < arr[middle]) return binary_Search(arr,middle - 1, low, num);
            else
                return binary_Search(arr,high,low+1,num);
        }
    }
}

