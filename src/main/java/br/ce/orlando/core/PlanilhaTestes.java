package br.ce.orlando.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PlanilhaTestes {
    
    @SuppressWarnings("resource")
	public static void escreverResultadoTeste(String nomePlanilha, String nomeClasseTeste, String resultado) throws IOException {
        // Carrega o arquivo de planilha a partir da pasta target
        File file = new File("src/main/resources/" + nomePlanilha);

        // Cria um objeto FileInputStream para ler a planilha
        FileInputStream inputStream = new FileInputStream(file);
        
        // Cria um objeto XSSFWorkbook para representar a planilha
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        
        // Seleciona a primeira aba da planilha
        XSSFSheet sheet = workbook.getSheetAt(0);
        
        // Procura a coluna "NOME DO TESTE AUTOMATIZADO" para encontrar a linha do teste
        int nomeColuna = -1;
        for (Cell celula : sheet.getRow(0)) {
            if (celula.getStringCellValue().equals("NOME DO TESTE AUTOMATIZADO")) {
                nomeColuna = celula.getColumnIndex();
                break;
            }
        }
        
        if (nomeColuna == -1) {
            throw new IllegalArgumentException("Coluna 'NOME DO TESTE AUTOMATIZADO' não encontrada na planilha.");
        }
        
        // Procura a coluna "RESULTADO OBTIDO" para atualizar o resultado do teste
        int resultadoColuna = -1;
        for (Cell celula : sheet.getRow(0)) {
            if (celula.getStringCellValue().equals("RESULTADO OBTIDO")) {
                resultadoColuna = celula.getColumnIndex();
                break;
            }
        }
        
        if (resultadoColuna == -1) {
            throw new IllegalArgumentException("Coluna 'RESULTADO OBTIDO' não encontrada na planilha.");
        }
        
        // Procura o nome da classe de teste na coluna "NOME DO TESTE AUTOMATIZADO"
        for (Row linha : sheet) {
            Cell cell = linha.getCell(nomeColuna);
            if (cell != null && cell.getStringCellValue().equals(nomeClasseTeste)) {
                // Atualiza o resultado na coluna "RESULTADO OBTIDO"
                XSSFCell resultCell = (XSSFCell) linha.getCell(resultadoColuna, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                resultCell.setCellValue(resultado);
                break;
            }
        }
        
        // Fecha o arquivo de entrada
        inputStream.close();
        
        // Cria um objeto FileOutputStream para gravar a planilha atualizada
        FileOutputStream outputStream = new FileOutputStream(file);
        workbook.write(outputStream);
        outputStream.close();
        
        // Fecha o objeto XSSFWorkbook
        workbook.close();
    }
    
    
    public void setBordaCelula(XSSFCellStyle style) {
      // Define a borda da célula
      style.setBorderBottom(BorderStyle.THIN);
      style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
      style.setBorderTop(BorderStyle.THIN);
      style.setTopBorderColor(IndexedColors.BLACK.getIndex());
      style.setBorderLeft(BorderStyle.THIN);
      style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
      style.setBorderRight(BorderStyle.THIN);
      style.setRightBorderColor(IndexedColors.BLACK.getIndex());
    }
    
    public void setAlinhamentoCenter(XSSFCellStyle style) {
   	 // Alinha o conteúdo da célula no centro
      style.setAlignment(HorizontalAlignment.CENTER);
      style.setVerticalAlignment(VerticalAlignment.CENTER);
    }
    
    public void setCorCelula(XSSFWorkbook workbook , XSSFCell resultCell, String cor) {
    	
    	// Verifica se a célula já tem um estilo definido e usa esse estilo
        XSSFCellStyle style = null;
        if (resultCell.getCellStyle() != null) {
            style = (XSSFCellStyle) resultCell.getCellStyle().copy();
        } else {
        	// Cria um objeto XSSFCellStyle para definir a cor de fundo da célula
            style = workbook.createCellStyle();
        }
    	
         //Determina que a célula seja preenchida com uma cor sólida.
    	 style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
         if (cor.equalsIgnoreCase("verde")) {
             style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
             style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
             style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
             resultCell.setCellStyle(style);
         } else if (cor.equalsIgnoreCase("vermelho")) {
             style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
             style.setFillForegroundColor(IndexedColors.RED.getIndex());
             style.setFillBackgroundColor(IndexedColors.RED.getIndex());
             resultCell.setCellStyle(style);
         } else if (cor.equalsIgnoreCase("amarelo")) {
             style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
             style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
             style.setFillBackgroundColor(IndexedColors.YELLOW.getIndex());
             resultCell.setCellStyle(style);
         }
    }
    
}
