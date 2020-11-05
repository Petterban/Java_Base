import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SearchOnePlus arr_need = new SearchOnePlus();

        UseRecursion testObject = new UseRecursion();
        int[] arr =  arr_need.createIntArr(input.nextLine());
        System.out.println("输入你想要找的数字：");
        int num_you_need = input.nextInt();

        Integer addr = testObject.getAddrByBinarySearch(arr,num_you_need);
        if (addr == null) System.out.println("不存在！");
        else System.out.println(num_you_need + "的下标为：" + addr);
    }
}
