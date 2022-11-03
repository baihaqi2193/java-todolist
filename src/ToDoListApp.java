public class ToDoListApp {
    public static String[] model = new String[10];

    public static void main(String[] args) {
        testShowToDoList();
    }
    // Business Logic

    /**
     * showToDoList
     * TODO : Menampilkan to-do-list
     */
    public static void showToDoList(String[] data){
        for (var i = 0; i < data.length ; i++ ) {
            String todo = data[i];
            if(todo != null) {
                System.out.println("[" + (i+1) + "]" + " " + todo);
            }
        }
    }

    public static void testShowToDoList(){
        model[0] = "Berdoa";
        model[1] = "Gosok gigi";
        model[2] = "Wudhu";
        showToDoList(model);
    }

    /**
     * addToDoList
     * TODO : Menambahkan to-do ke list
     */
    public static  void addToDoList(){}

    /**
     * removeToDoList
     * TODO : Menghapus to-do dari list
     */
    public static  void removeToDoList(){}

    // View
    /**
     * viewShowToDoList
     * TODO : Menampilkan view dari to-do-list
     */
    public static void viewShowToDoList(){

    }

    /**
     * viewAddToDoList
     * TODO : Menampilkan view dari add to-do-list
     */
    public static void viewAddToDoList(){

    }

    /**
     * viewRemoveToDoList
     * TODO : Menampilkan view dari remove to-do-list
     */
    public static void viewRemoveToDoList(){

    }
}
