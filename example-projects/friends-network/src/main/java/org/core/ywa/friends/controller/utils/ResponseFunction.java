package org.core.ywa.friends.controller.utils;

@FunctionalInterface
public interface ResponseFunction<T> {
	T doResponse();
}
