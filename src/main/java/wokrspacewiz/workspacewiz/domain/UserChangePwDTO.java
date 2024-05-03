package wokrspacewiz.workspacewiz.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("userChangePw")
public class UserChangePwDTO {
    private String userId;
    private String userPw;
    private String userEmail;
    private String grade;
}
