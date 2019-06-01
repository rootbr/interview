package com.rootbr.cronis.recursion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class PermutationsTests {

  @Test
  @Disabled
  public void generateArrayWithAllVariants() {
    char[] source = {'a', 'b', 'c'};


    char[][] results = Permutations.execute(source);
    char[][] answer = {
        {'a', 'b', 'c'}, {'a', 'c', 'b'},
        {'b', 'a', 'c'}, {'b', 'c', 'a'},
        {'c', 'a', 'b'}, {'c', 'b', 'a'}
    };
    assertThat(results).containsOnly(answer);

  }
}
