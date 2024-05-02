package wokrspacewiz.workspacewiz.service.room;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import wokrspacewiz.workspacewiz.domain.RoomDTO;
import wokrspacewiz.workspacewiz.mapper.RoomMapper;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RoomDetailService {

    private final RoomMapper roomMapper;

    public void execute(String roomsNum, String officeNum, Model model) {
        Map<String, String> map = new HashMap<>();
        map.put("roomsNum", roomsNum);
        map.put("officeNum", officeNum);
        RoomDTO dto = roomMapper.roomSelectOne(map);
        model.addAttribute("roomCommand", dto);
    }
}
