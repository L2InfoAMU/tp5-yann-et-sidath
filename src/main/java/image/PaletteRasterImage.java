package image;

import javafx.scene.paint.Color;

import java.util.List;

public class PaletteRasterImage implements Image {

    List<Color> colors;
    int width;
    int height;

    public void createRepresentation(){

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
