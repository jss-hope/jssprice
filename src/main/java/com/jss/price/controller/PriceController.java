package com.jss.price.controller;

import com.jss.price.bo.Lunzhengfei;

import java.io.File;
import java.util.List;

import com.jss.price.repository.LunzhengfeiRepository;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/price")
public class PriceController {
    @Autowired
    private LunzhengfeiRepository lunzhengfeiRepository;
    @RequestMapping(value = "/importLunzhengfei")
    public  void importLunzhengfei(@RequestParam("projectId") Integer projectId,
                                   @RequestParam("excelPath") String excelPath){
        try {
            //String excelPath;
           Workbook workbook = Workbook.getWorkbook( new File(excelPath));
           // Workbook workbook = Workbook.getWorkbook(new File("E:/test.xls"));
            Sheet sheet=workbook.getSheet(3);
            //3:获取数据
            System.out.println("行："+sheet.getRows());
            System.out.println("列："+sheet.getColumns());
            //Lunzhengfei lzf= new Lunzhengfei();
            //合计
            Lunzhengfei lzfh= new Lunzhengfei();

            Cell cellItemh=sheet.getCell(0,5);
            lzfh.setItem(cellItemh.getContents());
            Cell cellRenshuLzh=sheet.getCell(2,5);
            System.out.println("shuchu"+cellRenshuLzh.getContents());
            lzfh.setlRenshu(Integer.parseInt(cellRenshuLzh.getContents()));
            Cell cellCishuLzh=sheet.getCell(4,5);
            lzfh.setlCishu(Integer.parseInt(cellCishuLzh.getContents()));
            Cell cellTianshuLzh=sheet.getCell(6,5);
            lzfh.setlTianshu(Integer.parseInt(cellTianshuLzh.getContents()));
            Cell cellShisufeiLzh=sheet.getCell(8,5);
            lzfh.setlShisufei(Double.parseDouble(cellShisufeiLzh.getContents()));
            Cell cellChailufeiLzh=sheet.getCell(10,5);
            lzfh.setlChailufei(Double.parseDouble(cellChailufeiLzh.getContents()));
            Cell cellMoneyLzh=sheet.getCell(12,5);
            lzfh.setlMoney(Double.parseDouble(cellMoneyLzh.getContents()));
            lzfh.setProjectId(projectId);
            lunzhengfeiRepository.save(lzfh);

            for(int i=6;i<9;i++){
                Lunzhengfei lzf= new Lunzhengfei();
                Cell cellOrder=sheet.getCell(0,i);
                lzf.setItemOrder(Integer.parseInt(cellOrder.getContents()));
                Cell cellItem=sheet.getCell(1,i);
                lzf.setItem(cellItem.getContents());
                Cell cellRenshuLz=sheet.getCell(2,i);
                lzf.setlRenshu(Integer.parseInt(cellRenshuLz.getContents()));
                Cell cellCishuLz=sheet.getCell(4,i);
                lzf.setlCishu(Integer.parseInt(cellCishuLz.getContents()));
                Cell cellTianshuLz=sheet.getCell(6,i);
                lzf.setlTianshu(Integer.parseInt(cellTianshuLz.getContents()));
                Cell cellShisufeiLz=sheet.getCell(8,i);
                lzf.setlShisufei(Double.parseDouble(cellShisufeiLz.getContents()));
                Cell cellChailufeiLz=sheet.getCell(10,i);
                lzf.setlChailufei(Double.parseDouble(cellChailufeiLz.getContents()));
                Cell cellMoneyLz=sheet.getCell(12,i);
                lzf.setlMoney(Double.parseDouble(cellMoneyLz.getContents()));
                lzf.setProjectId(projectId);
                lunzhengfeiRepository.save(lzf);
                }
                //System.out.println();

            workbook.close();
            //lunzhengfeiRepository.save(lzf);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/saveLunzhengfei")
    public  void saveLunzhengfei(Lunzhengfei lzf){
        this.lunzhengfeiRepository.save(lzf);
    }
    //Put请求更新指定Id的
    @PutMapping(value="/update/{uuid}")
    public Lunzhengfei update(@PathVariable("uuid") Long uuid,
                          @RequestParam("sRenshu") Integer sRenshu,
                          @RequestParam("sCishu") Integer sCishu){
        Lunzhengfei lzf = new Lunzhengfei();
        lzf.setUuid(uuid);
        lzf.setsRenshu(sRenshu);
        lzf.setsCishu(sCishu);

        return lunzhengfeiRepository.save(lzf);
    }
    //更新指定projectId和itemOrder的数据
    @RequestMapping(value="/updateRenshu")
    public void updateByProject(@RequestParam("uuid") Long uuid,
                                @RequestParam(value = "sRenshu") Integer sRenshu){
//        Lunzhengfei  lzf = find(uuid);
//        if(sRenshu == null){
//            sRenshu = lun.geSR;
//        }
         lunzhengfeiRepository.updateByProject(uuid,  sRenshu);
         System.out.println("hhhh");

    }

    @RequestMapping(value="/updateCishu")
    public void updateCishu(@RequestParam("uuid") Long uuid,
                                @RequestParam(value = "sCishu") Integer sCishu) {
        lunzhengfeiRepository.updateCishu(uuid, sCishu);

    }

    //通过指定pid来查询
    @GetMapping(value="/findByProjectId/{projectId}")
    public List<Lunzhengfei> findByProjectId(@PathVariable("projectId") Integer projectId){
        return lunzhengfeiRepository.findByProjectId(projectId);
    }

    //通过指定pid来查询,按照itemorder排列
    @RequestMapping(value = "/listLzfByProjectId")
    public  List<Lunzhengfei> listLzfByProjectId(Integer projectId){
        return  lunzhengfeiRepository.listLzfByProjectId(projectId);

    }

    @RequestMapping(value = "/lunzhengfei")
    @ResponseBody
    public List<Lunzhengfei> test(){
        return lunzhengfeiRepository.findAll();
    }
}
