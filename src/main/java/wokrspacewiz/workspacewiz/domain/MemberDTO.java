package wokrspacewiz.workspacewiz.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("member")
public class MemberDTO {
    private String memberNum;
    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberAddr;
    private String memberAddrDetail;
    private String memberPost;
    private Date memberRegist;
    private String memberGender;
    private String memberPhone1;
    private String memberPhone2;
    private String memberEmail;
    private Date memberBirth;
    private Integer memberPoint;
    private String memberEmailConf;
    private MemberEnum memberType;
}
