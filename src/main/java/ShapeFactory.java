import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D.Double;

/**
 * The {@code ShapeFactory} class which generate various geometric shapes.
 *
 * @author VladKozhushko
 *
 * @version 1.0
 */
public class ShapeFactory {
   /**
    * Shape which will draw.
    */
   private Shape shape;
   /**
    * The thickness of the shape line.
    */
   private BasicStroke stroke = new BasicStroke(3.0F);
   /**
    * Shape color.
    */
   private Paint paint;
   /**
    * Shape width.
    */
   private static final int WIDTH = 25;
   /**
    * Shape height.
    */
   private static final int HEIGHT = 25;

   /**
    * @return current shape.
    */
   public Shape getShape(){
      return shape;
   }

   /**
    * @return current thickness of the shape line.
    */
   public BasicStroke getStroke(){
      return stroke;
   }

   /**
    * @return current shape color.
    */
   public Paint getPaint(){
      return paint;
   }

   /**
    * @return current shape width.
    */
   public int getWidth(){
      return WIDTH;
   }

   /**
    * @return current shape height.
    */
   public int getHeight(){
      return HEIGHT;
   }

   /**
    * Constructs {@code ShapeFactory} generate shapes.
    * It also generates shapes color.
    *
    * @param shapeForm argument which defines generation shapes form.
    * @param shapeColor argument which defines generation shapes color.
    *
    */
   //Constructor that generates various geometric shapes
   public ShapeFactory(int shapeForm, int shapeColor) {
      shapeGenerate(shapeForm);
      setShapeColor(shapeColor);
   }

   /**
    * Method {@code TitlesPanel} generate shape form.
    *
    * @param shapeType argument which defines generation shapes form.
    *
    */
   //Method which generates shape form
   private void shapeGenerate(int shapeType){
      switch(shapeType){
         case 1:
            this.shape = createStar(3, new Point(0, 0), WIDTH / 2.0D, WIDTH / 2.0D);
            break;
         case 3:
            this.shape = createStar(5, new Point(0, 0), WIDTH / 2.0D, WIDTH / 4.0D);
            break;
         case 5:
            this.shape = new Double((-WIDTH) / 2.0D, (-HEIGHT) / 2.0D, WIDTH, HEIGHT);
            break;
         case 7:
            GeneralPath path = new GeneralPath();
            double tmpHeight = Math.sqrt(2.0D) / 2.0D * HEIGHT;
            path.moveTo((-WIDTH / 2D), -tmpHeight);
            path.lineTo(0.0D, -tmpHeight);
            path.lineTo((WIDTH / 2D), tmpHeight);
            path.closePath();
            this.shape = path;
            break;
         case 9:
            this.shape = new java.awt.geom.Arc2D.Double((-WIDTH) / 2.0D, (-HEIGHT) / 2.0D, WIDTH, HEIGHT, 30.0D, 300.0D, Arc2D.PIE);
            break;
         default:
            throw new IllegalArgumentException("Type is unsupported");
      }
   }

   /**
    * Method {@code TitlesPanel} generate shape color.
    *
    * @param shapeColor argument which defines generation shapes color.
    *
    */
   //Method which generates shape color
   private void setShapeColor(int shapeColor){
      switch(shapeColor) {
         case 1:
            this.stroke = new BasicStroke(3.0F);
            break;
         case 3:
            break;
         case 4:
            this.stroke = new BasicStroke(7.0F);
            break;
         case 7:
            this.paint = new GradientPaint(-WIDTH, -HEIGHT, Color.white, WIDTH, HEIGHT, Color.gray, true);
            break;
         case 8:
            this.paint = Color.red;
            break;
         default:
            throw new IllegalArgumentException("Type is unsupported");
      }
   }

   /**
    * Method {@code TitlesPanel} generate user interface.
    *
    * @param arms argument which defines number of angles.
    * @param center argument which defines center of shapes.
    * @param rOuter argument which defines outer`s angles.
    * @param rInner argument which defines inner`s angles.
    */
   //Method for generating a five-pointed star
   private static Shape createStar(int arms, Point center, double rOuter, double rInner) {
      double angle = 3.141592653589793D / arms;
      GeneralPath path = new GeneralPath();

      for(int i = 0; i < 2 * arms; ++i) {
         double r = (i & 1) == 0 ? rOuter : rInner;
         java.awt.geom.Point2D.Double p = new java.awt.geom.Point2D.Double(center.x + Math.cos(i * angle) * r, center.y + Math.sin(i * angle) * r);
         if (i == 0) {
            path.moveTo(p.getX(), p.getY());
         } else {
            path.lineTo(p.getX(), p.getY());
         }
      }

      path.closePath();
      return path;
   }
}