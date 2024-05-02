package wokrspacewiz.workspacewiz.command;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberCommand {
    private String memberNum; // 자동부여
    @NotEmpty(message = "아이디를 입력해주세요")
    private String memberId;
    @NotEmpty(message = "비밀번호를 입력해주세요")
    private String memberPw;
    @NotBlank(message = "비밀번호 확인을 입력해주세요.")
    private String memberPwCon;
    @NotEmpty(message = "이름을 입력해주세요")
    private String memberName;
    @NotBlank(message = "주소를 입력하여 주세요.")
    private String memberAddr;
    private String memberAddrDetail;
    private String memberPost;
    private String memberGender;
    @NotBlank(message = "연락처을 입력하여 주세요.")
    @Size(min = 11, max = 13)
    private String memberPhone1;
    @Size(min = 11, max = 13)
    private String memberPhone2;
    @NotBlank(message = "이메일을 입력하여 주세요.")
    private String memberEmail;
    @NotNull(message="생년월일을 입력해주세요.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date memberBirth;
    /// String이 아닌 자료형은 @NotNull이다
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date memberRegist;
}
