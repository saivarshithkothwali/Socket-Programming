import java.net.Socket;

public class SocClient
{
    public static void main(String[] args) throws Exception
    {
        String ip="localhost";
        int port=5000;
        Socket client=new Socket(ip,port);
        System.out.println("Connected to server");
    }
}