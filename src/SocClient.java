import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SocClient
{
    public static void main(String[] args) throws Exception
    {
        String ip="localhost";
        int port=5000;
        Socket client=new Socket(ip,port);
        System.out.println("Connected to server");

        Scanner sc=new Scanner(System.in);

        OutputStream out=client.getOutputStream();
        InputStream in = client.getInputStream();
        byte[] data = new byte[1024];

        while(true)
        {
            String chat=sc.nextLine();
            out.write(chat.getBytes());





            int bytesRead = in.read(data);

            String message = new String(data,0,bytesRead);

            System.out.println("Server says: " + message);

            if(chat.equals("exit"))
            {
                client.close();
                break;
            }
        }
        out.close();
        in.close();


    }
}