import com.su.schedule.model.constants.TeacherConstant;
import com.su.schedule.spy.connnet.impl.PeizhengHttpConnectImpl;
import com.su.schedule.spy.resolver.impl.PeizhengHtmlResolver;
import junit.framework.TestCase;
import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shj on 2017/3/29.
 */
public class PeizhengHtmlResolverTestCase extends TestCase {

    private PeizhengHttpConnectImpl peizhengHttpConnect;
    private PeizhengHtmlResolver peizhengHtmlResolver;

    public PeizhengHtmlResolverTestCase(){

//        System.setProperty("global.config.path","/Users/shj/dev/env/env-dev");
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("super-schedule-spy/spring-service.xml");
//        this.peizhengHttpConnect = (PeizhengHttpConnectImpl)applicationContext.getBean("peizhengHttpConnect");
//        this.peizhengHtmlResolver = (PeizhengHtmlResolver)applicationContext.getBean("peizhengHtmlResolver");
        this.peizhengHtmlResolver = new PeizhengHtmlResolver();
    }


    public void testResolveTeacher(){
        try {
//            this.peizhengHttpConnect.init();
//            this.peizhengHttpConnect.getCookie();
//            System.out.println(this.peizhengHtmlResolver.resolveTeacher());
            String html = "\n" +
                    "<HTML>\n" +
                    "\t<HEAD>\n" +
                    "\t\t<title></title>\n" +
                    "\t\t<meta name=\"GENERATOR\" Content=\"Microsoft Visual Studio .NET 7.1\">\n" +
                    "\t\t<meta name=\"CODE_LANGUAGE\" Content=\"C#\">\n" +
                    "\t\t<meta name=\"vs_defaultClientScript\" content=\"JavaScript\">\n" +
                    "\t\t<meta name=\"vs_targetSchema\" content=\"http://schemas.microsoft.com/intellisense/ie5\">\n" +
                    "\t\t<LINK href=\"../_style/Styles_rpt.css\" type=\"text/css\" rel=\"stylesheet\">\n" +
                    "\t\t\n" +
                    "\t</HEAD>\n" +
                    "\t<body oncontextmenu=window.event.returnValue=false ondragstart=window.event.returnValue=false onsource=window.event.returnValue=false \n" +
                    "\tleftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\n" +
                    "\t\t<table id=\"pageRpt\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\"><tr><td>\n" +
                    "\t<table  width='100%' BORDER=0 align=center CELLPADDING=0 CELLSPACING=0 ><tr><td style='text-align:center;font-weight:bold;font-size:16pt'>广东培正学院教师课表</td></tr><tr><td style='text-align:center;font-size:13px'>2016-2017学年第二学期</td></tr></table><br><table width=99% BORDER=0 align=center CELLPADDING=0 CELLSPACING=0><tr><td  width=80% align=left >部门：管理学院&ensp;&ensp;教师：方计国&ensp;&ensp;性别：男&ensp;&ensp;职称：讲师</td></tr></table><TABLE WIDTH=99% BORDER=1 align=center CELLPADDING=0 CELLSPACING=0 bordercolorlight=#000000 bordercolordark=#FFFFFF><TR align=center height=25 ><TD width=9% colspan=2 >&ensp;</TD><TD width=13% align=center >星期一</TD><TD width=13%  align=center >星期二</TD><TD width=13% align=center  >星期三</TD><TD width=13%  align=center >星期四</TD><TD width=13% align=center  >星期五</TD><TD width=13%  align=center >星期六</TD><TD width=13% align=center  >星期日</TD></tr><tr ><td align=center width='5%' rowspan='2' valign=middle >上<br>午</td><td align=center width='4%'  height='150px'>一</td><td valign=top width='13%'><br></td><td valign=top width='13%'><br></td><td valign=top width='13%'>[BMgt0026]ERP沙盘实训(讲授) 总学时：36 讲授学时：36 安排学时：32 <br>[1-16周]1-2节 <br>综合实验大楼C401A ；14本工商管理1班 14本工商管理2班 14本工商管理4班 14本工商管理3班 14工商管理(专插本)1班 14本工商管理(国际)1班<br></td><td valign=top width='13%'><br></td><td valign=top width='13%'><br></td><td valign=top width='13%'><br></td><td valign=top width='13%'><br></td></tr><tr ><td align=center width='4%'  height='150px'>二</td><td valign=top width='13%'><br></td><td valign=top width='13%'><br></td><td valign=top width='13%'><br></td><td valign=top width='13%'><br></td><td valign=top width='13%'><br></td><td valign=top width='13%'><br></td><td valign=top width='13%'><br></td></tr><tr ><td align=center width='5%' rowspan='2' valign=middle >下<br>午</td><td align=center width='4%'  height='150px'>三</td><td valign=top width='13%'>[BMgt0026]ERP沙盘实训(讲授) 总学时：36 讲授学时：36 安排学时：32 <br>[1-16周]5-6节 <br>综合实验大楼C401A ；14本工商管理1班 14本工商管理2班 14本工商管理4班 14本工商管理3班 14工商管理(专插本)1班 14本工商管理(国际)1班<br>人数：27<br></td><td valign=top width='13%'><br></td><td valign=top width='13%'><br></td><td valign=top width='13%'><br></td><td valign=top width='13%'><br></td><td valign=top width='13%'><br></td><td valign=top width='13%'><br></td></tr><tr ><td align=center width='4%'  height='150px'>四</td><td valign=top width='13%'>[BMgt0026]ERP沙盘实训(讲授) 总学时：36 讲授学时：36 安排学时：32 <br>[1-16周]7-8节 <br>综合实验大楼C401A ；14本工商管理1班 14本工商管理2班 14本工商管理4班 14本工商管理3班 14工商管理(专插本)1班 14本工商管理(国际)1班<br>人数：31<br></td><td valign=top width='13%'><br></td><td valign=top width='13%'><br></td><td valign=top width='13%'><br></td><td valign=top width='13%'><br></td><td valign=top width='13%'><br></td><td valign=top width='13%'><br></td></tr><tr ><td align=center width='5%' rowspan='2' valign=middle >晚<br>上</td><td align=center width='4%'  height='150px'>五</td><td valign=top width='13%'><br></td><td valign=top width='13%'><br></td><td valign=top width='13%'><br></td><td valign=top width='13%'><br></td><td valign=top width='13%'><br></td><td valign=top width='13%'><br></td><td valign=top width='13%'><br></td></tr><tr ><td align=center width='4%'  height='150px'>六</td><td valign=top width='13%'><br></td><td valign=top width='13%'><br></td><td valign=top width='13%'><br></td><td valign=top width='13%'><br></td><td valign=top width='13%'><br></td><td valign=top width='13%'><br></td><td valign=top width='13%'><br></td></tr></table><TABLE name=theExportData WIDTH=100% BORDER=0 align=center CELLPADDING=0 CELLSPACING=0 ><tr><td width=100% ><b>注1：</b></td></tr><tr><td width=100% ><b>注2：</b></td></tr></table>\n" +
                    "</td></tr></table>\n" +
                    "\t</body>\n" +
                    "</HTML>\n";
            this.peizhengHtmlResolver.resolveClassDetail(html,"shj",7);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }


    }

    public void testTeacherW(){
        try {
            System.out.println(this.peizhengHtmlResolver.resolveTeacher(TeacherConstant.TEACHER_CONTENT));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
