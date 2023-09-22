package next.cesar.school.uploadarquviosapijava.upload;

import java.io.*;
import java.net.*;
import java.net.HttpURLConnection;



public class UploadArquivo {
    public static void main(String[] args) throws Exception {
        String url = "http://localhost:8080/upload";
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
            String hash = HashCalculate.getHash(buffer);
            sendPart(hash, buffer, bytesRead, bytesRead, bytesRead);
            System.out.println("Tamanho parte upload " + partsUploaded + " : " + buffer.length );
            System.out.println("Parte " + partsUploaded + " de " + totalParts + " uploaded.");
        }
        inputStream.close();
        
    }

    private static void sendPart(String hash, byte[] buffer, int bytesRead, int partsUploaded, int partSize) {
        String url = "http://localhost:8080/upload/" + String.valueOf(partsUploaded);
      
       
    
    }
}
    

