import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocServer
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket server=new ServerSocket(5000);

        System.out.println("server waiting on port 5000");

        Socket socket=server.accept();

        System.out.println("client connected");


        InputStream in = socket.getInputStream();
        OutputStream out=socket.getOutputStream();
        byte[] data = new byte[1024];

        Scanner sc=new Scanner(System.in);
        while(true)
        {


            int bytesRead = in.read(data);


            String message = new String(data, 0, bytesRead);

            System.out.println("Client says: " + message);

            String chat=sc.nextLine();


            out.write(chat.getBytes());

            if(chat.equals("exit"))
            {

                break;
            }
        }
        out.close();
        in.close();
        socket.close();
    }
}
