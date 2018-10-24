package app;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		
		Pralka pralka1 = new Beko();
		Pralka pralka2 = new Whirpool();
		Pralka pralka3 = new Amica();
		
		List<Pralka> listaPralek = new ArrayList<>();
		listaPralek.add(pralka1);
		listaPralek.add(pralka2);
		listaPralek.add(pralka3);
		
		sortujPralki(listaPralek);
		
		pralka1.setProgram(23);
		pralka2.setProgram(23);
		pralka3.setProgram(0);
		
		pralka1.nextProgram();
		pralka2.previousProgram();
		pralka3.previousProgram();
		
		pralka1.setTemp(43.7);
		pralka2.setTemp(-2);
		pralka3.setTemp(95);
		
		pralka1.tempUp();
		pralka2.tempUp();
		pralka3.tempUp();
		
		pralka1.tempDown();
		pralka2.tempDown();
		pralka3.tempDown();
		
		pralka1.setSpinning(666);
		pralka2.setSpinning(1023);
		pralka3.setSpinning(512);
		
		pralka1.spinUp();
		pralka2.spinUp();
		pralka3.spinUp();
		
		pralka1.spinDown();
		pralka2.spinDown();
		pralka3.spinDown();
		
		pralka1.showStatus();
		pralka2.showStatus();
		pralka3.showStatus();
		
	}
	
	public static void sortujPralki(List<Pralka> lista) {
		lista.stream()
				.forEach(s -> System.out.println(s.toString()));
		System.out.println("\n");
		lista.stream()
				.sorted((s, s1) -> s.getBrand()
						.name()
						.compareTo(s1.getBrand()
								.name()))
				.forEach(System.out::println);
		
	}
	
}
