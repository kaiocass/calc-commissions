package org.technical.test;

import org.technical.test.model.Transfer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransferBatch {

    public static void main(String[] args) {

        String filePath = args[0];

        List<Transfer> transfers = new ArrayList<>();
        Map<String, Double> commissions = new HashMap<>();
        double highestTransferAmount = 0.0;
        Transfer highestTransfer = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] dataLine = line.split(",");

                String accountID = dataLine[0];
                String transferID = dataLine[1];
                double amount = Double.parseDouble(dataLine[2]);

                Transfer transfer = new Transfer(accountID, transferID, amount);
                transfers.add(transfer);

                if (amount > highestTransferAmount) {
                    highestTransferAmount = amount;
                    highestTransfer = transfer;
                }
            }
            calculateCommissions(transfers, commissions, highestTransfer);
            printResults(commissions);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    private static void printResults(Map<String, Double> commissions) {
        commissions.forEach((key, value) -> System.out.printf("%s,%.0f%n", key, value));
    }

    private static void calculateCommissions(List<Transfer> transfers,
                                             Map<String, Double> commissions,
                                             Transfer highestTransfer) {

        for (Transfer transfer : transfers) {
            if (transfer.getAccountID().equals(highestTransfer.getAccountID())
                    && transfer.getTotalTransferAmount() == highestTransfer.getTotalTransferAmount()) {
                continue;
            }
            commissions.merge(transfer.getAccountID(), transfer.getTotalTransferAmount() * 0.10, Double::sum);
        }
    }
}