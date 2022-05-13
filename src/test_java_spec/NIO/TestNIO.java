package test_java_spec.NIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestNIO {

    public static void testNIO1() {
        String str = "abcde";
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(str.getBytes());
        byteBuffer.flip();
        byte[] byteArray = new byte[byteBuffer.limit()];
        byteBuffer.get(byteArray, 0, 2);
        System.out.println(new String(byteArray, 0, 2));
        System.out.println(byteBuffer.position());

        byteBuffer.mark();   // 标记当前position位置
        byteBuffer.get(byteArray, 2, 2);
        System.out.println(new String(byteArray, 2, 2));
        System.out.println(byteBuffer.position());

        byteBuffer.reset();
        System.out.println(byteBuffer.position());

        if (byteBuffer.hasRemaining()) {
            System.out.println(byteBuffer.remaining());
        }
    }

    public static void testNIO2() {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        System.out.println(byteBuffer.isDirect());
    }

    public static void testNIO3() throws Exception {
        FileInputStream fis = new FileInputStream("a.txt");
        FileOutputStream fos =  new FileOutputStream("b.txt");

        FileChannel fisChannel = fis.getChannel();
        FileChannel fosChannel = fos.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (fisChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            fosChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        fosChannel.close();
        fisChannel.close();
        fis.close();
        fos.close();

    }


    public static void testNIO4() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("a.txt"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("b.txt"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

        MappedByteBuffer inBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        byte[] dst = new byte[inBuffer.limit()];
        inBuffer.get(dst);
        outBuffer.put(dst);

        inChannel.close();
        outChannel.close();
    }

    public static void main(String[] args) throws Exception {
        //StringBuilder sb = new StringBuilder("abcdefg");
        // sb.reverse();
        //System.out.print(sb);
        testNIO4();
    }

}
