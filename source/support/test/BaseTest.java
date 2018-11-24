package source.support.test;

import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class BaseTest { // still unsure how this class will be used
    public static Logger logger;

    void setup(final Class clazz) {
        logger = Logger.getLogger(clazz.getName());
        final ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                final StringBuilder builder = new StringBuilder();
                builder.append("\n[")
                    .append("\033[35m")
                    .append(record.getSourceClassName())
                    .append(".")
                    .append(record.getSourceMethodName())
                    .append("\033[0m")
                    .append("]\n");
                return builder.toString();
            }
        });
        logger.addHandler(handler);
        logger.info("L1 | P1");
    }
}
