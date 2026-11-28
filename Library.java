
import java.util.*;

public class Library {
private Map<String,Libraryitem> items= new HashMap<>();
private Map<String,Members> members= new HashMap<>();
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
    members.put(mem_id, member);
    System.out.println("OK");

}
public void additem(String item_id,Libraryitem item){
 //add to map
    items.put(item_id, item);
    System.out.println("OK");
}
public void search(String text){
//change the case then travese the map to check the item and give its details ,sort accordingly
}

public void getoverduelist(){
 //sort accordingly ,traverse and print 
}
public void showinventory(){
    //traverse and show ie print accordingly 
    for( String s:items.keySet()){
        
    }
    
}

 public Members get_member(String id) throws MemberNotFoundException{
   for(String s : members.keySet()){
    if(s.equals(id)) return members.get(s);
   }
   throw new MemberNotFoundException("no member with  the given id");
}

public Libraryitem get_item(String id) throws ItemNotFoundException{
    for(String s : items.keySet()){
        if(s.equals(id)) return items.get(s);
    }
    throw new ItemNotFoundException("no item with the given id");
    }
}
