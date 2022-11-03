public class ToDoListApp {
    public static String[] model = new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowToDoList();
    }
    // Business Logic

    /**
     * inputString
     * TODO : Membaca data string dari input user
     */
    public static String inputString(String cmd){
        System.out.print(cmd + ": ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInputString(){
        String data = inputString("Masukkan input");
        System.out.println(data);
    }

    /**
     * showToDoList
     * TODO : Menampilkan to-do-list
     */
    public static void showToDoList(){
        if (model[0] == null) {
            System.out.println("To do list is empty!");
        } else {
            for (var i = 0; i < model.length ; i++ ) {
                String todo = model[i];
                if(todo != null) {
                    System.out.println("(" + (i+1) + ")" + " " + todo);
                }
            }
        }
    }

    public static void testShowToDoList(){
        showToDoList();
    }

    /**
     * addToDoList
     * TODO : Menambahkan to-do ke list
     */
    public static void addToDoList(String todo){
        // Cek apakah di model sudah penuh
        var isFull = true;
        for (int i = 0; i < model.length; i++) {
            // Jika ada yang null berarti tidak penuh
            if(model[i] == null) {
                // Set flag to false
                isFull = false;
                break;
            }
        }

        if(isFull) {
            var tempModel = model;
            model = new String[model.length * 2];
            for (int i = 0; i < tempModel.length; i++) {
                model[i] = tempModel[i];
            }
        }

        // Cek dimana data null (kosong)
        for (int i = 0; i < model.length; i++) {
            // Dapatkan indeks dimana data null
            if (model[i] == null) {
                // Add to-do ke indeks data null
                model[i] = todo;
                break;
            }
        }


    }

    public static void testAddToDoList(){
        for (int i = 1; i <= 5; i++) {
            addToDoList("Todo ke-" + i);
        }
    }

    /**
     * removeToDoList
     * TODO : Menghapus to-do dari list
     */
    public static boolean removeToDoList(Integer idx){
        var realIdx = idx - 1;
        // Kalau lebih dari index ga valid
        if(realIdx >= model.length){
            return false;
        } else if (realIdx < 0) {
            return false;
        }

        // Kalau udah null, ga valid
        if (model[realIdx] == null) {
            return false;
        } else {
            // Geser kalau nggak null
            for (int i = realIdx; i < model.length ; i++) {
                // Kalau di index akhir langsung jadi null
                if(i == model.length - 1){
                    model[i] = null;
                }
                // Kalau nggak di akhir, geser aja langsung
                else {
                    model[i] = model[i + 1];
                }

            }
            return true;
        }
    }

    public static void testRemoveToDoList(){
        System.out.println(removeToDoList(0));
    }

    // View
    /**
     * viewShowToDoList
     * TODO : Menampilkan view dari to-do-list
     */
    public static void viewShowToDoList(){
        boolean isExit = false;
        while (isExit == false){
            System.out.println("--- TO DO LIST ---");
            showToDoList();
            System.out.println("--- MENU ---");
            System.out.println("[1] Add");
            System.out.println("[2] Remove");
            System.out.println("[3] Exit");
            System.out.println("--- COMMAND ---");

            var input = inputString("Choose: ");
            if (input.equals("1")) {
                viewAddToDoList();
            } else if (input.equals("2")) {
                viewRemoveToDoList();
            } else if (input.equals("3")) {
                isExit = true;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }

    }

    public static void testViewShowToDoList(){
        addToDoList("Satu");
        addToDoList("Dua");
        addToDoList("Tiga");
        addToDoList("Empat");
        viewShowToDoList();
    }

    /**
     * viewAddToDoList
     * TODO : Menampilkan view dari add to-do-list
     */
    public static void viewAddToDoList(){
        System.out.println("--- ADD TO DO LIST ---");
        System.out.println("Type (x) to cancel");
        var todo = inputString("Add To Do / Cancel: ");
        if(todo.equals("x")){
            // Batal
        } else {
            addToDoList(todo);
            System.out.println("To Do Added!");
        }
    }

    /**
     * viewRemoveToDoList
     * TODO : Menampilkan view dari remove to-do-list
     */
    public static void viewRemoveToDoList(){
        System.out.println("--- REMOVE TO DO LIST ---");
        showToDoList();
        System.out.println("--- COMMAND ---");
        System.out.println("Type (x) to cancel");
        var number = inputString("Remove To Do / Cancel: ");
        if(number.equals("x")){
            // Batal
        } else {
            boolean success = removeToDoList(Integer.valueOf(number));
            if (success){
                System.out.println("To Do Removed!");
            } else {
                System.out.println("Unable to remove To Do: " + number);
                System.out.println("Please check your input!");
            }
        }
    }
}
