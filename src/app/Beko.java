package app;

public class Beko extends Pralka {
	
	public Beko() {
		super();
		super.skokTemp = 1.0;
		super.brand = (Typ.BEKO);
	}
	
	@Override
	public double roundTemp(double t) {
		t = Math.round(t);
		return t;
	}
	
}
