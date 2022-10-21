import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

public class DatagramServerExample implements Runnable{
    DatagramSocket socket;
    public DatagramServerExample() throws SocketException{
        socket = new DatagramSocket(4445);
        System.out.println("DATA SERVER listening ...");
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try{
            byte[] bytes = new byte[1000];
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
            socket.receive(packet);
            System.out.println("From Client: "+new String(packet.getData(),0,packet.getLength()));
            bytes = "Server say hello".getBytes();
            socket.send(new DatagramPacket(bytes, bytes.length, packet.getAddress(),packet.getPort()));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            socket.close();
        }
        
    }
    public static void main(String[] args) throws SocketException {
        new Thread(new DatagramServerExample()).start();;
    }
}
