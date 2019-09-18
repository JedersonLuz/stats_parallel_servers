package app;

import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class HandleMiddleware /* extends Thread */ {

    // private final String URL_MEDIA = "http://localhost:8080/MeanServer/webresources/media/123";
    private Socket cliente;

    // public HandleMiddleware(Socket cliente){
    //     this.cliente = cliente;
    // }

    /* public void run() {
        System.out.println("IP: " + cliente.getInetAddress().getHostAddress() + " connected");
        System.out.println("Send data for MeanServer");
        getMedia();
    } */

    public static void main(String[] args) {
        HandleMiddleware.getMedia();
    }

    public static void getMedia(){
        try {
            String URL_MEDIA = "http://localhost:8080/MeanRESTfulServer/webresources/mean/1;2;3";
            URL obj = new URL(URL_MEDIA);
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