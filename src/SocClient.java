import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocClient
{
    public static void main(String[] args) throws Exception
    {
        String ip="localhost";
        int port=5000;
        Socket client=new Socket(ip,port);
        System.out.println("Connected to server");
        //System.out.println(client);
        OutputStream out=client.getOutputStream();
        //System.out.println(out);
        out.write("Hello Server".getBytes());

        InputStream in = client.getInputStream();

        byte[] data = new byte[1024];

        int bytesRead = in.read(data);

        String message = new String(data,0,bytesRead);

        System.out.println("Server says: " + message);
    }
}