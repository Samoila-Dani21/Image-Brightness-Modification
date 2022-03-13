package Pachet1;
import Pachet2.Brightness;
import Pachet2.ConsumerThread;
import Pachet2.ProducerThread;
import Pachet2.ReadImage;
import Pachet2.Time;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TestApp {
    public static void main(String[] args) throws InterruptedException, IOException {

    	Brightness obiect=new Brightness();	
        					//Se utilizeaza parametrul obiect pentru a 
    						//face legatura dintre cele doua threaduri	
    	ReadImage imgob = new ReadImage();
    	
    	ProducerThread citire=new ProducerThread(obiect,imgob);	//Declarari pentru threaduri
        ConsumerThread procesare=new ConsumerThread(obiect,imgob);
        Thread threadProcesare= new Thread(procesare);
        					//Pornirea threadului citire
        citire.start();
		//Permite executia altui thread doar cand se termina acesta
        citire.join();				//Se porneste threadul de procesare
        threadProcesare.start();
  

			Time time=new Time();
			String outputFilePath = null;
			
			ReadImage fisier=new ReadImage();
			System.out.print("Noul fisier: ");
		        								//Se preia path-ul noului fisier
		    outputFilePath=fisier.OpenFile();
		    									//Se creeaza noul fisier
		    File output = new File(outputFilePath);
		        
		    time.setStartTime(System.nanoTime());
		    									//Se adauga in fisierul creat
		    									//poza modificata corespunzator
		    try {								
				ImageIO.write(obiect.ConvertToBrightened(), "bmp", output);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     System.out.println("Conversie reusita.");
			}

}

