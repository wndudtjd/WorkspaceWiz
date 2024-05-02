package wokrspacewiz.workspacewiz.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import wokrspacewiz.workspacewiz.command.MemberCommand;
import wokrspacewiz.workspacewiz.domain.MemberDTO;
import wokrspacewiz.workspacewiz.mapper.MemberMapper;

@Service
@RequiredArgsConstructor
public class MemberUpdateService {

    private final MemberMapper memberMapper;

    public void execute(String memberNum, MemberCommand memberCommand) {
        MemberDTO dto = new MemberDTO();
        BeanUtils.copyProperties(memberCommand, dto);
        dto.setMemberNum(memberNum);
        memberMapper.memberUpdate(dto);
    }
}
