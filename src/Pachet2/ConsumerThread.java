package Pachet2;

public class ConsumerThread implements Runnable {
	private Brightness obiect;
	private ReadImage imgob;					
	
	public ConsumerThread(Brightness ob,ReadImage img) {
		this.obiect=ob;				
		this.imgob=img;
	}
	public void run() {
											
													//citire din fisier
			imgob.ReadFromFile(obiect.getFilePath());
												//setarile pentru height,width
												//buffer
			obiect.setHeight(imgob.height);
	    	obiect.setWidth(imgob.width);
	    	obiect.setBufferedImage(imgob.image);

	}
}
