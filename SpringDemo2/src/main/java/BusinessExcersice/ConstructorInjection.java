package BusinessExcersice;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ConstructorInjection {
    private DataService dataService;

    public ConstructorInjection(DataService dataService){
        super();
        this.dataService = dataService;
    }

    public int findMax(){
        return Arrays.stream(dataService.retriveData()).max().orElse(0);
    }
}
