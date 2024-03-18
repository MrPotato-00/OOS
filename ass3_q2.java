import java.util.*;

class Main{
        static <T> void display(T[] element){
                boolean visited[]= new boolean[element.length];
                Arrays.fill(visited, false);
                System.out.println("Below are the required elements");

                System.out.println("Element" + "-->" + "Freq");
                for(int i=0;i<element.length;i++){

                        if(visited[i]==true){
                                continue;
                        }

                        int count=1;
                        for(int j=0;j<element.length;j++){
                                if(element[i]== element[j] && i!=j){
                                        visited[j]=true;
                                        count++;
                                }
                        }
                        System.out.println(element[i] + "-->" + count);
                }
        }


        public static void main(String args[]){
                //Integer a[]= {2,7,2,3,5,1,5};

                //display(a);

                Character c[]= {'a', 'e', 'a', 'i','a','e', 'o', 'z'};
                display(c);
        }
}
