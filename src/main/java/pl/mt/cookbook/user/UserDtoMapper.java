package pl.mt.cookbook.user;

import org.springframework.stereotype.Service;

@Service
public class UserDtoMapper {
    public UserDto mapToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setBirthDate(user.getBirthDate());
        userDto.setEmail(user.getEmail());
        userDto.setNewsletter(user.isNewsletter());
        return userDto;
    }

    public User map(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setBirthDate(userDto.getBirthDate());
        user.setEmail(userDto.getEmail());
        user.setNewsletter(userDto.isNewsletter());
        return user;
    }
}
