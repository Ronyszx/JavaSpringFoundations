package BusinessExcersice;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MySQLDataService implements DataService{

    public int retriveData(){
        int[] data = {11,33,44,55,76,87,98};
        Arrays.sort(data);
        return data[data.length-1];
    }

}
