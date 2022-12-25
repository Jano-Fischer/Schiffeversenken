import javax.swing.*;
import java.awt.*;

public class Feld extends JComponent {

    public void paintComponent(Graphics g){
        g.drawRect(0,0,this.getWidth()-1,this.getHeight()-1);
    }

}
