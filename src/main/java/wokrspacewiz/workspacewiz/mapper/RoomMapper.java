package wokrspacewiz.workspacewiz.mapper;

import org.apache.ibatis.annotations.Mapper;
import wokrspacewiz.workspacewiz.domain.RoomDTO;

import java.util.List;
import java.util.Map;

@Mapper
public interface RoomMapper {
    void roomInsert(RoomDTO dto);

    List<RoomDTO> roomSelectList(String officeNum);

    RoomDTO roomSelectOne(Map<String, String> map);

    void roomUpdate(RoomDTO dto);

    int roomDelete(String roomsNum);
}
