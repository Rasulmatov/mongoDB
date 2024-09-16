package uz.universes.mongodb.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import uz.universes.mongodb.entity.Users;
@Getter
@RequiredArgsConstructor
public class OtpGenerateEvent{
  private final Users users;
}
