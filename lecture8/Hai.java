package hai;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public final class Hai {
  
  public static final int SERVER_PORT = 5800;
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
    } // TODO: catch TWO different types of exceptions here
    
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

      // TODO: Choose the right input and output for the SERVER
      // writeIOStream( ... , ... );
      socket.close();
    }
    //normally we should somehow shutdown cleanly here with a sSocket.close();
  }


  private static void connectClient(String host, int port) 
    throws UnknownHostException, IOException {
    
    System.out.print("Connecting... ");
    Socket socket = new Socket(host, port);
    System.out.println("connected!  Type your message followed by a dot on a line by itself.");
    
    // TODO: Choose the right input and output for the CLIENT
    // writeIOStream( ... , ... );
    
    System.out.print("Message queued for server... ");
    socket.close();
  }
  
  private static void writeIOStream(InputStream i, OutputStream o)
    throws IOException {

    // TODO: Create a BufferedReader from an InputStream
    // BufferedReader in = ... ;

    // TODO: Create a BufferedWriter from an OutputStream
    // BufferedWriter out ... ;
    

    // waits for a complete line from in, writes it to out
    String line;
    while (null != (line=in.readLine())
             && !".".equals(line)) {
      out.write(line);
      out.newLine();
    }
    
    // closes (or flushes) the appropriate streams when done
    in.close();
    if (isSERVER_MODE) {
      out.flush();
    } else {
      out.close();
    }
  }

}
