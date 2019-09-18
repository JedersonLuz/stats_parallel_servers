package app;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Middleware{

    public static void main(String[] args) throws IOException {
        try {
            ServerSocket servidor = new ServerSocket(8000);
            System.out.println("Servidor opened on port 8000");
            ArrayList<Thread> slotes = new ArrayList<Thread>();

            while(true){
                Socket cliente = servidor.accept();
                System.out.println("IP " + cliente.getInetAddress().getHostAddress() + " connected");
                if(slotes.isEmpty()){
                    MeanCalculator meanCalculator = new MeanCalculator(cliente, "1,2,3,4,5");
                    MedianCalculator medianCalculator = new MedianCalculator(cliente, "1,2,3,4,5");
                    Thread mean = new Thread(meanCalculator);
                    Thread median = new Thread(medianCalculator);
                    mean.start();
                    median.start();
                    slotes.add(mean);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}