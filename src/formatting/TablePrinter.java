package formatting;

import java.text.Format;
import java.util.StringJoiner;

public class TablePrinter<T> {

    ColumnInfo<T>[] columns;

    private final String header;

    private static final String delimiter = " ";


    @SafeVarargs
    public TablePrinter(ColumnInfo<T>... columns) {
        this.columns = columns;
        this.header = generateHeader();
    }

    public static String centerAligned(String text, int width) {
        int printedLength = text.length();
        int padding = width - printedLength;
        int paddingLeft = padding / 2;

        return String.format("%-" + width + "s",
                String.format("%" + (paddingLeft + text.length()) + "s",
                        text));
    }

    String generateHeader() {

        StringJoiner cellJoiner = new StringJoiner(delimiter);

        for (ColumnInfo<T> column : columns) {
            String columnName = column.getColumnName().toUpperCase();
            int columnLength = column.getColumnLength();
            String columnLabel = centerAligned(columnName, columnLength);
            cellJoiner.add(columnLabel);
        }

        String header = cellJoiner.toString();
        String lineSeparator = "-".repeat(header.length());
        return header + "\n" + lineSeparator;
    }

    public String getTable(T[] items) {

        StringJoiner joiner = new StringJoiner("\n");
        joiner.add(header);

        for (int i = 0; i < items.length; i++) {
            joiner.add(generateRow(items[i]));
        }

        return joiner.toString();
    }

    private String generateRow(T item) {

        StringJoiner joiner = new StringJoiner(delimiter);

        for (int j = 0; j < columns.length; j++) {

            int cellLength = columns[j].getColumnLength();
            Object fieldValue = columns[j].getKeyExtractor().apply(item);
            Format formatter = columns[j].getFormatter();

            String cellContent = formatter != null ? formatter.format(fieldValue) : fieldValue.toString();

            boolean isNUmber = fieldValue instanceof Number;
            String format = "%" + (isNUmber ? "" : "-") + cellLength + "s";
            String cell = String.format(format, cellContent);

            joiner.add(cell);
        }
        return joiner.toString();
    }

    private String getCellFormattedContent(ColumnInfo<T>  columnInfo, T item) {
        Format formatter = columnInfo.getFormatter();
        Object fieldValue = columnInfo.getKeyExtractor().apply(item);
        return formatter != null ? formatter.format(fieldValue) : fieldValue.toString();
    }

    private Object getCellValue(ColumnInfo<T> columnInfo, T item) {
        return columnInfo.getKeyExtractor().apply(item);
    }

}


