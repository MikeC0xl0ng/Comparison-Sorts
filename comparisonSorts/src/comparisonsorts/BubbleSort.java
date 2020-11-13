package comparisonsorts;

public class BubbleSort {
    public static void sort(int arr[]){
        boolean ordinato;
        int buf;
        int j = 0;
        do{
            ordinato = true;
            for(int i = 0; i < arr.length-j-1; i++)
                if(arr[i] > arr[i+1]){
                    buf = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = buf;
                    ordinato = false;
                }
            j++;
        }while(ordinato == false);
    }
}
