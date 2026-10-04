package bridge;

/** A2: square defined by its side length. */
public class Square extends Shape {

    private final int side;

    public Square(String id, int side, Renderer renderer) {
        super(id, renderer);
        this.side = side;
    }

    @Override
    public int getSize() {
        return side;
    }

    @Override
    protected String draw(Renderer renderer) {
        return renderer.drawSquare(side);
    }
}