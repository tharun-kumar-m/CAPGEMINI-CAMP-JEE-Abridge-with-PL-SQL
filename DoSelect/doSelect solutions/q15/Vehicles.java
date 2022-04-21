package q15;

class Vehicles{
    String type, model_no, model_name, owner_name, owner_details;

    public Vehicles(String model_no, String model_name, String owner_name, String owner_details) {
        this.model_no = model_no;
        this.model_name = model_name;
        this.owner_name = owner_name;
        this.owner_details = owner_details;
    }
    public Vehicles() {  
    }
    public String get_type() {
        return this.type;
    }
    public String retrieve() throws TypeException {
        return "null" ;
    }
    public static void main(String[] args) {
        Car c = new Car("1205", "Ford", "Sam", "California");
        c.set_type("SUV");
        try {
            System.out.println(c.retrieve());
        } catch (TypeException e) {
            System.out.println(e.toString());
        }
    }
}
class Car extends Vehicles{
    public Car(String model_no, String model_name, String owner_name, String owner_details) {
        super(model_no, model_name, owner_name, owner_details);
    }
    public String get_type() {
        return this.type;
    }
    public void set_type(String typ) {
        type=typ;
    }
    @Override
    public String retrieve() throws TypeException{
        if (this.type==null) {
            throw new TypeException();
        }
        else {
            return "[ model no. = "+this.model_no+","+" model name = "+this.model_name+","+
        " owner_name = "+this.owner_name+","+" owner_details = "+this.model_no+" ]";
        }
    }     
}
@SuppressWarnings("serial")
class TypeException extends Exception{
    @Override
    public String toString() {
        return "Vehicle Type Not Set";
    } 
}