package next.cesar.school.uploadarquviosapijava.controllers;

import java.io.File;
import java.io.IOException;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/upload")
public class UploadController {

	// @Autowired
	// private UploadController storageService;

	@PostMapping("/file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		try{
			// Verifica se o arquivo está vazio
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("O arquivo está vazio.");
            }
			// Salva o arquivo em algum diretório (por exemplo, 'uploads/')
            String uploadDir = "uploads/";
            String fileName = file.getOriginalFilename();
            String filePath = uploadDir + fileName;
            File dest = new File(filePath);
            file.transferTo(dest);
			//String fileName = storageService.storeFile(file);

			return ResponseEntity.ok("Arquivo " + fileName + " carregado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro ao carregar o arquivo.");
        }
		}
		// String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
		// 		.path(fileName).toUriString();

		// return new Response(fileName, fileDownloadUri, file.getContentType(), file.getSize());
	}
