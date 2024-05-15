package com.example.socketex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SocketClient extends AsyncTask<Void, Void, String> {
    private static final String TAG = "SocketClient";
    private static final String SERVER_IP = "your_server_ip"; // 서버의 IP 주소
    private static final int SERVER_PORT = 8080; // 서버 포트

    @Override
    protected String doInBackground(Void... voids) {
        try {
            // 서버에 연결합니다.
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);

            // 서버로부터 데이터를 받습니다.
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String serverMessage = dis.readUTF();

            // 연결을 종료합니다.
            socket.close();

            return serverMessage;
        } catch (IOException e) {
            Log.e(TAG, "Error: " + e.getMessage());
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (result != null) {
            // 서버로부터 받은 데이터를 출력합니다.
            Log.d(TAG, "Server response: " + result);
        } else {
            Log.d(TAG, "Failed to receive data from server.");
        }
    }
}