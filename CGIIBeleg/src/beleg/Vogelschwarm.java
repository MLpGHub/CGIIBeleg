package beleg;

import java.util.ArrayList;

public class Vogelschwarm {
	private ArrayList<Vogel> schwarm;
	private static Vogelschwarm exemplar = new Vogelschwarm();
	
	private Vogelschwarm() {
		schwarm = new ArrayList<Vogel>();
	}
	
	public static Vogelschwarm getInstance() {
		return exemplar;
	}
	
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Es gibt nur EINEN Schwarm.");
	}
	
	public int getSchwarmgroesse() {
		return schwarm.size();
	}
	
	public Vogel getVogel(int index) {
		return schwarm.get(index);
	}
	
	public void add(Vogel v) {
		schwarm.add(v);
	}
	
	public void remove(Vogel v) {
		schwarm.remove(v);
	}
	
	public void update() {
		for (int i = 0; i < schwarm.size(); i++) {
			schwarm.get(i).update();
		}
	}
	
	public void render() {
		for (int i = 0; i < schwarm.size(); i++) {
			schwarm.get(i).render();
		}
	}
}
