public class Faculty extends Members {
    public Faculty(String name,String id){
        super(name,id);
    }
    @Override
    public  int getmaxitems(){
        return 5;
    }
    @Override 
    public int getloanperiod(){
        return 30;
    }
}
