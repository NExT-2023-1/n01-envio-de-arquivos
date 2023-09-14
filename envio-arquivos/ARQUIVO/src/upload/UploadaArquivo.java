package upload;

import java.io.*;
import java.net.*;

public class UploadaArquivo {

    public static void main(String[] args) throws Exception {
        String url = "http://example.com/upload";
        String fileName = "example.txt";
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
            URLConnection connection = new URL(url).openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/octet-stream");
            connection.setRequestProperty("Content-Length", String.valueOf(bytesRead));
            connection.setRequestProperty("Content-Range", "bytes " + ((partsUploaded - 1) * partSize) + "-" + ((partsUploaded - 1) * partSize + bytesRead - 1) + "/" + fileSize);
            connection.setDoOutput(true);
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(buffer, 0, bytesRead);
            outputStream.close();
            System.out.println("Parte " + partsUploaded + " de " + totalParts + " uploaded.");
        }
        inputStream.close();
        
    }
}
    

