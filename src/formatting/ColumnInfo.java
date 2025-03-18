package formatting;

import java.text.Format;
import java.util.function.Function;

public class ColumnInfo<T> {
    private final String columnName;
    private final int columnLength;
    private final Format formatter;
    private final Function<T, Object> keyExtractor;

    public ColumnInfo(String columnName, int columnLength, Format formatter, Function<T, Object> keyExtractor) {
        this.columnName = columnName;
        this.columnLength = columnLength;
        this.formatter = formatter;
        this.keyExtractor = keyExtractor;
    }

    public String getColumnName() {
        return columnName;
    }

    public int getColumnLength() {
        return columnLength;
    }

    public Format getFormatter() {
        return formatter;
    }

    public Function<T, Object> getKeyExtractor() {
        return keyExtractor;
    }
}
