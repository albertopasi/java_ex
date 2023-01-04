public class StringArrayTester {
    public static void main(String[] args){
        String[]  array = {"sangennaro","agamennone","leonardo","protuberanza", "fisiologicamente", "peppapig", "barbie", "magivheavventure" };
        StringArrayAlgs.iterMerge(array, array.length);
        System.out.println(StringArrayAlgs.printArray(array, array.length));

    }
}
