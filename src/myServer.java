import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class myServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket=new ServerSocket(8090);
        Socket socket= serverSocket.accept();
        DataInputStream input= new DataInputStream(socket.getInputStream());
        DataOutputStream output= new DataOutputStream(socket.getOutputStream());
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String request="";
        String response="";

        while (!request.equals("end")){

            request= input.readUTF();
            System.out.println("Request: "+request);
            response= br.readLine();
            output.writeUTF(response);
            output.flush();
        }
input.close();
        socket.close();
    }
}
