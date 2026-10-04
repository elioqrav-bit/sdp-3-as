package bridge;

/** I2: describes shapes as a pixel grid (bitmap). */
public class RasterRenderer implements Renderer {

    private static final String PREFIX = "RASTER";
    private static final String SUFFIX = " [pixel grid]";

    @Override
    public String drawCircle(int radius) {
        return PREFIX + " circle radius=" + radius + SUFFIX;
    }

    @Override
    public String drawSquare(int side) {
        return PREFIX + " square side=" + side + SUFFIX;
    }
}