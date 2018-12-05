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
     * Creates a monochromatic image of given size.
     *
     * @param color the color of the image
     * @param width the width of the image
     * @param height the height of the image
     */

    public PaletteRasterImage(Color color, int width, int height){
        this.width = width;
        this.height = height;
        createRepresentation();
        this.colors.add(color);
        for (int x=0; x<this.getWidth(); x++){
            for (int y=0; y<this.getHeight(); y++){
                this.pixels[x][y]= this.colors.indexOf(color);
            }
        }
    }

    /**
     * Creates an image from a matrix
     *
     * @param pixels the matrix used to create the image
     */
    public PaletteRasterImage(Color[][] pixels){
        requiresNonNull(pixels);
        requiresNonZeroDimensions(pixels);
        requiresRectangularMatrix(pixels);
        this.width = pixels.length;
        this.height = pixels[0].length;
        createRepresentation();
        for (int x = 0; x < this.getWidth(); x++){
            for (int y = 0; y< this.getHeight(); y++){
                if (!this.colors.contains(pixels[x][y])){
                    this.colors.add(pixels[x][y]);
                }
                this.pixels[x][y] = this.colors.indexOf(pixels[x][y]);
            }
        }
    }

    /**
     * Allocate the matrix representing the image.
     */

    public void createRepresentation(){
        this.colors = new ArrayList<>();
        this.pixels = new int[this.getWidth()][this.getHeight()];
    }

    /**
     * Allows to change the color of a pixel
     *
     * @param color the new color
     * @param x,y the position of the pixel into the image
     */
    public void setPixelColor(Color color, int x, int y){
        if (this.colors.contains(color)){
            this.pixels[x][y] = this.colors.indexOf(color);
        }
        else{
            this.colors.add(color);
            this.pixels[x][y] = this.colors.indexOf(color);
        }
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return colors.get(pixels[x][y]);
    }

    /**
     * Allows to change the colors of the pixels according to a matrix
     *
     * @param pixels the new matrix to use for colors
     */
    public void setPixelsColor(Color[][] pixels){
        for(int x = 0; x< this.getWidth(); x++){
            for (int y = 0; y < this.getHeight(); y++){
                this.setPixelColor(pixels[x][y], x, y);
            }
        }
    }

    /**
     * Allows to change the image into a monochromatic image
     *
     * @param color the color of the new monochromatic image
     */
    private void setPixelsColor(Color color){
        for(int x = 0; x< this.getWidth(); x++){
            for (int y = 0; y < this.getHeight(); y++){
                this.setPixelColor(color, x, y);
            }
        }
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
