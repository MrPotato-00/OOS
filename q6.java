class BinarySearch extends Thread{
	static boolean flag= false;
	int index;
	private int arr[];
	private int data,low,high;

	BinarySearch(int arr[], int data, int low, int high){
		this.arr=arr;
		this.data=data;
		this.low= low;
		this.high=high;
		index=-1;
	}	

	private void BSearch(int low, int high){
		if(flag){
			System.exit(0);
		}

		if(low<high-1){
			int mid= (low+high)/2;
			if(arr[mid]==data){
				index=mid;
				flag=false;
			}
			else{
				if(data < arr[mid]){
					high= mid;
				}
				else{
					low=mid;
				}
				BSearch(low, high);
			}
		}
	}
	
	public void run(){
		BSearch(low, high);
		if(index!=-1){
			System.out.println("Data Found at index: "+index);
		}
	}
}


class Main{
	public static void main(String args[]){

		int size= 20;
		int data= 14;
		int index=-1;
		int slice=10;

		int arr[]= new int [size];
		for(int i=0;i<size;i++){
			arr[i]= i+1;
		}

		BinarySearch[] threads= new BinarySearch[size/slice];

		for(int i=0;i<size/slice;i++){
			threads[i]= new BinarySearch(arr,data, slice*i, slice*(i+1)-1);
		       threads[i].start();
	       		try{
		 		threads[i].join();
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			
			if(threads[i].index!=-1){
				index= threads[i].index;
				break;
			}
		}

		if(index==-1){
			System.out.println("Data not found");
		}
	}
}	

