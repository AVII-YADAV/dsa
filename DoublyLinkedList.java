import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node previous;
}

public class DoublyLinkedList {
    Node START;

    DoublyLinkedList() {
    }

    void addnode() {
        System.out.println("Enter any data");
        Scanner sc2 = new Scanner(System.in);
        int item = sc2.nextInt();
        Node nn = new Node();
        nn.data = item;
        nn.next = null;
        nn.previous = null;
        if (START == null) {
            START = nn;
        } else {
            Node current = START;
            while (current.next != null) {
                current = current.next;
            }
            current.next = nn;
            nn.previous = current;
        }
        System.out.println("Data inserted.");
    }

    void deletenode() 
    {
        if (START==null) 
        {
         System.out.println("List empty");   
        }

        else if (START.next==null && START.previous==null) 
        {
            START=null;
        }
        else
        {
        System.out.println("deleted :"+START.data);
        START=START.next;
        START.previous=null;
        }
    }

    void traverse() {
        if (START == null) {
            System.out.println("List empty");
        } else {
            System.out.println("------Forward mode------");
            for (Node i = START; i != null; i = i.next) {
                System.out.print(i.data + " ");
            }

            System.out.println("\n----Reverse mode----");
            Node end = null;
            for (Node i = START; i != null; i = i.next) {
                end = i;
            }

            while (end != null) {
                System.out.println(end.data);
                end = end.previous;
            }
        }
    }

    void search() 
    {
        if (START == null) 
        {
            System.out.println("List is empty");
            return;
        }
    
        System.out.println("Enter the data to search:");
        Scanner sc = new Scanner(System.in);
        int searchData = sc.nextInt();
    
        Node current = START;
        boolean found = false;
    
        while (current != null) 
        {
            if (current.data == searchData) 
            {
                found = true;
                break;
            }
            current = current.next;
        }
    
        if (found) 
        {
            System.out.println("Data " + searchData + " found in the list.");
        } else 
        {
            System.out.println("Data " + searchData + " not found in the list.");
        }
    }
   

    public static void main(String[] args) {
        DoublyLinkedList obj = new DoublyLinkedList();
        while (true) {
            System.out.println("\nPress 1 for insert");
            System.out.println("Press 2 for delete");
            System.out.println("Press 3 for traverse");
            System.out.println("Press 4 for search");
            System.out.println("Press 5 for Exit");
            System.out.println("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    obj.addnode();
                    break;
                case 2:
                    obj.deletenode();
                    break;
                case 3:
                    obj.traverse();
                    break;
                case 4:
                    obj.search();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }
}
