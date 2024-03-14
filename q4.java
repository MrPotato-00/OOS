import java.io.FileReader;

class ReaderandSum{
	private int number;
	int sum;
	private int ch;
	private FileReader fr;
	private boolean flag;
	boolean endRead, endAdd;

	ReaderandSum(FileReader fr){
		number=0;
		sum=0;
		this.fr=fr;
		flag=false;
		endAdd= endRead= false;
	}

	synchronized void read() throws Exception{
		while(flag){
			try{
				wait();
			}
			catch(InterruptedException e){}
		}
		number =0;
		ch= fr.read();
		while(ch>=0){
			number= number*10 +(ch-'0');
			ch=fr.read();
			if(ch==null){
				break;
			}
		}

		if(ch<0){
			endRead= true;
		}
		flag= true;
		notify();
	}

	synchronized void add(){
		while(!flag){
			try{
				wait();
			}
			catch(InterruptedException e){};
		}
		sum+=number;
		flag= false;
		if(ch<0){
			endAdd= true;
		}
		notify();
	}
}

class Producer extends Thread{
	ReaderandSum reader;
	Producer(ReaderandSum reader){
		super("producer");
		this.reader= reader;
	}

	public void run(){
		while(!reader.endRead){
			try{
				reader.read();
			}
			catch(Exception e){
				System.out.println(e);
				reader.endAdd= reader.endRead= true;
				reader.sum=-1;
				System.exit(0);
			}
		}
	}
}

class Consumer extends Thread{
	ReaderandSum reader;
	Consumer(ReaderandSum reader){
		super("consumer");
		this.reader=reader;
	}

	public void run(){
		while(!reader.endAdd){
			reader.add();
		}
	}
}

class Main{
	public static void main(String args[]){
		int ch;
		FileReader fr= null;
		try{
			fr= new FileReader("file.txt");
		}
		catch(Exception e){
			System.out.println("File not found");
			System.exit(0);
		}

		ReaderandSum rm= new ReaderandSum(fr);
		Producer pd= new Producer(rm);
		Consumer cm= new Consumer(rm);

		pd.start();
		cm.start();

		try{
			pd.join();
			cm.join();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}

		System.out.println("Sum: "+rm.sum);
	}
}

