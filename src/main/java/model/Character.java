package model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

import static model.CharacterType.GIANT;
import static model.CharacterType.GNOME;
import static model.CharacterType.GOD;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Character {
    private final int id;
    private final String name;
    private final CharacterType characterType;
    private float hitPoints;


    public static List<Character> getCharacters() {
        return List.of(
                new Character(1, "Kratos", GOD, 1200f),
                new Character(2, "Atreus", GOD, 400f),
                new Character(3, "Sindri", GNOME, 200.5f),
                new Character(4, "Brok", GNOME, 200.5f),
                new Character(7, "Jörmungandr", GIANT, 10000f),
                new Character(8, "Mimir", GIANT, 100f));

    }
}
