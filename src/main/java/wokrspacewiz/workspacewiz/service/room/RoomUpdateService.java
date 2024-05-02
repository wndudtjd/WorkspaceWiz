package wokrspacewiz.workspacewiz.service.room;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import wokrspacewiz.workspacewiz.command.RoomCommand;
import wokrspacewiz.workspacewiz.domain.RoomDTO;
import wokrspacewiz.workspacewiz.mapper.RoomMapper;

@Service
@RequiredArgsConstructor
public class RoomUpdateService {

    private final RoomMapper roomMapper;

    public void execute(RoomCommand roomCommand) {
        RoomDTO dto = new RoomDTO();
        BeanUtils.copyProperties(roomCommand, dto);
        roomMapper.roomUpdate(dto);
    }
}
