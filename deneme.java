import java.time.LocalDate;
import java.time.Period;

class Employee{
    private String name;
    private double salary;
    private float  workHours;
    private LocalDate  hireYear;


   
    public Employee(String _name, double _salary, float _workHours, LocalDate _hireYear) {
        this.name = _name;
        this.salary = _salary;
        this.workHours = _workHours;
        this.hireYear = _hireYear;
    }
 
    void tax(){
        if(this.salary>1000){
            this.salary=this.salary-this.salary*0.03;
        }
    }
    void bonus(){
        float extraHour;
        if(this.workHours>40){
            extraHour=this.workHours-40;
            this.salary= this.salary+this.workHours*30;
        }
    }
    void raiseSalary(){
        LocalDate today= LocalDate.of(2021, 01, 01);
        Period diff = Period.between(today, this.hireYear);
        int getYears=diff.getYears();
        if(getYears<10){
            this.salary=this.salary+this.salary*0.05;
        }
        else if((getYears>9) & (getYears<20)){
            this.salary=this.salary+this.salary*0.1;
        }
       else if(getYears>19){
        this.salary=this.salary+this.salary*0.15;
       }
    }   @Override
    public String toString() {
        return "Employee [name=" + name + ", salary=" + salary + ", workHours=" + workHours + ", hireYear=" + hireYear
                + "]";
    }

}
class HelloWorld {
    public static void main(String[] args) {
        LocalDate hireYear= LocalDate.of(2020, 01, 01);
        Employee e=new Employee("Elif Sena ÇAL", 10000, 50, hireYear);
        e.tax();
        e.bonus();   
        e.raiseSalary();
        System.out.println(e);
    }
}
