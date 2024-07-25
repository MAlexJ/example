package com.malex.lecture_15_Lambda_Functional_Interface.supplier.usage;

import static org.assertj.core.api.Assertions.assertThat;

import com.malex.utils.AbstractUtils;
import java.util.Optional;
import java.util.function.Supplier;
import org.junit.Test;
import org.mockito.Mockito;

public class Optional_orElseGet extends AbstractUtils {

  @Test
  public void notNullValue() {
    // given
    Integer num = 1;

    // when
    Integer result = Optional.ofNullable(num).orElseGet(applySupplier());

    // then
    assertThat(result).isEqualTo(1);
  }

  @Test
  public void nullValue() {
    // given
    Integer num = null;

    // when
    Integer result = Optional.ofNullable(num).orElseGet(applySupplier());

    // then
    assertThat(result).isEqualTo(Integer.MAX_VALUE);
  }

  @Test
  public void mockitoLazyInitialization() {
    var clazzMock = Mockito.mock(Optional_orElseGet.class);

    clazzMock.notNullValue();
    Mockito.verify(clazzMock, Mockito.times(0)).applySupplier();
  }

  private Supplier<Integer> applySupplier() {
    Supplier<Integer> supplier =
        () -> {
          println("Lazy initialization!");
          return Integer.MAX_VALUE;
        };
    return supplier;
  }
}
