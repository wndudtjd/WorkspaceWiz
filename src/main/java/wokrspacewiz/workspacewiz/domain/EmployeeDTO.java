package wokrspacewiz.workspacewiz.domain;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Alias("employee")
public class EmployeeDTO {
    private String empNum;
    private String empId;
    private String empPw;
    private String empName;
    private String empAddr;
    private String empAddrDetail;
    private Integer empPost;
    private String empPhone;
    private String empEmail;
    private Date empRegiDate;
    private String empJumin;
}
