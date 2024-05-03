package wokrspacewiz.workspacewiz.mapper;

import org.apache.ibatis.annotations.Mapper;
import wokrspacewiz.workspacewiz.domain.UserChangePwDTO;

import java.util.Map;

@Mapper
public interface FindMapper {
    String findId(Map<String, String> map);

    int pwUpdate(UserChangePwDTO dto);
}
