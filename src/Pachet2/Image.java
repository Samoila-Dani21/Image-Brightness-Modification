package Pachet2;

import java.awt.image.BufferedImage;

public abstract class Image {
						
    double width;
    double height;
    BufferedImage image;

	abstract void ReadFromFile(String s);
	abstract String OpenFile();
    
    Image() {
    }
}
