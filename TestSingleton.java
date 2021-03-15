class Singleton{
    private int id = 5;
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }    
}

public class TestSingleton {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        //default id is 5
        System.out.println(singleton.getId());
        //setting id for first object
        singleton.setId(10);
        
        Singleton singleton2 = Singleton.getInstance();
        //id will be same of first and second objects 
        System.out.println(singleton2.getId());;
    }
}
