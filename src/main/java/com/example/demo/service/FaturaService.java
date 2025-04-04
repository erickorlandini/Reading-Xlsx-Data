package com.example.demo.service;

import com.example.demo.model.Fatura;
import com.example.demo.repository.FaturaRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class FaturaService {

    private static final int COL_ESPECIFICACAO = 39;

    @Autowired
    private FaturaRepository faturaRepository;

    private static final String FILE_PATH = "/home/erick/Documentos/Projetos/Java/LeituraXlsx/src/main/resources/planilhas/Exemple-Sheet.xlsx";

    public void processarPlanilha() {
        try (FileInputStream fis = new FileInputStream(new File(FILE_PATH));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Primeira aba
            List<Fatura> faturas = new ArrayList<>();

            for (int i = 3; i <= sheet.getLastRowNum(); i++) { // Começa na linha 4 (índice 3)
                Row row = sheet.getRow(i);
                if (row == null) continue;

                Fatura fatura = new Fatura();
                fatura.setFaturaPo(getStringValue(row, 0));
                fatura.setDataFatura(getDateValue(row, 1));
                fatura.setPaisProcedencia(getStringValue(row, 2));
                fatura.setUrfDespacho(getStringValue(row, 3));
                fatura.setUrfEntrada(getStringValue(row, 4));
                fatura.setIncoterm(getStringValue(row, 5));
                fatura.setMoedaMle(getStringValue(row, 6));
                fatura.setValorMle(getBigDecimalValue(row, 7));
                fatura.setMoedaDesconto(getStringValue(row, 8));
                fatura.setValorDesconto(getBigDecimalValue(row, 9));
                fatura.setMoedaDespesas(getStringValue(row, 10));
                fatura.setValorDespesas(getBigDecimalValue(row, 11));
                fatura.setMoedaFrete(getStringValue(row, 12));
                fatura.setValorFretePrepaid(getBigDecimalValue(row, 13));
                fatura.setValorFreteCollect(getBigDecimalValue(row, 14));
                fatura.setValorFreteNacional(getBigDecimalValue(row, 15));
                fatura.setMoedaSeguro(getStringValue(row, 16));
                fatura.setValorSeguro(getBigDecimalValue(row, 17));
                fatura.setPartnumber(getStringValue(row, 18));
                fatura.setApelido(getStringValue(row, 19));
                fatura.setDescricaoResumida(getStringValue(row, 20));
                fatura.setUnidadeMedida(getStringValue(row, 21));
                fatura.setNcm(getStringValue(row, 22));
                fatura.setDestaqueNcm(getStringValue(row, 23));
                fatura.setNaladiSh(getStringValue(row, 24));
                fatura.setNaladiNcca(getStringValue(row, 25));
                fatura.setAliquotaIcms(getStringValue(row, 26));
                fatura.setQuantidade(getStringValue(row, 27));
                fatura.setQuantidadeEstatistica(getStringValue(row, 28));
                fatura.setPesoLiquido(getStringValue(row, 29));
                fatura.setPesoLiquidoUnitario(getStringValue(row, 30));
                fatura.setPesoBruto(getStringValue(row, 31));
                fatura.setExportador(getStringValue(row, 32));
                fatura.setFabricante(getStringValue(row, 33));
                fatura.setValorUnitario(getBigDecimalValue(row, 34));
                fatura.setValorTotalMoeda(getBigDecimalValue(row, 35));
                fatura.setPaisOrigem(getStringValue(row, 36));
                fatura.setNve(getStringValue(row, 37));
                fatura.setDescricaoNfe(getStringValue(row, 38));
                fatura.setQuebraAuxiliar(getStringValue(row, 39));
                fatura.setEspecificacao(getStringValue(row, COL_ESPECIFICACAO));
                fatura.setNumeroAtoConcessorio(getStringValue(row, 41));
                fatura.setItemAto(getStringValue(row, 42));
                fatura.setMarca(getStringValue(row, 43));
                fatura.setNumeroSerie(getStringValue(row, 44));
                fatura.setModelo(getStringValue(row, 45));
                fatura.setAnoFabricao(getStringValue(row, 46));
                fatura.setLote(getStringValue(row, 47));
                fatura.setDataValidade(getStringValue(row, 48));
                fatura.setNecessitaLi(getBooleanValue(row, 49));
                fatura.setNumeroFatura(getStringValue(row, 50));
                fatura.setItemFatura(getStringValue(row, 51));
                fatura.setCfop(getStringValue(row, 52));
                fatura.setGtin(getStringValue(row, 53));
                fatura.setCodigoSecundario(getStringValue(row, 54));
                fatura.setAuxiliarInvoice(getStringValue(row, 55));
                fatura.setSequenciaInvoice(getStringValue(row, 56));
                fatura.setNumeroPedido(getStringValue(row, 57));
                fatura.setSequenciaPedido(getStringValue(row, 58));
                fatura.setNumeroOrdemCompra(getStringValue(row, 59));
                fatura.setSequenciaOrdemCompra(getStringValue(row, 60));
                fatura.setArea(getStringValue(row, 61));

                faturas.add(fatura);
            }

            faturaRepository.saveAll(faturas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getStringValue(Row row, int index) {
        Cell cell = row.getCell(index);
        if (cell == null) return "";

        String value = cell.toString().trim();
        // Trunca para 255 caracteres se for muito longo
        return value.length() > 255 ? value.substring(0, 255) : value;
    }

    private LocalDate getDateValue(Row row, int index) {
        Cell cell = row.getCell(index);
        if (cell == null) return null;

        try {
            if (cell.getCellType() == CellType.NUMERIC) {
                return cell.getLocalDateTimeCellValue().toLocalDate();
            } else if (cell.getCellType() == CellType.STRING) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                return LocalDate.parse(cell.getStringCellValue().trim(), formatter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private BigDecimal getBigDecimalValue(Row row, int index) {
        Cell cell = row.getCell(index);
        if (cell != null && cell.getCellType() == CellType.NUMERIC) {
            return BigDecimal.valueOf(cell.getNumericCellValue());
        }
        return BigDecimal.ZERO;
    }

    private Boolean getBooleanValue(Row row, int index) {
        Cell cell = row.getCell(index);
        if (cell == null) {
            return null;
        }

        String stringValue = cell.toString().trim().toLowerCase();

        if (stringValue.equals("s") || stringValue.equals("sim") ||
                stringValue.equals("y") || stringValue.equals("yes") ||
                stringValue.equals("true") || stringValue.equals("1")) {
            return true;
        } else if (stringValue.equals("n") || stringValue.equals("não") ||
                stringValue.equals("no") || stringValue.equals("false") ||
                stringValue.equals("0")) {
            return false;
        }
        return null;
    }
}

