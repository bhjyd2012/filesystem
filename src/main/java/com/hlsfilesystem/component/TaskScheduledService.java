package com.hlsfilesystem.component;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



/**   
 * @ClassName:  TaskScheduledService   
 * @Description:TODO(定时任务类)   
 * @author: hucheng 
 * @date:   2019年8月9日 下午4:15:12       
 * @Copyright: 2019 www.xxxx.com Inc. All rights reserved. 
 * 注意：本内容仅限于xxxxxxxxx传阅，禁止外泄以及用于其他的商业目
*/  
@Component
public class TaskScheduledService {
	 /**   
	 * @Title: deleteFile   
	 * @Description: TODO(定时清除upload文件上传目录中的Excel文件)   
	 * @param:       
	 * @return: void      
	 * @throws   
	 */  
	@Scheduled(cron = "0/5 * * * * *")
     private void deleteFile() {
    	SimpleDateFormat sip = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String date = sip.format(new Date());
    	System.err.println(date+":开始执行定时器!");
    	
    	String path = System.getProperty("user.dir");
    	System.out.println(path);
		String serverpath = path.replace("filesystem", "filesystem\\src\\main\\resources\\static\\exceltemplate\\upload\\");
		//ExcelUtil.deleteFile(serverpath)//自定义Excel工具类中的删除文件方法
		System.err.println(serverpath);
		System.out.println();
     }
}
