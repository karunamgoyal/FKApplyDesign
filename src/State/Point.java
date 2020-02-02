package src.State;
//Class For Managing Move
public class Point{
    private Integer x,y;

    public Point(){
        x=0;
        y=0;
    }
    public Point(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }
    public void printPoint(){
        System.out.println("X "+ x);
        System.out.println("Y "+ y);
    }
    public Integer getX(){
        return x;
    }
    public Integer getY(){
        return y;
    }

}