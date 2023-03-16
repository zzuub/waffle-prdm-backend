package com.pr_dm.eco.config.oauth;


import com.pr_dm.eco.User.dto.UserDto;
import com.pr_dm.eco.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
@Slf4j
public class LoginIndexController {
    private final PostService postService;

    @GetMapping("/logintest")
    public String index(Model model, @LoginUser UserDto user){
        model.addAttribute("post", postService.findAllDesc());

        if(user != null){
            model.addAttribute("username", user.getName());
        }
        return "login test";
    }
}
