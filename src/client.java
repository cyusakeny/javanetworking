import java.io.*;
import java.net.Socket;
public class client {
    public static void main(String[] args) throws Exception{
        //initialize
        Socket newsocket= new Socket("localhost",8090);
        DataOutputStream output = new DataOutputStream(newsocket.getOutputStream());
        DataInputStream input= new DataInputStream(newsocket.getInputStream());
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String request="";
        String response="";
        while (!request.equals("end")){

            System.out.println("Write a request: ");
            request=br.readLine();
            output.writeUTF(request);
            output.flush();
            response=input.readUTF();
            System.out.println("Server response: "+response);
        }
        output.close();
newsocket.close();
    }
}
