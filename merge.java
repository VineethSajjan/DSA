import java.util.*;
class merge{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        ms(arr,0,n-1);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }
    public static void ms(int [] arr,int low,int high){
        if(low==high){
            return ;
        }
        int mid=(low+high)/2;
        ms(arr,low,mid);
        ms(arr,mid+1,high);
        mergesort(arr,low,mid,high);
    }
    public static void mergesort(int [] arr,int low,int mid,int high){
        List<Integer> l = new ArrayList<>();
        int left=low;
        int right=mid+1;
        while(left<=mid && right<=high){
            if(arr[left]<arr[right]){
                l.add(arr[left]);
                left++;
            }
            else{
                l.add(arr[right]);
                right++;
            }
        }
        while(left<=mid){
            l.add(arr[left]);
            left++;
        }
        while(right<=high){
            l.add(arr[right]);
            right++;
        }
        for(int i=low;i<=high;i++){
            arr[i] = l.get(i-low);
        }
    }
}
