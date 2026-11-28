import java.util.Scanner;

class ItemNotFoundException extends Exception{
    public ItemNotFoundException(String msg) {
        super(msg);
    }   
}

class MemberNotFoundException extends Exception{
    public MemberNotFoundException(String msg){
        super(msg);
    }
}

class ItemNotAvailableException extends Exception{
    public ItemNotAvailableException(String msg){
        super(msg);
    }
}

class BorrowLimitExceededException extends Exception{
    public BorrowLimitExceededException(String msg){
        super(msg);
    }
}

class ItemNotOnLoanException extends Exception{
    public ItemNotOnLoanException (String msg){
        super(msg);
    }
}

class InvalidIdException extends Exception {
    public InvalidIdException (String msg){
        super(msg);
    }
}

public class Main {
    public static void main(String []args){
        Scanner sc= new Scanner(System.in);
        Library library =new Library();
        while(true){
            String[] cmd= sc.nextLine().trim().split("\\|");
            try {
                switch(cmd[0]){
                    case "ADD_BOOK"->{
                        if(!cmd[1].matches("[B][1-9][0-9]*")){
                            throw new InvalidIdException("invalid id");
                        }
                        library.additem(cmd[1],new Book(cmd[2],cmd[1],cmd[3]));
                    }
                    case "ADD_MAGAZINE"->{
                        if(!cmd[1].matches("[M][1-9][0-9]*")){
                            throw new InvalidIdException("invalid id");
                        }
                        library.additem(cmd[1],new Magazine(cmd[2],cmd[1],cmd[3]));
                    }
                    case "ADD_REFERENCE"->{
                        if(!cmd[1].matches("[R][1-9][0-9]*")){
                            throw new InvalidIdException("invalid id");
                        }
                        library.additem(cmd[1],new ReferenceBook(cmd[2],cmd[1],cmd[3]));
                    }
                    case "ADD_MEMEBER"->{
                        
                    }
                    case "BORROW"->{
                        
                    }
                    case "RETURN"->{}
                    case "SEARCH"->{}
                    case "LOANS"->{}
                    case "OVERDUE"->{}
                    case "INVENTORY"->{
                        library.showinventory();
                    }
                    case "EXIT"->{ return ;}
                    default ->{}

                }
            }
            catch(InvalidIdException e){
                System.out.println("Not a vaild id");
            }
            catch(Exception e){

            }

        }
    }

}
