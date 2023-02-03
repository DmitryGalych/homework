package stream;

import model.Character;
import model.CharacterType;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

import static model.CharacterType.GNOME;
import static model.CharacterType.GOD;
import static org.assertj.core.api.Assertions.assertThat;

public class GodOfStreamTest {
    private final List<Character> characters = Character.getCharacters();

    @Test
    void shouldReturnCharacterNames() {
        assertThat(StreamUtils.getNames(characters))
                .hasSize(characters.size())
                .hasOnlyElementsOfType(String.class)
                .doesNotContainNull();
    }

    @Test
    void shouldReturnEmptyListByNegativeId() {
        assertThat(StreamUtils.getCharactersByFilter(characters, ch -> ch.getId() == -1))
                .isEmpty();
    }

    @Test
    void shouldReturnCharactersWithTypeGnome() {
        assertThat(StreamUtils.getCharactersByFilter(characters, ch -> ch.getCharacterType().equals(GNOME)))
                .extracting(Character::getName)
                .containsOnly("Sindri", "Brok");
    }

    @Test
    void shouldReturnCountOfCharactersWithTypeGod() {
        assertThat(StreamUtils.getCountOfCharacters(characters, GOD))
                .isEqualTo(2);
    }

    @Test
    void shouldReturnCharacterWithMaxHitPoints() {
        assertThat(StreamUtils.getCharacterWithMaxHitPoints(characters))
                .extracting(Character::getName)
                .isEqualTo("Jörmungandr");
    }

    @Test
    void shouldReturnCharactersSortedByIdInReversedMode() {
        Comparator<Character> comparator = Comparator.comparing((ch) -> -ch.getId());
        assertThat(StreamUtils.sortWithReverseOrder(characters, Comparator.comparing(Character::getId)))
                .isSortedAccordingTo(comparator);
    }

    @Test
    void shouldReturnMapGroupedByCharacterType() {
        assertThat(StreamUtils.groupCharactersByType(characters))
                .containsOnlyKeys(CharacterType.values());
    }
}