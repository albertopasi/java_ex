
public class Cerchio
{   private double x;
    private double y;
    private double radius;

   public Cerchio (double a, double b, double raggio)
   {    x = a;
        y=b;
        radius =raggio;
   }

   /*
       Verifica se questo cerchio e il cerchio c sono coincidenti, 
       ovvero se hanno tutti i punti in comune
   */

   public boolean isCoincident(Cerchio c)
   {    return (x == c.x && y==c.y && radius==c.radius);	
   }


   /*
       verifica se questo cerchio e' interno al cerchio c o se
       il cerchio c e' interno a questo cerchio
   */
   public boolean isEncircled(Cerchio c)
   {
        return (this.distanceCentre(c)<(radius-c.radius) || c.distanceCentre(this)<(c.radius-radius));
   }
   private double distanceCentre(Cerchio c)
   {
        return Math.sqrt(Math.pow((x-c.x),2)+Math.pow((y-c.y),2));
   }

   /*
      verifica se questo cerchio e il cerchio c sono esterni, ovvero non
      sono contenuti uno nell'altro e non hanno alcun punto in comune
   */
   public boolean isExternal(Cerchio c)
   {
	 return (this.distanceCentre(c)>(radius+c.radius));
   }
          


   /*
      verifica se questo cerchio e il cerchio c sono secanti, 
      ovvero se hanno almeno un punto in comune.
   */
   public boolean isSecant(Cerchio c)
   {
        return (Math.abs(radius-c.radius)<this.distanceCentre(c) && this.distanceCentre(c)<(radius+c.radius));
   }
          


   /*
      Verifica se questo cerchio e il cerchio c sono tangenti,
      ovvero se hanno un solo punto in comune
   */
   public boolean isTangential(Cerchio c)
   {
        return (this.distanceCentre(c)==Math.abs(radius-c.radius) || this.distanceCentre(c)==(radius+c.radius));
   }

   public String toString()
   {
     return ("Cerchio (" + x + ","+ y + ","  + radius+")");
   }

  //... campi di esemplare... da completare
  //...

}
