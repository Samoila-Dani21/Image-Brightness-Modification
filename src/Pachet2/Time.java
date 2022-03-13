package Pachet2;

public class Time implements Interf{
	private long startTime;
	@Override
	public double getTime() {	
											//Calcularea duratei
		long endTime = System.nanoTime();
        double totalTime = (double)(endTime - startTime);
        //System.out.println("Timp de executie conversie : " + totalTime / 1.0E9D + " secunde");
        return totalTime / 1.0E9D;
	}
	public void setStartTime(long startT) {
		this.startTime=startT;
	}
	public long getStartTime() {
		return this.startTime;
	}
	public void printTimeConversie() {
		System.out.println("Timp de executie conversie : " + this.getTime() + " secunde");
	}
	public void printTimeTest() {
		System.out.println("Timp de executie Test : " + this.getTime() + " secunde");
	}
	public void printTimeDeschidereFisier() {
		System.out.println("Timp de executie pentru deschiderea si\n citirea pathului"
				+ "unui fisier : " + this.getTime() + " secunde");
	}
	 public void printTimeCitireFisier() {
		 System.out.println("Timp de executie citire din fisier: " + this.getTime() + " secunde");
		}
}
