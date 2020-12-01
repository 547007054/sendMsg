package com.ztjs.platform.controller.fence;

import com.ztjs.platform.common.entity.Result;
import com.ztjs.platform.model.po.fence.MessageListPo;
import com.ztjs.platform.service.fence.MessageListService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aa on 2019/9/11.
 */
@Slf4j
@Controller
@Scope("prototype")
@AllArgsConstructor
@RequestMapping("fence/indexFence")
public class MessageListController {

    private final MessageListService messageListService;
    private final static String xls = "xls";
    private final static String xlsx = "xlsx";
    private final static String XLS = "XLS";
    private final static String XLSX = "XLSX";

    @GetMapping
    public String index() {
        return "fence/index";
    }

    /**
     * 上传安全质量信息表格，将内容保存到服务器
     * @param file
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/excelImport", method = RequestMethod.POST)
    public Result uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        Result result = new Result();
        try{
            List<String[]> messageList = readExcel(file);
            for(int i = 0;i<messageList.size();i++){
                String[] message = messageList.get(i);
                MessageListPo messageListPo = new MessageListPo();
                System.out.println("时间是"+message[0]);
                System.out.println(message[1]);
                String a =message[0].substring(0,4);
                String b =message[0].substring(5,7);
                String c =message[0].substring(8);
                String d=a+"-"+b+"-"+c;
                messageListPo.setTime(d);
                messageListPo.setCraftContent(message[1]);
                messageListPo.setName(message[2]);
                //messageListPo.setSqaContent(message[2]);
                //创建时间
                Date time = new Date(System.currentTimeMillis());
                messageListPo.setCreateTime(time);
                messageListService.addMessageList(messageListPo);
            }
            result.setCode(200);
            result.setMsg("操作成功!");
        }catch (Exception e) {
            e.printStackTrace();
            result.setMsg("系统繁忙，请稍后再试！");
            result.setCode(500);
        }
        return result;
    }



    //返回json数据
/*    @ResponseBody
    @RequestMapping(value = "/excelImport", method = RequestMethod.POST)
    public
    Result uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

        Result result = new Result();
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        if (file.isEmpty()) {
            result.setCode(500);
            result.setMsg("文件为空！");
            return result;
        }
        try {
            //根据路径获取这个操作excel的实例
            XSSFWorkbook wb = new XSSFWorkbook(file.getInputStream());
            //根据页面index 获取sheet页
            XSSFSheet sheet = wb.getSheetAt(0);
            //实体类集合
            List<MessageListPo> messageListPos = new ArrayList<>();
            XSSFRow row = null;
            //循环sesheet页中数据从第二行开始，第一行是标题
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                //获取每一行数据
                row = sheet.getRow(i);
                MessageListPo messageListPo = new MessageListPo();
                messageListPo.setTime(row.getCell(0).getStringCellValue());
                messageListPo.setCraftContent(row.getCell(1).getStringCellValue());
                messageListPo.setSqaContent(row.getCell(2).getStringCellValue());
                //创建时间
                Date time = new Date(System.currentTimeMillis());
                messageListPo.setCreateTime(time);
                int  a = messageListService.addMessageList(messageListPo);
                if(a != 0){
                    System.out.println("操作成功！！！");
                }else{
                    System.out.println("操作失败！！！");
                }
                messageListPos.add(messageListPo);
            }
            //循环展示导入的数据，实际应用中应该校验并存入数据库
            for (MessageListPo imdata : messageListPos) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
                System.out.println("ID:"+imdata.getId()+" time:"+imdata.getTime()+"CRAFT_CONTENT"+imdata.getCraftContent()+"SQA_CONTENT"+imdata.getSqaContent());
            }
            result.setCode(200);
            result.setMsg("操作成功!");
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("系统繁忙，请稍后再试！");
            result.setCode(500);
        }
        return result;
    }*/


    public static List<String[]> readExcel(MultipartFile file) throws IOException {
        //检查文件
        checkFile(file);
        //获得Workbook工作薄对象
        Workbook workbook = getWorkBook(file);
        //创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回
        List<String[]> list = new ArrayList<String[]>();
        if(workbook != null){
            for(int sheetNum = 0;sheetNum < workbook.getNumberOfSheets();sheetNum++){
                //获得当前sheet工作表
                Sheet sheet = workbook.getSheetAt(sheetNum);
                if(sheet == null){
                    continue;
                }
                //获得当前sheet的开始行
                int firstRowNum  = sheet.getFirstRowNum();
                //获得当前sheet的结束行
                int lastRowNum = sheet.getLastRowNum();
                //循环除了第一行的所有行
                for(int rowNum = firstRowNum+1;rowNum <= lastRowNum;rowNum++){
                    //获得当前行
                    Row row = sheet.getRow(rowNum);
                    if(row == null){
                        continue;
                    }
                    //获得当前行的开始列
                    int firstCellNum = row.getFirstCellNum();
                    //获得当前行的列数
                    int lastCellNum = row.getPhysicalNumberOfCells();
                    String[] cells = new String[row.getPhysicalNumberOfCells()];
                    //循环当前行
                    for(int cellNum = firstCellNum; cellNum < lastCellNum;cellNum++){
                        Cell cell = row.getCell(cellNum);
                        cells[cellNum] = getCellValue(cell);
                    }
                    list.add(cells);
                }
            }
            workbook.close();
        }
        return list;
    }

    public static void checkFile(MultipartFile file) throws IOException{
        //判断文件是否存在
        if(null == file){
            throw new FileNotFoundException("文件不存在！");
        }
        //获得文件名
        String fileName = file.getOriginalFilename();
        //判断文件是否是excel文件
        if(!fileName.endsWith(xls) && !fileName.endsWith(XLS) &&!fileName.endsWith(XLSX) && !fileName.endsWith(xlsx)){
            throw new IOException(fileName + "不是excel文件");
        }
    }
    public static Workbook getWorkBook(MultipartFile file) {
        //获得文件名
        String fileName = file.getOriginalFilename();
        //创建Workbook工作薄对象，表示整个excel
        Workbook workbook = null;
        try {
            //获取excel文件的io流
            InputStream is = file.getInputStream();
            //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
            if(fileName.endsWith(xls)||fileName.endsWith(XLS)){
                //2003
                workbook = new HSSFWorkbook(is);
            }else if(fileName.endsWith(xlsx)||fileName.endsWith(XLSX)){
                //2007
                workbook = new XSSFWorkbook(is);
            }
        } catch (IOException e) {
        }
        return workbook;
    }
    public static String getCellValue(Cell cell){
        String cellValue = "";
        if(cell == null){
            return cellValue;
        }
        //把数字当成String来读，避免出现1读成1.0的情况
        if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }
        //判断数据的类型
        switch (cell.getCellType()){
            case Cell.CELL_TYPE_NUMERIC: //数字
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_STRING: //字符串
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_BOOLEAN: //Boolean
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA: //公式
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_BLANK: //空值
                cellValue = "";
                break;
            case Cell.CELL_TYPE_ERROR: //故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }



}
