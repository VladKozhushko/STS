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
    * Main UI panel graphics.
    */
   private Graphics2D g2d;
   /**
    * Timer which start redrawing process.
    */
   private Timer animation;
   /**
    * Redraw indicator.
    */
   private boolean is_done = true;
   /**
    * Rotation angle of shape.
    */
   private int start_angle = 0;
   /**
    * Contains shape form and color
    */
   private int shape;

   /**
    * Constructs {@code TitlesPanel} generate user interface.
    *
    * @param _shape argument which defines the type for generation shapes.
    */
   //Constructor that generates user interface
   public TitlesPanel(int _shape) {
      this.shape = _shape;
      (this.animation = new Timer(50, this)).setInitialDelay(50);
      this.animation.start();
   }

   /**
    * Method that catches all changes.
    * @param arg0 (not use).
    */
   //Method that catches all changes
   public void actionPerformed(ActionEvent arg0) {
      if (this.is_done) {
         this.repaint();
      }

   }

   /**
    * Main drawing method which draw draw various geometric shapes.
    * @param g UI panel graphic.
    */
   //Method that draw various geometric shapes
   private void doDrawing(Graphics g) {
      this.is_done = false;
      (this.g2d = (Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      Dimension size = this.getSize();
      Insets insets = this.getInsets();
      int w = size.width - insets.left - insets.right;
      int h = size.height - insets.top - insets.bottom;
      ShapeFactory shape = new ShapeFactory(this.shape);
      this.g2d.setStroke(shape.stroke);
      this.g2d.setPaint(shape.paint);
      double angle = (double)(this.start_angle++);
      if (this.start_angle > 360) {
         this.start_angle = 0;
      }

      double dr = 90.0D / ((double)w / ((double)shape.width * 1.5D));

      for(int j = shape.height; j < h; j += (int)((double)shape.height * 1.5D)) {
         for(int i = shape.width; i < w; i += (int)((double)shape.width * 1.5D)) {
            angle = angle > 360.0D ? 0.0D : angle + dr;
            AffineTransform transform = new AffineTransform();
            transform.translate((double)i, (double)j);
            transform.rotate(Math.toRadians(angle));
            this.g2d.draw(transform.createTransformedShape(shape.shape));
         }
      }

      this.is_done = true;
   }

   /**
    * Method which starts drawing process.
    * @param g graphic which transmitted to {@code doDrawing} method.
    */
   //Method starts drawing
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      this.doDrawing(g);
   }
}
