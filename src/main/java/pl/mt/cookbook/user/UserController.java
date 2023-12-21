package pl.mt.cookbook.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/user")
@Controller
class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "user-form";
    }

    @PostMapping("/add")
    public String add(UserDto userDto) {
        userService.save(userDto);
        return "redirect:/user/show-all";
    }

    @GetMapping("/show-all")
    public String showAll(Model model) {
        List<UserDto> userDtoList = userService.findAll();
        if (userDtoList.isEmpty()) {
            model.addAttribute("message", "Brak użytkowników w bazie.");
        }
        model.addAttribute("users", userDtoList);
        return "users";
    }
}
