package wokrspacewiz.workspacewiz.service.module;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wokrspacewiz.workspacewiz.mapper.MemberMapper;

@Service
@RequiredArgsConstructor
public class UserEmailCheckService {

    private final MemberMapper memberMapper;

    public int execute(String chk) {
        int i = memberMapper.userEmailCheckUpdate(chk);
        return i;
    }
}
