
import java.util.*;

public class Data {
private Map<String,Libraryitem> find_item= new HashMap<>();
private Map<String,Members> find_member= new HashMap<>();
private int day=0;
private List<String> duelist=new ArrayList<>(); 
private List<String> borrowed_notdue = new ArrayList<>();
public int getday(){
    return day;
}
public void advancedays(int n){
//add n to days ,and update the overdue list by travesing the borrowed_notdue and checking their over due 
}
public void addmember(String mem_id,Members member){
 //add to map
}
public void additem(String mem_id,Libraryitem item){
 //add to map
}
public void search(String text){
//change the case then travese the map to check the item and give its details ,sort accordingly
}

public void getoverduelist(){
 //sort accordingly ,traverse and print 
}
public void showinventory(){
    //traverse and show ie print accordingly 
}

// public Members get_member(String id){
    
// }

// public Libraryitem get_item(String id){
    
// }
}
