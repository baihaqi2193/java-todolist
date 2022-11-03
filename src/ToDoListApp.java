public class ToDoListApp {
    public static String[] model = new String[10];

    public static void main(String[] args) {

        testAddToDoList();
        testRemoveToDoList();
        testShowToDoList();
    }
    // Business Logic

    /**
     * showToDoList
     * TODO : Menampilkan to-do-list
     */
    public static void showToDoList(){
        for (var i = 0; i < model.length ; i++ ) {
            String todo = model[i];
            if(todo != null) {
                System.out.println("[" + (i+1) + "]" + " " + todo);
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
        } else if (realIdx <= 0) {
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
