package upload;

import java.io.*;
import java.net.*;

public class UploadArquivo {

    public static void main(String[] args) throws Exception {
        String url = "http://example.com/upload";
        String fileName = args[0];
        File file = new File(fileName);
        int partSize = 1024 * 1024; // 1 MB
        long fileSize = file.length();
        int totalParts = (int) Math.ceil((double) fileSize / partSize);
        int partsUploaded = 0;
        FileInputStream inputStream = new FileInputStream(file);
        byte[] buffer = new byte[partSize];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) > 0) {
            partsUploaded++;
            System.out.println("Tamanho parte upload " + partsUploaded + " : " + buffer.length );
            System.out.println("Parte " + partsUploaded + " de " + totalParts + " uploaded.");
        }
        inputStream.close();
        
    }
}
    

