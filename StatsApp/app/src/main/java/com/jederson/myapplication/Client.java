package com.jederson.myapplication;

import android.os.AsyncTask;
import android.text.Editable;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;


public class Client extends AsyncTask<Void, Void, Void> {

    String host= "10.180.14.64";
    int port = 12345;
    String numbers;

    public String mean, median;

    public Client (String numbers) {
        this.numbers = numbers;
    }

    @Override
    protected Void doInBackground(Void... arg0) {

        Socket socket = null;

        try {
            Log.d("Mensagem", "Conectando!");
            Socket cliente = new Socket(host, port);
            Log.d("Mensagem", "Conectado com sucesso!");
            //dados enviados para o servidor

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream()));

            //Estou usando Arrays.toString(), somente para ele pegar todas as strings que passar no
            //método.
            Log.d("Mensagem", "Enviando dados");
            bw.write(numbers.toString());
            Log.d("Mensagem", "Dados enviados");
            bw.newLine();
            bw.flush();

            //dados reebidos pelo servidor
            BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            Log.d("Mensagem", "Aguardando dados");
            String retorno =  br.readLine();
            Log.d("Mensagem", "Dados recebidos");
            Log.d("retorno", retorno);
            mean = retorno.split("-")[0];
            median = retorno.split("-")[1];
            Log.d("dados", mean + " " + median);
            MainActivity.updateData(mean, median);
            cliente.close();
        } catch (Exception e) {
            Log.d("err", e.toString());
        } finally {
            if (socket != null) {
                try {
                    socket.close();
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