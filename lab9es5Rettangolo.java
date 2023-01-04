public class lab9es5Rettangolo implements Poligono
{
    private int a;
    private int b;

    public lab9es5Rettangolo(int x1, int x2){
        a=x1;
        b=x2;
    }

    public int perimetro(){
        return (a+b)*2;
    }
    public double area(){
        return a*b;
    }

    public int compareTo(Object o) {
        if(this.area()<((Poligono) o).area()) return -1;
        if(this.area()==((Poligono) o).area()) return 0;
        return 1;
    }
    public String toString(){
        return ("[R] " +a+ " " +b);
    }
}