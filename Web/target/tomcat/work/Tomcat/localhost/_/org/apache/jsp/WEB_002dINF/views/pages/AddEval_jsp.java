/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-04-02 22:02:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AddEval_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\" />\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n");
      out.write("<title>TA Evaluaion</title>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css\" />\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js\"></script>\r\n");
      out.write("<link href=\"../css/bootstrap.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("<link href=\"../css/main.css\" rel=\"stylesheet\" />\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"wrapper\">\r\n");
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
      out.write("\t\t\t\t\t<a href=\"logout.do\">Sign Out</a>\r\n");
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
      out.write("\t\t\t\t\t<li><a href=\"Schedule.jsp\"><i\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"fa fa-dashboard fa-fw\"></i> TA Schedule</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"page-wrapper\">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"col-lg-12\">\r\n");
      out.write("\t\t\t\t\t<h1 class=\"page-header\">TA Evaluaion</h1>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"box box-info col-lg-12\">\r\n");
      out.write("\t\t\t\t\t<div class=\"box-header with-border\"></div>\r\n");
      out.write("\t\t\t\t\t<div class=\"box-body\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"mydiv\">\r\n");
      out.write("\t\t\t\t\t\t\t<label>Choose a TA: </label> <br />\r\n");
      out.write("\t\t\t\t\t\t\t<form id=\"evalTa\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<select name=\"TA\" class=\"form-control\" id=\"\"> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${TAs}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</select> <br /> <label>Write Evaluation here</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<textarea class=\"form-control\" name=\"evaluation\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"error\"> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${evalError}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(" </span> <br /> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"btn btn-sm btn-info btn-flat pull-left\" type=\"submit\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tvalue='Submit' /> <br />\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t$(\"#evalTa\").submit(function(e) {\r\n");
      out.write("\t\t\tvar url = \"AddEval.jsp\";\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\ttype : \"POST\",\r\n");
      out.write("\t\t\t\turl : url,\r\n");
      out.write("\t\t\t\tdata : $(\"#evalTa\").serialize(),\r\n");
      out.write("\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\t//if (data.search(\"success\") != -1) {\r\n");
      out.write("\t\t\t\t\t//    window.location.replace('EvalTa.jsp');\r\n");
      out.write("\t\t\t\t\t//}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t//$(\"#mydiv\").load(location.href + \" #mydiv\");\r\n");
      out.write("\t\t\t//location.reload(); \r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t$(document).ready(function() {\r\n");
      out.write("\t\t\t$('#myTable').dataTable();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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