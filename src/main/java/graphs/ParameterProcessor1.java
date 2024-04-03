/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class ParameterProcessor1 {

    // Simulated data storage for previous values
    private static Map<String, Integer> previousValues = new HashMap<>();

    // Method to fetch parameter values from an external source
    public static Map<String, Integer> fetchParameterValues() {
        // Simulated parameter values for demonstration
        Map<String, Integer> parameterValues = new HashMap<>();
        parameterValues.put("VAV_VAV_01_Room1_ColdReq", 10);
//        parameterValues.put("VAV_VAV_01_Room1_HotReq", 20);
        parameterValues.put("VAV_VAV_01_Room1_RoomSP", 10);
        // Add more parameter values as needed
        return parameterValues;
    }

    // Method to process parameter values
    public static void processParameter(String device, String location, String parameter, int value) {
        if (parameter.equals("RoomSP")) {
            // Get the previous value of HotReq or ColdReq
            Integer previousValue = previousValues.getOrDefault("VAV_" + device + "_" + location + "_HotReq", 0);
            if (previousValue == 0) {
                previousValue = previousValues.getOrDefault("VAV_" + device + "_" + location + "_ColdReq", 0);
            }
            // Add the previous value to the RoomSP value
            value += previousValue;
            System.out.println("Processed RoomSP: " + value);
        }
        // Store the current value for future reference
        previousValues.put("VAV_" + device + "_" + location + "_" + parameter, value);
    }

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            // Fetch parameter values dynamically
            Map<String, Integer> parameterValues = fetchParameterValues();

            // Process each parameter value
            if (parameterValues != null) {
                for (Map.Entry<String, Integer> entry : parameterValues.entrySet()) {
                    String[] parts = entry.getKey().split("_");
                    String device = parts[1];
                    String location = parts[2];
                    String parameter = parts[4];
                    int value = entry.getValue();
                    processParameter(device, location, parameter, value);
                }
            }

            
            System.out.println("previousValue "+previousValues);
            // Wait for 1 minute before fetching and processing the next set of values
            TimeUnit.MINUTES.sleep(1);
        }
    }
}
