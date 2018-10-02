package source.temp.help;
import java.util.logging.Formatter;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
/**
 * Allows log output to be formatted uniformly for all JUnit tests. I left this public and in 
 * a separate file instead of keeping it with {@code TestSetup} because there may be cases 
 * where I want different formatting outside of the problem sets.
 */
public class MyFormatter extends Formatter {
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
}
