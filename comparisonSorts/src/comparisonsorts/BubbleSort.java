package comparisonsorts;

public class BubbleSort {
    public static void sort(int arr[]){
        int len = arr.length;
        int buf, i, j;
        for(i = 0; i < len; i++)
            for(j = i+1; j < len; j++){
                if(arr[j] < arr[i]){
                    buf = arr[j];
                    arr[j] = arr[i];
                    arr[i] = buf;
                }
            }
             
    }
}
