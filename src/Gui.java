import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Gui extends JFrame {

    int felderanzahl = 10;
    int feldergroeße = 150;
    int felderabstand = 20;

    Feld[][] spielfeldspieler1 = new Feld[felderanzahl][felderanzahl];

    public Gui(String title){
        super(title);         // Konstruktor der Mutterklasse JFrame

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        int frameWidth = felderanzahl*feldergröße + (felderanzahl+2)*felderabstand;
        int frameHeight = frameWidth+200;
        setSize(frameWidth, frameHeight);

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);

        setResizable(false);

        Container cp = getContentPane();
        cp.setLayout(null);
        for (y=0; y<felderanzahl; y++){
            for (x=0;x<felderanzahl;x++){
              Feld feld = new Feld();
              int feldx = felderabstand +(feldergröße+felderabstand)*x;
                int feldy = felderabstand +(feldergröße+felderabstand)*y;
                feld.setLocation(feldx,feldy);
                feld.setSize(feldergröße,feldergröße);
                cp.add(feld);

                felder[x][y] = feld;

                MouseListener mousAdapter = new PMousListener(x,y);
            }
        }
        setVisible(true);
    }

    private class PMousListener extends MouseAdapter {
        private int x,y;

        public PMousAdapter(int x,int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public void mousPressed(MouseEvent e){
            System.out.println("feld["+x+","+y+"] clicked");
    }

    public static main(String[] args){
            new Gui("Schiffeversenken");
    }
}
