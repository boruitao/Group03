/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-04-11 20:09:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class viewAllApplication_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("<meta charset=\"utf-8\" />\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n");
      out.write("<meta name=\"description\" content=\"\" />\n");
      out.write("<meta name=\"author\" content=\"\" />\n");
      out.write("<title>View All Job Postings</title>\n");
      out.write("<script\n");
      out.write("\tsrc=\"http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js\"></script>\n");
      out.write("<link rel=\"stylesheet\"\n");
      out.write("\thref=\"http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css\" />\n");
      out.write("<script type=\"text/javascript\"\n");
      out.write("\tsrc=\"http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js\"></script>\n");
      out.write("<link href=\"../css/bootstrap.min.css\" rel=\"stylesheet\" />\n");
      out.write("<link href=\"../css/main.css\" rel=\"stylesheet\" />\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\t<div id=\"wrapper\">\n");
      out.write("\t\t<div class=\"navbar-default sidebar\" role=\"navigation\">\n");
      out.write("\t\t\t<div class=\"sidebar-nav navbar-collapse\">\n");
      out.write("\n");
      out.write("\t\t\t\t<div class=\"navbar-header\">\n");
      out.write("\t\t\t\t\t<a class=\"navbar-brand\" href=\"Dashboard.do\">TAMAS</a>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<h6 class=\"welcome\">\n");
      out.write("\t\t\t\t\tWelcome \n");
      out.write("\t\t\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\n");
      out.write("\t\t\t\t</h6>\n");
      out.write("\t\t\t\t<h6 class=\"welcome\">\n");
      out.write("\t\t\t\t\t<a href=\"logout.do\">Sign Out</a>\n");
      out.write("\t\t\t\t</h6>\n");
      out.write("\t\t\t\t<ul class=\"nav\" id=\"side-menu\">\n");
      out.write("\t\t\t\t\t<li><a href=\"Dashboard.do\"><i\n");
      out.write("\t\t\t\t\t\t\tclass=\"fa fa-dashboard fa-fw\"></i> Dashboard</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"ViewAllJobPosting.jsp\"><i\n");
      out.write("\t\t\t\t\t\t\tclass=\"fa fa-dashboard fa-fw\"></i> View Job Postings</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"EvalTa.jsp\"><i class=\"fa fa-dashboard fa-fw\"></i>\n");
      out.write("\t\t\t\t\t\t\tTA Evaluaion</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"viewAllApplication.jsp\"><i\n");
      out.write("\t\t\t\t\t\t\tclass=\"fa fa-dashboard fa-fw\"></i> View Application</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"Schedule.jsp\"><i\n");
      out.write("\t\t\t\t\t\t\tclass=\"fa fa-dashboard fa-fw\"></i> TA Schedule</a></li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div id=\"page-wrapper\">\n");
      out.write("\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t<div class=\"col-lg-12\">\n");
      out.write("\t\t\t\t\t<h1 class=\"page-header\">View All Applications</h1>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t<div class=\"box box-info col-lg-12\">\n");
      out.write("\t\t\t\t\t<div class=\"box-header with-border\"></div>\n");
      out.write("\t\t\t\t\t<div class=\"box-body\">\n");
      out.write("\t\t\t\t\t\t<div class=\"table-responsive\">\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<table id=\"myTable\" class=\"table no-margin\">\n");
      out.write("\t\t\t\t\t\t\t\t<thead>\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<!-- \"Applicant Name\", \"U/G\", \"Job Title\", \"Course Code\", \"Application Status\" }; -->\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th data-field=\"fruit\" data-sortable=\"true\">Job Title</th>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th>Applicant Name</th>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th>U/G</th>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th>Job Title</th>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th>Course Code</th>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th>Application Status</th>\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t\t</thead>\n");
      out.write("\t\t\t\t\t\t\t\t<tbody>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${applications}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t</tbody>\n");
      out.write("\t\t\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t\t\t\t<script>\n");
      out.write("$(document).ready(function(){\n");
      out.write("    $('#myTable').dataTable();\n");
      out.write("});\n");
      out.write("                            </script>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<span class=\"error\"> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${viewAllJobPostingsError }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(" </span>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t\t<br />\n");
      out.write("\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</body>\n");
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
