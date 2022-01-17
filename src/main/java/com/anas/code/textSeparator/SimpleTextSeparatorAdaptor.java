package com.anas.code.textSeparator;


public abstract class SimpleTextSeparatorAdaptor implements SimpleTextSeparator{
    private TextSeparator[] textSeparators;

    public SimpleTextSeparatorAdaptor(TextSeparator[] textSeparators){
        setTextSeparators(textSeparators);
    }

    @Override
    public String[] split(String text) {
        return splitAdaptor(text);
    }

    protected String[] splitAdaptor(String text){
        String[] result = new String[1]; // 1 is a start length
        StringBuilder tempStringBuilder = new StringBuilder();

        // Blinding loop
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            boolean isSeparator = false;

            // Check if the char is a separator
            for (TextSeparator textSeparator : textSeparators) {
                if (textSeparator.isSeparator(c)) {
                    isSeparator = true;
                    break;
                }
            }
            // Add the before string to the temp string builder
            tempStringBuilder.append(c);

            // If the char is a separator, then add the temp string to the result
            if (isSeparator) {
                result[result.length - 1] = tempStringBuilder.toString();
                // Increase the result length
                result = increaseResultLength(result);
            }
        }
        return result;
    }

    private String[] increaseResultLength(String[] result) {
        String[] temp = new String[result.length + 1];
        for (int i = 0; i < result.length; i++) {
            temp[i] = result[i];
        }
        return temp;
    }

    // Getter and Setter
    public void setTextSeparators(TextSeparator[] textSeparators){
        this.textSeparators = textSeparators;
    }

    public TextSeparator[] getTextSeparators(){
        return textSeparators;
    }
}
