package comparisonsorts;
import java.util.Arrays; 
import java.lang.Math;                                          //@author Hugh Jass
import java.util.Scanner;

public class ComparisonSorts {
    
    public static void print2D(String mat[][]) { 
        for (String[] row : mat) 
            System.out.println(Arrays.toString(row)); 
        System.out.println("____________________________");
        System.out.flush();
        
    }
    
    public static void controllaOrdinamento(int [] arr){
        for( int i=0; i<arr.length-1; i++)
            if(arr[i]>arr[i+1]){
                System.out.println(Arrays.toString(arr));
                System.exit(1);
            }
    }
    
    public static void controllaVettore(int [] arr1, int [] arr2){
        if(!Arrays.equals(arr1, arr2))
        {
            System.out.println(Arrays.toString(arr1));
            System.out.println(Arrays.toString(arr2));
            System.exit(1);
        }
    }
    
    public static void main(String[] args) {
        
        System.out.println("Insert the number of tests: ");     // asking for user input
        Scanner sc = new Scanner(System.in);                    // user input
        int numTests = sc.nextInt()+1;                          // user's choice of the number of tests to do
        
        SelectionSort ss = new SelectionSort();                 // ss - Selection Sort
        BubbleSort bbs = new BubbleSort();                      // bbs - Bubble Sort
        MergeSort ms = new MergeSort();                         // ms - Merge Sort
        QuickSort qs = new QuickSort();                         // qs - Quick Sort
        QuickSort2 qs2 = new QuickSort2();
        
        int [][] result = new int [5][numTests];                // creating a matrix to save the results int
        String [][] resultStr = new String [6][numTests];       // creating a matrix to save the results str
        
        for(int i = 1; i < 5; i++)                              //creating the first column in the int matrix
            result[i][0] = i;                                   //creating the first column int he int matrix
        
        resultStr[0][0] = "///////////////";                    //creating the first column in the str matrix
        resultStr[1][0] = "Selection sort:";                    //creating the first column in the str matrix
        resultStr[2][0] = "Bubble sort:   ";                    //creating the first column in the str matrix
        resultStr[3][0] = "Merge sort:    ";                    //creating the first column in the str matrix
        resultStr[4][0] = "Quick sort:    ";                    //creating the first column in the str matrix
        resultStr[5][0] = "Quick sort2:   ";                    //creating the first column in the str matrix
        
        int test, j;                                  
        long start, finish, time;                                     // will be used for taking time
        int maxLen = 10000;                                     // max length of an array
        int minLen = 1000;
        int max = 10000;                                      // max value for array element
        
        
        for(test = 1; test < numTests; test++){                 // looping the tests 'numTests' times
            int len = minLen+(int)(Math.random() * (maxLen - minLen + 1));       
            result [0][test] = len;                             // saving the length of the created array to the result matrix
            resultStr [0][test] = len + "";                     // saving the length of the created array to the result matrix
            int [] arr = new int [len];
            for(j = 0; j < len; j++)                            // looping through the array
                arr[j] = (int)(Math.random() * max);            // putting inside the random values
            
            int [] arrss  = new int [len];                                 
            int [] arrbbs = new int [len];
            int [] arrms  = new int [len];
            int [] arrqs  = new int [len];
            int [] arrqs2 = new int [len];
            
            System.arraycopy(arr, 0, arrss , 0, len);
            System.arraycopy(arr, 0, arrbbs, 0, len);
            System.arraycopy(arr, 0, arrms , 0, len);
            System.arraycopy(arr, 0, arrqs , 0, len);
            System.arraycopy(arr, 0, arrqs2, 0, len);
           
            
            
            // Selection Sort
            start = System.currentTimeMillis();                 // taking time
            ss.sort(arrss);                                     // Selection Sort
            finish = System.currentTimeMillis();                // stopping time
            controllaOrdinamento(arrss);
            controllaVettore(arrss, arrss);
            time = finish - start;                       // computing the result
            //result[1][test] = time;                             // adding the result to the matrix int
            resultStr[1][test] = String.format("%04d", time);   // saving the result also to the matrix str
            print2D(resultStr);
            
            // Bubble sort
            start = System.currentTimeMillis();                 
            bbs.sort(arrbbs);                                     
            finish = System.currentTimeMillis();                
            controllaOrdinamento(arrbbs);
            controllaVettore(arrbbs, arrss);
            time = (finish - start);                       
            //result[2][test] = time;
            resultStr[2][test] = String.format("%04d", time); 
            print2D(resultStr);
            
            // Merge sort
            start = System.currentTimeMillis();                 
            ms.sort(arrms);                                     
            finish = System.currentTimeMillis();                
            controllaOrdinamento(arrms);
            controllaVettore(arrms, arrss);
            time = (finish - start); 
            //result[3][test] = time;  
            resultStr[3][test] = String.format("%04d", time);
            print2D(resultStr);
            
            //  Quick sort
            start = System.currentTimeMillis();                 
            qs.sort(arrqs);                                     
            finish = System.currentTimeMillis();                
            time = (finish - start); 
            controllaOrdinamento(arrqs);
            controllaVettore(arrqs, arrss);
            //result[4][test] = time;     
            resultStr[4][test] = String.format("%04d", time);
            print2D(resultStr);
            
            //  Quick sort
            start = System.currentTimeMillis();                 
            qs2.sort(arrqs2, 0, arrqs2.length-1);                                     
            finish = System.currentTimeMillis();                
            time = (finish - start); 
            controllaOrdinamento(arrqs2);
            controllaVettore(arrqs2, arrss);
            //result[4][test] = time;     
            resultStr[5][test] = String.format("%04d", time);
            print2D(resultStr);
            
        }
        print2D(resultStr);
    }
}
