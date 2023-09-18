
package universidadulpgrupo61.entidades;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;


public class JDesktopPaneP extends JDesktopPane{
    private BufferedImage img;
    
    public JDesktopPaneP(){
        try {
            img=ImageIO.read(getClass().getResourceAsStream("/universidadulpgrupo61/src/imagenes/ulp.jpg")); 
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    @Override
        public void paint(Graphics g){
            super.paintComponent(g);
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }
    
}
