package app;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CountDownLatch; 


public class Middleware{

    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            ServerSocket server = new ServerSocket(12345);
            System.out.println("server opened on port 12345");

            while(true){
                CountDownLatch latch = new CountDownLatch(2);

                Socket client = server.accept();
                System.out.println("IP " + client.getInetAddress().getHostAddress() + " connected");
                MeanCalculator meanCalculator = new MeanCalculator(client, "1,2,3,4,5", latch);
                MedianCalculator medianCalculator = new MedianCalculator(client, "1,2,3,4,5", latch);
                
                Thread mean = new Thread(meanCalculator);
                Thread median = new Thread(medianCalculator);
                mean.start();
                mean.join();
                median.start();
                median.join();
                latch.await();
                
                System.out.println("Média: " + meanCalculator.response + "\n" + "Mediana: " + medianCalculator.response);

                String returnMessage = "Média: " + meanCalculator.response + "-" + "Mediana: " + medianCalculator.response;

                OutputStream os = client.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(returnMessage);
                bw.flush();

                client.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}