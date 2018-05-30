# BusInfoSystem
基于maven项目管理软件配置的SSM框架的车辆信息管理软件
  
  1、maven是一款基于项目全生命周期的资源管理软件，可以在此基础上快速地完成项目基础工程建设；
  
  2、提供jar本地中间库，方便项目导入jar包提供管理；
 
关于SSM框架实现web项目跨域访问，采用Rest控制器编写规则，因此配置项目跨域请求的时候新建了一个FilterCORSFilter.class过滤器类，基于web.xml配置如下：
  
   <filter>  
       
       <filter-name>SimpleCORSFilter</filter-name>  
       <filter-class>Filter.SimpleCORSFilter</filter-class>  
       <init-param>  
           <param-name>IsCross</param-name>  
           <param-value>true</param-value>  
       </init-param>  
   </filter>  
   <filter-mapping>  
       
       <filter-name>SimpleCORSFilter</filter-name>  
       <url-pattern>/*</url-pattern>  
   
   </filter-mapping>

其中该过滤器配置需要在项目编码过滤器配置之前。另外一种方式就是配置maven的jar包导入文件，映入cors-filter.jar,然后配置web.xml,这种方式不适合@RestController,初步判断适合@Controller+@ResponseBody规范类控制接口类。
