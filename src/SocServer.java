import java.net.ServerSocket;
import java.net.Socket;
public class SocServer
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket server=new ServerSocket(5000);

        System.out.println("server waiting on port 5000");

        Socket socket=server.accept();

        System.out.println("client connected");

    }
}
