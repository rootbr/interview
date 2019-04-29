package com.rootbr.interview;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class MainTests {
  public String foo() {
    return "s";
  }

  @Test
  public void test() {
    List list = mock(ArrayList.class);
    when(list.get(anyInt())).thenReturn(new Object());
    var b = true;
    assertThat(b).isTrue();
    assertThat(list.get(1)).isNotNull();
  }
}
