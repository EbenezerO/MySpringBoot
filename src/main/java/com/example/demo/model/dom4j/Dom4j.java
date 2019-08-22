package com.example.demo.model.dom4j;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.util.Iterator;
import java.util.List;


public class Dom4j {
    public String getXML(){
        String res="";
        try {
            SAXReader reader = new SAXReader();
            Document doc = reader.read("D:\\Idea\\workspace\\demo\\src\\main\\java\\com\\example\\demo\\model\\dom4j\\pm.xml");
            // 获取根节点
            Element root = doc.getRootElement();
            // 获取根节点下的子节点measData
            Element it1 = root.element("measData");
            Element it2 = it1.element("measInfo");

            List key = it2.elements("measType");

            Element it3 = it2.element("measValue");
            List value = it3.elements("r");
            Iterator<?> itk = key.iterator(), itv = value.iterator();
            while ( itk.hasNext())
            {
                Element ek = (Element) itk.next();
                Element ev = (Element) itv.next();;
                res+=(ek.getStringValue()+":"+ev.getStringValue()+"\r\n");
            }


        }catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;

    }

    public static void main(String[] args) {
        Dom4j t=new Dom4j();
        System.out.println(t.getXML());
    }

}
