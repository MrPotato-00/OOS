import java.util.*;

class Main{

        static <T> void display(T[] arr){
                boolean visited[]= new boolean[arr.length];

                Arrays.fill(visited, false);
                System.out.println("Below are the list of duplicates");
                for(int i=0;i<arr.length;i++){

                        if(visited[i]==true){
                                continue;
                        }
                        int cnt=1;
                        for(int j=i;j<arr.length;j++){
                                if(arr[i]==arr[j] && i!=j){
                                        visited[i]=true;
                                        cnt++;
                                }
                        }
                        if(cnt>1){
                                System.out.println(arr[i]);
                        }
                }
        }




        public static void main(String args[]){
                //Integer a[]= {2,1,5,2,7,7};
                //display(a);


                Character c[]= {'a' ,'e', 'a', 'i', 'o', 'e'};
                display(c);
        }
}
