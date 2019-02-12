package com.freesoft.identity.manager.web.rest.context;

import java.util.Locale;

public class LocaleContextHolder {

    private static ThreadLocal<Locale> localeHolder = new ThreadLocal<>();

    public static Locale getLocale() {
        return localeHolder.get();
    }

    public static void setLocale(Locale locale) {
        localeHolder.set(locale);
    }
}
