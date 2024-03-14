class Common{
	int sum1=0;
	int sum2=0;
	int n;
	
	public Common(int n){
		this.n=n;
	}
	
	public void sumOdd(int i){
		sum1+=i;
	}
	public void sumEven(int i){
		sum2+=i;
	}
			

}

class Odd extends Thread{
	Common ob;
	
	public Odd(Common ob){
		this.ob= ob;
	}
	public void run(){
		for(int i=1;i<ob.n;i++){	
			if(i%2==1){
				ob.sumOdd(i);
			}
		}
	}
}

class Even extends Thread{
	Common ob;

	public Even(Common ob){
		this.ob=ob;
	}
	public void run(){
		for(int i=1;i<=ob.n;i++){
			if(i%2==0){
				ob.sumEven(i);
			}
		}
	}
}

class Main{
	public static void main(String args[]){
		Common ob= new Common(100);
		// thread 1
		
		Odd thread1= new Odd(ob);
		// thread 2
		
		Even thread2= new Even(ob);

		thread1.start();
		thread2.start();

		try{
			thread1.join();
			thread2.join();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}

		int sum= ob.sum1+ob.sum2;
		System.out.println("The sum is: "+sum);


	}
}
