package hai;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public final class HaiSolution {
  
  public static final int SERVER_PORT = 6092;
  public static boolean isSERVER_MODE;
  public static String MSG_DONE = "Command unsuccessful! :[";
  
  public static void main(String[] args) {
    if (args.length != 1) {
      System.err.println("Usage:\tjava hai.Hai [-s | host ]");
      return;
    }
    
    String arg = args[0];
    isSERVER_MODE = "-s".equals(arg);

    try {
      if (isSERVER_MODE) {
        startServer(SERVER_PORT);
        MSG_DONE = "Server shut down gracefully!";
      } else {
        connectClient(arg,SERVER_PORT);
        MSG_DONE = "Sent!";
      }
    } catch (UnknownHostException e) {
      System.err.println("Unknown host: "+e.getLocalizedMessage());
      System.exit(-1);
    } catch (IOException e) {
      System.err.println(e);
      System.exit(-1);
    }
    
    System.out.println(MSG_DONE);
    System.exit(0);
  }
  
  private static void startServer(int port) throws IOException {
    final ServerSocket sSocket = new ServerSocket(port);

    System.out.println(
        "Server started on port "+
        sSocket.getLocalPort()+
        ". Press Ctrl+C to stop server.");

    Socket socket;
    while (true) {
      socket = sSocket.accept();

      System.out.println(
          ">> Incoming chat from remote address "+
          socket.getInetAddress().toString().substring(1)+
          "! <<");

      writeIOStream(socket.getInputStream(), System.out);
      socket.close();
    }
    //normally we should somehow shutdown cleanly here with a sSocket.close();
  }


  private static void connectClient(String host, int port) 
    throws UnknownHostException, IOException {
    
    System.out.print("Connecting... ");
    Socket socket = new Socket(host, port);
    System.out.println("connected!  Type your message followed by a dot on a line by itself.");
    
    writeIOStream(System.in, socket.getOutputStream());
    
    System.out.print("Message queued for server... ");
    socket.close();
  }
  
  private static void writeIOStream(InputStream i, OutputStream o)
    throws IOException {

    BufferedReader in =
      new BufferedReader(
          new InputStreamReader(i));
    
    BufferedWriter out =
      new BufferedWriter(
        new OutputStreamWriter(o));
            
    String line;
    while (null != (line=in.readLine())
             && !".".equals(line)) {
      out.write(line);
      out.newLine();
    }
    
    in.close();

    if (isSERVER_MODE) {
      out.flush();
    } else {
      out.close();
    }
  }

}
