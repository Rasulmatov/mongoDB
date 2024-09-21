package uz.universes.mongodb.controller.entitiy;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthUserCriteria {
    private String name;
    private int page = 0;
    private int size = 10;
}
