import java.util.*;

public abstract class Members{
private String name;
private String id;
private List<String> borroweditems =new ArrayList<>();
protected Members(String name,String id){
    this.name=name;
    this.id=id;
}
public abstract int getmaxitems();
public abstract int getloanperiod();
public void Borrow(String item_id){
//put the id item in the list ,add the member to the item object..,handle exception here  use the id from the object
}
public void Return(String item_id){
//the handling of this part will be covered in the return part of the item this part just remove the id form the borrowed list
}

public void showloans(){
//traverses the list and using the itemid prints the title and duedate,dont forget to sort accordingly
}
public String getid(){
    return this.id;
}
}
