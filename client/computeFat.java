package client;

import java.math.BigInteger;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import compute.Compute;

public class computeFat {

    public static void main(String args[]) {


        try {
            String host = args[0];
            int porta = Integer.parseInt(args[1]);
            Integer fat = Integer.parseInt(args[2]);

            String name = "Compute";
            Registry registry = LocateRegistry.getRegistry(host, porta);
            Compute comp = (Compute) registry.lookup(name);

            // Inicialmente, foi utilizada a classe Fatorial, porém qualquer valor maior que 12 ocasionou num overflow.
            // limite superior do tipo int = 2^31 - 1 = 2147483647
            // 13! = 6227020800
            // Assim, foi utilizada a classe FatorialBig, que implementa 'BigInteger' ao invés de 'Integer', 
            // que oferece um limite superior maior e portanto permite armazenamento de valores muito grandes

            //Fatorial task = new Fatorial(fat);
            FatorialBig task = new FatorialBig(fat); 
            BigInteger result = comp.executeTask(task);
            System.out.println("Resultado: " + result);
        } catch (Exception e) {
            System.err.println("ComputeFat exception:");
            e.printStackTrace();
        } 
    }

    
}