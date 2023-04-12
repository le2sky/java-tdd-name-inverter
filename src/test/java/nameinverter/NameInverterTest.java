package nameinverter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class NameInverterTest {

    @Test
    void name() {
        assertThat(invert(null)).isEqualTo("");
        assertThat(invert("")).isEqualTo("");
        assertThat(invert("name")).isEqualTo("name");
    }

    private String invert(String name) {
        if (name == null || name.isEmpty()) {
            return "";
        } else {
            return name;
        }
    }
}