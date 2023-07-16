import java.util.*;
class selection{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sort(arr,n);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }
    public static void sort(int [] arr,int n){
        int min;
        for(int i=0;i<n-1;i++){
            min = i; // store minimum element index
            for(int j=i;j<n;j++){
                if(arr[j]<arr[min]){
                    min=j; // check for minimum element index 
                }
            }
            int temp=arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
        }
    }
}