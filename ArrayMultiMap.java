public class ArrayMultiMap implements MultiMap{

   //variabili di esemplare
   protected Pair[] p;
   protected int pSize;
   private final int INIT_SIZE = 1;
   
   //costruttore
   public ArrayMultiMap(){
      p = new Pair[INIT_SIZE];
      makeEmpty();
   }
   
   /**
	Inserisce nel dizionario un’associazione avente 
	chiave uguale a key e valore uguale a value.
	@param key la chiave specificata
	@param value il valore specificato
	@throws IllegalArgumentException se key o value sono null
  */
	public void insert(Object key, Object value){
	   if (key == null || value == null){
         throw new IllegalArgumentException();
      }
      if (pSize == p.length){ 
		   p = resize(p, 2*pSize);
		}   
      // inserisco nuova coppia in fondo e inc. pSize
		p[pSize++] = new Pair(key, value);     
	}

 /**
	Elimina dal dizionario un’associazione di chiave specificata 
	restituendone il valore associato oppure null se non e’ 
	presente nel dizionario.
	@param key la chiave specificata
	@return il valore associato alla chiave key che per primo appare nella multimappa,
	null se la chiave non e' gia' presente
 */
	public Object remove(Object key){
	
	   for (int i = 0; i < pSize; i++){
	      if (p[i].getKey().equals(key)){
	         Object obj = p[i].getValue();
				p[i] = p[pSize-1];
				pSize--; 
				return obj; 
			}
		}
      return null; // non c’e’
	}

/**
	Se il dizionario contiene un’associazione avente 
	chiave uguale a key, restituisce true, 
	altrimenti restituisce false 
	@param key la chiave specificata
	@return uno dei valori associati se la chiave specificata e’ 
		presente (il primo che si incontra), altrimenti null
	*/ 
	public Object find(Object key){
	
	   for (int i = 0; i < pSize; i++){
         if (p[i].getKey().equals(key)){
            return p[i].getValue();
         }
      }   
      return null; // non c’e’
	
	}

	/**
	Se il dizionario contiene una o più associazioni aventi chiave 
	uguale a key, restituisce i valori, altrimenti restituisce un 
	array vuoto 
	@param key la chiave specificata
	@return un array con i valori associati alla chiave specificata, 
	se presente, o un array vuoto se non presente
	*/ 
	public Object[] findAll(Object key){
	   
	   Object[] result = new Object[1];
	   int nelem = 0;
	   for (int i = 0; i < pSize; i++){
         if (p[i].getKey().equals(key)){
            if(nelem == result.length){
               result = resize(result, 2*result.length);
            }
            result[nelem] = p[i].getValue();
            nelem++;
         }
      }
      if(nelem < result.length){
         result = resize(result,nelem);
      }   
      return result; 
	   
	}

	/**
	@return un array contenente le chiavi del 
	dizionario, eventualmente ripetute. Restituisce un
	array vuoto (0 elementi) se il dizionario e’ vuoto 
	*/ 
	public Object[] keys(){
	   Object[] keys = new Object[pSize];
		for(int i=0; i< pSize; i++){
			keys[i] = p[i].getKey();
		}	
		return keys;
	}

	/**
	Se ci sono associazioni di chiave uguale a key, ne 
	restituisce i valori, altrimenti restituisce un 
	array vuoto.
	@param key la chiave specificata 
	@return valori associati alla chiave specificata, 
	se presente, o un array vuoto altrimenti  
	*/ 
	public Object[] removeAll(Object key){
	
	   Object[] result = new Object[1];
	   int nelem = 0;
	   for (int i = 0; i < pSize; i++){
         if (p[i].getKey().equals(key)){
            if(nelem == result.length){
               result = resize(result, 2*result.length);
            }
            result[nelem] = p[i].getValue();
            p[i] = p[pSize-1];
            pSize--;
            i=i-1; //avendo messo in posizione i l'ultima associazione
                   //devo verificare che anche questo non abbia la chiave cercata
            nelem++;
         }
      }
      if(nelem < result.length){
         result = (Pair[])resize(result,nelem);
      }    
      return result; 
	
	}

	// metodi di Container	
	public void makeEmpty(){
	   pSize = 0;
	}	
	public boolean isEmpty(){
	   return (pSize==0);
	}

	//metodi di utilita'
	protected Object[] resize(Object[] oldv, int newsize){
         Object[] newV = new Object[newsize];
         if(newsize<oldv.length){
             System.arraycopy(oldv,0,newV,0,newsize);
         }
         else{
             System.arraycopy(oldv,0,newV,0,oldv.length);
         }    
         return newV;
   }
   
   protected Pair[] resize(Pair[] oldv, int newsize){
         Pair[] newV = new Pair[newsize];
         if(newsize<oldv.length){
             System.arraycopy(oldv,0,newV,0,newsize);
         }
         else{
             System.arraycopy(oldv,0,newV,0,oldv.length);
         }    
         return newV;
   }
   
   public int size(){
      return pSize;
   }
   
   public String toString(){
   
   	   String s ="";
   	   for(int i=0; i<pSize; i++){
   	   	   s+=p[i]+"\n";
   	   }
   	   return s;
   }
	
   //classe interna
	protected class Pair{ 
      private Object key;
      private Object value;
      
      public Pair(Object k, Object v){  
         setKey(k); 
         setValue(v); 
      }
   
      public Object getKey(){  
         return key;
      }
      public Object getValue(){  
         return value;
      }
      public void setKey(Object k){  
         key = k;
      }
      public void setValue(Object v){
         value = v;
      }
      
      public String toString(){
      	  return key+" : "+value;
      }
      
   }

}




interface MultiMap extends Container
{  /**
	Inserisce nel dizionario un’associazione avente 
	chiave uguale a key e valore uguale a value.
	@param key la chiave specificata
	@param value il valore specificato
	@throws IllegalArgumentException se key o value sono null
  */
	void insert(Object key, Object value);

 /**
	Elimina dal dizionario un’associazione di chiave specificata 
	restituendone il valore associato oppure null se non e’ 
	presente nel dizionario.
	@param key la chiave specificata
	@return un valore associato alla chiave specificata, 
	se presente, null altrimenti
 */
	Object remove(Object key);

/**
	Se il dizionario contiene un’associazione avente 
	chiave uguale a key, restituisce true, 
	altrimenti restituisce false 
	@param key la chiave specificata
	@return uno dei valori associati se la chiave specificata e’ 
		presente, altrimenti null
	*/ 
	Object find(Object key);

	/**
	Se il dizionario contiene una o più associazioni aventi chiave 
	uguale a key, restituisce i valori, altrimenti restituisce un 
	array vuoto 
	@param key la chiave specificata
	@return un array con i valori associati alla chiave specificata, 
	se presente, o un array vuoto se non presente
	*/ 
	Object[] findAll(Object key);

	/**
	@return un array contenente le chiavi del 
	dizionario, eventualmente ripetute. Restituisce un
	array vuoto (0 elementi) se il dizionario e’ vuoto 
	*/ 
	Object[] keys();

	/**
	Se ci sono associazioni di chiave uguale a key, ne 
	restituisce i valori, altrimenti restituisce un 
	array vuoto.
	@param key la chiave specificata 
	@return valori associati alla chiave specificata, 
	se presente, o un array vuoto altrimenti  
	*/ 
	Object[] removeAll(Object key);

}

interface Container{
   boolean isEmpty();
   void makeEmpty();

}