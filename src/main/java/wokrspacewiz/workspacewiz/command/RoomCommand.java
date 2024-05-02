package wokrspacewiz.workspacewiz.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomCommand {
    private String roomsNum;
    private String officeNum;
    private String roomsName;
    private Integer roomsPrice;
    private String roomsContent;
    private MultipartFile roomsMainStore;
    private MultipartFile roomsImages[];
}
