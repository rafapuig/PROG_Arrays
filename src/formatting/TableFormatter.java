package formatting;

import java.text.Format;
import java.util.StringJoiner;

public class TableFormatter<T> {

    ColumnInfo<T>[] columns;

    private final String header;
    private final String lineSeparator;

    private static final String delimiter = " ";


    @SafeVarargs
    public TableFormatter(ColumnInfo<T>... columns) {
        this.columns = columns;
        this.header = generateHeader();
        this.lineSeparator = generateLineSeparator();
    }

    private static String centerAligned(String text, int width) {
        int printedLength = text.length();
        int padding = width - printedLength;
        int paddingLeft = padding / 2;

        return String.format("%-" + width + "s",
                String.format("%" + (paddingLeft + printedLength) + "s",
                        text));
    }

    private String generateHeader() {

        StringJoiner joiner = new StringJoiner(delimiter);

        for (ColumnInfo<T> column : columns) {
            String columnLabel = generateColumnHeader(column);
            joiner.add(columnLabel);
        }

        return joiner.toString();
    }

    private String generateColumnHeader(ColumnInfo<T> column) {
        String columnName = column.getColumnName().toUpperCase();
        int columnLength = column.getColumnLength();
        return centerAligned(columnName, columnLength);
    }


    private String generateLineSeparator() {
        return  "-".repeat(header.length());
    }


    public String getTable(T[] items) {

        StringJoiner joiner = new StringJoiner(System.lineSeparator());

        joiner.add(header);
        joiner.add(lineSeparator);
        String tableRows = getRows(items);
        joiner.add(tableRows);

        return joiner.toString();
    }


    public String getRows(T[] items) {

        StringJoiner joiner = new StringJoiner(System.lineSeparator());

        for (int i = 0; i < items.length; i++) {
            joiner.add(getRow(items[i]));
        }

        return joiner.toString();
    }


    public String getRow(T item) {

        StringJoiner joiner = new StringJoiner(delimiter);

        for (int j = 0; j < columns.length; j++) {
            String cellContent = getCellContent(columns[j], item);
            joiner.add(cellContent);
        }
        return joiner.toString();
    }


    public String getCellContent(ColumnInfo<T> column, T item) {
        int cellLength = column.getColumnLength();
        Object fieldValue = column.getKeyExtractor().extract(item);
        Format formatter = column.getFormatter();

        String formattedValue = formatter != null ? formatter.format(fieldValue) : fieldValue.toString();

        boolean isNUmber = fieldValue instanceof Number;
        String contentFormat = "%" + (isNUmber ? "" : "-") + cellLength + "s";
        return String.format(contentFormat, formattedValue);
    }


}


