package comparisonsorts;
import java.util.Arrays; 
import java.lang.Math;                                          //@author Hugh Jass
import java.util.Scanner;

public class ComparisonSorts {
    
    public static void print2D(String mat[][]) { 
        for (String[] row : mat) 
            System.out.println(Arrays.toString(row)); 
    }
    
    public static void main(String[] args) {
        
        System.out.println("Insert the number of tests: ");     // asking for user input
        Scanner sc = new Scanner(System.in);                    // user input
        int numTests = sc.nextInt()+1;                          // user's choice of the number of tests to do
        
        SelectionSort ss = new SelectionSort();                 // ss - Selection Sort
        BubbleSort bbs = new BubbleSort();                      // bbs - Bubble Sort
        MergeSort ms = new MergeSort();                         // ms - Merge Sort
        QuickSort qs = new QuickSort();                         // qs - Quick Sort
        
        int [][] result = new int [5][numTests];                // creating a matrix to save the results int
        String [][] resultStr = new String [5][numTests];       // creating a matrix to save the results str
        
        for(int i = 1; i < 5; i++)                              //creating the first column in the int matrix
            result[i][0] = i;                                   //creating the first column int he int matrix
        
        resultStr[0][0] = "///////////////";                    //creating the first column in the str matrix
        resultStr[1][0] = "Selection sort:";                    //creating the first column in the str matrix
        resultStr[2][0] = "Bubble sort:   ";                    //creating the first column in the str matrix
        resultStr[3][0] = "Merge sort:    ";                    //creating the first column in the str matrix
        resultStr[4][0] = "Quick sort:    ";                    //creating the first column in the str matrix
        
        int test, j, time;                                  
        long start, finish;                                     // will be used for taking time
        int maxLen = 10000;                                     // max length of an array
        int max = 1000000;                                      // max value for array element
        
        for(test = 1; test < numTests; test++){                 // looping the tests 'numTests' times
            int len = (int)(Math.random() * maxLen);        
            result [0][test] = len;                             // saving the length of the created array to the result matrix
            resultStr [0][test] = len + "";                     // saving the length of the created array to the result matrix
            int [] arr = new int [len];
            for(j = 0; j < len; j++)                            // looping through the array
                arr[j] = (int)(Math.random() * max);            // putting inside the random values
            
            int [] arrss = arr;                                 //copying the array 
            int [] arrbbs = arr;
            int [] arrms = arr;
            int [] arrqs = arr;
            
            // Selection Sort
            start = System.currentTimeMillis();                 // taking time
            ss.sort(arrss);                                     // Selection Sort
            finish = System.currentTimeMillis();                // stopping time
            time = (int)(finish - start);                       // computing the result
            result[1][test] = time;                             // adding the result to the matrix int
            resultStr[1][test] = String.format("%03d", time);   // saving the result also to the matrix str       
            
            // Bubble sort
            start = System.currentTimeMillis();                 
            bbs.sort(arrbbs);                                     
            finish = System.currentTimeMillis();                
            time = (int)(finish - start);                       
            result[2][test] = time;
            resultStr[2][test] = String.format("%03d", time);          
            
            // Merge sort
            start = System.currentTimeMillis();                 
            ms.sort(arrms);                                     
            finish = System.currentTimeMillis();                
            time = (int)(finish - start); 
            result[3][test] = time;  
            resultStr[3][test] = String.format("%03d", time);          
            
            //  Quick sort
            start = System.currentTimeMillis();                 
            qs.sort(arrqs);                                     
            finish = System.currentTimeMillis();                
            time = (int)(finish - start);                       
            result[4][test] = time;     
            resultStr[4][test] = String.format("%03d", time);          
            
        }
        print2D(resultStr);
    }
}
