package com.github.throyer.sender.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;

public class JSON {
  private JSON() { }

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  public static <T> String stringify(final T object) {
    try {
      return OBJECT_MAPPER.writeValueAsString(object);
    } catch (JsonProcessingException exception) {
      return "";
    }
  }

  public static <T> T parse(String json, Class<T> type) {
      try {
        return OBJECT_MAPPER.readValue(json, type);
      } catch (JsonProcessingException exception) {
        return  null;
      }
  }

  public static Message setContentTypeJson(Message message) {
    message.getMessageProperties().setContentType("json");
    return message;
  }
}
