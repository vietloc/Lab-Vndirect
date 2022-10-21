import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.plaf.synth.SynthEditorPaneUI;

public class SocketServerExample {
    public SocketServerExample(int serverPort) throws IOException{
        ServerSocket serverSock = new ServerSocket(serverPort);
        System.out.println("SERVER Listening ... ");
        while(true){
            Socket socket = serverSock.accept();
            new Thread(()->{
                try(DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                ){
                    System.out.println("Client Say: "+ input.readUTF());
                    output.writeUTF("I'm a socket server!");
                }catch (Exception e) {
                    // TODO: handle exception
                }
            }).start();
        }
    }
    public static void main(String[] args) throws IOException {
        new SocketServerExample(9245);
    }
}
