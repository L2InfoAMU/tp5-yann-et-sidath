package image;

import javafx.scene.paint.Color;

public class BruteRasterImage extends RasterImage {

    private int width;
    private int height;
    private Color[][] pixels;

    /**
     * Creates a monochromatic image of given size.
     *
     * @param color the color of the image
     * @param height the height of the image
     * @param width the width of the image
     */
    public BruteRasterImage(Color color, int width, int height){
        super(width, height);
        createRepresentation();
        for(int x=0; x<this.getWidth(); x++){
            for(int y=0; y<this.getHeight(); y++){
                pixels[x][y]= color;
            }
        }
    }

    /**
     * Creates an image from a given matrix.
     *
     * @param colors the matrix from which the image is created
     * @throws IllegalArgumentException if the matrix is not rectangular or if it has an empty row or column
     * @throws NullPointerException if the matrix has null parts
     */

    public BruteRasterImage(Color[][] colors){
        super(colors);
        createRepresentation();
        for(int x=0; x<this.getWidth(); x++){
            for(int y=0; y<this.getHeight(); y++){
                pixels[x][y]= colors[x][y];
            }
        }
    }

    /**
     * Allocate the matrix representing the image
     */
    private void createRepresentation(){
        //TODO: implémenter cette fonction
        this.pixels= new Color[this.getWidth()][this.getHeight()];
    }

    /**
     * Allows to change the color of a given pixel
     *
     * @param color the new color
     * @param x,y the place of the pixel in the image
     */
    public void setPixelColor(int x, int y, Color color){
        pixels[x][y]= color;
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return pixels[x][y];
    }

    /**
     * Allows to change the color of the pixels according to a matrix
     *
     * @param pixels the matrix
     */
    private void setPixelsColor(Color[][] pixels){
        for (int x=0; x<this.getWidth(); x++){
            for (int y=0; y<this.getHeight(); y++){
                this.setPixelColor(x,y,pixels[x][y]);
            }
        }
    }

    /**
     * Allows to change the color of all pixels into one
     *
     * @param color the new color
     */
    private void setPixelsColor(Color color){
        for (int x=0; x<this.getWidth(); x++){
            for (int y=0; y<this.getHeight(); y++){
                this.setPixelColor(x,y,color);
            }
        }
    }


}
