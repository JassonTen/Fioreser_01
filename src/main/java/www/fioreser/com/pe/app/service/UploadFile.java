package www.fioreser.com.pe.app.service;

import java.io.*;
import java.nio.file.*;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author FENIX
 */
public class UploadFile {
    private final String FOLDER = "images//";
    private final String IMG_DEFAULT = "default.jpg";
    
    
    public String upload(MultipartFile multipartFile) throws IOException{
        if(!multipartFile.isEmpty()){
            byte [] bytes = multipartFile.getBytes();
            Path path = Paths.get(FOLDER + multipartFile.getOriginalFilename());
            Files.write(path, bytes);
            return multipartFile.getOriginalFilename();
            
        }
        return IMG_DEFAULT;
    }
    public void delete(String nameFile){
        File file = new File(FOLDER + nameFile);
        file.delete();
    }
}
