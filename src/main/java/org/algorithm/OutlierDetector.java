package org.algorithm;

import java.math.BigDecimal;
import java.util.ArrayList;

public class OutlierDetector {

    public static void main(String[] args) {
        ArrayList<BigDecimal> data = new ArrayList<>();
        data.add(BigDecimal.valueOf(9.12));
        data.add(BigDecimal.valueOf(0.09));
        data.add(BigDecimal.valueOf(0));
        data.add(BigDecimal.valueOf(0.105));
        data.add(BigDecimal.valueOf(0));

        BigDecimal[] outliers = detectOutliers(data);
        System.out.println("Outliers:");
        for (BigDecimal outlier : outliers) {
            System.out.println(outlier);
        }
    }

    public static BigDecimal[] detectOutliers(ArrayList<BigDecimal> data) {
        // Convert the list to an array for easier manipulation
        BigDecimal[] dataArray = new BigDecimal[data.size()];
        dataArray = data.toArray(dataArray);

        // Sort the array in ascending order
        java.util.Arrays.sort(dataArray);

        // Calculate the quartiles
        BigDecimal Q1 = dataArray[dataArray.length / 4];
        BigDecimal Q3 = dataArray[dataArray.length * 3 / 4];

        // Calculate the interquartile range
        BigDecimal IQR = Q3.subtract(Q1);

        // Calculate the extended interquartile range
        BigDecimal extendedIQR = IQR.multiply(BigDecimal.valueOf(1.5));

        // Calculate the bounds to identify outliers
        BigDecimal lowerBound = Q1.subtract(extendedIQR);
        BigDecimal upperBound = Q3.add(extendedIQR);

        // Identify outliers
        ArrayList<BigDecimal> outliersList = new ArrayList<>();
        for (BigDecimal value : dataArray) {
            if (value.compareTo(lowerBound) < 0 || value.compareTo(upperBound) > 0) {
                outliersList.add(value);
            }
        }

        // Convert the list of outliers to an array
        BigDecimal[] outliersArray = new BigDecimal[outliersList.size()];
        outliersArray = outliersList.toArray(outliersArray);

        return outliersArray;
    }
}
