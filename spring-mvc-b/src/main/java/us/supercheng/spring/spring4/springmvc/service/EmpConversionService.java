package us.supercheng.spring.spring4.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import us.supercheng.spring.spring4.springmvc.entity.Dept;
import us.supercheng.spring.spring4.springmvc.entity.Emp;

public class EmpConversionService implements Converter<String, Emp> {

    @Autowired
    private DeptService deptService;

    @Override
    public Emp convert(String source) {
        System.out.println("convert method source: " + source);

        if(source!=null) {
            System.out.println("convert method source: is not null");
            String [] infoList = source.split("-");
            if(infoList != null && infoList.length == 6) {

                Emp emp = new Emp(infoList[0],infoList[1],infoList[2],infoList[3],Integer.parseInt(infoList[4]), new Dept("9","Test"));
                System.out.println("Converted: "  + emp);
                Dept dept = null;
                System.out.println("infoList != null && infoList.length == 6");
                // System.out.println("Total Dept: " + deptService.getAllDepts().size());

                return emp;


//                for (Dept each : deptService.getAllDepts()) {
//                    System.out.println("Searching Dept......" + each.getDeptId() + " infoList[5]: " + infoList[5]);
//                    if((each.getDeptId() + "").equalsIgnoreCase(infoList[5])) {
//                        emp.setEmpDept(each);
//                        System.out.println("Custom Emp Converter: " + emp);
//                        return emp;
//                    }
//                }
            }
        }
        return null;
    }
}
