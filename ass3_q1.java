class Main{
        static <T extends Comparable<T>> void sortnprint(T[] element){
                for(int i=0;i<element.length;i++){
                        for(int j=i;j<element.length-1;j++){
                                if(element[j].compareTo(element[j+1])>0){
                                        T temp= element[j];
                                        element[j]=element[j+1];
                                        element[j+1]= temp;
                                }
                        }
                }
                System.out.println("Sorted array");
                for(int i=0;i<element.length;i++){
                        System.out.println(element[i]);
                }

        }

        public static void main(String args[]){
                Integer a[]={7,4,3,6,5};
                sortnprint(a);

                //Character c[]= {'e', 'i', 'a', 'o', 'u'};
                //sortnprint(c);
        }
}
