public class lab9es5Triangolo implements Poligono
{
    private int a;
    private int b;
    private int c;

    public lab9es5Triangolo(int a, int b, int c){
        if(a>b){
            int temp =a;
            a=b;
            b=temp;
        }
        if(b>c){
            int temp =b;
            b=c;
            c=temp;
        }
        if(a>b){
            int temp =a;
            a=b;
            b=temp;
        }
        if(c>a+b) throw new IllegalArgumentException();
        this.a=a;
        this.b=b;
        this.c=c;
    }

    public int perimetro(){
        return a+b+c;
    }
    public double area(){
        double p= perimetro()/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    public int compareTo(Object o) {
        if(this.area()<((Poligono) o).area()) return -1;
        if(this.area()==((Poligono) o).area()) return 0;
        return 1;
    }
    public String toString(){
        return ("[T] " +a+ " "+b + " "+ c);
    }
}
