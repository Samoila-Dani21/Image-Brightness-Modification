package Pachet2;
import javax.imageio.ImageIO;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadImage extends Image {
    Time time=new Time();
	public ReadImage() throws InterruptedException {
	}

    public void  ReadFromFile(String s )  {
        synchronized(this) {
    	time.setStartTime(System.nanoTime());
        try {									//Se creeaza alt fisier cu pathul s
            File input = new File(s);
            this.image = ImageIO.read(input);				//Se citeste imaginea 
            this.width = (double) this.image.getWidth();	//Se preiau datele din imagine
            this.height = (double) this.image.getHeight();
        } catch (IOException var8) {
            System.out.println("Fisierul nu exista.");
            System.exit(0);
        }
       time.printTimeCitireFisier();				//Afisare timp citire
       }
    }

    public String OpenFile() {
    	synchronized(this) {
    	String filePath=null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            System.out.println("Numele imaginii (nume.bmp):"); //imaginea ce urmeaza a fi prelucrata

            for (filePath = br.readLine().toString(); !filePath.endsWith(".bmp"); filePath = br.readLine().toString()) {
                System.out.println("Fisierul nu are extensia potrivita. Introduceti un fisier cu extensia .bmp.");
            }								
            								//Fisierul citeste informatia pana cand numele este
            								//se termina cu extensia potrivita
        } catch (IOException var8) {
            System.out.println("Nu s-a realizat citirea in mod corect");
        }
        return "src\\"+filePath;
    	}
    }
}
