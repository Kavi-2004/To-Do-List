import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();
        ArrayList<Boolean> status = new ArrayList<>();

        while (true) {
            
            System.out.println("\n📋  ----- TO-DO LIST MENU -----");
            System.out.println("1️⃣  Add Task");
            System.out.println("2️⃣  View Tasks");
            System.out.println("3️⃣  Mark Task as ✅ Completed");
            System.out.println("4️⃣  🔍 Search Task");
            System.out.println("5️⃣  🗑️ Delete Task");
            System.out.println("6️⃣  ❌ Exit");
            System.out.print("👉 Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("📝  Enter task description: ");
                String task = scanner.nextLine();
                tasks.add(task);
                status.add(false);  //initially not completed
                System.out.println("✅ Task added!");        }
                
                
            else if (choice == 2) {
                if (tasks.isEmpty()) {
                    System.out.println("📭  No tasks added.");
                } else {
                    System.out.println("\n📋  Your Tasks:");
                    for (int i = 0; i < tasks.size(); i++) {
                        String mark = status.get(i) ? "✅" : "❌";
                        System.out.println((i + 1) + ". " + mark + "  " + tasks.get(i));
                    }
                }

            } else if( choice == 3){
                System.out.print("✔️  Enter task number to mark as completed: ");
                int taskNum = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    if (taskNum >= 1 && taskNum <= tasks.size()) {
                        status.set(taskNum - 1, true);
                        System.out.println("🎉  Task marked as ✅ done!");
                    } else {
                        System.out.println("⚠️  Invalid task number.");
                    }

            }
            else if (choice == 4) {
                System.out.print("🔍  Enter keyword to search: ");
                String searchText = scanner.nextLine().toLowerCase();
                boolean found = false;
                for (int i = 0; i < tasks.size(); i++) {
                     if (tasks.get(i).toLowerCase().contains(searchText)) {
                            String mark = status.get(i) ? "✅" : "❌";
                            System.out.println((i + 1) + ". " + mark + "  " + tasks.get(i));
                            found = true;
                        }
                }
                if (!found) {
                    System.out.println("😕  No matching tasks found.");
                }
                
            } else if (choice == 5) {
                System.out.print("🗑️  Enter task number to delete: ");
                int index = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                if (index > 0 && index <= tasks.size()) {
                    tasks.remove(index - 1);
                    status.remove(index - 1); // Also remove the status
                    System.out.println("🧹  Task deleted!");

                } else {
                    System.out.println("⚠️ Invalid task number.");
                }

            } else if (choice == 6) {
                System.out.println("👋  Exiting... Bye!");
                break;

            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }

        scanner.close();
    }
}
