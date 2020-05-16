package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ArgumentTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("input이 null이거나 빈 값일 경우 IllegalException이 발생하는지 체크")
    public void emptyInputTest(String arg){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Argument.stringExpressionToList(arg));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 * 2 + 3 ? 4", "1 * 2 + 3 4 4", "1 +", "*"})
    @DisplayName("argument invalid format 테스트")
    public void invalidSymbolTest(String arg){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Argument.stringExpressionToList(arg));
    }

    @ParameterizedTest
    @CsvSource(value = {"1 * 2 + 3 - 1 / 4:9"}, delimiter = ':')
    @DisplayName("argument toList 테스트")
    public void toListTest(String arg, int expected){
        assertThat(Argument.stringExpressionToList(arg)).hasSize(expected);
    }
}