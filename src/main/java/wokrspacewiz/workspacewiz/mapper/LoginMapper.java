package wokrspacewiz.workspacewiz.mapper;

import org.apache.ibatis.annotations.Mapper;
import wokrspacewiz.workspacewiz.domain.AuthInfoDTO;

@Mapper
public interface LoginMapper {
    AuthInfoDTO loginSelect(String userId);
}
