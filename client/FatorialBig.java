package client;

import java.io.Serializable;
import java.math.BigInteger;

import compute.Task;

public class FatorialBig implements Task<BigInteger>, Serializable {

    private static final long serialVersionUID = 227L;

    private int num = 0; 

    public FatorialBig(Integer num) {
        this.num = num;
    }

    @Override
    public BigInteger execute() {
        return computeFatBig(num); 
    }

    public static BigInteger computeFatBig(int num) {
        
        BigInteger big = new BigInteger("1");   
  
        // Multiplcando big por 2, 3, 4, ..., até num  
        for (int j = 2; j <= num; j++)  {  
            big = big.multiply(BigInteger.valueOf(j));  
        }  
        return big;     
    }
    
}
