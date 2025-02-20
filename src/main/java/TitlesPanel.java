import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import javax.swing.*;

/**
 * The {@code TitlesPanel} class generates user interface graphical panel.
 * It extends {@link JPanel} and implements {@link ActionListener}.
 *
 *<p>It draws a {@code ShapeFactory}.</p>
 *
 * @author VladKozhushko
 *
 * @version 1.0
 */
public class TitlesPanel extends JPanel implements ActionListener {
    /**
    * Redraw indicator.
    */
   private boolean isDone = true;
   /**
    * Rotation angle of shape.
    */
   private int startAngle = 0;
   /**
    * Contains shape form.
    */
   private final int shapeForm;
   /**
    * Contains shape color.
    */
   private final int shapeColor;

   /**
    * Constructs {@code TitlesPanel} generate user interface.
    *
    * @param shapeForm argument which defines generation shapes form.
    * @param shapeColor argument which defines generation shapes color.
    *
    */
   //Constructor that generates user interface
   public TitlesPanel(int shapeForm, int shapeColor) {
      this.shapeForm = shapeForm;
      this.shapeColor = shapeColor;
      Timer animation = new Timer(50, this);
      animation.setInitialDelay(50);
      animation.start();
   }

   /**
    * Method that catches all changes.
    * @param arg0 (not use).
    */
   //Method that catches all changes
   public void actionPerformed(ActionEvent arg0) {
      if (this.isDone) {
         this.repaint();
      }
   }

   /**
    * Main drawing method which draw draw various geometric shapes.
    * @param g UI panel graphic.
    */
   //Method that draw various geometric shapes
   private void doDrawing(Graphics g) {
      this.isDone = false;
      Graphics2D g2d = (Graphics2D)g;
      g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      Dimension size = this.getSize();
      Insets insets = this.getInsets();
      int w = size.width - insets.left - insets.right;
      int h = size.height - insets.top - insets.bottom;
      ShapeFactory shape = new ShapeFactory(this.shapeForm, shapeColor);
      g2d.setStroke(shape.getStroke());
      g2d.setPaint(shape.getPaint());
      double angle = this.startAngle++;
      if (this.startAngle > 360) {
         this.startAngle = 0;
      }

      double dr = 90.0D / (w / (shape.getWidth() * 1.5D));

      for(int j = shape.getHeight(); j < h; j += (int)(shape.getHeight() * 1.5D)) {
         for(int i = shape.getWidth(); i < w; i += (int)(shape.getWidth() * 1.5D)) {
            angle = angle > 360.0D ? 0.0D : angle + dr;
            AffineTransform transform = new AffineTransform();
            transform.translate(i, j);
            transform.rotate(Math.toRadians(angle));
            g2d.draw(transform.createTransformedShape(shape.getShape()));
         }
      }

      this.isDone = true;
   }

   /**
    * Method which starts drawing process.
    * @param g graphic which transmitted to {@code doDrawing} method.
    */
   //Method starts drawing
   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      this.doDrawing(g);
   }
}
