package app;

abstract public class Pralka {
	
	private int				program;
	protected int			maxProgram	= 20;
	private double			temp;
	final protected double	maxTemp		= 90;
	private int				spinning;
	final protected int		maxSpinning	= 1000;
	protected double		skokTemp	= 0.5;
	private final char		stopien		= 186;
	protected Typ			brand;
	
	public Pralka() {
		
	}
	
	public int getProgram() {
		return program;
	}
	
	public void setProgram(int program) {
		if (program <= maxProgram && program > 0) {
			this.program = program;
			System.out.println("Ustawiono program: " + this.program);
		} else if (program > maxProgram) {
			this.program = maxProgram;
			System.out.println("Przekroczono maksymalna liczbe programow. Ustawiono program: " + maxProgram);
		} else if (program < 1) {
			this.program = 1;
			System.out.println("Nie ma takiego programu. Ustawiono program: " + 1);
			
		}
	}
	
	public void nextProgram() {
		if (this.program >= maxProgram) {
			this.program = 1;
			System.out.println("Ustawiono program nr: " + 1);
		} else {
			this.program = program++;
			System.out.println("Ustawiono program nr: " + this.program);
		}
	}
	
	public void previousProgram() {
		if (program == 1) {
			this.program = maxProgram;
			System.out.println("Ustawiono program nr: " + maxProgram);
		} else {
			this.program = program -= 1;
			System.out.println("Ustawiono program nr: " + this.program);
		}
	}
	
	public double getTemp() {
		return temp;
	}
	
	public void setTemp(double t) {
		if (t <= maxTemp && t >= 0) {
			this.temp = roundTemp(t);
			System.out.println("Ustawiono temperature: " + this.temp + getStopien() + "C");
		} else if (t > maxTemp) {
			this.temp = maxTemp;
			System.out.println("Ustawiono za wysoką temperaturę! Maksymalna temp: " + maxTemp + getStopien() + "C");
		} else if (t < 0) {
			this.temp = 0;
			System.out.println("Ustawiono za niską temperaturę! Minimalna temp: " + 0 + getStopien() + "C");
			
		}
	}
	
	public double roundTemp(double t) {
		t = Math.round(t * 2.0) / 2.0;
		return t;
	}
	
	public void tempUp() {
		try {
			if (this.temp >= maxTemp) {
				throw new TempException();
			}
			this.temp += skokTemp;
			System.out.println("Obecna temperatura wynosi: " + this.temp + getStopien() + "C");
		} catch (TempException e) {
			System.out.println(e.getMessage() + " Nie można zwiększyć temperatury. Maksymalna temperatura wynosi: " + maxTemp + getStopien() + "C");
		}
	}
	
	public void tempDown() {
		try {
			if (this.temp <= 0) {
				throw new TempException();
			}
			this.temp -= skokTemp;
			System.out.println("Obecna temperatura wynosi: " + this.temp + getStopien() + "C");
		} catch (TempException e) {
			System.out.println(e.getMessage() + " Nie można obnizyć temperatury. Minimalna temperatura wynosi: " + 0 + getStopien() + "C");
		}
	}
	
	public int getSpinning() {
		return spinning;
	}
	
	public void setSpinning(int w) {
		if (w > maxSpinning) {
			this.spinning = maxSpinning;
			System.out.println("Ustawiono za wysokie obroty! Maksymalne obroty: " + maxSpinning);
			
		} else if (w < 0) {
			this.spinning = 0;
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
		if (this.spinning == maxSpinning) {
			this.spinning = 0;
		} else {
			this.spinning += 100;
		}
		System.out.println("Aktualne obroty: " + this.spinning);
	}
	
	public void spinDown() {
		if (this.spinning == 0) {
			this.spinning = maxSpinning;
		} else {
			this.spinning -= 100;
		}
		System.out.println("Aktualne obroty: " + this.spinning);
	}
	
	public void showStatus() {
		System.out.println("Marka: " + brand);
		System.out.println("Program: " + getProgram());
		System.out.println("Temperatura: " + getTemp() + getStopien() + "C");
		System.out.println("Wirowanie: " + getSpinning());
		;
	}
	
	@Override
	public String toString() {
		return "Brand = " + brand;
	}
	
	public Typ getBrand() {
		return brand;
	}

	public char getStopien() {
		return stopien;
	}
	
}
