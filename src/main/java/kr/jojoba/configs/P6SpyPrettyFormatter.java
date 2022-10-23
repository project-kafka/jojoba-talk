package kr.jojoba.configs;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.engine.jdbc.internal.FormatStyle;

public class P6SpyPrettyFormatter implements MessageFormattingStrategy {
    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        if (StringUtils.isNoneBlank(sql)) {
            if (StringUtils.startsWithIgnoreCase(sql, "create") || StringUtils.startsWithIgnoreCase(sql, "alter") ||
                    StringUtils.startsWithIgnoreCase(sql, "comment")) {
                sql = FormatStyle.DDL.getFormatter().format(sql);
            } else {
                sql = FormatStyle.BASIC.getFormatter().format(sql);
            }
        }

        return "took " + elapsed + " ms | " + sql;
    }
}
