package puzzler;

import java.io.*;

public class Copy {
    static void copy(String src, String dest) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(src);
            out = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int n;
            while ((n = in.read(buf)) > 0)
                out.write(buf, 0, n);
        } finally {
        	//in.close也可能会抛出异常！导致out.close无法执行，
        	//所以需要在in.close周围加上try catch
            if (in != null) in.close();
            if (out != null) out.close();
        } 
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 2)
            System.out.println("Usage: java Copy <source> <dest>");
        else
            copy(args[0], args[1]);
    }
}