package image;

import javafx.scene.paint.Color;

public class BruteRasterImage implements Image {

    private int width;
    private int height;
    private Pixel[][] pixels;


    public BruteRasterImage(Color color, int width, int height){
        this.width = width;
        this.height = height;
        for(int x=0; x<this.getHeight(); x++){
            for(int y=0; y<this.getWidth(); y++){
                pixels[x][y]= new Pixel(x,y,color);
            }
        }
    }

    public BruteRasterImage(Color[][] colors){

    }

    @Override
    public Color getPixelColor(int x, int y) {
        return pixels[x][y].getColor();
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }
}
