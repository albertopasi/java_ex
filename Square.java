import java.awt.Rectangle;
public class Square extends Rectangle
{   private int x;
    private int y;
    private int l;

    public Square(int asc, int ord, int lato){
        x=asc;
        y=ord;
        l=lato;
    }

    public int getArea(){
        return l*l;
    }
    
    public void setSize(int width, int height){
        if(width==height) {
            super.setSize(width, width);
        }else{
            throw new IllegalArgumentException();
        }
    }
    public void setSize(int dim){
        l=dim;
    }

    public String toString(){
        return "Square[x=" + x + ",y="+y+",width= "+l+",height="+l+"]";
    }
}
