package wokrspacewiz.workspacewiz.mapper;

import org.apache.ibatis.annotations.Mapper;
import wokrspacewiz.workspacewiz.domain.MemberDTO;

import java.util.List;

@Mapper
public interface MemberMapper {
    void memberInsert(MemberDTO dto);

    List<MemberDTO> memberSelectList();

    MemberDTO memberSelectOne(String memberNum);

    void memberUpdate(MemberDTO dto);

    int memberDelete(String memberNum);

    int memberSignInInsert(MemberDTO dto);

    int userEmailCheckUpdate(String chk);
}
