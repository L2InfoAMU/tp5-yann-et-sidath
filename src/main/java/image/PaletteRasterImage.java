package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import static util.Matrices.*;

public class PaletteRasterImage implements Image {

    List<Color> colors;
    int[][] pixels;
    int width;
    int height;

    /**
     * Allocate the matrix representing the image.
     */

    public void createRepresentation(){
        this.colors = new ArrayList<>();
        this.pixels = new int[this.getWidth()][this.getHeight()];
    }

    /**
     * Creates a monochromatic image of given size.
     * @param color the color of the image
     * @param width the width of the image
     * @param height the height of the image
     */

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

    /**
     * Creates an image from a matrix
     * @param colors the matrix used to create the image
     */
    public PaletteRasterImage(Color[][] colors){
        requiresNonNull(colors);
        requiresNonZeroDimensions(colors);
        requiresRectangularMatrix(colors);
        this.width = colors.length;
        this.height = colors[0].length;
        createRepresentation();
        for (int x =0; x < this.getWidth(); x++){
            for (int y = 0; y< this.getHeight(); y++){
                if (!this.colors.contains(colors[x][y])){
                    this.colors.add(colors[x][y]);
                }
                pixels[x][y] = this.colors.indexOf(colors[x][y]);
            }
        }
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return colors.get(pixels[x][y]);
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
