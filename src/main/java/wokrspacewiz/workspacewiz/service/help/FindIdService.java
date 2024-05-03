package wokrspacewiz.workspacewiz.service.help;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import wokrspacewiz.workspacewiz.mapper.FindMapper;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FindIdService {

    private final FindMapper findMapper;

    public boolean execute(String userPhone, String userEmail, Model model) {
        Map<String, String> map = new HashMap<>();
        map.put("userPhone", userPhone);
        map.put("userEmail", userEmail);
        String userId = findMapper.findId(map);
        if (userId != null) {
            model.addAttribute("userId", userId);
            return true;
        }else {
            return false;
        }
    }
}
