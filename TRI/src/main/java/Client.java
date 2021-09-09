import java.net.*;
import java.io.*;

public class Client {
    //initialising values
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;

    public Client(String address, int port){
        // establishing a connection with the server
        try{
            socket = new Socket(address, port);
            System.out.println("Connected");
            // after the connection, the user inserts the information at this point
            input = new DataInputStream(System.in);

            out = new DataOutputStream((socket.getOutputStream()));

        }
        catch(UnknownHostException u){
            System.out.println(u);
        }
        catch(IOException i){
            System.out.println(i);
        }

        String line = "";
        // the client can enter any information until they type over
        while (!line.equals("Over")){
            try{
                line = input.readLine();
                out.writeUTF(line);
            }
            catch(IOException i){
                System.out.println(i);
            }
        }
        try{
            input.close();
            out.close();
            socket.close();
        }catch (IOException i){
            System.out.println(i);
        }
    }
    public static void main(String args[]){
        Client client = new Client("127.0.0.1", 5000);
    }
}
