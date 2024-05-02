package wokrspacewiz.workspacewiz.service.room;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wokrspacewiz.workspacewiz.domain.RoomDTO;
import wokrspacewiz.workspacewiz.mapper.RoomMapper;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RoomDeleteService {

    private final RoomMapper roomMapper;

    public void execute(String roomsNum, String officeNum) {
        Map<String, String> map = new HashMap<>();
        map.put("roomsNum", roomsNum);
        map.put("officeNum", officeNum);
        RoomDTO dto = roomMapper.roomSelectOne(map);
        int i = roomMapper.roomDelete(roomsNum);
        if (i > 0) {
            String resource = "/Users/juyeongseong/Desktop/WorkspaceWiz/WorkspaceWiz/src/main/resources/static/upload";
            File file = new File(resource + "/" + dto.getRoomsMainStore());
            if(file.exists()) file.delete();
            if(dto.getRoomsImages() != null) {
                for(String fileName : dto.getRoomsImages().split("/")) {
                    // 2. 파일 객체 생성
                    file = new File(resource + "/" + fileName);
                    // 3. 파일 삭제
                    if(file.exists())file.delete();
                }
            }
        }
    }
}
