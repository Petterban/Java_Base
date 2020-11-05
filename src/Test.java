import org.jetbrains.annotations.NotNull;
//二分法查找
public class Test {
    int high = 0;
    int low = 0;
    int middle = 0;

    public int binarySearch(int @NotNull [] arr, int num_search){
        int position = -1;
        this.high = arr.length -1;
        this.middle = (this.high + this.low)/2;
        while(this.high >= this.low){
            if (arr[middle] == num_search){
                position = middle;
                break;
            }
            else if (arr[middle] > num_search){
                high = middle -1;
                middle = (high+low)/2;
            }else if (arr[middle] < num_search){
                low = middle + 1;
                middle = (high + low)/2;
            }
        }
        return position;

    }
}

