package com.svs.server;

import com.svs.client.Client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {
    private final int PORT = 3777;
    private ThreadPoolExecutor poolExecutor;

    public Server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Сервер запущен.");
            while (true) {
                socket = serverSocket.accept();
                System.out.println("Клиент подключился");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
