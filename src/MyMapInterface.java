public interface MyMapInterface<k,v>
{
    //size
    int size();
    //emty?
    boolean isEmty();
    //get element by key
   Object get(Object key);
   //put element
   Object put(Object key, Object value);

   //inner interface
    interface Entry<k,v>
   {
       k getKey();
       v getValue();
   }


}
