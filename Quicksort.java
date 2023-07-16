import java.util.*;
class Quicksort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        Quick(arr,0,n-1);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }

    public static void  Quick(int [] arr,int low,int high){
        if(low<high){
            int partion = partition(arr,low,high);
            Quick(arr,low,partion-1);
            Quick(arr,partion+1,high);
        }
    }
    public static int partition(int [] arr,int low,int high){
        int partion =low;
        int i=low;
        int j=high;
        while(i<j){
            while(arr[i]<=arr[partion] && i<high){
                i++;
            }
            while(arr[j] > arr[partion]&& j>low){
                j--;
            }
            if(i<j){
                swap(arr,i,j);
            }
        }
        swap(arr,partion,j);
        return j;
    }
    public static void swap(int [] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
