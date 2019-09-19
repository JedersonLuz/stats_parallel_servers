package app;

import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.util.concurrent.CountDownLatch;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class MedianCalculator extends Thread {

    private Socket client;
    private String numbers;
    private CountDownLatch countDownLatch;
    public String response;

    public MedianCalculator(Socket client, String numbers, CountDownLatch countDownLatch){
        this.client = client;
        this.numbers = numbers;
        this.countDownLatch = countDownLatch;
    }

    public void run() {
        System.out.println("Send data for MedianServer");
        getMedian(numbers);
        countDownLatch.countDown();
    }

    /* public static void main(String[] args) {
        MedianCalculator.getMedian("1,2,3,4");
    } */

    public void getMedian(String numbers){
        try {
            String uri = "http://localhost:8080/MedianRESTfulSerever/webresources/median/" + numbers;
            URL obj = new URL(uri);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            //int responseCode = con.getResponseCode();
            //System.out.println(responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();
            this.response = response.toString();
            //System.out.println(response.toString());
            /* String returnMessage = response.toString();

            OutputStream os = client.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(returnMessage);
            bw.flush(); */
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}