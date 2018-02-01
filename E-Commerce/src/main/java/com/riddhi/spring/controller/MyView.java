package com.riddhi.spring.controller;


import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.riddhi.spring.pojo.Cart;
import com.riddhi.spring.pojo.OrderDetail;

public class MyView extends AbstractPdfView
{

   @Override
   protected void buildPdfDocument(Map<String, Object> model, Document pdfdoc, PdfWriter pdfwriter, HttpServletRequest request,
           HttpServletResponse response) throws Exception {
       Font  helvetica_18_blue = new Font(Font.HELVETICA, 18, Font.BOLDITALIC, Color.BLUE);
       Paragraph title = new Paragraph("Order History", helvetica_18_blue);
       
       @SuppressWarnings("unchecked")
       List<OrderDetail> order=(List<OrderDetail>) model.get("list");
       pdfdoc.add(title);
       
      PdfPTable table = new PdfPTable(2);
       table.setWidthPercentage(100.0f);
       //table.setWidths(new float[] {3.0f, 2.0f, 2.0f, 2.0f, 1.0f});
       table.setSpacingBefore(10);
       
       // define font for table header row
       Font font = FontFactory.getFont(FontFactory.HELVETICA);
       //font.setColor(BaseColor.WHITE);
       
       // define table header cell
       PdfPCell cell = new PdfPCell();
       //cell.setBackgroundColor(BaseColor.BLUE);
       cell.setPadding(5);
       
       // write table header
       cell.setPhrase(new Phrase("Product", font));
       table.addCell(cell);
       
       cell.setPhrase(new Phrase("Quantity", font));
       table.addCell(cell);

//      cell.setPhrase(new Phrase("Price", font));
//       table.addCell(cell);
       
       
     
       // write table row data
       for (OrderDetail o : order) {
           table.addCell(o.getProduct().getProductName());
           table.addCell(String.valueOf(o.getQuantity()));
           
          //table.addCell(String.valueOf(o.getOrderId()));
       }
       
       pdfdoc.add(table);
   }
       
   }