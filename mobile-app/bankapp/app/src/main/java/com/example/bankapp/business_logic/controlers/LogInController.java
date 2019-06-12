package com.example.bankapp.business_logic.controlers;

import com.example.bankapp.data_access.models.User;
import com.example.bankapp.data_access.repositories.UserRepository;

public class LogInController {

    public enum LogInControllerResultEnum{
        SUCCESS, USER_NO_FOUND, INVALID_PASSWORD
    }

    public class LogInControllerResult{

        public final User user;
        public final LogInControllerResultEnum result;

        private LogInControllerResult(User user, LogInControllerResultEnum result){
            this.user = user;
            this.result = result;
        }
    }

    private UserRepository userRepository;

    public  LogInController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public LogInControllerResult makeLogIn(long userId, String password){
        //Verify User
        User loggedUser = userRepository.getById(userId);
        if(loggedUser == null) return new LogInControllerResult(null, LogInControllerResultEnum.USER_NO_FOUND);

        //Verify Password
        if(loggedUser.getPassword().compareTo(password) != 0) return new LogInControllerResult(null, LogInControllerResultEnum.INVALID_PASSWORD);

        return new LogInControllerResult(loggedUser, LogInControllerResultEnum.SUCCESS);
    }
}
