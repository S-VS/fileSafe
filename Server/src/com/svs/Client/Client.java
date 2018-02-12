package com.svs.Client;

import java.io.*;
import java.net.Socket;

public class Client {
    private final int PORT = 3777;
    private final String SERVER = "localhost";
    private Socket socket;
    private InputStream downloadFile;
    private OutputStream uploadFile;
    private DataInputStream in;
    private DataOutputStream out;

    public Client() {
        this.socket = socket;
        this.downloadFile = downloadFile;
        this.uploadFile = uploadFile;
        this.in = in;
        this.out = out;
    }

    public void connect() {
        try {
            socket = new Socket(SERVER, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
//            downloadFile = new FileInputStream(String.valueOf(socket.getInputStream()));
//            uploadFile = new FileOutputStream(String.valueOf(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
