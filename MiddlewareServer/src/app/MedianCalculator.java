package app;

import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class MedianCalculator extends Thread {

    private Socket cliente;
    private String numbers;

    public MedianCalculator(Socket cliente, String numbers){
        this.cliente = cliente;
        this.numbers = numbers;
    }

    public void run() {
        System.out.println("Send data for MeanServer");
        getMedian(numbers);
    }

    /* public static void main(String[] args) {
        MedianCalculator.getMedian("1,2,3,4");
    } */

    public static void getMedian(String numbers){
        try {
            String uri = "http://localhost:8080/MedianRESTfulServer/webresources/median/" + numbers;
            URL obj = new URL(uri);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            System.out.println(responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();
            System.out.println(response.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}