package br.com.nagata.dev.controller.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public final class URL {

  private URL() {
    throw new IllegalStateException("Utility class");
  }

  public static String decodeParam(String text) {
    return URLDecoder.decode(text, StandardCharsets.UTF_8);
  }
}
