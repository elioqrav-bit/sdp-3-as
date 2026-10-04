package bridge;

/** A1: circle defined by its radius. */
public class Circle extends Shape {

    private final int radius;

    public Circle(String id, int radius, Renderer renderer) {
        super(id, renderer);
        this.radius = radius;
    }

    @Override
    public int getSize() {
        return radius;
    }

    @Override
    protected String draw(Renderer renderer) {
        return renderer.drawCircle(radius);
    }
}