import java.net.*;
import java.io.*;

public class Server {
    // initialisation
   private Socket socket = null;
   private ServerSocket server = null;
   private DataInputStream in = null;

   public Server (int port){
      try{
          server = new ServerSocket(port);
          System.out.println("Server started \n" + "Waiting for a client ...\n");
            // when connection is successful, it displays the accepted message
          socket = server.accept();
          System.out.println("Client accepted");

          in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

          String line = "";
          // the client can enter any information until they type over
          while (!line.equals("Over")){
         try{
                  line = in.readUTF();
                  System.out.println(line);
              }catch (IOException i){
                  System.out.println(i);
              }
          }

            System.out.println("Closing connection");
            socket.close();
            in.close();
      }catch (IOException i){
          System.out.println(i);
      }
   }
   public static void main(String args[]){
       Server server = new Server(5000);
   }
}
