import java.util.HashSet;
import java.util.Set;

/*
* 算法：查找出整型数组中仅出现一次的数字
* */
public class SearchOne {
    private String str = null;
    public SearchOne(String str){
        this.str = str;
    }

    public SearchOne(){}

    //使用String类的方法将字符串转化为整型数组，要求数字以逗号隔开
    public int[] createIntArr(){
        String[] temp_str_arr = this.str.split(",");
        int[] arr = new int[temp_str_arr.length];

        for (int i = 0 ; i < temp_str_arr.length; i++){
            arr[i] = Integer.parseInt(temp_str_arr[i]);//这里也可以使用valueOf()方法
        }
        return  arr;
    }

    //方法一：双重循环，使用判断标识
    public Integer searchOneFirst(){//返回值使用Integer，方便返回不存在的情况
        int[] arrCreated = createIntArr();
        boolean isExist = true;
        for (int i = 0;i<arrCreated.length;i++){
            isExist = true;
            for (int j = 0;j<arrCreated.length;j++){
                if(i == j){
                    continue;
                    //在最初编写时，忘记判断相同下标的情况
                }
                if (arrCreated[i] == arrCreated [j]){
                    isExist = false;
                    break;
                }
            }
            if (isExist){
                return arrCreated[i];
            }
        }

        return  null;//如果返回值是int类型，就无法返回null
    }

    //方法一2.0：双重循环，不使用判断标识
    public Integer searchOneFirst_2(){
        int[] arrCreated = createIntArr();
        for (int i = 0;i<arrCreated.length;i++){
            for (int j = 0; j<=arrCreated.length;j++){//查看下面代码，这边其实不会越界
                if(i == j){
                    continue;
                }
                if (j == arrCreated.length){//当第二层循环超出边界时表示未找到重复的数字
                    return arrCreated[i];
                }
                if (arrCreated[i] == arrCreated[j]){
                    break;
                }
            }
        }
        return null;
    }

    //方法二：利用Set集合的特性，Set不能添加相同的值
    public Integer searchOneSecond(){
        int[] arrCreated = createIntArr();
        Set<Integer> mySet = new HashSet<>();
        for (int i : arrCreated){//foreach循环的前面的参数i表示数组中的值而不是下标
            if (!mySet.add(i)){
                mySet.remove(i);
            }
        }
        if (mySet.size() == 0)//表示不存在唯一的数字的情况
        return null;
        //return mySet.toArray(new Integer[mySet.size()])[0];
        return mySet.toArray(new Integer[0])[0];//IDE推荐使用这种方式创建数组
    }

    //方法三：使用^位运算符，该算法要求数组中必须存在仅出现一次的数字
    //异或的逻辑在于使用二进制数进行查看
    public int searchOneThird(){
        int[] arrCreated = createIntArr();
        int flag = 0;
        for (int k : arrCreated){
            flag ^= k;
        }
        return flag;
    }
}
