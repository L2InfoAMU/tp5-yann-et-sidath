package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage implements Image {

    List<Color> colors;
    int[][] pixels;
    int width;
    int height;

    public void createRepresentation(){
        this.colors = new ArrayList<>();
        this.pixels = new int[this.getWidth()][this.getHeight()];
    }

    public PaletteRasterImage(Color color, int width, int height){
        this.width = width;
        this.height = height;
        createRepresentation();
        colors.add(color);
        for (int x=0; x<this.getWidth(); x++){
            for (int y=0; y<this.getHeight(); y++){
                pixels[x][y]= colors.indexOf(color);
            }
        }
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return null;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    /**
     * Allows to change the width of the image
     *
     * @param width the new width of the image
     */
    protected void setWidth(int width){
        this.width= width;
    }

    /**
     * Allows to change the height of the image.
     *
     * @param height the new height of the image
     */
    protected void setHeight(int height){
        this.height= height;
    }
}
