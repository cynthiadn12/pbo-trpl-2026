class Parent {
    // 4. Constructor
    public Parent() {
        System.out.println("-> Constructor Parent dipanggil");
    }

    // 1. Final Method: Tidak bisa di-override
    public final void methodFinal() {
        System.out.println("-> Ini Final Method dari Parent");
    }

    // 2. Static Method: Milik class, bukan objek
    public static void methodStatic() {
        System.out.println("-> Ini Static Method dari Parent");
    }

    // 3. Private Method: Tidak diwariskan ke Child
    private void methodPrivate() {
        System.out.println("-> Ini Private Method dari Parent");
    }
}

class Child extends Parent {
    // Constructor
    public Child() {
        super(); // Memanggil constructor parent
        System.out.println("-> Constructor Child dipanggil");
    }

    // ERROR! Hapus tanda komentar (//) di bawah ini untuk melihat error kompilasi
    // @Override
    // public void methodFinal() {
    //     System.out.println("Mencoba override Final Method");
    // }

    // METHOD HIDING (Bukan Overriding karena ini static)
    public static void methodStatic() {
        System.out.println("-> Ini Static Method dari Child (Hiding)");
    }

    // METHOD BARU (Bukan Overriding karena Parent method-nya private)
    private void methodPrivate() {
        System.out.println("-> Ini method private independen milik Child");
    }
    
    // Method bantuan untuk memanggil methodPrivate() agar bisa dites di main
    public void panggilPrivateChild() {
        this.methodPrivate();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== DEMO BUKAN OVERRIDING ===\n");
        
        System.out.println("1. Pemanggilan Constructor:");
        // Constructor tidak di-override, tapi constructor parent otomatis terpanggil
        Child anak = new Child(); 
        
        System.out.println("\n2. Memanggil Final Method (Diwarisi, tidak bisa diubah):");
        anak.methodFinal();
        
        System.out.println("\n3. Memanggil Static Method (Method Hiding, bukan Override):");
        Parent.methodStatic(); // Memanggil milik class Parent
        Child.methodStatic();  // Memanggil milik class Child
        
        System.out.println("\n4. Memanggil Private Method (Bukan Override):");
        anak.panggilPrivateChild(); 
    }
}

/*
Cara mencoba error final method:
Jika Anda ingin melihat langsung kenapa final method tidak bisa di-override, hapus tanda komentar (//) pada bagian @Override public void methodFinal() di dalam class Child, lalu coba jalankan lagi. 
Program akan langsung menolak untuk berjalan (Compile-time error).
*/
