package BusinessExcersice;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan
public class BusinessCalculationService {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(BusinessCalculationService.class);
        System.out.println(context.getBean(ConstructorInjection.class).findMax());
    }
}
