package wokrspacewiz.workspacewiz.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("office")
public class OfficeDTO {
    private String officeNum;
    private String officeAddr;
    private String officeAddrDetail;
    private Integer officePost;
    private String officeName;
    private String officePhone;
    private String empNum;
}
