package test;

import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPSClient;

public class FTPTest {
	public static void main(String[] args) throws SocketException, IOException {
		
		FTPSClient ftp = new FTPSClient();
		ftp.connect("172.16.236.150");
		ftp.login("root", "root");
		
		int reply = ftp.getReplyCode();
		System.out.println(reply);
		FTPFile[] fs = ftp.listFiles();
		for(FTPFile ff : fs) {
			System.out.println(ff.getName());
		}
		
		ftp.logout();
		ftp.disconnect();
	}
}
