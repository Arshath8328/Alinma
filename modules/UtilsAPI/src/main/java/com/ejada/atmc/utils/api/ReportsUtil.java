/*
 * JasperUtils.java Oct 01, 2015  
 *
 * Copyright (c) 2005-2015 Ejada Solutions.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Ejada
 * Solutions, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Ejada.
 */
package com.ejada.atmc.utils.api;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ejada.atmc.acl.db.custom.model.PSBeneficiaryDetail;
import com.ejada.atmc.acl.db.custom.model.PSCoverageDetail;
import com.ejada.atmc.acl.db.custom.model.PSStatementAccount;
import com.ejada.atmc.acl.db.custom.model.SOADetail;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.CsvExporterConfiguration;
import net.sf.jasperreports.export.CsvReportConfiguration;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.ExporterConfiguration;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.ExporterOutput;
import net.sf.jasperreports.export.HtmlExporterConfiguration;
import net.sf.jasperreports.export.HtmlExporterOutput;
import net.sf.jasperreports.export.HtmlReportConfiguration;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.PdfExporterConfiguration;
import net.sf.jasperreports.export.PdfReportConfiguration;
import net.sf.jasperreports.export.ReportExportConfiguration;
import net.sf.jasperreports.export.SimpleCsvExporterConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterConfiguration;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.export.SimpleHtmlReportConfiguration;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import net.sf.jasperreports.export.WriterExporterOutput;
import net.sf.jasperreports.web.util.WebHtmlResourceHandler;

/**
 * Utility class for Jasper Reports.
 * @author Basel A.Aziz
 *
 */
public class ReportsUtil 
{
	
	public static final String FORMAT_CSV = "csv";
	public static final String FORMAT_PDF = "pdf";
	public static final String FORMAT_HTML = "html";
	
	//public static final String IMAGES_PATH = "/CorpWeb/reports/imgs/";
	public static final String IMAGES_PATH = "../image?image={0}";
	
	public static final String CSV_FIELD_DELIMTER = ",";
	public static final String CSV_RECORD_DELIMTER = "\r\n";
	public static final String TXT_FIELD_DELIMTER = "\t";
	public static final String TXT_RECORD_DELIMTER = "\r\n";
	
	public static final String ENCODING_CP1256 = "Cp1256";
	
	public static final String REPORT_URL = "JRUrl";
	public static final String REPORT_PAGE_INDEX = "JRPageIndex";
	
//	public static final String HTML_HEADER = "<html>"+
//		    "<head>"+
//		    "  <title></title>"+
//		    "  <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>"+
//		    "  <link rel=\"stylesheet\" type=\"text/css\" href=\"/CorpWeb/shared/media/uikit_blue.css\" />"+
//		    "<script language='javascript' type='text/javascript' src='/CorpWeb/shared/js/uikit.js'></script>"+
//		    "  <style type='text/css'>"+
//		    "    a {text-decoration: none}"+
//		    "  </style>"+
//		    "</head>"+
//		    "<body text='#000000' link='#000000' alink='#000000' vlink='#000000'>"+
//		    "<table width='100%' cellpadding='0' cellspacing='0' border='0'>"+
//		    "<tr><td>";
	
	public static final String HTML_HEADER = "";	
//	public static final String HTML_FOOTER_PRINT_SCRIPT = 	"<script language='JavaScript' type='text/javascript' src='/CorpWeb/js/jq.js'></script>" +
//															"<script>" +
//															"$(document).ready(function() {window.focus();window.print();});" +
//															"$(document).bind('contextmenu', function(e){" +
//															"var srcTagName;" +
//															"if(navigator.userAgent.indexOf('MSIE') != -1) srcTagName = window.event.srcElement.tagName.toLowerCase();" +
//															"else if(navigator.userAgent.indexOf('Chrome') != -1) srcTagName = event.target.tagName.toLowerCase();" +
//															"else if(navigator.userAgent.indexOf('Firefox') != -1) srcTagName = e.target.tagName.toLowerCase();" +
//															"if(srcTagName == 'input' || srcTagName == 'textarea') return true;" +
//															"return false;" +
//															"});" +
//															"function downloadReport(aURL)" + 
//															"{" + 
//															"window.onbeforeunload = '';" +
//															"if(aURL != null) window.location.assign(aURL);" +
//															"}" + 
//															"</script>";
	
	
			
