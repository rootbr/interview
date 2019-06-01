package com.rootbr;

import com.rootbr.cronis.tree.Node;
import java.util.Random;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class RandomTreeProvider implements ArgumentsProvider {
  private static Random random = new Random();

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
    Node[] trees = new Node[1000];
    for (int i = 0; i < trees.length; i++) {
      Node<Integer> tree = new Node<>(null);
      for (int j = 0; j < random.nextInt(200); j++) {
        tree.put(random.nextInt(50));
      }
      trees[i] = tree;
    }
    return Stream.of(trees).map(Arguments::of);
  }
}
