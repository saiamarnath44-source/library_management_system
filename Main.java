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

public class Main {
    public static void main(String []args){
        Scanner sc= new Scanner(System.in);
        while(true){
            String[] cmd= sc.nextLine().trim().split("\\|");
            try {
                switch(cmd[0]){
                    case "ADD_BOOK"->{}
                    case "ADD_MAGAXINE"->{}
                    case "ADD_REFERENCE"->{}
                    case "ADD_MEMEBER"->{}
                    case "BORROW"->{}
                    case "RETURN"->{}
                    case "SEARCH"->{}
                    case "LOANS"->{}
                    case "OVERDUE"->{}
                    case "INVENTORY"->{}
                    case "EXIT"->{}
                    default ->{}

                }
            }
            catch(Exception e){

            }














        }
    }

}
