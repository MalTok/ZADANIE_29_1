package pl.mt.cookbook.user;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserDtoMapper userDtoMapper;

    public UserService(UserRepository userRepository, UserDtoMapper userDtoMapper) {
        this.userRepository = userRepository;
        this.userDtoMapper = userDtoMapper;
    }

    @Transactional
    public void save(UserDto userDto) {
        User user = userDtoMapper.map(userDto);
        userRepository.save(user);
    }

    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(userDtoMapper::mapToDto).toList();
    }
}
