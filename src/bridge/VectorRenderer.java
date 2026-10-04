package bridge;

/** I1: describes shapes as resolution-independent vector primitives. */
public class VectorRenderer implements Renderer {

    private static final String PREFIX = "VECTOR";

    @Override
    public String drawCircle(int radius) {
        return PREFIX + " circle radius=" + radius;
    }

    @Override
    public String drawSquare(int side) {
        return PREFIX + " square side=" + side;
    }
}