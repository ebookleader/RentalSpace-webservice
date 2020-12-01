package com.webservice.rentalSpace.service.user;

import com.webservice.rentalSpace.domain.user.User;
import com.webservice.rentalSpace.domain.user.UserRepository;
import com.webservice.rentalSpace.web.dto.UserUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public Long updateToSeller(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new IllegalArgumentException("There is no user where email = "+email)
        );
        user.updateToSeller();
        return user.getId();
    }
}
