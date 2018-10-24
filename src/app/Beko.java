package app;

public class Beko extends Pralka {
	
	public Beko() {
		super();
		super.setSkokTemp(1.0);
		super.setBrand(Typ.BEKO);
	}
	
	@Override
	public double roundTemp(double t) {
		t = Math.round(t);
		return t;
	}
	
}
