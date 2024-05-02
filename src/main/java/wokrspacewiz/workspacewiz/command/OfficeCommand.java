package wokrspacewiz.workspacewiz.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfficeCommand {
    private String officeNum;
    private String officeAddr;
    private String officeAddrDetail;
    private Integer officePost;
    private String officeName;
    private String officePhone;
}
