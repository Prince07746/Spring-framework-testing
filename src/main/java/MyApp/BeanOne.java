package MyApp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("bean1")
public class BeanOne {

    private BeanTwo beanTwo;
    @Value("Prince")
    private String name;
    String lastName;

    @Autowired
    public BeanOne(String name,String lastName,BeanTwo beanTwo) {
        this.name = name;
        this.lastName = lastName;
        this.beanTwo = beanTwo;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void display(){
        System.out.println("This is the bean one using: ");
        System.out.println("This data is populated by: "+getName()+" "+getLastName());
        System.out.println(beanTwo.toString());
    }




}
