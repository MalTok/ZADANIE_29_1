package pl.mt.cookbook.user;

import jakarta.validation.Valid;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.mt.cookbook.user.dto.UserEditNewsletterDto;
import pl.mt.cookbook.user.dto.UserEditPasswordDto;
import pl.mt.cookbook.user.dto.UserEditPersonalDto;
import pl.mt.cookbook.user.mapper.UserEditNewsletterDtoMapper;
import pl.mt.cookbook.user.mapper.UserEditPasswordDtoMapper;
import pl.mt.cookbook.user.mapper.UserEditPersonalDtoMapper;

import java.util.Optional;

@RequestMapping("/user")
@Controller
class UserController {
    private final UserService userService;
    private final UserEditPersonalDtoMapper userEditPersonalDtoMapper;
    private final UserEditPasswordDtoMapper userEditPasswordDtoMapper;
    private final UserEditNewsletterDtoMapper userEditNewsletterDtoMapper;

    public UserController(UserService userService, UserEditPersonalDtoMapper userEditPersonalDtoMapper,
                          UserEditPasswordDtoMapper userEditPasswordDtoMapper,
                          UserEditNewsletterDtoMapper userEditNewsletterDtoMapper) {
        this.userService = userService;
        this.userEditPersonalDtoMapper = userEditPersonalDtoMapper;
        this.userEditPasswordDtoMapper = userEditPasswordDtoMapper;
        this.userEditNewsletterDtoMapper = userEditNewsletterDtoMapper;
    }

    @GetMapping("/update")
    public String update(@CurrentSecurityContext(expression = "authentication.name") String username, Model model) {
        Optional<User> usernameOptional = userService.findByEmail(username);
        if (usernameOptional.isPresent()) {
            User user = usernameOptional.get();
            UserEditPersonalDto userEditPersonalDto = userEditPersonalDtoMapper.maptoDto(user);
            model.addAttribute("userPersonal", userEditPersonalDto);
            UserEditPasswordDto userEditPasswordDto = userEditPasswordDtoMapper.maptoDto(user);
            model.addAttribute("userPassword", userEditPasswordDto);
            UserEditNewsletterDto userEditNewsletterDto = userEditNewsletterDtoMapper.maptoDto(user);
            model.addAttribute("userNewsletter", userEditNewsletterDto);
        }
        return "user-form-edit";
    }

    @PostMapping("/update/personal-data")
    public String updateData(@Valid @ModelAttribute("userPersonal") UserEditPersonalDto userEditPersonalDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             Model model) {
        Optional<User> usernameOptional = userService.findByEmail(userEditPersonalDto.getEmail());
        if (usernameOptional.isPresent()) {
            User user = usernameOptional.get();
            UserEditPasswordDto userEditPasswordDto = userEditPasswordDtoMapper.maptoDto(user);
            model.addAttribute("userPassword", userEditPasswordDto);
            UserEditNewsletterDto userEditNewsletterDto = userEditNewsletterDtoMapper.maptoDto(user);
            model.addAttribute("userNewsletter", userEditNewsletterDto);
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("userPersonal", userEditPersonalDto);
            return "user-form-edit";
        } else {
            userService.updateData(userEditPersonalDto);
            redirectAttributes.addFlashAttribute("updateMessage", true);
            return "redirect:/user/update";
        }
    }

    @PostMapping("/update/password")
    public String updatePassword(@Valid @ModelAttribute("userPassword") UserEditPasswordDto userEditPasswordDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {
        Optional<User> usernameOptional = userService.findByEmail(userEditPasswordDto.getEmail());
        if (usernameOptional.isPresent()) {
            User user = usernameOptional.get();
            UserEditPersonalDto userEditPersonalDto = userEditPersonalDtoMapper.maptoDto(user);
            model.addAttribute("userPersonal", userEditPersonalDto);
            UserEditNewsletterDto userEditNewsletterDto = userEditNewsletterDtoMapper.maptoDto(user);
            model.addAttribute("userNewsletter", userEditNewsletterDto);
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("userPassword", userEditPasswordDto);
            return "user-form-edit";
        } else {
            userService.updatePassword(userEditPasswordDto);
            redirectAttributes.addFlashAttribute("updateMessage", true);
            return "redirect:/user/update";
        }
    }

    @PostMapping("/update/newsletter")
    public String updateNewsletter(@Valid @ModelAttribute("userNewsletter") UserEditNewsletterDto userEditNewsletterDto,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes,
                                   Model model) {
        Optional<User> usernameOptional = userService.findByEmail(userEditNewsletterDto.getEmail());
        if (usernameOptional.isPresent()) {
            User user = usernameOptional.get();
            UserEditPersonalDto userEditPersonalDto = userEditPersonalDtoMapper.maptoDto(user);
            model.addAttribute("userPersonal", userEditPersonalDto);
            UserEditPasswordDto userEditPasswordDto = userEditPasswordDtoMapper.maptoDto(user);
            model.addAttribute("userPassword", userEditPasswordDto);
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("userNewsletter", userEditNewsletterDto);
            return "user-form-edit";
        } else {
            userService.updateNewsletter(userEditNewsletterDto);
            redirectAttributes.addFlashAttribute("updateMessage", true);
            return "redirect:/user/update";
        }
    }
}
