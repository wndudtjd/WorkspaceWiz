package wokrspacewiz.workspacewiz.mapper;

import org.apache.ibatis.annotations.Mapper;
import wokrspacewiz.workspacewiz.domain.OfficeDTO;

import java.util.List;

@Mapper
public interface OfficeMapper {
    void officeInsert(OfficeDTO dto);

    List<OfficeDTO> officeSelectList();

    OfficeDTO officeSelectOne(String officeNum);
}
