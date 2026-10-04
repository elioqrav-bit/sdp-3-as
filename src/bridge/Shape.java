package bridge;

import java.util.Objects;

/**
 * Abstraction: owns the identity and domain data of a shape and
 * delegates all drawing to the Renderer it is bridged to.
 */
public abstract class Shape {

    private final String id;
    private Renderer renderer; // the bridge: interface-typed, never a concrete class

    protected Shape(String id, Renderer renderer) {
        this.id = Objects.requireNonNull(id, "id");
        this.renderer = Objects.requireNonNull(renderer, "renderer");
    }

    public String getId() {
        return id;
    }

    /** Domain data: radius for a circle, side length for a square. */
    public abstract int getSize();

    /** Replaces the implementation on this very object; id and size stay untouched. */
    public void setImplementation(Renderer renderer) {
        this.renderer = Objects.requireNonNull(renderer, "renderer");
    }

    public String execute() {
        return draw(renderer);
    }

    /** Refined abstractions decide WHICH low-level operation to call. */
    protected abstract String draw(Renderer renderer);
}