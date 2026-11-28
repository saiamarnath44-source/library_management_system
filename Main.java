
import java.util.Scanner;

class ItemNotFoundException extends Exception {

    public String ivd_id;

    public ItemNotFoundException(String msg, String ivd_id) {
        super(msg);
        this.ivd_id = ivd_id;
    }
}

class MemberNotFoundException extends Exception {

    public String ivd_id;

    public MemberNotFoundException(String msg, String ivd_id) {
        super(msg);
        this.ivd_id = ivd_id;
    }
}

class ItemNotAvailableException extends Exception {

    public String na_id;

    public ItemNotAvailableException(String msg, String na_id) {
        super(msg);
        this.na_id = na_id;
    }
}

class BorrowLimitExceededException extends Exception {

    public String ex_id;
    public int max;

    public BorrowLimitExceededException(String msg, String ex_id, int max) {
        super(msg);
        this.ex_id = ex_id;
        this.max = max;
    }
}

class ItemNotOnLoanException extends Exception {

    public ItemNotOnLoanException(String msg) {
        super(msg);
    }
}

class InvalidIdException extends Exception {

    public InvalidIdException(String msg) {
        super(msg);
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        while (sc.hasNextLine()) {
            String[] cmd = sc.nextLine().trim().split("\\|");
            try {
                switch (cmd[0]) {
                    case "ADD_BOOK" -> {
                        if (!cmd[1].matches("[B][1-9][0-9]*")) {
                            throw new InvalidIdException("invalid id");
                        }
                        library.additem(cmd[1], new Book(cmd[2], cmd[1], cmd[3]));
                    }
                    case "ADD_MAGAZINE" -> {
                        if (!cmd[1].matches("[M][1-9][0-9]*")) {
                            throw new InvalidIdException("invalid id");
                        }
                        library.additem(cmd[1], new Magazine(cmd[2], cmd[1], cmd[3]));
                    }
                    case "ADD_REFERENCE" -> {
                        if (!cmd[1].matches("[R][1-9][0-9]*")) {
                            throw new InvalidIdException("invalid id");
                        }
                        library.additem(cmd[1], new ReferenceBook(cmd[2], cmd[1], cmd[3]));
                    }
                    case "ADD_MEMBER" -> {
                        switch (cmd[3]) {
                            case "STUDENT" -> {
                                if (!cmd[1].matches("[S][1-9][0-9]*")) {
                                    throw new InvalidIdException("invalid id");
                                }
                                library.addmember(cmd[1], new Student(cmd[2], cmd[1]));
                            }
                            case "STAFF" -> {
                                if (!cmd[1].matches("[T][1-9][0-9]*")) {
                                    throw new InvalidIdException("invalid id");
                                }
                                library.addmember(cmd[1], new Staff(cmd[2], cmd[1]));
                            }
                            case "FACULTY" -> {
                                if (!cmd[1].matches("[F][1-9][0-9]*")) {
                                    throw new InvalidIdException("invalid id");
                                }
                                library.addmember(cmd[1], new Faculty(cmd[2], cmd[1]));
                            }
                        }
                    }
                    case "BORROW" -> {
                        Members _member = library.get_member(cmd[1]);
                        Libraryitem _item = library.get_item(cmd[2]);
                        _member.Borrow(_item, library);
                    }
                    case "RETURN" -> {
                        Libraryitem _item = library.get_item(cmd[1]);
                        if (!_item.getstatus().startsWith("ON_LOAN")) {
                            throw new ItemNotOnLoanException(cmd[1] + " is not on loan");
                        }
                        if (_item instanceof Book) {
                            ((Book) _item).isreturned();
                        } else {
                            ((Magazine) _item).isreturned();
                        }
                    }
                    case "ADVANCE" -> {
                        library.advancedays(Integer.parseInt(cmd[1]));
                    }
                    case "SEARCH" -> {
                        library.search(cmd[1]);
                    }
                    case "LOANS" -> {
                        Members _member = library.get_member(cmd[1]);
                        _member.showloans(library);
                    }
                    case "OVERDUE" -> {
                        library.getoverduelist();
                    }
                    case "INVENTORY" -> {
                        library.showinventory();
                    }
                    case "EXIT" -> {
                        return;
                    }
                    default -> {
                    }

                }
            } catch (InvalidIdException e) {
                System.out.println("ERROR " + e.getMessage());
            } catch (MemberNotFoundException e) {
                System.out.println("ERROR member " + e.ivd_id + " not found");
            } catch (ItemNotFoundException e) {
                System.out.println("ERROR item " + e.ivd_id + " not found");
            } catch (ItemNotAvailableException e) {
                if (e.getMessage().equals("cannot be borrowed")) {
                    System.out.println("ERROR " + e.na_id + " cannot be borrowed");
                } else {
                    System.out.println("ERROR " + e.na_id + " is on loan");
                }
            } catch (BorrowLimitExceededException e) {
                System.out.println("ERROR " + e.ex_id + " has reached the limit of " + e.max);
            } catch (ItemNotOnLoanException e) {
                System.out.println("ERROR " + e.getMessage());
            } catch (Exception e) {
                System.out.println("ERROR " + e);
            }

        }
    }

}
