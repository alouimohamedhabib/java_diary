package fileIoPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ExampleByteBuffer {

	public static void main(String[] args) {
		File f = new File("hello.txt");
		try {
			FileInputStream fs = new FileInputStream(f);
			FileChannel channel = fs.getChannel();
			ByteBuffer bf = ByteBuffer.allocate(1024);
			
			try {
				while(channel.read(bf) > 0) {
					bf.flip();
					while(bf.hasRemaining()) {
						System.out.println((char) bf.get());
					}
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
