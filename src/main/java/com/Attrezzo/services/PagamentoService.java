package com.Attrezzo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Attrezzo.dtos.PagamentoDto;
import com.Attrezzo.models.Pagamento;
import com.Attrezzo.repositories.PagamentoRepository;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

@Service
public class PagamentoService {

	
	@Autowired
	PagamentoRepository pagRepository;
	
	@Autowired
	ClienteService clienteService;
	
	public Pagamento findById(UUID id) {
		return pagRepository.findById(id).orElseThrow(()-> new RuntimeException("cannot be found"));
	}
	public List<Pagamento> findAll(){
		return pagRepository.findAll();
	}
	public List<Pagamento> findByCliente(UUID id){
		var cliente = clienteService.findById(id);
		return pagRepository.findByClienteId(cliente);
	}
	public Pagamento createPagamento(PagamentoDto pagDto) {
		var pagamento = new Pagamento();
		BeanUtils.copyProperties(pagDto, pagamento);	
		return pagRepository.save(pagamento);
	}
	public byte[] pdfPagamento(LocalDate data) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(byteArrayOutputStream);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        LocalDate primeiroDiaMes = LocalDate.of(data.getYear(), data.getMonth(), 1);
        LocalDate ultimoDiaMes = primeiroDiaMes.withDayOfMonth(primeiroDiaMes.lengthOfMonth());
        List<Pagamento> pagamentos = pagRepository.findByDatas(primeiroDiaMes, ultimoDiaMes);
        for (Pagamento pagamento : pagamentos) {
        	
			var nomeCliente = pagamento.getClienteId().getNome();
			var paragrafoCliente = new Paragraph("Cliente: " + nomeCliente);
			var paragrafoGasto = new Paragraph("Gasto: " + pagamento.getValor());
			var paragrafoData = new Paragraph("Data: " + pagamento.getData());
			var paragrafoEspacamento = new Paragraph("_____________________________________________");
			
			document.add(paragrafoCliente);
			document.add(paragrafoGasto);
			document.add(paragrafoData);
			document.add(paragrafoEspacamento);
			document.close();
		}
        return byteArrayOutputStream.toByteArray();
        
	}
	public Pagamento updatePagamento(PagamentoDto pagDto, UUID id) {
		var pagamento = findById(id);
		pagamento.setClienteId(clienteService.findById(pagDto.clienteId()));
		pagamento.setValor(pagDto.valor());
		pagamento.setData(pagDto.data());
		return pagRepository.save(pagamento);
	}
	public void deletePagamento(UUID id) {
		var pagamento = findById(id);
		pagRepository.delete(pagamento);
	}
}
