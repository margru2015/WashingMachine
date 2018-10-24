package app;

abstract public class Pralka {
	
	private int				program;
	private int				maxProgram	= 20;
	private double			temp;
	private int				spinning;
	private double			skokTemp	= 0.5;
	private Typ				brand;
	final private int		maxSpinning	= 1000;
	final private double	maxTemp		= 90;
	final private char		stopien		= 186;
	final private int		minProgram	= 1;
	final private double	minTemp		= 0;
	final private int		minSpinning	= 0;
	
	public Pralka() {
		
	}
	
	public int getProgram() {
		return program;
	}
	
	public void setProgram(int program) {
		if (program <= getMaxProgram() && program > 0) {
			this.program = program;
			System.out.println("Ustawiono program: " + this.program);
		} else if (program > getMaxProgram()) {
			this.program = getMaxProgram();
			System.out.println("Przekroczono maksymalna liczbe programow. Ustawiono program: " + getMaxProgram());
		} else if (program < getMinProgram()) {
			this.program = getMinProgram();
			System.out.println("Nie ma takiego programu. Ustawiono program: " + getMinProgram());
			
		}
	}
	
	public void nextProgram() {
		if (this.program >= getMaxProgram()) {
			this.program = getMinProgram();
			System.out.println("Ustawiono program nr: " + getMinProgram());
		} else {
			this.program = program++;
			System.out.println("Ustawiono program nr: " + this.program);
		}
	}
	
	public void previousProgram() {
		if (program == getMinProgram()) {
			this.program = getMaxProgram();
			System.out.println("Ustawiono program nr: " + getMaxProgram());
		} else {
			this.program = program -= getMinProgram();
			System.out.println("Ustawiono program nr: " + this.program);
		}
	}
	
	public double getTemp() {
		return temp;
	}
	
	public void setTemp(double t) {
		if (t <= getMaxTemp() && t >= getMinTemp()) {
			this.temp = roundTemp(t);
			System.out.println("Ustawiono temperature: " + this.temp + getStopien() + "C");
		} else if (t > getMaxTemp()) {
			this.temp = getMaxTemp();
			System.out.println("Ustawiono za wysoką temperaturę! Maksymalna temp: " + getMaxTemp() + getStopien() + "C");
		} else if (t < getMinTemp()) {
			this.temp = getMinTemp();
			System.out.println("Ustawiono za niską temperaturę! Minimalna temp: " + getMinTemp() + getStopien() + "C");
			
		}
	}
	
	public double roundTemp(double t) {
		t = Math.round(t * 2.0) / 2.0;
		return t;
	}
	
	public void tempUp() {
		try {
			if (this.temp >= getMaxTemp()) {
				throw new TempException();
			}
			this.temp += getSkokTemp();
			System.out.println("Obecna temperatura wynosi: " + this.temp + getStopien() + "C");
		} catch (TempException e) {
			System.out.println(e.getMessage() + " Nie można zwiększyć temperatury. Maksymalna temperatura wynosi: " + getMaxTemp() + getStopien() + "C");
		}
	}
	
	public void tempDown() {
		try {
			if (this.temp <= getMinTemp()) {
				throw new TempException();
			}
			this.temp -= getSkokTemp();
			System.out.println("Obecna temperatura wynosi: " + this.temp + getStopien() + "C");
		} catch (TempException e) {
			System.out.println(e.getMessage() + " Nie można obnizyć temperatury. Minimalna temperatura wynosi: " + getMinTemp() + getStopien() + "C");
		}
	}
	
	public int getSpinning() {
		return spinning;
	}
	
	public void setSpinning(int w) {
		if (w > getMaxSpinning()) {
			this.spinning = getMaxSpinning();
			System.out.println("Ustawiono za wysokie obroty! Maksymalne obroty: " + getMaxSpinning());
			
		} else if (w < getMinSpinning()) {
			this.spinning = getMinSpinning();
			System.out.println("Ustawiono za niskie obroty! Wirowanie wyłączone");
		} else {
			int v = roundSpin(w);
			this.spinning = v;
			System.out.println("Ustawiono obroty: " + this.spinning);
		}
	}
	
	public int roundSpin(int a) {
		int b = (int) (Math.round(a / 100.0)) * 100;
		return b;
	}
	
	public void spinUp() {
		if (this.spinning == getMaxSpinning()) {
			this.spinning = getMinSpinning();
		} else {
			this.spinning += 100;
		}
		System.out.println("Aktualne obroty: " + this.spinning);
	}
	
	public void spinDown() {
		if (this.spinning == getMinSpinning()) {
			this.spinning = getMaxSpinning();
		} else {
			this.spinning -= 100;
		}
		System.out.println("Aktualne obroty: " + this.spinning);
	}
	
	public void showStatus() {
		System.out.println("Marka: " + getBrand());
		System.out.println("Program: " + getProgram());
		System.out.println("Temperatura: " + getTemp() + getStopien() + "C");
		System.out.println("Wirowanie: " + getSpinning());
		;
	}
	
	@Override
	public String toString() {
		return "Brand = " + getBrand();
	}
	
	public Typ getBrand() {
		return brand;
	}
	
	public char getStopien() {
		return stopien;
	}
	
	public double getMaxTemp() {
		return maxTemp;
	}
	
	public int getMaxProgram() {
		return maxProgram;
	}
	
	public void setMaxProgram(int maxProgram) {
		this.maxProgram = maxProgram;
	}
	
	public int getMaxSpinning() {
		return maxSpinning;
	}
	
	public double getSkokTemp() {
		return skokTemp;
	}
	
	public void setSkokTemp(double skokTemp) {
		this.skokTemp = skokTemp;
	}
	
	public void setBrand(Typ brand) {
		this.brand = brand;
	}
	
	public int getMinProgram() {
		return minProgram;
	}
	
	public double getMinTemp() {
		return minTemp;
	}
	
	public int getMinSpinning() {
		return minSpinning;
	}
	
}