	public static final String HTML_FOOTER_DOWNLOAD_BTN = "<button type=''Button'' name=''downloadPage'' value=''{0}'' onclick='''downloadReport(&#39;'{1}'&#39;);'''  class=''uk-button ej-button-btnRequest''>{0}</button>";
	public static final String HTML_FOOTER_PREVIOUS_BTN = "<button type=''Button'' name=''previousBtn'' value=''{0}'' onclick='''downloadReport(&#39;'{1}'&#39;);'''  class=''uk-button ej-button-btnRequest'' {2}>{0}</button>";
	public static final String HTML_FOOTER_NEXT_BTN = "<button type=''Button'' name=''nextBtn'' value=''{0}'' onclick='''downloadReport(&#39;'{1}'&#39;);'''  class=''uk-button ej-button-btnRequest'' {2}>{0}</button>";
	public static final String HTML_FOOTER_BACK_BTN = "<h:commandButton id='btnCancel' styleClass='btn btn-default' title='#{props['btn_cancel']}' action='#{benefController.cancelBeneficiary}' reRender='mainSection' value='#{props['btn_cancel']}'/>";	
	
	public static final String HTML_FOOTER_PRINT_SCRIPT = HTML_FOOTER_BACK_BTN;
	
	public static JasperPrint fillReport(String name, List<? extends Object> data, Map<String,Object> params)
	{
        // Look up the compiled report design resource 
        InputStream stream = ReportsUtil.class.getResourceAsStream("/" + name);
        if (stream == null) { 
            throw new IllegalArgumentException("Unknown report name         '" + name 
                    + "' requested"); 
        } 
                 
        // Fill the requested report with the specified data 
        
        JRBeanArrayDataSource ds = new JRBeanArrayDataSource(data.toArray());
        JasperPrint jasperPrint = null; 
        try 
        { 
//          jasperPrint = JasperFillManager.fillReport(stream, params, ds); 
        	JasperReport report = (JasperReport) JRLoader.loadObject(stream);
        	jasperPrint = JasperFillManager.fillReport(report, params, ds); 
        } 
        catch (RuntimeException e) 
        { 
            throw e; 
        } 
        catch (Exception e) 
        { 
            e.printStackTrace(); 
        } 
        finally 
        { 
            try 
            { 
                stream.close(); 
            } 
            catch (IOException e) 
            { 
                ; 
            } 
        } 
        
        return jasperPrint;
	}
	
	
	/**
	 * Returns a Jasper Exporter according to the given format. 
	 * @param format
	 * @param populatedReport
	 * @param response
	 * @return
	 * @throws IOException
	 * @throws JRException
	 */
	public static Exporter<ExporterInput, ? extends ReportExportConfiguration, ? extends ExporterConfiguration, ? extends ExporterOutput> getExporter(String format, JasperPrint populatedReport,OutputStream out,Map<?,?> model) throws IOException, JRException
	{
		if (format.equals(FORMAT_CSV))
			return getCSVExporter(populatedReport, out);
		else if(format.equals(FORMAT_PDF))
			return getPDFExporter(populatedReport, out);
		else return null;
	}
	
	public static void fillAndExportPDFReport(String name, List<? extends Object> data, Map<String,Object> params,OutputStream out) throws Exception
	{
		JasperPrint populatedReport = fillReport(name, data, params);
		if (populatedReport != null)
		{
			Exporter<ExporterInput, ? extends ReportExportConfiguration, ? extends ExporterConfiguration, ? extends ExporterOutput> exporter = getExporter(FORMAT_PDF, populatedReport, out,params);
			try {
			exporter.exportReport();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new Exception(e);
			}
		}

	}
	
