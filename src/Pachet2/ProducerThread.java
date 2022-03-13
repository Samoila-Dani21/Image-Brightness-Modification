package Pachet2;

public class ProducerThread extends Thread{
	private Brightness obiect;
	private ReadImage imgob;
	
	public ProducerThread(Brightness ob,ReadImage img) {
		this.obiect=ob;
		this.imgob=img;
	}
	public void start() {
		super.start();
	}

	public void run() {

		try {
			synchronized(this) {
			Time timeDeschidere=new Time();
			
			timeDeschidere.setStartTime(System.nanoTime());		//initializare timp deschidere fisier
	    	obiect.setFilePath(imgob.OpenFile());				//deschidere fisier
	    	timeDeschidere.printTimeDeschidereFisier();			//Afisare timp								
	    	
	    	Thread.sleep(1000);

			}
			
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}

	}
}
