package uz.universes.mongodb.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Reting {
    FIVE_STARS("⭐⭐⭐⭐⭐","5"),
    FOUR_STARS("⭐⭐⭐⭐", "4"),
    THREE_STARS("⭐⭐⭐", "3"),
    TWO_STARS("⭐⭐", "2"),
    ONE_STAR("⭐", "1");

    String star;
    String rate;


}
