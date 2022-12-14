package generic;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class ConverterTest {
    private String firstTypeName, secondTypeName;
    private Method[] declaredMethod;

    @BeforeClass
    void precondition() {
        TypeVariable<Class<Converter>>[] params = Converter.class.getTypeParameters();
        firstTypeName = params[0].getName();
        secondTypeName = params[1].getName();
        declaredMethod = Converter.class.getDeclaredMethods();
    }

    @Test(description = "Converter interface has two generic parameters")
    void converterHasTwoGenericParams() {
        TypeVariable<Class<Converter>>[] parameters = Converter.class.getTypeParameters();

        assertThat(parameters.length)
                .isEqualTo(2);
    }

    @Test(description = "Converter interface has different generic parameters")
    void converterHasDifferentGenericParams() {
        assertThat(firstTypeName)
                .isNotEqualTo(secondTypeName);
    }

    @Test(description = "Methods return types are generics")
    void methodsReturnTypeIsGeneric() throws NoSuchMethodException {
        assertThat(declaredMethod)
                .extracting(Method::getGenericReturnType)
                .extracting(Type::getTypeName)
                .contains(firstTypeName, secondTypeName);
    }

    @Test(description = "Methods return types parents are core java classes")
    void methodsParentReturnTypeIsCoreClass() {
        assertThat(declaredMethod)
                .extracting(Method::getReturnType)
                .containsOnly(Number.class, Date.class);
    }
}