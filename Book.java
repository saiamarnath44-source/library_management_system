public class Book extends Libraryitem implements Borrowable{
    private String author;
    private int takenday=0;
    private Boolean isavailable=true;
    private  String id_mem= "" ;
    public Book(String title ,String id,String author){
        super(title, id);
        this.author=author;
    }
    @Override 
    public int getfine(){
        return 2;
    }
    @Override 
    public int gettotalfine(){
        int topay=0;
        //take the current day  and the value from the dueday form this calculate the dayslate*price =fine if condition if current day<dueday
        return topay;
    }
    @Override 
    public void getstatus(){
        //checks the availability then prints accordingly
    }
    public int getdueday(){
        //ckecks the loan period form the member id related to this item 
        return 0;
    }
    public void isborrowed(String mem_id){
        //this method will be called from the borrw of the member object this will have to store the day it is borrowed and the id of the member and chage the availability use the ids form the object
    }
    public void isreturned(){
        // change the availability,call  the return of the member form here ,get the fine to pay from gettotalfine then print  ,then change the day and the member to null 
    } 
}