package wokrspacewiz.workspacewiz.service.module;

import kotlin.Pair;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileUploadService {
    public String saveFile(String directory, MultipartFile mf) throws IOException {
        if (mf == null || mf.isEmpty()) return null;

        String originalFilename = mf.getOriginalFilename();
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String storeName = UUID.randomUUID().toString().replace("-", "");
        String storeFileName = storeName + extension;
        File targetFile = new File(directory, storeFileName);
        mf.transferTo(targetFile);
        return storeFileName;
    }

    public Pair<String, String> saveMultipartFile(String directory, MultipartFile[] files) {
        StringBuilder originalTotal = new StringBuilder();
        StringBuilder storeTotal = new StringBuilder();
        for(MultipartFile mf : files) {
            try {
                String storedFileName = saveFile(directory, mf);
                if (storedFileName != null) {
                    originalTotal.append(mf.getOriginalFilename()).append("/");
                    storeTotal.append(storedFileName).append("/");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new Pair<>(storeTotal.toString(), originalTotal.toString());
    }
}
