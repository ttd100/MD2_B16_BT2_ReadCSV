package rikkei.academy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String PATH_FILE = "E:\\IdeaProjects\\MD2\\Bai16\\TH2-ReadCSV\\src\\rikkei\\academy\\countries.csv";

        List<Country> countries = parseList(PATH_FILE);

        System.out.println(countries);
    }

    public static List<Country> parseList(String PATH) {
        List<Country> countries = new ArrayList<Country>() {
            @Override
            public String toString() {
                StringBuilder s = new StringBuilder();
                for (Country c : this) {
                    s.append(c.toString()).append("\n");
                }
                return s.toString();
            }
        };
        try (
                BufferedReader reader = new BufferedReader(new FileReader(PATH));
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] infor = line.split(",");
                countries.add(new Country(Integer.parseInt(infor[0]), infor[1].replace("\"", ""), infor[2].replace("\"", "")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countries;
    }


}
