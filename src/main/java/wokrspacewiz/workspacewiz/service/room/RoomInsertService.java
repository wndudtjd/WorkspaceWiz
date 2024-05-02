package wokrspacewiz.workspacewiz.service.room;

import kotlin.Pair;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import wokrspacewiz.workspacewiz.command.RoomCommand;
import wokrspacewiz.workspacewiz.domain.RoomDTO;
import wokrspacewiz.workspacewiz.mapper.AutoNumMapper;
import wokrspacewiz.workspacewiz.mapper.RoomMapper;
import wokrspacewiz.workspacewiz.service.module.FileUploadService;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoomInsertService {

    private final RoomMapper roomMapper;
    private final AutoNumMapper autoNumMapper;
    private final FileUploadService fileUploadService;

    public void execute(RoomCommand roomCommand) throws IOException {
        RoomDTO dto = new RoomDTO();
        BeanUtils.copyProperties(roomCommand, dto);

        Map<String, String> map = new HashMap<>();
        map.put("tableName", "rooms");
        map.put("columnName", "rooms_num");
        map.put("sep", "rom");
        String roomsNum = autoNumMapper.autoNumSelect(map);
        dto.setRoomsNum(roomsNum);

        // 파일추가
        // URL resource = getClass().getClassLoader().getResource("static");
        String resource = "/Users/juyeongseong/Desktop/WorkspaceWiz/WorkspaceWiz/src/main/resources/static/upload";

        String storeFileName = fileUploadService.saveFile(resource, roomCommand.getRoomsMainStore());
        dto.setRoomsMainStore(storeFileName);
        dto.setRoomsMainStoreImg(roomCommand.getRoomsMainStore().getOriginalFilename());

        if(!roomCommand.getRoomsImages()[0].getOriginalFilename().isEmpty() && roomCommand.getRoomsImages() != null && roomCommand.getRoomsImages().length > 0) {
            Pair<String, String> imagesFiles = fileUploadService.saveMultipartFile(resource, roomCommand.getRoomsImages());
            dto.setRoomsImages(imagesFiles.getFirst()); // storeImg
            dto.setRoomsImagesImg(imagesFiles.getSecond()); // originalImg
        }
        roomMapper.roomInsert(dto);
    }
}
