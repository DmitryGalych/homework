package options;

import model.Character;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.Optional;

import static model.CharacterType.GIANT;
import static model.CharacterType.GOD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OptionsTest {

    @Test
    void shouldReturnOptionalWithString() {
        final String expectedData = "Hello";
        assertThat(OptionUtils.getOptionalString(expectedData))
                .isExactlyInstanceOf(Optional.class)
                .contains(expectedData);
    }

    @Test
    void shouldThrowNullPointerException() {
        assertThatThrownBy(() -> OptionUtils.getOptionalString(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void shouldReturnCharacterFromList() {
        assertThat(OptionUtils.getCharacterByType(Character.getCharacters(), GIANT))
                .map(Character::getCharacterType)
                .get()
                .isEqualTo(GIANT);
    }

    @Test
    void shouldReturnEmptyOptionalObjFromEmptyList() {
        assertThat(OptionUtils.getCharacterByType(Collections.emptyList(), GOD))
                .isEmpty();
    }

    @Test
    void shouldReturnEmptyOptionalByNullType() {
        assertThat(OptionUtils.getCharacterByType(Character.getCharacters(), null))
                .isEmpty();
    }
}