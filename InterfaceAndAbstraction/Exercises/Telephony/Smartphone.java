package Telephony;


import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;

    }

    @Override
    public String browse() {
        StringBuilder builder = new StringBuilder();
        for (String url : urls) {
            if (hasNumber(url)) {
                builder.append("Invalid URL!").append(System.lineSeparator());
            } else {
                builder.append(String.format("Browsing: %s!", url)).append(System.lineSeparator());
            }

        }

        return builder.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder builder = new StringBuilder();
        for (String number : numbers) {
            if (hasOnlyDigit(number)) {
                builder.append(String.format("Calling... %s", number)).append(System.lineSeparator());
            } else {
                builder.append("Invalid number!").append(System.lineSeparator());
            }

        }

        return builder.toString().trim();
    }

    private boolean hasNumber(String input) {

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))){
                return true;
            }

        }
        return false;
    }


    private boolean hasOnlyDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;

            }


        }
        return true;
    }
}
