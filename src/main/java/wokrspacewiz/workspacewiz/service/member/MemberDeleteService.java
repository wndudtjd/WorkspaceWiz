package wokrspacewiz.workspacewiz.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wokrspacewiz.workspacewiz.mapper.MemberMapper;

@Service
@RequiredArgsConstructor
public class MemberDeleteService {

    private final MemberMapper memberMapper;

    public void execute(String memberNum) {
        int i = memberMapper.memberDelete(memberNum);
    }
}
