package wokrspacewiz.workspacewiz.service.room;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import wokrspacewiz.workspacewiz.domain.RoomDTO;
import wokrspacewiz.workspacewiz.mapper.RoomMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomListService {

    private final RoomMapper roomMapper;

    public void execute(String officeNum, Model model) {
        List<RoomDTO> list = roomMapper.roomSelectList(officeNum);
        model.addAttribute("list", list);
    }
}
