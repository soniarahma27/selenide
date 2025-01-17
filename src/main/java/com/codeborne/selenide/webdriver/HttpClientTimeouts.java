package com.codeborne.selenide.webdriver;

import javax.annotation.ParametersAreNonnullByDefault;
import java.time.Duration;

/**
 * A temporary workaround to override default timeouts of NettyClient used in Selenium.
 *
 * Its default read timeout 3 minutes is too long.
 * Selenide sets to 1.5 minutes.
 *
 * @since 5.22.0
 * @deprecated The only field of this class {@link #defaultLocalReadTimeout} will be
 * moved to {@link SelenideNettyClientFactory} in 6.8.0
 */
@Deprecated
@ParametersAreNonnullByDefault
public class HttpClientTimeouts {
  @Deprecated
  public static Duration defaultLocalReadTimeout = Duration.ofSeconds(90);
}
