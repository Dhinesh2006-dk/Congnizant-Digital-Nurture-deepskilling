public class TaskManagement {

    Task head = null;

    // Add Task
    public void addTask(int id,
                        String name,
                        String status) {

        Task newTask =
                new Task(id, name, status);

        if(head == null) {

            head = newTask;
            return;
        }

        Task current = head;

        while(current.next != null) {

            current = current.next;
        }

        current.next = newTask;
    }

    // Search Task
    public Task searchTask(int id) {

        Task current = head;

        while(current != null) {

            if(current.taskId == id) {

                return current;
            }

            current = current.next;
        }

        return null;
    }

    // Traverse Tasks
    public void displayTasks() {

        Task current = head;

        System.out.println("\nTask List:");

        while(current != null) {

            System.out.println(current);

            current = current.next;
        }
    }

    // Delete Task
    public void deleteTask(int id) {

        if(head == null) {

            return;
        }

        if(head.taskId == id) {

            head = head.next;

            System.out.println("Task Deleted");

            return;
        }

        Task current = head;

        while(current.next != null &&
              current.next.taskId != id) {

            current = current.next;
        }

        if(current.next != null) {

            current.next =
                    current.next.next;

            System.out.println("Task Deleted");
        }
        else {

            System.out.println("Task Not Found");
        }
    }

    public static void main(String[] args) {

        TaskManagement system =
                new TaskManagement();

        system.addTask(
                101,
                "Assignment",
                "Pending");

        system.addTask(
                102,
                "Meeting",
                "Completed");

        system.addTask(
                103,
                "Report",
                "Pending");

        system.displayTasks();

        System.out.println(
                "\nSearch Result:");

        System.out.println(
                system.searchTask(102));

        system.deleteTask(102);

        system.displayTasks();
    }
}
