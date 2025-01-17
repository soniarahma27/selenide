package com.codeborne.selenide.impl;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.Duration;
import java.util.Optional;

public class Arguments {
  private final Object[] args;

  public Arguments(@Nullable Object... args) {
    this.args = args;
  }

  @CheckReturnValue
  @Nonnull
  public <T> Optional<T> ofType(@Nonnull Class<T> klass) {
    if (args == null) return Optional.empty();

    for (Object arg : args) {
      if (arg != null && klass.isAssignableFrom(arg.getClass()))
        //noinspection unchecked
        return Optional.of((T) arg);
    }
    return Optional.empty();
  }

  @CheckReturnValue
  public long getTimeoutMs(long defaultTimeout) {
    return ofType(Duration.class).map(Duration::toMillis)
      .orElseGet(() ->
        ofType(HasTimeout.class).map(HasTimeout::timeout).map(Duration::toMillis)
          .orElse(defaultTimeout)
      );
  }
}
