import java.awt.*;

public class Ball {
    private int x, y;
    private final int Diameter =60;
    private final int SPEED = 10;
    double dx = SPEED, dy = SPEED;
    Board board;

    public Ball(Board board){
        x = 0;
        y = 0;
//        'this' <--- That keyword references the object that is executing to calling the this reference
        this.board = board;
    }
    public void move(){


        //LEF AND RIGHT
        if (x <= 0 || x + Diameter >= board.getWidth()){
            dx*=-1;
        }
        if(y <= 0 || y + Diameter >= board.getHeight()){
            dy*=-1;
        }

        x+=dx;
        y+=dy;
    }

    public void setPosition(int x, int y){
        this.x = x - Diameter/2;
        this.y = y - Diameter/2;
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, Diameter, Diameter);
    }
    double MAXANGLE = 5*Math.PI/12;//70 degree
    public void checkCollisions(Paddle other){
        if(getBounds().intersects(other.getBounds())){
         double paddleY = other.getBounds().getY();
         double paddleC = other.getBounds().getHeight()/2;
         double bally = y;

         double relativeInteresect = (paddleY + paddleC) - bally;
         double normalInteresect = relativeInteresect/paddleC;
         double bounceAngle  = MAXANGLE + normalInteresect;



        }
    }

    public void paint(Graphics g){
        g.fillOval(x,y,Diameter,Diameter);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public  int getDiameter(){
        return Diameter;
    }

}
