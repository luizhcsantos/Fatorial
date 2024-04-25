package client;

import java.io.Serializable;
import compute.Task;

public class Fatorial implements Task<Integer>, Serializable {

    private static final long serialVersionUID = 227L;

    private int fat = 0; 

    public Fatorial(Integer fat) {
        this.fat = fat;
    }

    @Override
    public Integer execute() {
        return computeFat(fat); 
    }

    public static Integer computeFat(Integer numero) {
        
        // Caso base: fatorial de 0 é 1
        if (numero == 0) {
            return 1;
        } 
         else {
            // Caso recursivo: fatorial de n é n * (fatorial de n-1)
            return numero * computeFat(numero - 1);
        }
    }

    
    
}
