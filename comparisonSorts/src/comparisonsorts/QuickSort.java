package comparisonsorts;

public class QuickSort {
    
    public static void sort(int arr[]){
        work(arr, 0, arr.length-1);
    }
    
    public static void work(int arr[], int sx, int dx){
        if(sx < dx){
            //System.out.println("SX: " + sx + " DX: " + dx);
            //try{Thread.sleep(5000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
            int pivotIndex = findPivot(arr, sx, dx);  //arr[pivotIndex] is on right place
            work(arr, sx, pivotIndex-1);              //recursion with the sorting of the left side of the array (pivot is the center)
            work(arr, pivotIndex+1, dx);              //recursion with the sorting of the right side of the array (pivot is the center)
        }
    }
    
    public static int findPivot(int arr[], int sx, int dx){
        int pivotIndex = sx;                    //declaration of the variables we need
        int biggestElementIndex = dx+1;         //declaration of the variables we need
        int buf, i;                             //declaration of the variables we need
        for(i = dx; i > 0; i--){
            if(arr[pivotIndex] < arr[i]){
                biggestElementIndex--;
                buf = arr[i];                           //swapping 
                arr[i] = arr[biggestElementIndex];      //swapping 
                arr[biggestElementIndex] = buf;         //swapping 
            }
        }
        buf = arr[biggestElementIndex - 1];                 //swapping 
        arr[biggestElementIndex - 1] = arr[pivotIndex];     //swapping 
        arr[pivotIndex] = buf;                              //swapping 
        
        return biggestElementIndex - 1;
    }
}
