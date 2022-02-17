public class main
{
    //the best test of the world!
    public static void main(String[] args)
    {
        MyHashMap myy = new MyHashMap();
        for (int i = 0; i < 2; i++)
            myy.put(i," value: "+i);
        for (int i = 0; i < myy.size(); i++)
            System.out.println(myy.get(i));
    }
}
