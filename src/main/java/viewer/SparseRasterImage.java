package viewer;

import image.Point;
import image.RasterImage;
import javafx.scene.paint.Color;

import java.util.HashMap;


public class SparseRasterImage extends RasterImage {

    HashMap<Point,Color> colors;


    public SparseRasterImage(Color color, int width, int height){
        super(width, height);
        createRepresentation();
    }

    public  SparseRasterImage(Color[][] pixels){
        super(pixels);
        createRepresentation();
    }

    public void createRepresentation(){
        this.colors = new HashMap<>();
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return null;
    }

}
