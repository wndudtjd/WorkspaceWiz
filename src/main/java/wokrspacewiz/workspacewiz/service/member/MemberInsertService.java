package wokrspacewiz.workspacewiz.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import wokrspacewiz.workspacewiz.command.MemberCommand;
import wokrspacewiz.workspacewiz.domain.MemberDTO;
import wokrspacewiz.workspacewiz.domain.MemberEnum;
import wokrspacewiz.workspacewiz.mapper.AutoNumMapper;
import wokrspacewiz.workspacewiz.mapper.MemberMapper;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MemberInsertService {

    private final MemberMapper memberMapper;
    private final AutoNumMapper autoNumMapper;
    private final PasswordEncoder passwordEncoder;

    public void execute(MemberCommand memberCommand) {
        Map<String, String> map = new HashMap<>();
        map.put("tableName", "members");
        map.put("columnName", "member_num");
        map.put("sep","mem");
        String memberNum = autoNumMapper.autoNumSelect(map);
        String newPw = passwordEncoder.encode(memberCommand.getMemberPw());
        MemberDTO dto = new MemberDTO();
        BeanUtils.copyProperties(memberCommand, dto);
        dto.setMemberNum(memberNum);
        dto.setMemberPw(newPw);
        dto.setMemberType(MemberEnum.MT01);
        memberMapper.memberInsert(dto);
    }
}
