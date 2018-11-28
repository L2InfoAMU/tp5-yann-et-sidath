package image;

import javafx.scene.paint.Color;

import static util.Matrices.*;

public class BruteRasterImage implements Image {

    private int width;
    private int height;
    private Pixel[][] pixels;

    /**
     * Creates a monochromatic image of given size.
     *
     * @param color the color of the image
     * @param height the height of the image
     * @param width the width of the image
     */
    public BruteRasterImage(Color color, int width, int height){
        this.width = width;
        this.height = height;
        for(int x=0; x<this.getHeight(); x++){
            for(int y=0; y<this.getWidth(); y++){
                pixels[x][y]= new Pixel(x,y,color);
            }
        }
    }

    /**
     * Creates an image from a given matrix.
     * @param colors the matrix from which the image is created
     * @throws IllegalArgumentException if the matrix is not rectangular or if it has an empty row or column
     * @throws NullPointerException if the matrix has null parts
     */

    public BruteRasterImage(Color[][] colors){
        requiresNonNull(colors);
        requiresNonZeroDimensions(colors);
        requiresRectangularMatrix(colors);
        this.height = colors.length;
        this.width = colors[0].length;
        for(int x=0; x<this.getHeight(); x++){
            for(int y=0; y<this.getWidth(); y++){
                pixels[x][y]= new Pixel(x,y,colors[x][y]);
            }
        }
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

    /**
     * Allows to change the width of the image
     * @param width the new width of the image
     */
    protected void setWidth(int width){
        this.width= width;
    }

    /**
     * Allows to change the height of the image.
     * @param height the new height of the image
     */
    protected void setHeight(int height){
        this.height= height;
    }
}
