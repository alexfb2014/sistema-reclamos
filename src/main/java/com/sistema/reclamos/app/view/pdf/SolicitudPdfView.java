package com.sistema.reclamos.app.view.pdf;

import java.awt.Color;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.sistema.reclamos.app.models.entity.Solicitud;

@Component("solicitud/mostrarSolicitudParaCliente")
public class SolicitudPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Solicitud solicitud = (Solicitud) model.get("solicitud");

		// Tabla Titulo
		PdfPTable tablaTitulo = new PdfPTable(1);
		tablaTitulo.setSpacingAfter(20);
		PdfPCell celltitulo = null;
		celltitulo = new PdfPCell( new Phrase("Caja Municipal de Ahorro y Credito - Solicitud"));
		celltitulo.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		celltitulo.setBorder(Rectangle.NO_BORDER);
		tablaTitulo.addCell(celltitulo);
		
		document.add(tablaTitulo);
		
		// Tabla 1
		PdfPTable tabla = new PdfPTable(1);
		tabla.setSpacingAfter(20);

		PdfPCell cell = null;
		cell = new PdfPCell(new Phrase("Datos del cliente"));
		cell.setBackgroundColor(new Color(184, 218, 255));
		cell.setPadding(8f);
		tabla.addCell(cell);
		

		PdfPCell cell1 = null;
		cell1 = new PdfPCell(new Phrase("Nombre: " + solicitud.getCliente().getNombreYApellido()));
		cell1.setPadding(8f);
		tabla.addCell(cell1);
		
		PdfPCell cell2 = null;
		cell2 = new PdfPCell(new Phrase("Tipo/Documento: " + solicitud.getCliente().getTipoDocumento().getDescripcion() + "/"
				+ solicitud.getCliente().getNumdoc()));
		cell2.setPadding(8f);
		tabla.addCell(cell2);
		
		PdfPCell cell3 = null;
		cell3 = new PdfPCell(new Phrase("telefono: " + solicitud.getCliente().getTelefono()));
		cell3.setPadding(8f);
		tabla.addCell(cell3);
		
		PdfPCell cell4 = null;
		cell4 = new PdfPCell(new Phrase("Email: " + solicitud.getCliente().getEmail()));
		cell4.setPadding(8f);
		tabla.addCell(cell4);

		PdfPCell cell5 = null;
		cell5 = new PdfPCell(new Phrase("Direccion: " + solicitud.getCliente().getDireccion()));
		cell5.setPadding(8f);
		tabla.addCell(cell5);

		
		document.add(tabla);

		// Tabla 2
		PdfPTable tabla2 = new PdfPTable(1);
		tabla2.setSpacingAfter(20);

		cell = new PdfPCell( new Phrase("Datos de la Solicitud"));
		cell.setBackgroundColor(new Color(184, 218, 255));
		cell.setPadding(8f);
		
		tabla2.addCell(cell);
		
		PdfPCell cell6 = null;
		cell6 = new PdfPCell(new Phrase("Tipo de solicitud: " + solicitud.getTipoSolicitud().getDescripcion()));
		cell6.setPadding(8f);
		tabla2.addCell(cell6);
		
		PdfPCell cell7 = null;
		cell7 = new PdfPCell(new Phrase("Fecha Registro: " + solicitud.getFechaRegistro()));
		cell7.setPadding(8f);
		tabla2.addCell(cell7);
		
		PdfPCell cell8 = null;
		cell8 = new PdfPCell(new Phrase("Fecha respuesta: " + solicitud.getFechaRespuesta()));
		cell8.setPadding(8f);
		tabla2.addCell(cell8);
		
		PdfPCell cell9 = null;
		cell9 = new PdfPCell(new Phrase("Producto/Servicio: " + solicitud.getProducto().getDetalle()));
		cell9.setPadding(8f);
		tabla2.addCell(cell9);
		
		PdfPCell cell10 = null;
		cell10 = new PdfPCell(new Phrase("Motivo: " + solicitud.getMotivo().getDetalle()));
		cell10.setPadding(8f);
		tabla2.addCell(cell10);
		
		PdfPCell cell11 = null;
		cell11 = new PdfPCell(new Phrase("Medio Notificacion: " + solicitud.getNotificacion()));
		cell11.setPadding(8f);
		tabla2.addCell(cell11);
		
		PdfPCell cell12 = null;
		cell12 = new PdfPCell(new Phrase("Detalle: " + solicitud.getDetalle().getDetalle()));
		cell12.setPadding(8f);
		tabla2.addCell(cell12);
		
		PdfPCell cell13 = null;
		cell13 = new PdfPCell(new Phrase("Pedido: " + solicitud.getDetalle().getPedido()));
		cell13.setPadding(8f);
		tabla2.addCell(cell13);
		
		if (solicitud.getDetalle().getOpinionArea().length()> 0) {
			PdfPCell cell14 = null;
			cell14 = new PdfPCell(new Phrase("Opinion Area: " + solicitud.getDetalle().getOpinionArea()));
			cell14.setPadding(8f);
		}
		
		PdfPCell cell14 = null;
		cell14 = new PdfPCell(new Phrase("Respuesta: " + solicitud.getDetalle().getRespuesta()));
		cell14.setPadding(8f);
		tabla2.addCell(cell14);
		
		
		document.add(tabla2);
		
		
	}
	

}
