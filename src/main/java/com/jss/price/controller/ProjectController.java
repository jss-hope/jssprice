package com.jss.price.controller;

import com.jss.price.bo.ShenjiaProject;
import com.jss.price.repository.ShenjiaProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ShenjiaProjectRepository shenjiaProjectRepository;

    @RequestMapping(value = "/create")
    public void createProject(@RequestParam("projectId") String projectId,
                              @RequestParam("projectName") String projectName,
                              @RequestParam("projectType") String projectType,
                              @RequestParam("createDate") String createDate,
                              @RequestParam("userId") String userId,
                              @RequestParam("projectStatus") String projectStutas
                              )throws Exception{

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ShenjiaProject sjp = new ShenjiaProject();
        Timestamp ctime = Timestamp.valueOf(createDate);
        Date tempTime = formatter.parse(createDate);
        sjp.setProjectId(projectId);
        sjp.setProjectName(projectName);
        sjp.setProjectType(projectType);
//        sjp.setCreateDate(ctime);
        sjp.setUserId(userId);
        sjp.setProjectStatus(projectStutas);


        //this.shenjiaProjectRepository.save(shenjiaProject);
    }

    @RequestMapping(value = "/inf")
    @ResponseBody
    public List<ShenjiaProject> test(){
        return shenjiaProjectRepository.findAll();
    }

}
