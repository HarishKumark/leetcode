/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphs;

/**
 *
 * @author hkorada
 */
import java.util.concurrent.TimeUnit;

public class RoomSPHotReqProcessor {

    private static int roomSPValue = 0;
    private static long lastHotReqTime = 0;

    public static void processParameter(String parameter, int value, long timestamp) {
        if (parameter.equals("RoomSP")) {
            roomSPValue = value;
            System.out.println("Updated RoomSP value: " + roomSPValue);
        } else if (parameter.equals("HotReq")) {
            if (timestamp - lastHotReqTime >= TimeUnit.MINUTES.toMillis(1)) {
                roomSPValue += value;
                lastHotReqTime = timestamp;
                System.out.println("Processed HotReq. New RoomSP value: " + roomSPValue);
            } else {
                System.out.println("Received HotReq. Waiting for 1 minute before processing again.");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Simulated parameter values for demonstration
        String[] parameters = {"RoomSP:10", "HotReq:5", "RoomSP:15", "HotReq:10","ColdReq:5",  "RoomSp:5"};
        int[] values = {100, 20, 120, 30};
        long[] timestamps = {System.currentTimeMillis(), System.currentTimeMillis() + 5000,
            System.currentTimeMillis() + 60000, System.currentTimeMillis() + 61000};

        for (int i = 0; i < parameters.length; i++) {
            processParameter(parameters[i], values[i], timestamps[i]);
            TimeUnit.SECONDS.sleep(1); // Simulate time between parameter updates
        }
    }
}
