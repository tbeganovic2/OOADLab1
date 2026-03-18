public class Searcher extends Thread{
    private Integer start;
    private Integer end;
    private Integer search;
    public Searcher(Integer startIndex, Integer endIndex,Integer searchingFor){
        start=startIndex;
        end=endIndex;
        search=searchingFor;
    }
    public void run(){
        for (Integer i = start; i < end; i++) {
            if (Main.brojevi.get(i).equals(search)) {
                    Main.foundNum=true;
                    Main.foundIndex=i;
                    return;
            }
        }
    }
}
