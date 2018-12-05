package viewer;

import image.RasterImage;
import javafx.scene.paint.Color;

public class SparseRasterImage extends RasterImage {

    public SparseRasterImage(Color color, int width, int height){
        super(width, height);

    }

    public  SparseRasterImage(Color[][] pixels){
        super(pixels);
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return null;
    }
}
