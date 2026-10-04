# Assignment 3 - Bridge Pattern

- **Name:** Sissenbay Rassul
- **Group:** se2538
- **Topic:** A - Drawing (Shape / Renderer)
- **Repository:** https://github.com/elioqrav-bit/sdp-3-as
- **Base commit (working I1/I2 version):** `86a3a76788a99a5493a030d2475002c3145bb802`
- **Extension commit (I3):** `9caebd0149cc8e01c73a8fcdd991f95a3384de6c`

## Role map

| Role | Class | Path |
|---|---|---|
| Abstraction | `Shape` | src/bridge/Shape.java |
| A1 | `Circle` (radius 2) | src/bridge/Circle.java |
| A2 | `Square` (side 3) | src/bridge/Square.java |
| Implementor | `Renderer` | src/bridge/Renderer.java |
| I1 | `VectorRenderer` | src/bridge/VectorRenderer.java |
| I2 | `RasterRenderer` | src/bridge/RasterRenderer.java |
| I3 (extension) | `AsciiRenderer` | src/bridge/AsciiRenderer.java |
| Client | `Main` | src/Main.java |

## Where to look

- **Bridge field:** `private Renderer renderer;` in `Shape`, set through the constructor
- **execute():** `Shape.execute()` calls `draw(renderer)`, then `Circle.draw` / `Square.draw` call `renderer.drawCircle(...)` / `renderer.drawSquare(...)`
- **setImplementation(...):** `Shape.setImplementation(Renderer)`
- **T5 check:** `Main.checkRuntimeSwitch()`

## Commands

    javac --release 17 -encoding UTF-8 -d out "@sources.txt"
    java -cp out Main --demo

## Expected results

    T1 PASS | Circle + VectorRenderer | result=VECTOR circle radius=2
    T2 PASS | Circle + RasterRenderer | result=RASTER circle radius=2 [pixel grid]
    T3 PASS | Square + VectorRenderer | result=VECTOR square side=3
    T4 PASS | Square + RasterRenderer | result=RASTER square side=3 [pixel grid]
    T5 PASS | Circle: VectorRenderer -> RasterRenderer | sameObject=true | stateUnchanged=true
       before=VECTOR circle radius=2 | after=RASTER circle radius=2 [pixel grid]
    T6 PASS | Circle + AsciiRenderer | result=ASCII circle radius=2 ( o )
    T7 PASS | Square + AsciiRenderer | result=ASCII square side=3 [###]
    SUMMARY: 7/7 PASS

## Extension

`git diff 86a3a76788a99a5493a030d2475002c3145bb802 HEAD -- src > extension.diff`
Only `src/Main.java` and `src/bridge/AsciiRenderer.java` changed.