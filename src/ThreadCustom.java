import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadCustom extends Thread {
	
	private Boolean tabaco = false;
	private Boolean papel = false;
	private Boolean fosforo = false;
	private Semaphore s;
	private Vendedor v;
	private String threaName;
	
	public String getThreaName() {
		return threaName;
	}

	public ThreadCustom(Semaphore s, Vendedor v, String threaName) {
		
		this.s = s;
		this.v = v;
		this.threaName = threaName;
	}
	
	public Boolean getTabaco() {
		return tabaco;
	}

	public void setTabaco(Boolean tabaco) {
		this.tabaco = tabaco;
	}

	public Boolean getPapel() {
		return papel;
	}

	public void setPapel(Boolean papel) {
		this.papel = papel;
	}

	public Boolean getFosforo() {
		return fosforo;
	}

	public void setFosforo(Boolean fosforo) {
		this.fosforo = fosforo;
	}

	@Override
	public void run() {
		Boolean verify = true;
		Random r = new Random();
		while (verify) {
			if (v.getFosforo().equals(false) && getFosforo().equals(true) ||
				v.getPapel().equals(false) && getPapel().equals(true) ||
				v.getTabaco().equals(false) && getTabaco().equals(true)) {
				try {
					s.acquire();
					System.out.println(getThreaName() + " fumando");
					Thread.sleep(r.nextInt(2000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println(getThreaName() + " terminou de fumar");
				s.release();
				verify = false;
			} else {
				try {
					Thread.sleep(r.nextInt(2000));
					v.sortProducts();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
