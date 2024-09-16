package uz.universes.mongodb.service.otp;

import org.h2.engine.User;
import uz.universes.mongodb.entity.Users;

public interface OtpService {
    void generateOtp(Users o);
}
