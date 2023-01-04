public class QuadraticEquation
{  private double a;
   private double b;
   private double c;

  /*
      Costruttore: riceve i coefficienti a, b, c dell'equazione quadratica
      e inizializza i campi di esemplare secondo i valori ricevuti
  */
  public QuadraticEquation(double acoeff, double bcoeff, double ccoeff)
  {
    a=acoeff;
    b=bcoeff;
    c=ccoeff;
  }



  /*
      Restituisce la prima delle due soluzioni dell'equazione quadratica,
      usando la ben nota formula...
  */
  public double getSolution1()
  {
    return ((-b + Math.sqrt(b*b - 4*a*c))/2*a);
  }


  /*
      Restituisce la seconda delle due soluzioni dell'equazione quadratica,
      usando la ben nota formula...
  */
  public double getSolution2()
  {
    return ((-b - Math.sqrt(b*b - 4*a*c))/2*a);
  }



  /*
      Restituisce il valore false se l'equazione non ha soluzioni
      (ovvero se il discriminante e` negativo)
  */
  public int hasSolutions()
  {
	  if(a!=0 && (b*b - 4*a*c)>=0){
      return 2;
    }else if((a!=0 && (b*b - 4*a*c)<0) || ((a==b && b==0) && c!=0)){
      return 0;
    }else if(a==0 && b!=0){
      return 1;
    }else{
        return 3; /*if(a==b && b==c && c==0){ */
    }
    
  
  }
  public double nonQuadraticSolution(){
    return (-c)/b;
  }
  public double getA(){
    return a;
  }
  public double getB(){
    return b;
  }
  public double getC(){
    return c;
  }

  //... campi di esemplare... da completare
  //...

}
