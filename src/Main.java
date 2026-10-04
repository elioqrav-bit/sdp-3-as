import bridge.Circle;
import bridge.RasterRenderer;
import bridge.Renderer;
import bridge.Shape;
import bridge.Square;
import bridge.VectorRenderer;

/** Client: runs the demonstration checks. */
public class Main {

    private static final int CIRCLE_RADIUS = 2;
    private static final int SQUARE_SIDE = 3;

    private static int passed = 0;
    private static int total = 0;

    public static void main(String[] args) {
        if (args.length == 1 && args[0].equals("--demo")) {
            runDemo();
        } else {
            System.out.println("Usage: java -cp out Main --demo");
        }
    }

    private static void runDemo() {
        checkCombination("T1", newCircle(new VectorRenderer()), new VectorRenderer(),
                "VECTOR circle radius=2");
        checkCombination("T2", newCircle(new RasterRenderer()), new RasterRenderer(),
                "RASTER circle radius=2 [pixel grid]");
        checkCombination("T3", newSquare(new VectorRenderer()), new VectorRenderer(),
                "VECTOR square side=3");
        checkCombination("T4", newSquare(new RasterRenderer()), new RasterRenderer(),
                "RASTER square side=3 [pixel grid]");
        checkRuntimeSwitch();
        printSummary();
    }

    private static Shape newCircle(Renderer renderer) {
        return new Circle("circle-1", CIRCLE_RADIUS, renderer);
    }

    private static Shape newSquare(Renderer renderer) {
        return new Square("square-1", SQUARE_SIDE, renderer);
    }

    /** Runs the real execute() and compares the actual text with the expected text. */
    private static void checkCombination(String checkId, Shape shape, Renderer renderer,
                                         String expected) {
        String actual = shape.execute();
        String classes = shape.getClass().getSimpleName() + " + "
                + renderer.getClass().getSimpleName();
        report(checkId, actual.equals(expected), classes, "result=" + actual, expected);
    }

    /** T5: the same object gets a new implementation at runtime. */
    private static void checkRuntimeSwitch() {
        Shape original = newCircle(new VectorRenderer());
        String idBefore = original.getId();
        int sizeBefore = original.getSize();
        String before = original.execute();

        Shape afterSwitch = switchRenderer(original, new RasterRenderer());
        String after = afterSwitch.execute();

        boolean sameObject = original == afterSwitch;
        boolean stateUnchanged = idBefore.equals(afterSwitch.getId())
                && sizeBefore == afterSwitch.getSize();
        boolean resultsOk = before.equals("VECTOR circle radius=2")
                && after.equals("RASTER circle radius=2 [pixel grid]");
        boolean ok = sameObject && stateUnchanged && resultsOk;

        total++;
        if (ok) {
            passed++;
        }
        System.out.println("T5 " + (ok ? "PASS" : "FAIL")
                + " | Circle: VectorRenderer -> RasterRenderer"
                + " | sameObject=" + sameObject + " | stateUnchanged=" + stateUnchanged);
        System.out.println("   before=" + before + " | after=" + after);
        if (!ok) {
            System.out.println("   expected before=VECTOR circle radius=2"
                    + " | after=RASTER circle radius=2 [pixel grid]");
        }
    }

    private static Shape switchRenderer(Shape shape, Renderer newRenderer) {
        shape.setImplementation(newRenderer);
        return shape;
    }

    private static void report(String checkId, boolean ok, String classes,
                               String details, String expected) {
        total++;
        if (ok) {
            passed++;
        }
        StringBuilder line = new StringBuilder();
        line.append(checkId).append(' ').append(ok ? "PASS" : "FAIL")
                .append(" | ").append(classes).append(" | ").append(details);
        if (!ok) {
            line.append(" | expected=").append(expected);
        }
        System.out.println(line);
    }

    private static void printSummary() {
        System.out.println("SUMMARY: " + passed + "/" + total + " PASS");
    }
}