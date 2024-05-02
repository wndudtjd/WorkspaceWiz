package wokrspacewiz.workspacewiz.command;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeCommand {
    private String empNum;
    @NotEmpty(message = "아이디를 입력해주세요. ")
    @Size(min = 8, max = 12)
    private String empId;
    @Pattern(regexp = "^(?=.*?[A-Za-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-+]).{8,}$",
            message = "영문자와 숫자 그리고 특수문자가 포함된 8글자 이상")
    private String empPw;
    @NotEmpty(message = "비밀번호확인 입력하여 주세요.")
    private String empPwCon;
    @NotBlank(message = "이름을 입력하여 주세요.")
    private String empName;
    @NotBlank(message = "주소를 입력하여 주세요.")
    private String empAddr;
    private String empAddrDetail;
    private Integer empPost;
    @NotBlank(message = "연락처을 입력하여 주세요.")
    private String empPhone;
    @Email(message = "형식에 맞지 않습니다.")
    @NotEmpty(message = "이메일을 입력하여 주세요.")
    private String empEmail;
    @NotEmpty(message = "주민번호를 입력하여 주세요.")
    private String empJumin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date empRegiDate;
}
