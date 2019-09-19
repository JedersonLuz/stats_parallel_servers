package com.jederson.statsapp;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;


public class Client extends AsyncTask<Void, Void, Void> {

    String host= "127.0.0.1";
    int port = 12345;
    String numbers;

    public String mean, median;

    public Client (String numbers) {
        this.numbers = numbers;
    }

    @Override
    protected Void doInBackground(Void... arg0) {

        Socket client = null;

        try {
            client = new Socket(host, port);
            Log.d("Mensagem", "Conectado com sucesso!");
            PrintStream mensagem = new PrintStream(client.getOutputStream());
            mensagem.println(String.format("%s", numbers));
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String line = in.readLine();
            in.close();
            mean = line.split("-")[0];
            median = line.split("-")[1];
        } catch (Exception e) {
            Log.d("Mensagem", "Conexão falhou!!");
        } finally {
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
    }

}