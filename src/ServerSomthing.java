import java.io.*;
import java.net.Socket;

public class ServerSomthing extends Thread {
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;

    public ServerSomthing(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start();
    }
    @Override
    public void run() {
        String word;
        try {
            while (true) {
                word = in.readLine();
                if (word.equals("exit")) {
                    break;
                }
                if (word.equals("Привет")) {
                    send(word);
                }
                if (word.equals("Пока")) {
                    send(word);
                }

            }
        } catch (IOException e) {
        }
    }

    private void send(String msg) {
        try {
            out.write("server:" + msg + "\n");
            out.flush();
        } catch (IOException ignored) {}
    }
}
