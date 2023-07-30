class Test{
    public static void main(String[] args) {
        A d = new A();
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