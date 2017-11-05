package us.supercheng.spring.spring4.springmvc.service;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import us.supercheng.spring.spring4.springmvc.entity.Dept;
import us.supercheng.spring.spring4.springmvc.entity.Emp;

@Service
public class EmpConversionService implements Converter<String, Emp> {
    @Override
    public Emp convert(String source) {
        System.out.println("convert method source: " + source);
        if(source!=null) {
            System.out.println("convert method source: is not null");
            String [] infoList = source.split("-");
            if(infoList != null && infoList.length == 6) {
                Emp emp = new Emp(infoList[0],infoList[1],infoList[2],infoList[3],Integer.parseInt(infoList[4]),
                        new Dept(infoList[5],null));
                System.out.println("Converted: "  + emp);
                return emp;
            }
        }
        return null;
    }
}
