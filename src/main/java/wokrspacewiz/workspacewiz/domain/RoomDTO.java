package wokrspacewiz.workspacewiz.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("room")
public class RoomDTO {
    private String roomsNum;
    private String officeNum;
    private String roomsName;
    private Integer roomsPrice;
    private String roomsContent;
    private String roomsMainStore;
    private String roomsMainStoreImg;
    private String roomsImages;
    private String roomsImagesImg;
    private Integer visitCount;
}
