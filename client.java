package java_server;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class suca_server {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			Socket soc = new Socket("25.57.231.32", 1000);
			Socket soc_log = new Socket("25.57.231.32", 1001);
			
			ObjectOutputStream writer = new ObjectOutputStream(soc.getOutputStream());
			ObjectOutputStream writer_log = new ObjectOutputStream(soc_log.getOutputStream());
            InputStream reader = soc.getInputStream();
            InputStream reader_log = soc_log.getInputStream();
            
            System.out.println("INput UserName");
			String UserName = in.nextLine();
			
			writer.writeObject(UserName);
			System.out.println(reader.read() == 1 ? "User registred suc cock":"User already exist");
			
			System.out.println("INput Login");
			String UserLogin = in.nextLine();
			
			writer_log.writeObject(UserLogin);
			System.out.println(reader_log.read() == 1 ? "User logined suc cock":"UserLogin already exist");
			
			
			
			soc.close();
			soc_log.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
