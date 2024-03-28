/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mavenproject1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author hkorada
 */
public class Mavenproject1 {

    public static void main(String[] args) {
        try {

            HashMap<String, HashMap<String, Date>> map = new HashMap<>();

            HashMap<String, Date> executedTypes = new HashMap<>();

            BufferedReader br
                    = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/home/hkorada/Downloads/testsignals.csv"))));
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");

                map.putIfAbsent(split[2], new HashMap<>());
                map.get(split[2]).putIfAbsent(split[0], new Date());

                if (split[0].equalsIgnoreCase("RoomSp")) {

                    String key = split[0] + "_" + split[2];
                    Date get = executedTypes.get(key);

                    Calendar cal = Calendar.getInstance();
                    cal.add(Calendar.MINUTE, 10);
                    Date time = cal.getTime();

                    Date executionTime = map.get(split[2]).get("HotReq");
                    if (new Date().after(executionTime)) {
                        System.out.println("hot req api calling");
                    }
                    executedTypes.putIfAbsent(key, time);
                }

            }
            System.out.println(map);
            System.out.println(executedTypes);
        } catch (Exception e) {
        }

    }

}
