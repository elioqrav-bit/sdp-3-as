package bridge;

/**
 * Implementor: low-level drawing operations.
 * Knows nothing about Shape subclasses, only about primitive drawing steps.
 */
public interface Renderer {

    String drawCircle(int radius);

    String drawSquare(int side);
}