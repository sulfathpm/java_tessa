import java.util.*;

public class pg17 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int choice;
        ArrayList <String> names=new ArrayList<>();
        while (true) {
            System.out.println("1.add names\n2.remove names\n3.search for a name\n4.sort names\n5.display names.\n0.exit\nchoice?");
            choice=sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("name?");
                    String name=sc.nextLine();
                    names.add(name);
                    break;
                case 2:
                    System.out.println("Enter name to remove?");
                    String rname=sc.nextLine();
                    names.remove(rname);
                    break;
                case 3:
                    System.out.println("Search for a name?");
                    String searchname=sc.nextLine();
                    if(names.contains(searchname))
                        {
                            System.out.println("Name is on the list");
                        }else{
                            System.out.println("Name is not on the list");
                        }
                    break;
                case 4: 
                    Collections.sort(names);
                    System.out.println("Names sorted.");
                    break;
                case 5: 
                if (names.isEmpty()) {
                    System.out.println("List is empty.");
                } else {
                    System.out.println("names   : ");
                    for(String x:names){
                        System.out.println(x);
                    }}
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("invalid choice");
                    break;
            }
        }

    }
}
