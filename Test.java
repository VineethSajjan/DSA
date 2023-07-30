class Test{
    public static void main(String[] args) {
        Vineeth d = new A();
        d.find();
    }
}
class Vineeth{
    Vineeth(){
        System.out.println("constructor invoked");
    }
    void find(){
        
    }
}
class A extends Vineeth{
    A(){
        System.out.println("A constructor invoked");
    }
}
class B extends Vineeth{
    B(){
        System.out.println("B constructor invoked");
    }
}