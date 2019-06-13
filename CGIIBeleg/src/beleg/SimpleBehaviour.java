package beleg;

public class SimpleBehaviour implements Verhalten {
	private BeweglichesObjekt so;
	
	public SimpleBehaviour(BeweglichesObjekt so) {
		this.so = so;
	}
	
	public void update() {
		if (so.pos.x > 0.5) {
			try {
				so.speed.add(new Vektor3D(-0.001, 0, 0));
				so.pos.add(so.speed);
			} catch (Exception e) {}
		} else if (so.pos.x < -0.5) {
			try {
				so.speed.add(new Vektor3D(0.001, 0, 0));
				so.pos.add(so.speed);
			} catch (Exception e) {}
		} else {
			try { so.pos.add(so.speed); } catch (Exception e) {}
		}
	}
}
