/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-03-31 18:52:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ChangeSchedule_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\" />\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css\" />\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js\"></script>\r\n");
      out.write("<link href=\"../css/bootstrap.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("<link href=\"../css/main.css\" rel=\"stylesheet\" />\r\n");
      out.write("<link href='../css/fullcalendar.min.css' rel='stylesheet' />\r\n");
      out.write("<link href='../css/fullcalendar.print.min.css' rel='stylesheet' media='print' />\r\n");
      out.write("<script src='../lib/moment.min.js'></script>\r\n");
      out.write("<script src='../lib/jquery.min.js'></script>\r\n");
      out.write("<script src='../lib/jquery-ui.min.js'></script>\r\n");
      out.write("<script src='../js/fullcalendar.min.js'></script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t/* initialize the external events\r\n");
      out.write("\t\t-----------------------------------------------------------------*/\r\n");
      out.write("\r\n");
      out.write("\t\t$('#external-events .fc-event').each(function() {\r\n");
      out.write("\r\n");
      out.write("\t\t\t// store data so the calendar knows to render an event upon drop\r\n");
      out.write("\t\t\t$(this).data('event', {\r\n");
      out.write("\t\t\t\ttitle: $.trim($(this).text()), // use the element's text as the event title\r\n");
      out.write("\t\t\t\tstick: true // maintain when user navigates (see docs on the renderEvent method)\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\t// make the event draggable using jQuery UI\r\n");
      out.write("\t\t\t$(this).draggable({\r\n");
      out.write("\t\t\t\tzIndex: 999,\r\n");
      out.write("\t\t\t\trevert: true,      // will cause the event to go back to its\r\n");
      out.write("\t\t\t\trevertDuration: 0  //  original position after the drag\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t/* initialize the calendar\r\n");
      out.write("\t\t-----------------------------------------------------------------*/\r\n");
      out.write("\r\n");
      out.write("\t\t$('#calendar').fullCalendar({\r\n");
      out.write("\t\t\theader: {\r\n");
      out.write("\t\t\t\tleft: 'prev,next today',\r\n");
      out.write("\t\t\t\tcenter: 'title',\r\n");
      out.write("\t\t\t\tright: 'month,agendaWeek,agendaDay'\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\teditable: true,\r\n");
      out.write("\t\t\tdroppable: true, // this allows things to be dropped onto the calendar\r\n");
      out.write("\t\t\tdrop: function() {\r\n");
      out.write("\t\t\t\t// is the \"remove after drop\" checkbox checked?\r\n");
      out.write("\t\t\t\tif ($('#drop-remove').is(':checked')) {\r\n");
      out.write("\t\t\t\t\t// if so, remove the element from the \"Draggable Events\" list\r\n");
      out.write("\t\t\t\t\t$(this).remove();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write("\tbody {\r\n");
      out.write("\t\t//margin-top: 40px;\r\n");
      out.write("\t\ttext-align: center;\r\n");
      out.write("\t\tfont-size: 14px;\r\n");
      out.write("\t\tfont-family: \"Lucida Grande\",Helvetica,Arial,Verdana,sans-serif;\r\n");
      out.write("\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t#wrap {\r\n");
      out.write("\t\twidth: 1100px;\r\n");
      out.write("\t\tmargin: 0 auto;\r\n");
      out.write("\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t#external-events {\r\n");
      out.write("\t\tfloat: left;\r\n");
      out.write("\t\twidth: 150px;\r\n");
      out.write("\t\tpadding: 0 10px;\r\n");
      out.write("\t\tborder: 1px solid #ccc;\r\n");
      out.write("\t\tbackground: #eee;\r\n");
      out.write("\t\ttext-align: left;\r\n");
      out.write("\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t#external-events h4 {\r\n");
      out.write("\t\tfont-size: 16px;\r\n");
      out.write("\t\tmargin-top: 0;\r\n");
      out.write("\t\tpadding-top: 1em;\r\n");
      out.write("\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t#external-events .fc-event {\r\n");
      out.write("\t\tmargin: 10px 0;\r\n");
      out.write("\t\tcursor: pointer;\r\n");
      out.write("\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t#external-events p {\r\n");
      out.write("\t\tmargin: 1.5em 0;\r\n");
      out.write("\t\tfont-size: 11px;\r\n");
      out.write("\t\tcolor: #666;\r\n");
      out.write("\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t#external-events p input {\r\n");
      out.write("\t\tmargin: 0;\r\n");
      out.write("\t\tvertical-align: middle;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t#calendar {\r\n");
      out.write("\t\tfloat: right;\r\n");
      out.write("\t\twidth: 900px;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"wrapper\">\r\n");
      out.write("\t\t<div class=\"navbar-default sidebar\" role=\"navigation\">\r\n");
      out.write("\t\t\t<div class=\"sidebar-nav navbar-collapse\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t\t\t<a class=\"navbar-brand\" href=\"Dashboard.do\">TAMAS</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<h6 class=\"welcome\">Welcome ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</h6>\r\n");
      out.write("\t\t\t\t<h6 class=\"welcome\">\r\n");
      out.write("\t\t\t\t\t<a href=\"logout.php\">Sign Out</a>\r\n");
      out.write("\t\t\t\t</h6>\r\n");
      out.write("\t\t\t\t<ul class=\"nav\" id=\"side-menu\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"Dashboard.do\"><i\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"fa fa-dashboard fa-fw\"></i> Dashboard</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"ViewAllJobPosting.jsp\"><i\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"fa fa-dashboard fa-fw\"></i> View Job Postings</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"EvalTa.jsp\"><i class=\"fa fa-dashboard fa-fw\"></i>\r\n");
      out.write("\t\t\t\t\t\t\tTA Evaluaion</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"viewAllApplication.jsp\"><i\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"fa fa-dashboard fa-fw\"></i> View Application</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"page-wrapper\">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"col-lg-12\">\r\n");
      out.write("\t\t\t\t\t<h1 class=\"page-header\">Schedule</h1>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"box box-info col-lg-12\">\r\n");
      out.write("\t\t\t\t\t<div class=\"box-header with-border\"></div>\r\n");
      out.write("\t\t\t\t\t<div class=\"box-body\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"mydiv\">\r\n");
      out.write("\t<div id='wrap'>\r\n");
      out.write("\r\n");
      out.write("\t\t<div id='external-events'>\r\n");
      out.write("\t\t\t<h4>Draggable Events</h4>\r\n");
      out.write("\t\t\t<div class='fc-event'>My Event 1</div>\r\n");
      out.write("\t\t\t<div class='fc-event'>My Event 2</div>\r\n");
      out.write("\t\t\t<div class='fc-event'>My Event 3</div>\r\n");
      out.write("\t\t\t<div class='fc-event'>My Event 4</div>\r\n");
      out.write("\t\t\t<div class='fc-event'>My Event 5</div>\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\t<input type='checkbox' id='drop-remove' />\r\n");
      out.write("\t\t\t\t<label for='drop-remove'>remove after drop</label>\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div id='calendar'></div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div style='clear:both'></div>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\t\t\t\t\t</br>\r\n");
      out.write("\t\t\t\t\t<a class=\"btn btn-md btn-info btn-flat pull-left\">Change Schedule</a></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</br>\r\n");
      out.write("\t\t\t\t\t</br>\r\n");
      out.write("\t\t\t\t\t</br>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
