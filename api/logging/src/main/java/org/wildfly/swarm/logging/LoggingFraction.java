package org.wildfly.swarm.logging;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.wildfly.swarm.container.Fraction;

/**
 * @author Bob McWhirter
 */
public class LoggingFraction implements Fraction {

    private Map<String, Formatter> formatters = new HashMap<>();

    private ConsoleHandler consoleHandler;

    private RootLogger rootLogger;

    public LoggingFraction() {
    }

    public LoggingFraction formatter(String name, String pattern) {
        this.formatters.put(name, new Formatter(name, pattern));
        return this;
    }

    public Collection<Formatter> formatters() {
        return this.formatters.values();
    }

    public LoggingFraction consoleHandler(String level, String formatter) {
        this.consoleHandler = new ConsoleHandler(level, formatter);
        return this;
    }

    public ConsoleHandler consoleHandler() {
        return this.consoleHandler;
    }

    public LoggingFraction rootLogger(String handler, String level) {
        this.rootLogger = new RootLogger(handler, level);
        return this;
    }

    public RootLogger rootLogger() {
        return this.rootLogger;
    }
}