package generic;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleBoxTest {
    private String typeName;

    @BeforeClass
    void precondition() {
        typeName = SimpleBox.class.getTypeParameters()[0].getName();
    }

    @Test(description = "Box class has one generic parameter")
    void boxClassHasOneGenParam() {
        TypeVariable<Class<SimpleBox>>[] parameters = SimpleBox.class.getTypeParameters();

        assertThat(parameters.length)
                .isEqualTo(1);
    }

    @Test(description = "Generic parameter is not bounded")
    void genParamIsNotBounded() {
        TypeVariable<Class<SimpleBox>> parameter = SimpleBox.class.getTypeParameters()[0];

        assertThat(parameter.getBounds()[0].getTypeName())
                .isEqualTo(Object.class.getTypeName());
    }

    @Test(description = "Field 'object' has generic type")
    void classFieldIsGeneric() throws NoSuchFieldException {
        Field value = SimpleBox.class.getDeclaredField("object");
        Type genericType = value.getGenericType();

        assertThat(genericType.getTypeName())
                .isEqualTo(typeName);
    }

    @Test(description = "Constructor parameter type is generic")
    void constructorParameterIsGeneric() {
        Constructor<?> constructor = SimpleBox.class.getDeclaredConstructors()[0];
        Parameter parameter = constructor.getParameters()[0];

        assertThat(constructor.getParameters())
                .hasSize(1);
        assertThat(parameter.getParameterizedType().getTypeName())
                .isEqualTo(typeName);
    }

    @Test(description = "Getter type is generic")
    void getterReturnTypeIsGeneric() throws NoSuchMethodException {
        Method declaredMethod = SimpleBox.class.getDeclaredMethod("getObject");

        assertThat(declaredMethod.getGenericReturnType().getTypeName())
                .isEqualTo(typeName);
    }

    @Test(description = "Setter type is generic")
    void setterParameterIsGeneric() throws NoSuchMethodException {
        Method declaredMethod = SimpleBox.class.getDeclaredMethod("setObject", Object.class);
        Parameter parameter = declaredMethod.getParameters()[0];

        assertThat(declaredMethod.getParameters())
                .hasSize(1);
        assertThat(parameter.getParameterizedType().getTypeName())
                .isEqualTo(typeName);
    }
}
