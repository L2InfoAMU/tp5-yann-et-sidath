package image;

import javafx.scene.paint.Color;

import static util.Matrices.*;


public abstract class RasterImage implements Image {

    int width;
    int height;

    public RasterImage(int width, int height){
        this.width = width;
        this.height = height;
    }

    public RasterImage(Color[][] pixels){
        requiresNonNull(pixels);
        requiresNonZeroDimensions(pixels);
        requiresRectangularMatrix(pixels);
        this.width = pixels.length;
        this.height = pixels[0].length;
    }


    @Override
    public abstract Color getPixelColor(int x, int y);

    @Override
    public  int getWidth() {
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
