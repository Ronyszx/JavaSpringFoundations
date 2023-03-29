package ScopesExample;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
class A{

}

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PrototypeClass{

}

@Configuration
@ComponentScan
public class ScopesApplication {


    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(ScopesApplication.class)){
            System.out.println(context.getBean(A.class));
            System.out.println(context.getBean(A.class));
            System.out.println(context.getBean(A.class));//WE see that same instance is created when run

            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));// new instances are created  for every call

        }
    }
}
