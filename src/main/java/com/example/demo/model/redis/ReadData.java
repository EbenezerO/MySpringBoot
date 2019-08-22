package com.example.demo.model.redis;

import de.siegmar.fastcsv.reader.CsvContainer;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ReadData {
    public Author FindAll(String key ) throws IOException {
        File file = new File("D:\\Idea\\workspace\\demo\\src\\main\\java\\com\\example\\demo\\model\\redis\\data.csv");
        CsvReader csvReader = new CsvReader();
        csvReader.setContainsHeader(true);

        CsvContainer csv = csvReader.read(file, StandardCharsets.UTF_8);
        for (CsvRow row : csv.getRows()) {
            if(row.getField("id").equals(key))
            {
                Author temp=new Author();
                temp.setName(row.getField("name"));
                temp.setIntro_l(row.getField("intro"));
                System.out.println(temp.toString());
                return temp;
            }
        }
        return  null;
    }

    public static void main(String[] args) {
        ReadData a=new ReadData();
        try {
            System.out.println(a.FindAll("a3"));
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

}
