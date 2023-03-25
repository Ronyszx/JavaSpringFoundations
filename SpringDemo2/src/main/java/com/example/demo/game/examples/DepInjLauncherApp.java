package com.example.demo.game.examples;

import com.example.demo.game.GameRunner;
import com.example.demo.game.gameConsole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;



@Component
class BusinessClass{

//    @Autowired
    Dependency1 dependency1;

//    @Autowired
    Dependency2 dependency2;

//    @Autowired not Mandatory as Constructor injection is the recommened as shown below
//
    public BusinessClass(Dependency1 dependency1, Dependency2 dependency2){
        super();
        System.out.println("Constructor Injection  - Business Class");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }



//     public String toString(){
//        return "toString" + dependency1 + " +" + dependency2;
//    }
}

@Component
class Dependency1{

}

@Component
class Dependency2{

}

@Configuration
@ComponentScan
public class DepInjLauncherApp {
    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(DepInjLauncherApp.class)){
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean(BusinessClass.class));
        }
    }
}


//    Dependency injection is a pattern we can use to implement IoC, where the control being inverted is setting an object's dependencies.
//
//        Connecting objects with other objects, or “injecting” objects into other objects, is done by an assembler rather than by the objects themselves.
//
//        Here's how we would create an object dependency in traditional programming:
//
//public class Store {
//    private Item item;
//
//    public Store() {
//        item = new ItemImpl1();
//    }
//}
//Copy
//        In the example above, we need to instantiate an implementation of the Item interface within the Store class itself.
//
//        By using DI, we can rewrite the example without specifying the implementation of the Item that we want:
//
//public class Store {
//    private Item item;
//    public Store(Item item) {
//        this.item = item;
//    }
//}
//Copy
//        In the next sections, we'll look at how we can provide the implementation of Item through metadata.
//
//        Both IoC and DI are simple concepts, but they have deep implications in the way we structure our systems, so they're well worth understanding fully.
//
//        4. The Spring IoC Container
//        An IoC container is a common characteristic of frameworks that implement IoC.
//
//        In the Spring framework, the interface ApplicationContext represents the IoC container. The Spring container is responsible for instantiating, configuring and assembling objects known as beans, as well as managing their life cycles.
//
//        The Spring framework provides several implementations of the ApplicationContext interface: ClassPathXmlApplicationContext and FileSystemXmlApplicationContext for standalone applications, and WebApplicationContext for web applications.
//
//        In order to assemble beans, the container uses configuration metadata, which can be in the form of XML configuration or annotations.
//
//        Here's one way to manually instantiate a container:
//
//        ApplicationContext context
//        = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Copy
//        To set the item attribute in the example above, we can use metadata. Then the container will read this metadata and use it to assemble beans at runtime.
//
//        Dependency Injection in Spring can be done through constructors, setters or fields.
//
//        5. Constructor-Based Dependency Injection
//        In the case of constructor-based dependency injection, the container will invoke a constructor with arguments each representing a dependency we want to set.
//
//        Spring resolves each argument primarily by type, followed by name of the attribute, and index for disambiguation. Let's see the configuration of a bean and its dependencies using annotations:
//
//@Configuration
//public class AppConfig {
//
//    @Bean
//    public Item item1() {
//        return new ItemImpl1();
//    }
//
//    @Bean
//    public Store store() {
//        return new Store(item1());
//    }
//}
//Copy
//        The @Configuration annotation indicates that the class is a source of bean definitions. We can also add it to multiple configuration classes.
//
//        We use the @Bean annotation on a method to define a bean. If we don't specify a custom name, then the bean name will default to the method name.
//
//        For a bean with the default singleton scope, Spring first checks if a cached instance of the bean already exists, and only creates a new one if it doesn't. If we're using the prototype scope, the container returns a new bean instance for each method call.
//
//        Another way to create the configuration of the beans is through XML configuration:
//
//<bean id="item1" class="org.baeldung.store.ItemImpl1" />
//<bean id="store" class="org.baeldung.store.Store">
//<constructor-arg type="ItemImpl1" index="0" name="item" ref="item1" />
//</bean>
//        Copy
//        6. Setter-Based Dependency Injection
//        For setter-based DI, the container will call setter methods of our class after invoking a no-argument constructor or no-argument static factory method to instantiate the bean. Let's create this configuration using annotations:
//
//@Bean
//public Store store() {
//        Store store = new Store();
//        store.setItem(item1());
//        return store;
//        }
//        Copy
//        We can also use XML for the same configuration of beans:
//
//<bean id="store" class="org.baeldung.store.Store">
//<property name="item" ref="item1" />
//</bean>
//        Copy
//        We can combine constructor-based and setter-based types of injection for the same bean. The Spring documentation recommends using constructor-based injection for mandatory dependencies, and setter-based injection for optional ones.
//
//        7. Field-Based Dependency Injection
//        In case of Field-Based DI, we can inject the dependencies by marking them with an @Autowired annotation:
//
//public class Store {
//    @Autowired
//    private Item item;
//}
//Copy
//        While constructing the Store object, if there's no constructor or setter method to inject the Item bean, the container will use reflection to inject Item into Store.
//
//        We can also achieve this using XML configuration.
//
//        This approach might look simpler and cleaner, but we don't recommend using it because it has a few drawbacks such as:
//
//        This method uses reflection to inject the dependencies, which is costlier than constructor-based or setter-based injection.
//        It's really easy to keep adding multiple dependencies using this approach. If we were using constructor injection, having multiple arguments would make us think that the class does more than one thing, which can violate the Single Responsibility Principle.
//        More information on the @Autowired annotation can be found in the Wiring In Spring article.
//
//        8. Autowiring Dependencies
//        Wiring allows the Spring container to automatically resolve dependencies between collaborating beans by inspecting the beans that have been defined.
//
//        There are four modes of autowiring a bean using an XML configuration:
//
//        no: the default value – this means no autowiring is used for the bean and we have to explicitly name the dependencies.
//        byName: autowiring is done based on the name of the property, therefore Spring will look for a bean with the same name as the property that needs to be set.
//        byType: similar to the byName autowiring, only based on the type of the property. This means Spring will look for a bean with the same type of the property to set. If there's more than one bean of that type, the framework throws an exception.
//        constructor: autowiring is done based on constructor arguments, meaning Spring will look for beans with the same type as the constructor arguments.
//        For example, let's autowire the item1 bean defined above by type into the store bean:
//
//@Bean(autowire = Autowire.BY_TYPE)
//public class Store {
//
//    private Item item;
//
//    public setItem(Item item){
//        this.item = item;
//    }
//}
//Copy
//        We can also inject beans using the @Autowired annotation for autowiring by type:
//
//public class Store {
//
//    @Autowired
//    private Item item;
//}
//Copy
//        If there's more than one bean of the same type, we can use the @Qualifier annotation to reference a bean by name:
//
//public class Store {
//
//    @Autowired
//    @Qualifier("item1")
//    private Item item;
//}
//Copy
//        Now let's autowire beans by type through XML configuration:
//
//<bean id="store" class="org.baeldung.store.Store" autowire="byType"> </bean>
//        Copy
//        Next, let's inject a bean named item into the item property of store bean by name through XML:
//
//<bean id="item" class="org.baeldung.store.ItemImpl1" />
//
//<bean id="store" class="org.baeldung.store.Store" autowire="byName">
//</bean>
//        Copy
//        We can also override the autowiring by defining dependencies explicitly through constructor arguments or setters.
