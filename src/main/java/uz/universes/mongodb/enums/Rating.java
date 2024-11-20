package uz.universes.mongodb.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Rating {
    FIVE_STARS("⭐⭐⭐⭐⭐","5"),
    FOUR_STARS("⭐⭐⭐⭐", "4"),
    THREE_STARS("⭐⭐⭐", "3"),
    TWO_STARS("⭐⭐", "2"),
    ONE_STAR("⭐", "1");

    private final String star;
    private final String rate;


    public static Rating findByRate(String rate) {
        for (Rating rating: values()){
            if (rating.rate.equals(rate)) {
                return rating;
            }
        }
        return null;
    }
}
