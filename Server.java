import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class Server{

    public void run(){
        try{
            int port = 8010;
            ServerSocket socket = new ServerSocket(port);
            socket.setSoTimeout(5000);
            while (true) {
                System.out.println("Server is listening on port: "+port);
                Socket acceptedConnection = socket.accept();
                System.out.println("connection accepted from client "+acceptedConnection.getRemoteSocketAddress());
                PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream());
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));
                toClient.println("Hello from the server!");
                toClient.close();
                fromClient.close();
                acceptedConnection.close();

            }
        }
        catch(IOException ex ){
            ex.printStackTrace();
        }
       
    }


    public static void main(String[] args) {
        Server server = new Server();
        server.run();
    }
}