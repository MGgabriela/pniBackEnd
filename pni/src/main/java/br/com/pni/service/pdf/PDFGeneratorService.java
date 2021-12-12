package br.com.pni.service.pdf;

import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import br.com.pni.controller.dto.custom.OrderRequest;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

@Service
public class PDFGeneratorService {
	
    public void export(HttpServletResponse response, List<OrderRequest> allEmployees, 
    		int nome,int valorT,int inicio, int fim, int faixaSal, int cpf, int formacao, int sexo, 
    		int status, int vinculo,int escolaridade,int modalidade,int instituicao,int cargo, int atuacao) throws IOException {
       	
    	System.out.println("\n\nemp: "+allEmployees+"\n\n");
    	
        // various fonts
//        BaseFont bf_helv = BaseFont.createFont(BaseFont.HELVETICA, "Cp1252", false);
//        BaseFont bf_times = BaseFont.createFont(BaseFont.TIMES_ROMAN, "Cp1252", false);
        BaseFont bf_courier = BaseFont.createFont(BaseFont.COURIER, "Cp1252", false);
//        BaseFont bf_symbol = BaseFont.createFont(BaseFont.SYMBOL, "Cp1252", false);
    	
        Document document = new Document(PageSize.A4);//esquerda,direita,superior,inferior
        PdfWriter.getInstance(document, response.getOutputStream());

        // headers and footers must be added before the document is opened
        HeaderFooter footer = new HeaderFooter(
                    new Phrase("", new Font(bf_courier)), true);
        footer.setBorder(Rectangle.NO_BORDER);
        footer.setAlignment(Element.ALIGN_RIGHT);
        document.setFooter(footer);
        
        document.open();        
        
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        Paragraph paragraph = new Paragraph("Titulo", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        
        Paragraph paragraph2 = texto();
        
        Table table = tabela(allEmployees,nome,valorT,inicio,fim,faixaSal,cpf,formacao,sexo,
        		status,vinculo,escolaridade,modalidade,instituicao,cargo,atuacao);
        
        PdfPTable table2 = tablePDF(allEmployees);
        
        document.add(paragraph);
        document.add(paragraph2);
        document.add(new Paragraph("Inserindo Imagem"));
        
        Image i = Image.getInstance(System.getProperty("user.dir")+"\\src\\main\\resources\\img\\grafico.png");
//        i.scaleAbsolute(100, 200);  
        //Imagem não passa do tamanho da folha
        float documentWidth = document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin();
        float documentHeight = document.getPageSize().getHeight() - document.topMargin() - document.bottomMargin();           
        i.scaleToFit(documentWidth, documentHeight);        
        document.add(i);
        
        document.setPageSize(PageSize.A4.rotate());
        document.newPage();        
        document.add(table);
        
        document.newPage();    
        document.add(table2);        
        
        document.setPageSize(PageSize.A4);
        document.newPage();
        document.add(new Paragraph("This is portrait again"));
        
        document.close();
    }
    
    
    @SuppressWarnings("deprecation")
	public Table tabela(List<OrderRequest> allEmployees, 
    		int nome,int valorT,int inicio, int fim, int faixaSal, int cpf, int formacao, int sexo, 
    		int status, int vinculo,int escolaridade,int modalidade,int instituicao,int cargo, int atuacao) {
    	
		    int contador = 0;
		    
		    if(nome     == 1){ contador++; }
		    if(valorT   == 1){ contador++; }
		    if(inicio   == 1){ contador++; }
		    if(fim      == 1){ contador++; }
		    if(faixaSal == 1){ contador++; }
		    if(cpf      == 1){ contador++; }
		    if(formacao == 1){ contador++; }
		    if(sexo     == 1){ contador++; }
		    if(status       == 1){ contador++; }
		    if(vinculo      == 1){ contador++; }
		    if(escolaridade == 1){ contador++; }
		    if(modalidade   == 1){ contador++; }
		    if(instituicao  == 1){ contador++; }
		    if(cargo        == 1){ contador++; }
		    if(atuacao      == 1){ contador++; }
	    
//		  float[] colsWidth = {0.8f, 3f, 0.8f, 1f, 1f, 1f, 0.8f, 0.8f, 0.8f, 1f};   
		  Table  table = new Table (contador);
	//      table.setBorderWidth(1);
		  
	      table.setBackgroundColor(new Color(248,248,255));
	      table.setBorderColor(new Color(255, 255, 255));
	      table.getDefaultCell().setBorderColor(new Color(211, 211, 211));	
	      table.getDefaultCell().setVerticalAlignment(Element.ALIGN_CENTER);
	      table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
	      table.setPadding(5);
	      table.rotate();
	//      table.setSpacing(1);
	      
	      Cell cell = new Cell("instituição");
	      cell.setColspan(contador);
	      table.addCell(cell);
	      
	      if(nome == 1) {	
	      	Cell cell1 = new Cell("nome");	  
	      	table.addCell(cell1);
	      }
	      if(valorT == 1) {	
	      	Cell cell2 = new Cell("valor total do contrato");	      	
	      	table.addCell(cell2);
	      }
	      if(inicio == 1) {	
	      	Cell cell3 = new Cell("data de inicio");
	      	table.addCell(cell3);            
	      }
	      if(fim == 1) {	
	      	Cell cell4 = new Cell("data de término");
	      	table.addCell(cell4);
	      }
	      if(faixaSal == 1) {	
	      	Cell cell5 = new Cell("faixa salarial");
	      	table.addCell(cell5);
	      }
	      if(cpf == 1) {	
	        Cell cell6 = new Cell("cpf");
	        table.addCell(cell6);
	      }
	      if(formacao == 1) {	
	        Cell cell7 = new Cell("formação");
	        table.addCell(cell7);
	      }
	      if(sexo == 1) {	
	        Cell cell8 = new Cell("sexo");
	        table.addCell(cell8);
	      }	      
	      if(status == 1) {	
		        Cell cell8 = new Cell("status");
		        table.addCell(cell8);
		      }
	            
	      table.endHeaders();
	      
	      for (OrderRequest e : allEmployees) {
	      	 if(nome     == 1) {table.addCell(e.getNome());}
//	      	 if(valorT   == 1) {table.addCell(e.getValorTotalContrato().toString() ); }
	      	 if(inicio   == 1) {table.addCell(e.getDataInicio().toString() ); }
	      	 if(fim      == 1) {table.addCell(e.getDataFim().toString() ); }
//	      	 if(faixaSal == 1) {table.addCell(e.getContratoFaixaSalarial()); }
	      	 if(cpf      == 1) {table.addCell(e.getCpf()); }
	      	 if(formacao == 1) {table.addCell(e.getFormacao()); }
	      	 if(sexo     == 1) {table.addCell(e.getSexo()); }
	      	 if(status   == 1) {table.addCell(e.getStatus()); }
	      }     
	     
		return table;
    }

    
    public Paragraph texto() {
    	
        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);
    	
        Paragraph paragraph = new Paragraph("This is a paragraph.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse quis quam congue, dictum tellus vel, venenatis augue. Mauris iaculis tortor eget congue dignissim. Suspendisse potenti. Aenean aliquam auctor semper. Proin elementum purus eu sem malesuada, ut tincidunt nibh tincidunt. Cras sed tempus odio. Integer a nisi laoreet, varius mi ac, ornare velit. Aliquam dapibus libero mauris, eu condimentum sem viverra quis. Donec a pulvinar lectus. Praesent tincidunt viverra enim a auctor. Nunc nec lectus sed urna varius venenatis vel eu arcu. Donec augue risus, vestibulum non tincidunt sed, tincidunt sed risus. Ut eget ante ex. In hac habitasse platea dictumst. Vestibulum tristique eu ex a euismod. In vitae odio placerat, finibus leo vitae, pellentesque lorem.\n"
        		+ "\n"
        		+ "Vestibulum nec malesuada libero. Donec venenatis augue vitae vehicula accumsan. Nullam egestas, nunc ac aliquet tempus, lacus quam commodo est, non ornare erat tortor sed neque. Phasellus convallis tellus vel tortor elementum, nec commodo mauris venenatis. Curabitur hendrerit mi ut imperdiet consequat. Nullam tincidunt sagittis est, quis vestibulum augue. Integer cursus laoreet vestibulum.\n"
        		+ "\n"
        		+ "Ut lectus risus, elementum sit amet fermentum a, consequat quis urna. Phasellus ultricies enim lectus, vel volutpat erat mollis consequat. Praesent at convallis ante. Nam nec orci efficitur sem fermentum rhoncus eget in quam. Pellentesque consectetur mattis tellus, eget laoreet mi placerat sed. Vestibulum cursus blandit orci vel varius. Pellentesque sit amet ipsum dolor. Pellentesque semper erat nec massa mattis, non egestas ligula mattis. Curabitur velit leo, gravida vel risus nec, lobortis maximus sapien. Suspendisse gravida blandit erat at interdum. Mauris nec turpis libero. Donec placerat, orci ut suscipit sagittis, dolor eros tristique est, et gravida lectus dolor sit amet sem. Etiam tincidunt eros id viverra porttitor. Pellentesque orci risus, consectetur et gravida nec, molestie ac tortor. Praesent pretium aliquam viverra. Aliquam aliquam nulla eget accumsan ultricies.\n"
        		+ "\n"
        		+ "Integer imperdiet euismod hendrerit. Suspendisse mollis libero eget lectus eleifend pharetra. Sed sed turpis vitae urna tempor interdum. Aliquam scelerisque felis eu urna consectetur, at mollis libero maximus. Ut pharetra nibh et augue sodales malesuada. Quisque porta malesuada neque id maximus. Nunc odio ante, tincidunt sed massa et, fermentum malesuada augue. Donec at volutpat ex. Donec est justo, rutrum ac sem eget, dapibus viverra nulla.\n"
        		+ "\n"
        		+ "Aliquam varius quam non imperdiet imperdiet. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Quisque dictum pellentesque tortor sed cursus. Praesent fringilla orci nec mollis varius. Mauris quis commodo libero. Quisque sit amet velit massa. Vestibulum blandit rutrum accumsan. Fusce molestie nunc lectus, sit amet sodales sem rhoncus a. Aliquam ut mauris sed enim facilisis consectetur sit amet vitae arcu. Curabitur eu aliquam erat.\n"
        		+ "\n"
        		+ "Aliquam bibendum, nibh vitae bibendum volutpat, risus dolor posuere dui, nec commodo justo libero non dolor. Donec varius augue et blandit interdum. Sed pulvinar odio tincidunt odio pulvinar, nec pulvinar velit consequat. Phasellus et convallis erat. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nullam dapibus est ut molestie facilisis. Nam iaculis justo et cursus consectetur. Interdum et malesuada fames ac ante ipsum primis in faucibus. Ut quis volutpat dui. Duis condimentum odio at gravida imperdiet. Sed at lacus sit amet justo congue sagittis. Praesent scelerisque elementum mi id iaculis. Integer euismod nisl at semper faucibus. Suspendisse blandit nisi mi, non vestibulum justo euismod ut. Quisque euismod fermentum magna, elementum tristique nulla.\n"
        		+ "\n"
        		+ "Donec quam mi, condimentum eget leo id, venenatis vestibulum magna. Nunc elementum orci enim, sed dapibus velit feugiat sed. Quisque rhoncus purus ac elementum mattis. In hac habitasse platea dictumst. Suspendisse nec risus tempor, viverra purus vitae, scelerisque lacus. Aenean eu commodo augue, at laoreet mauris. Proin et sodales felis, nec consequat ligula. Nunc scelerisque est ut mi gravida tempus eget sed metus. Fusce congue felis ac varius ultricies. Etiam eu finibus orci.\n"
        		+ "\n"
        		+ "Sed finibus ultricies lorem ac mollis. Quisque tincidunt, lacus sed luctus vehicula, nunc quam consectetur quam, id pharetra sem nunc id leo. Phasellus accumsan ac erat sagittis vestibulum. Mauris porttitor nunc at nulla sollicitudin, vel fermentum odio sodales. Nam vitae justo erat. Donec imperdiet ante sem, at porta metus porta eget. Donec in lorem id ex luctus egestas. Vivamus facilisis metus at elementum hendrerit. Curabitur suscipit fringilla luctus. Phasellus laoreet libero quis velit accumsan dignissim. Nulla bibendum scelerisque dolor elementum eleifend. Mauris quam tortor, pellentesque a sollicitudin quis, vestibulum in sapien. Donec suscipit vestibulum tincidunt. Vestibulum ut urna et tortor dignissim feugiat nec ac ante.\n"
        		+ "\n"
        		+ "Aenean orci felis, rhoncus a elit vel, elementum ultricies libero. Donec eget laoreet dui, ut sollicitudin nibh. Sed ornare in massa sed gravida. Etiam sagittis lorem velit, id pretium erat hendrerit at. Donec sed porta dolor, et lobortis ligula. Nulla sed faucibus risus. Ut ut nisl fermentum, tempus sapien eu, eleifend felis. Aliquam sed nisl in mauris luctus tristique vel sit amet erat. Aliquam non magna sed quam egestas molestie. Etiam mattis tristique tellus in placerat. Integer mollis bibendum blandit. Proin sed consectetur lorem, eu rhoncus magna.\n"
        		+ "\n"
        		+ "Duis enim elit, venenatis quis venenatis vel, consequat eu purus. Ut porttitor tincidunt felis sit amet gravida. Fusce elit diam, sollicitudin et luctus et, auctor eu nulla. Praesent ligula justo, aliquet ac tellus auctor, porttitor tempor velit. Ut finibus, mauris et interdum dapibus, ligula urna egestas eros, ut maximus ligula tellus ut ante. Nam molestie nisi eget erat semper lobortis. Donec porta egestas sem, ac sodales enim accumsan vitae. Nullam scelerisque commodo ex in scelerisque. Quisque sed magna in nunc pellentesque sollicitudin eu nec metus. Suspendisse ultrices ligula velit. Mauris non porta est. Quisque sodales orci ac velit luctus viverra. Cras semper, enim sit amet luctus finibus, nunc massa vulputate orci, eget fringilla ipsum orci non orci. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Vestibulum malesuada eros ac urna rhoncus, eu efficitur augue eleifend."
        		+ "", fontParagraph);
        paragraph.setAlignment(Paragraph.ALIGN_JUSTIFIED_ALL);
        
    	return paragraph;
    }

    
    private PdfPTable tablePDF(List<OrderRequest> users) {
        
			Font font = new Font(Font.HELVETICA, 12, Font.BOLDITALIC);
	
			
			PdfPTable table = new PdfPTable(4);
			table.setWidthPercentage(100);
			// setting column widths
			table.setWidths(new float[] { 6.0f, 6.0f, 6.0f, 6.0f });

//			table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
			PdfPCell cell = new PdfPCell();
			// table headers
			cell.setPhrase(new Phrase("First Name", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("Last Name", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("Email", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("DOB", font));
			table.addCell(cell);

			// adding table rows
			for (OrderRequest e : users) {

				table.addCell(e.getNome());
				table.addCell(e.getDataInicio().toString());
				table.addCell(e.getDataFim().toString());
//				table.addCell(e.getContratoFaixaSalarial());
			}
			return table;
		
	}

    
}
