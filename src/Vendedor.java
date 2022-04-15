import java.util.Random;

public class Vendedor {
	private Boolean tabaco = false;
	private Boolean papel = false;
	private Boolean fosforo = false;
	
	public void sortProducts() {
		Random r = new Random();
		
		Integer sort = r.nextInt(3);
		
		setTabaco(false);
		setPapel(false);
		setFosforo(false);
		
		if (sort.equals(0)) {
			setTabaco(true);
			setPapel(true);
		} else if (sort.equals(1)) {
			setPapel(true);
			setFosforo(true);
		}
		else {
			setTabaco(true);
			setFosforo(true);
		}
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
	
	
}
