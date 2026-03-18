import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main
{
    public static List<Integer> brojevi;

    public static boolean foundNum=false;
    public static Integer foundIndex=0;

    public static void main(String[] args) throws InterruptedException {
        Random gen=new Random();
        brojevi=new ArrayList<>(100000000);
        for(int i=0;i<100000000;i++){
            brojevi.add(gen.nextInt(0,100001));
        }
        List<Thread> niti=new ArrayList<>();
        Integer searchedForNum=21;
        for(int i=0;i<16;i++){
            Integer startIndex=i*(brojevi.size()/16);
            Integer endIndex=(i+1)*(brojevi.size()/16)-1;
            Thread nit=new Thread(new Searcher(startIndex,endIndex,searchedForNum));
            niti.add(nit);
            niti.get(i).start();
        }
        for(Thread t : niti){
            t.join();
            if(foundNum) break;
        }
        System.out.println("Found index:"+ foundIndex + "Num: " + brojevi.get(foundIndex));
    }
}
