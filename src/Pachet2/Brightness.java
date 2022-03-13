package Pachet2;

import java.awt.image.BufferedImage;

public class Brightness extends ReadImage{
    ReadImage imgob = new ReadImage();			
    Time timeConversie=new Time();
    Time timeDeschidere=new Time();
    private double bHeight;
    private double bWidth;
    private BufferedImage brightenedImage;
    private String filePath; 

    public Brightness() throws InterruptedException {

    }
    public BufferedImage ConvertToBrightened()  {
    							
    	synchronized(this) {
    	timeConversie.setStartTime(System.nanoTime());

    											//Se modifica parametrii pozei 
        for(int y = 0; (double)y < this.bHeight; ++y) {   
            for(int x = 0; (double)x < this.bWidth; ++x) {
                int pixel = this.brightenedImage.getRGB(x, y);
                int alpha = pixel >> 24 & 255;
                int red = pixel >> 16 & 255;
                int green = pixel >> 8 & 255;
                int blue = pixel & 255;
                red = Math.min(255, red + 63);
                green = Math.min(255, green + 63);
                blue = Math.min(255, blue + 63);
                int newPixel = alpha << 24 | red << 16 | green << 8 | blue;
                this.brightenedImage.setRGB(x, y, newPixel);
            }
        }
        										//Se afiseaza timpul de conversie
        this.timeConversie.printTimeConversie();
        return this.brightenedImage;    		//poza prelucrata
    	}
    }	
    					//metode de get si set:
    public void setHeight(double height) {
    	this.bHeight=height;
    }
    public void setWidth(double width) {
    	this.bWidth=width;
    }
    public void setBufferedImage(BufferedImage brightenedImageVal) {
    	this.brightenedImage=brightenedImageVal;
    }
    public void setFilePath(String path) {
    	this.filePath=path;
    }
    public String getFilePath() {
    	return this.filePath;
    }
    
}
