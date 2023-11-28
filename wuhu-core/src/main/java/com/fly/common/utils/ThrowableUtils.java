package com.fly.common.utils;

import java.util.function.Supplier;

public class ThrowableUtils {

    public static boolean handle(Runnable handle) {
        try {
            handle.run();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static <T> T handle(Supplier<T> tryHandler) {
        try {
            return tryHandler.get();
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> T handle(Supplier<T> tryHandler, Supplier<T> catchHandler) {
        try {
            return tryHandler.get();
        } catch (Exception e) {
            return catchHandler.get();
        }
    }

    public static <T> T run(Supplier<T> tryHandler, Supplier<T> catchHandler, Runnable finallyHandler) {
        try {
            return tryHandler.get();
        } catch (Exception e) {
            return catchHandler.get();
        } finally {
            finallyHandler.run();
        }
    }

    public static <T> T run(Supplier<T> tryHandler, Runnable finallyHandler) {
        try {
            return tryHandler.get();
        } finally {
            finallyHandler.run();
        }
    }

    public static <T> T tryFinally(Supplier<T> tryHandle, Runnable finallyHandle) {
        try {
            return tryHandle.get();
        } finally {
            finallyHandle.run();
        }
    }

    public static void emptyCheck(Object target, String cause) {
        if (null == target) {
            throw new NullPointerException(cause);
        }
    }

    public static <T> T emptyCheck(Object target, T value) {
        return null == target ? null : value;
    }
}
