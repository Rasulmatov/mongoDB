package uz.universes.mongodb.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.universes.mongodb.enums.Rating;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = ("post"))
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String body;
    private Rating rating;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
}
