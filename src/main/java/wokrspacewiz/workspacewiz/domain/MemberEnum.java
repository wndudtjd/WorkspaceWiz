package wokrspacewiz.workspacewiz.domain;

import org.apache.ibatis.type.Alias;

@Alias("memEnum")
public enum MemberEnum {
    // memberType
    MT01, // local
    MT02, // kakao
    MT03, // google
    MT04 // naver
}
