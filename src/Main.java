import java.util.concurrent.Semaphore;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		Semaphore semaforo = new Semaphore(1);
		
		Vendedor vendedor = new Vendedor();
		vendedor.sortProducts();
		ThreadCustom fumante1 = new ThreadCustom(semaforo, vendedor, "fumante 1");
		fumante1.setTabaco(true);
		ThreadCustom fumante2 = new ThreadCustom(semaforo, vendedor, "fumante 2");
		fumante2.setPapel(true);
		ThreadCustom fumante3 = new ThreadCustom(semaforo, vendedor, "fumante 3");
		fumante3.setFosforo(true);
		
		
	    
		fumante1.start();
		fumante2.start();
		fumante3.start();
	    
	    
	    fumante1.join();
	    fumante2.join();
	    fumante3.join();
	}
}
