class Solution {

    String[] ones = {
        "", "One", "Two", "Three", "Four",
        "Five", "Six", "Seven", "Eight", "Nine",
        "Ten", "Eleven", "Twelve", "Thirteen",
        "Fourteen", "Fifteen", "Sixteen", "Seventeen",
        "Eighteen", "Nineteen"
    };

    String[] tens = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    public String numberToWords(int num) {

        if (num == 0) {
            return "Zero";
        }

        String result = "";

        if (num >= 1000000000) {
            result += convert(num / 1000000000) + " Billion ";
            num %= 1000000000;
        }

        if (num >= 1000000) {
            result += convert(num / 1000000) + " Million ";
            num %= 1000000;
        }

        if (num >= 1000) {
            result += convert(num / 1000) + " Thousand ";
            num %= 1000;
        }

        if (num > 0) {
            result += convert(num);
        }

        return result.trim();
    }

    // Converts a number from 1 to 999
    private String convert(int num) {

        String result = "";

        if (num >= 100) {
            result += ones[num / 100] + " Hundred ";
            num %= 100;
        }

        if (num >= 20) {
            result += tens[num / 10] + " ";
            num %= 10;
        }

        if (num > 0) {
            result += ones[num] + " ";
        }

        return result.trim();
    }
}
