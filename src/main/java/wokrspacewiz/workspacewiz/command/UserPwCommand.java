package wokrspacewiz.workspacewiz.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPwCommand {
    private String oldPw;
    private String newPw;
    private String newPwCon;

    public boolean isMemberPwEqualsMemberPwCon() {
        return newPw.equals(newPwCon);
    }
}
