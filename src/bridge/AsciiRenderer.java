package bridge;

/** I3: describes shapes as ASCII art; added without touching existing code. */
public class AsciiRenderer implements Renderer {

    private static final String PREFIX = "ASCII";

    @Override
    public String drawCircle(int radius) {
        return PREFIX + " circle radius=" + radius + " ( o )";
    }

    @Override
    public String drawSquare(int side) {
        return PREFIX + " square side=" + side + " [###]";
    }
}