package BusinessExcersice;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Primary
public class MongoDBDataService implements DataService{

    public int[] retriveData(){
        int[] data = {1,3,4,5,6,7,8};
        return data;
    }
}
