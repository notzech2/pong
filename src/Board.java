
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel implements ActionListener {
    final  int WIDTH = 800;
    final int HEIGHT = 600;
private final int EDGESPACE = 50;
private final int DECORIZE =25;
int pScore = 0, cScore =0;

    Paddle pPaddle;
    Paddle cPaddle;
    Ball bBall;
    Timer timer;
    Game game;



    public Board(Game game){

        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setBackground(Color.pink);

        pPaddle = new Paddle(this,this.game);
        cPaddle = new Paddle(this,this.game);
        bBall = new Ball(this);

    }

    public void init(){
        bBall.setPosition(WIDTH/2,HEIGHT/2);
        pPaddle.setPosition(EDGESPACE,HEIGHT/2);
        cPaddle.setPosition(WIDTH - EDGESPACE,HEIGHT/2);
        timer = new Timer(1000/60, this);
        timer.start();
    }



    public void paintComponent(Graphics g){
       super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("serif",Font.BOLD,72));
        printSimpleString(Integer.toString(pScore),getWidth()/2, 0,DECORIZE*2,g);
        printSimpleString(Integer.toString(cScore),getWidth()/2, getWidth()/2,DECORIZE*2,g);
        pPaddle.paint(g);
        cPaddle.paint(g);
        bBall.paint(g);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("im running");
        bBall.checkCollisions(cPaddle);
        bBall.checkCollisions(pPaddle);
        bBall.move();
        cPaddle.move(bBall);
        pPaddle.move();
        repaint();
    }

     private void printSimpleString(String s, int width, int Xpos, int YPos, Graphics g){
        int stringLen = (int)g.getFontMetrics().getStringBounds(s,g).getWidth();
        int start = width/2 - stringLen/2;
        g.drawString(s,start + Xpos,YPos);
     }
}
