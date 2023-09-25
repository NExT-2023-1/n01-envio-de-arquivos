package next.cesar.school.uploadarquviosapijava.payload;

public class Response {
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;

    public Response(String fileName, String fileDownloadUri, String fileType, long size){
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
    }
    
    public String getFileName(){
        return fileName;
    }
    
    public void SetFileName(String fileName){
        this.fileName = fileName;
    }
    
    public String getDownloadUri(){
        return fileDownloadUri;
    }

    public void SetFileDownloadUrl(String fileDownloadUrl){
        this.fileDownloadUri = fileDownloadUri;
    }

    public String getFileType(){
        return fileType;
    }

    public void SetFileType(String fileType){
        this.fileType = fileType;
    }

    public long getSize(){
        return size;
    }

    public void SetSize(){
        this.size = size;
    }
}
