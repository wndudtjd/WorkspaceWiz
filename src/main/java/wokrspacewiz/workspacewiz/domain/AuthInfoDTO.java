package wokrspacewiz.workspacewiz.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("authInfo")
public class AuthInfoDTO {
    private String userNum;
    private String userId;
    private String userPw;
    private String userName;
    private String grade;
    private String userEmail;
    private String userEmailCheck;
}
