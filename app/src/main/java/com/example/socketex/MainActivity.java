package com.example.socketex;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    private static final String SERVER_IP = "192.168.219.106"; // 서버의 IP 주소
    private static final int SERVER_PORT = 8080; // 서버 포트

    private TextView responseTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // XML 레이아웃에서 TextView와 Button을 찾아와 변수에 할당합니다.
        responseTextView = findViewById(R.id.responseTextView);
        Button connectButton = findViewById(R.id.connectButton);

        // 버튼에 클릭 리스너를 설정하여 클릭 이벤트를 처리합니다.
        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectToServer();
            }
        });
    }

    private void connectToServer() {
        // 클라이언트 소켓을 시작하기 위해 AsyncTask를 실행합니다.
        SocketClient socketClient = new SocketClient();
        socketClient.execute();
    }

    // AsyncTask를 사용하여 서버와 통신합니다.
    private class SocketClient extends AsyncTask<Void, Void, String> {
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
                // 서버로부터 받은 데이터를 TextView에 표시합니다.
                responseTextView.setText("Server Response: " + result);
            } else {
                responseTextView.setText("Failed to receive data from server.");
            }
        }
    }
}
