import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.awt.*;

public class ShapeFactoryTest {
    @Test
    public void testShowColor(){
        ShapeFactory factory = new ShapeFactory(38);
        Assertions.assertEquals(Color.red, factory.paint, "Show color must be red");
    }
}
