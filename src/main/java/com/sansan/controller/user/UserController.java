package com.sansan.controller.user;

import com.sansan.bean.system.User;
import com.sansan.common.ExcelUtil;
import com.sansan.common.Response;
import com.sansan.service.UserService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户管理类
 * @author Sisansan
 * @date 2018-05-23
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userSrv;
	
	/**
	 * 获取用户列表
	 * @return
	 */
	@RequestMapping(value="/getListUser", method=RequestMethod.GET, produces={ "application/json;charset=UTF-8" })
	@ResponseBody
	public Response getListUser(){
		int total;
		List<User> list = userSrv.getListUser();
		total = list.size();
		Map<String, Object> map = new HashMap<>();
		map.put("Rows", list);
		map.put("Total", total);
		
 		return new Response().success(map);
	}
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/addUser", method=RequestMethod.POST, produces={ "application/json;charset=UTF-8" })
	@ResponseBody
	public Response addUser(User user){
		Map<String, Object> map = new HashMap<>();
		
		try{
			map = userSrv.addUser(user);
		}catch(Exception e){
			e.printStackTrace();
			map.put("msg", "服务器异常");
			map.put("code",0);
		}
		
		return new Response().success(map);
	}

	/**
	 * 编辑用户
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/editUser", method=RequestMethod.POST, produces={ "application/json;charset=UTF-8" })
	@ResponseBody
	public Response editUser(User user){
		Map<String, Object> map = new HashMap<>();
		try{
			map = userSrv.editUser(user);
		}catch (Exception e){
			e.printStackTrace();
			map.put("msg","service error...");
			map.put("code",0);
		}

		return new Response().success(map);
	}

	/**
	 * 删除用户
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/deleteUser", method=RequestMethod.POST, produces={ "application/json;charset=UTF-8" })
	@ResponseBody
	public Response deleteUser(User user){
		Map<String,Object> map = new HashMap<>();
		try{
			map = userSrv.deleteUser(user);
		}catch (Exception e){
			e.printStackTrace();
			map.put("msg","service error...");
			map.put("code",0);
		}
		return new Response().success(map);
	}

	/**
	 * 导出报表
	 * @return
	 */
	@RequestMapping(value="/exportUser", method=RequestMethod.GET, produces={ "application/json;charset=UTF-8" })
	@ResponseBody
	public void exportUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取数据
		List<User> list = userSrv.getListUser();

		//excel标题
        String[] title = {"序号","用户名","密码","真实姓名","年龄","性别","联系地址","联系方式","注册日期"};

        //excel文件名
		String fileName = "用户信息表"+System.currentTimeMillis()+".xls";

  		//sheet名
        String sheetName = "用户信息表";

        //导出的内容
		String[][] content =  new String[list.size()][];

		for (int i = 0; i < list.size(); i++) {
			content[i] = new String[title.length];
			User obj = list.get(i);
			content[i][0] = String.valueOf(obj.getUserID());
			content[i][1] = obj.getUserName();
			content[i][2] = obj.getPassWord();
			content[i][3] = obj.getName();
			content[i][4] = String.valueOf(obj.getAge());
			content[i][5] = String.valueOf(obj.getSex());
			content[i][6] = obj.getAddress();
			content[i][7] = obj.getPhone();
			content[i][8] = obj.getRegTime();
        }

		//创建HSSFWorkbook
		HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);

		//响应到客户端
		try {
				this.setResponseHeader(response, fileName);
				OutputStream os = response.getOutputStream();
				wb.write(os);
				os.flush();
				os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	//发送响应流方法
	public void setResponseHeader(HttpServletResponse response, String fileName) {
		try {
			try {
				fileName = new String(fileName.getBytes(),"ISO8859-1");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setContentType("application/octet-stream;charset=ISO8859-1");
			response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
			response.addHeader("Pargam", "no-cache");
			response.addHeader("Cache-Control", "no-cache");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