	public static void downloadFundPDF(List<SOADetail> soaDetails,  OutputStream out){
		try {
			SOADetail soaDetail = soaDetails.get(0);
			List<PSCoverageDetail> psCoverageDetails = soaDetail.getPsCoverageDetails();
			List<PSBeneficiaryDetail> psBeneficiaryDetails = soaDetail.getPsBeneficiaryDetails();
			List<PSStatementAccount> psStatementAccounts = soaDetail.getPsStatementAccounts();
			JRBeanCollectionDataSource itemsJRBean1 = new JRBeanCollectionDataSource(psCoverageDetails);
			JRBeanCollectionDataSource itemsJRBean2 = new JRBeanCollectionDataSource(psBeneficiaryDetails);
			JRBeanCollectionDataSource itemsJRBean3 = new JRBeanCollectionDataSource(psStatementAccounts);
			
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("ItemDataSourcePSC", itemsJRBean1);
			parameters.put("ItemDataSourcePSB", itemsJRBean2);
			parameters.put("ItemDataSourcePSS", itemsJRBean3);
			fillAndExportPDFReport("PS_Policy_"+".jasper", soaDetails, parameters, out);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns a HTML Exporter instance
	 * @param populatedReport
	 * @param writer
	 * @return
	 * @throws IOException
	 * @throws JRException
	 */
	public static Exporter<ExporterInput, HtmlReportConfiguration, HtmlExporterConfiguration, HtmlExporterOutput> getHtmlExporter(JasperPrint populatedReport,Writer writer,Map<?,?> model) throws IOException, JRException
	{
		
		Exporter<ExporterInput, HtmlReportConfiguration, HtmlExporterConfiguration, HtmlExporterOutput> exporter = new HtmlExporter();

		//exporter config
		SimpleHtmlExporterConfiguration exporterConfig = new SimpleHtmlExporterConfiguration();
		exporterConfig.setBetweenPagesHtml("");
		exporterConfig.setHtmlHeader(HTML_HEADER);  
		
		// report config
		SimpleHtmlReportConfiguration reportConfig = new SimpleHtmlReportConfiguration();
		reportConfig.setRemoveEmptySpaceBetweenRows(true);
		reportConfig.setIgnorePageMargins(true);
		
		//exporter input
		exporter.setExporterInput(new SimpleExporterInput(populatedReport));
		
		// exporter output
		SimpleHtmlExporterOutput output = new SimpleHtmlExporterOutput(writer);
		output.setImageHandler(new WebHtmlResourceHandler(IMAGES_PATH));
		output.setResourceHandler(new WebHtmlResourceHandler(IMAGES_PATH));
		exporter.setExporterOutput(output);
		
		// report URL is used for downloading reports and pagination
		String reportUrl = (String)model.get(REPORT_URL);
		if (reportUrl !=null)
		{
			int pageIndex = 0;
			boolean previousBtnDisabled = true;
			boolean nextBtnDisabled = true;
			// report has multiple pages
			if (populatedReport.getPages() != null && populatedReport.getPages().size() > 1)
			{
				int lastPageIndex = populatedReport.getPages().size() - 1;
				
				// Adjust pageIndex and enabling/disabling previous and next buttons				
				String pageIndexStr = (String)model.get(REPORT_PAGE_INDEX);
				// pageIndex exists in model i.e. this is not the first time this report is viewed
				if (pageIndexStr != null)
				{
					try
					{
						pageIndex = Integer.parseInt(pageIndexStr);
					}
					catch(Exception e)
					{
					}
					// first page, enable next and diable previous
					if (pageIndex <= 0)
					{
						pageIndex = 0;
						nextBtnDisabled = false;
					}
					// last page, enable previous and disable next
					else if (pageIndex >= lastPageIndex)
					{
						pageIndex = lastPageIndex;
						previousBtnDisabled = false;
					}
					// middle page, enable both next and previous
					else
					{
						nextBtnDisabled = false;
						previousBtnDisabled = false;
					}
				}
				// pageIndex does not exist in model i.e. this is the first time this report is viewed so for sure this is the first page
				else
				{
					nextBtnDisabled = false;
				}
			}
			//BA 8/10/2015 - for now we will NOT display the download and pagination buttons
			//exporterConfig.setHtmlFooter(getHTMLFooterWithBtns(reportUrl,previousBtnDisabled,nextBtnDisabled,pageIndex));
			exporterConfig.setHtmlFooter(HTML_FOOTER_PRINT_SCRIPT);
			reportConfig.setPageIndex(pageIndex);
		}
		else
		{
			exporterConfig.setHtmlFooter(HTML_FOOTER_PRINT_SCRIPT);
		}

		exporter.setConfiguration(exporterConfig);
		exporter.setConfiguration(reportConfig);
		
		return exporter;

	}
	
	/**
	 * Returns a PDF Exporter instance
	 * @param populatedReport
	 * @param os
	 * @return
	 * @throws IOException
	 * @throws JRException
	 */
	public static Exporter<ExporterInput, PdfReportConfiguration, PdfExporterConfiguration, OutputStreamExporterOutput> getPDFExporter(JasperPrint populatedReport ,OutputStream os) 
	{
		
		Exporter<ExporterInput, PdfReportConfiguration, PdfExporterConfiguration, OutputStreamExporterOutput> exporter = new JRPdfExporter();
		
		exporter.setExporterInput(new SimpleExporterInput(populatedReport));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(os));
		
		return exporter;

	}
	
	/**
	 * Returns a CSV Exporter instance
	 * @param populatedReport
	 * @param os
	 * @return
	 * @throws IOException
	 * @throws JRException
	 */
	public static Exporter<ExporterInput, CsvReportConfiguration, CsvExporterConfiguration, WriterExporterOutput> getCSVExporter(JasperPrint populatedReport ,OutputStream os) throws IOException, JRException
	{
		
		Exporter<ExporterInput, CsvReportConfiguration, CsvExporterConfiguration, WriterExporterOutput> exporter = new JRCsvExporter();
		
		
		exporter.setExporterInput(new SimpleExporterInput(populatedReport));
		exporter.setExporterOutput(new SimpleWriterExporterOutput(os,ENCODING_CP1256));
		
		SimpleCsvExporterConfiguration exporterConfig = new SimpleCsvExporterConfiguration();
		exporterConfig.setFieldDelimiter(CSV_FIELD_DELIMTER);
		exporterConfig.setRecordDelimiter(CSV_RECORD_DELIMTER);

		exporter.setConfiguration(exporterConfig);
		
		return exporter;

	}
	
	/**
	 * Returns a CSV exporter instance which will be used for Text Reports. Difference between the Txt Exporter and the CSV one will be the delimter only. 
	 * @param populatedReport
	 * @param os
	 * @return
	 * @throws IOException
	 * @throws JRException
	 */
	public static Exporter<ExporterInput, CsvReportConfiguration, CsvExporterConfiguration, WriterExporterOutput> getTxtExporter(JasperPrint populatedReport ,OutputStream os) throws IOException, JRException
	{
		
		Exporter<ExporterInput, CsvReportConfiguration, CsvExporterConfiguration, WriterExporterOutput> exporter = new JRCsvExporter();
		
		
		exporter.setExporterInput(new SimpleExporterInput(populatedReport));
		exporter.setExporterOutput(new SimpleWriterExporterOutput(os,ENCODING_CP1256));
		
		SimpleCsvExporterConfiguration exporterConfig = new SimpleCsvExporterConfiguration();
		exporterConfig.setFieldDelimiter(TXT_FIELD_DELIMTER);
		exporterConfig.setRecordDelimiter(TXT_RECORD_DELIMTER);

		exporter.setConfiguration(exporterConfig);
		
		return exporter;

	}
	
	/*
	 * Returns HTML footer with download, next and previous buttons.
	 */
	private static String getHTMLFooterWithBtns(String reportUrl,boolean prevBtnDisabled, boolean nextBtnDisabled,int pageIndex)
	{
		String prevBtnDisabledStr = (prevBtnDisabled)?"disabled":"";
		String nextBtnDisabledStr = (nextBtnDisabled)?"disabled":"";
		String qsStartingChar = (reportUrl.contains("?"))?"&":"?";
		
		StringBuilder sb = new StringBuilder();
		//sb.append(MessageFormat.format(HTML_FOOTER_PREVIOUS_BTN, SpringUtils.getMessage("Reports", "btn_prev", SpringUtils.getRequest()),reportUrl + qsStartingChar + "format=html&"+REPORT_PAGE_INDEX+"=" + (pageIndex-1),prevBtnDisabledStr));
		//sb.append(MessageFormat.format(HTML_FOOTER_NEXT_BTN, SpringUtils.getMessage("Reports", "btn_next", SpringUtils.getRequest()),reportUrl + qsStartingChar + "format=html&"+REPORT_PAGE_INDEX +"=" + (pageIndex+1),nextBtnDisabledStr));
		//sb.append(MessageFormat.format(HTML_FOOTER_DOWNLOAD_BTN, SpringUtils.getMessage("Reports", "btn_download_page", SpringUtils.getRequest()),reportUrl + qsStartingChar + "format=pdf"));
		//sb.append(HTML_FOOTER_PRINT_SCRIPT);
		return sb.toString();
	}
}
