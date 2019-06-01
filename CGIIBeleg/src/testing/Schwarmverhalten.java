package testing;

public class Schwarmverhalten implements Verhalten {
	private Steuerung steuerung;
	private Vogel vogel;
	private double dist;
	private double min_speed;
	private double max_speed;
	private boolean followMouse;
	
	public Schwarmverhalten(Vogel vogel, double dist, double min_speed, double max_speed, boolean followMouse) {
		this.vogel = vogel;
		this.dist = dist;
		this.min_speed = min_speed;
		this.max_speed = max_speed;
		this.followMouse = followMouse;
	}
	
	public void update() {
		Vektor3D seperation = steuerung.seperation(vogel, dist);
		Vektor3D ausrichtung = steuerung.ausrichtung(vogel, dist);
		Vektor3D zusammenhalt = steuerung.zusammenhalt(vogel, dist);
		
		try {
			//
		} catch (Exception e) {
			//
		}
		
	}
}
