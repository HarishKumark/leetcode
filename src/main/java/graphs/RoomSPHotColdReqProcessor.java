/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphs;

/**
 *
 * @author hkorada
 */
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RoomSPHotColdReqProcessor {

    private static int roomSPValue = 0;
    private static int hotReqValue = 0;
    private static long lastHotReqTime = 0;
    private static long lastColdReqTime = 0;

    public static void processParameter(String parameterName, int value) {
        System.out.println("Updated " + parameterName + " value: " + roomSPValue);
        switch (parameterName) {
            case "RoomSP":
                if (hotReqValue > 0) {
                    roomSPValue -= hotReqValue;
                    hotReqValue = 0; // Reset hotReqValue
                }
                roomSPValue += value;
                System.out.println("Updated " + parameterName + " value: " + roomSPValue);
                break;
            case "HotReq":
                long currentTime = System.currentTimeMillis();
                long timeDifference = currentTime - lastHotReqTime;

                if (value > 0 && timeDifference >= TimeUnit.MINUTES.toMillis(2)) {
                    hotReqValue = value;
                    lastHotReqTime = currentTime;
                    System.out.println("Processed HotReq. New HotReq value: " + hotReqValue);
                } else if (value > 0) {
                    System.out.println("Received HotReq. Waiting for " + (TimeUnit.MINUTES.toMillis(2) - timeDifference) + " milliseconds before processing again.");
                }
                break;
            case "ColdReq":
                if (roomSPValue > 0) {
                    roomSPValue += value;
                    System.out.println("Updated " + parameterName + " value: " + roomSPValue);
                }
                break;
            default:
                break;
        }
    }

    public static String generateRandomParameter(Random random) {
        String[] parameterTypes = {"RoomSP", "HotReq", "ColdReq"};
        int index = random.nextInt(parameterTypes.length);
        int randomValue = random.nextInt(50) + 1; // Generate random value between 1 and 50
        return parameterTypes[index] + ":" + randomValue;
    }

    public static void main(String[] args) throws InterruptedException {
        // Simulated parameter values for demonstration
        Random random = new Random();

        while (true) {
//            String[] parameters = {"HotReq:10", "RoomSP:10", "HotReq:5", "RoomSP:10", "ColdReq:5", "RoomSP:10"};

            String parameter = generateRandomParameter(random);

//            for (String parameter : parameters) {
            String[] parts = parameter.split(":");
            int value = Integer.parseInt(parts[1]);
            processParameter(parts[0], value);
            TimeUnit.SECONDS.sleep(1); // Simulate time between parameter updates
//            }
        }
    }
}
