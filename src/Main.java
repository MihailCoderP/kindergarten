import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Child {
    private String fullName;
    private String gender;
    private int age;

    public Child(String fullName, String gender, int age) {
        this.fullName = fullName;
        this.gender = gender;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}

class Group {
    private String name;
    private int number;
    private List<Child> children;

    public Group(String name, int number) {
        this.name = name;
        this.number = number;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public List<Child> getChildren() {
        return children;
    }
}

public class Main {
    private Map<Integer, Group> groups;
    private Map<String, Child> children;

    public Main() {
        this.groups = new HashMap<>();
        this.children = new HashMap<>();
    }

    public void addGroup(String name, int number) {
        Group group = new Group(name, number);
        groups.put(number, group);
        System.out.println("Group added: " + group.getName() + ", Number: " + group.getNumber());
    }

    public void removeGroup(int number) {
        if (groups.containsKey(number)) {
            groups.remove(number);
            System.out.println("Group removed successfully.");
        } else {
            System.out.println("Group not found.");
        }
    }

    public void addChild(String fullName, String gender, int age, int groupNumber) {
        Child child = new Child(fullName, gender, age);
        children.put(fullName, child);

        if (groups.containsKey(groupNumber)) {
            groups.get(groupNumber).getChildren().add(child);
            System.out.println("Child added to group " + groupNumber + ": " + child.getFullName());
        } else {
            System.out.println("Group not found. Child not added.");
        }
    }

    public void removeChild(String fullName) {
        if (children.containsKey(fullName)) {
            Child child = children.get(fullName);
            for (Group group : groups.values()) {
                if (group.getChildren().contains(child)) {
                    group.getChildren().remove(child);
                    break;
                }
            }
            children.remove(fullName);
            System.out.println("Child removed successfully: " + fullName);
        } else {
            System.out.println("Child not found.");
        }
    }

    public void displayGroupInfo(int groupNumber) {
        if (groups.containsKey(groupNumber)) {
            Group group = groups.get(groupNumber);
            System.out.println("Group: " + group.getName() + ", Number: " + group.getNumber());
            System.out.println("Children in the group:");
            for (Child child : group.getChildren()) {
                System.out.println("- " + child.getFullName() + " (" + child.getGender() + ", Age: " + child.getAge() + ")");
            }
        } else {
            System.out.println("Group not found.");
        }
    }

    public static void main(String[] args) {
        Main childCareSystem = new Main();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChild Care System Menu:");
            System.out.println("1. Add Group");
            System.out.println("2. Remove Group");
            System.out.println("3. Add Child");
            System.out.println("4. Remove Child");
            System.out.println("5. Display Group Info");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Group Name: ");
                    String groupName = scanner.nextLine();
                    System.out.print("Enter Group Number: ");
                    int groupNumber = scanner.nextInt();
                    childCareSystem.addGroup(groupName, groupNumber);
                    break;

                case 2:
                    System.out.print("Enter Group Number to Remove: ");
                    int removeGroupNumber = scanner.nextInt();
                    childCareSystem.removeGroup(removeGroupNumber);
                    break;

                case 3:
                    System.out.print("Enter Child's Full Name: ");
                    String childName = scanner.nextLine();
                    System.out.print("Enter Child's Gender: ");
                    String childGender = scanner.nextLine();
                    System.out.print("Enter Child's Age: ");
                    int childAge = scanner.nextInt();
                    System.out.print("Enter Group Number to Add Child: ");
                    int addChildToGroup = scanner.nextInt();
                    childCareSystem.addChild(childName, childGender, childAge, addChildToGroup);
                    break;

                case 4:
                    System.out.print("Enter Child's Full Name to Remove: ");
                    String removeChildName = scanner.nextLine();
                    childCareSystem.removeChild(removeChildName);
                    break;

                case 5:
                    System.out.print("Enter Group Number to Display Info: ");
                    int displayGroupInfoNumber = scanner.nextInt();
                    childCareSystem.displayGroupInfo(displayGroupInfoNumber);
                    break;

                case 6:
                    System.out.println("Exiting Child Care System. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
