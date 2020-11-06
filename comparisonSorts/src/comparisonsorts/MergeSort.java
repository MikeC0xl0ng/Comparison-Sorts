package comparisonsorts;

public class MergeSort {
    void sort(int arr[]){
        sort(arr, 0, arr.length-1);
    }
    
     public static void sort(int v[], int stIndex, int finIndex){
        if(stIndex < finIndex)
        {
            int m = (stIndex + finIndex) / 2;
            sort(v, stIndex, m);
            sort(v, m+1, finIndex);
            merge(v, stIndex, m, finIndex);
        }
        
    }
    
    static void merge(int v[], int stIndex, int m, int finIndex){
        if(finIndex - stIndex < 1) //se il vettore v contiene un valore solo 
            return;
        else{                   //se il vettore v contiene più di un valore
            int v1 [] = new int[m-stIndex+1];
            int v2 [] = new int[finIndex-m];
            int i, j;
            for(i = 0; i < v1.length; i++)
                v1[i] = v[stIndex+i];
            for(j = 0; j<v2.length; j++)
                v2[j] = v[m+1+j];
            
            i = 0;
            j = 0;
            int k = stIndex;
            while(i < v1.length && j < v2.length){
                if(v1[i] < v2[j]){
                    v[k] = v1[i];
                    k = k + 1;
                    i = i + 1;
                }
                else{
                    v[k] = v2[j];
                    k = k + 1;
                    j = j + 1;
                }
            }
            int z;
            for(z = i; z < v1.length; z++){
                v[k] = v1[z];
                k = k + 1;
            }
            for(z = j; z < v2.length; z++){
                v[k] = v2[z];
                k = k + 1;
            }
        }

    }
}