package Utils;

import Model.*;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.List;

public class TableUtils {

    public static void renderTable(String title, List<String> options) {
        org.nocrala.tools.texttablefmt.CellStyle cellStyle =
                new org.nocrala.tools.texttablefmt.CellStyle(CellStyle.HorizontalAlign.center);
        org.nocrala.tools.texttablefmt.Table table =
                new Table(1, BorderStyle.UNICODE_BOX_HEAVY_BORDER, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        table.setColumnWidth(0, 50, 60);

        table.addCell(title, cellStyle);
        if (options != null) {
            for (String option : options) {
                table.addCell(option, cellStyle);
            }
        }
        System.out.println(table.render());
    }

    public static void readUserData(List<Users> users) {
        org.nocrala.tools.texttablefmt.CellStyle cellStyle = new org.nocrala.tools.texttablefmt.CellStyle(CellStyle.HorizontalAlign.center);
        org.nocrala.tools.texttablefmt.Table table = new Table(9, BorderStyle.UNICODE_BOX_HEAVY_BORDER_WIDE, ShownBorders.ALL);
        table.setColumnWidth(0, 3, 50);
        table.setColumnWidth(1, 12, 50);
        table.setColumnWidth(2, 5, 50);
        table.setColumnWidth(3, 25, 50);
        table.setColumnWidth(4, 20, 50);
        table.setColumnWidth(5, 7, 50);
        table.setColumnWidth(6, 5, 50);
        table.setColumnWidth(7, 10, 50);
        table.setColumnWidth(8, 25, 50);
        table.addCell("ID", cellStyle);
        table.addCell("Username", cellStyle);
        table.addCell("Gender", cellStyle);
        table.addCell("Email", cellStyle);
        table.addCell("Password", cellStyle);
        table.addCell("Role", cellStyle);
        table.addCell("Remark", cellStyle);
        table.addCell("IsDisabled", cellStyle);
        table.addCell("CreatedAt", cellStyle);

        if ((users != null) && !users.isEmpty() && (users.get(0).getId() > 0)) {
            for (Users user : users) {
                table.addCell(user.getId() + " ", cellStyle);
                table.addCell(user.getUsername(), cellStyle);
                table.addCell(user.getGender(), cellStyle);
                table.addCell(user.getEmail(), cellStyle);
                table.addCell(user.getPassword(), cellStyle);
                table.addCell(user.getRole(), cellStyle);
                table.addCell(user.getRemark() + " ", cellStyle);
                table.addCell(user.getDisabled() + " ", cellStyle);
                table.addCell(user.getCreatedAt() + " ", cellStyle);
            }
            table.addCell("Total user: ", 2);
            int size = users.size();
            table.addCell("   " + size + (size > 1 ? " users" : " user"), 7);
        } else {
            table.addCell("There are no users matching your search criteria", 9);
        }
        System.out.println(table.render());
    }
    public static void readCategoryData(List<Category> categories) {
        org.nocrala.tools.texttablefmt.CellStyle cellStyle = new org.nocrala.tools.texttablefmt.CellStyle(CellStyle.HorizontalAlign.center);
        org.nocrala.tools.texttablefmt.Table table = new Table(4, BorderStyle.UNICODE_BOX_HEAVY_BORDER_WIDE, ShownBorders.ALL);
        table.setColumnWidth(0, 3, 50);
        table.setColumnWidth(1, 12, 50);
        table.setColumnWidth(2, 30, 50);
        table.setColumnWidth(3, 25, 50);
        table.addCell("Category ID", cellStyle);
        table.addCell("Category name", cellStyle);
        table.addCell("Description", cellStyle);
        table.addCell("Created At", cellStyle);

        if ((categories != null) && !categories.isEmpty() && (categories.get(0).getId() > 0)) {
            for (Category category : categories) {
                table.addCell(category.getId() + " ", cellStyle);
                table.addCell(category.getName(), cellStyle);
                table.addCell(category.getDescription(), cellStyle);
                table.addCell(category.getCreatedAt()+ " ", cellStyle);
            }
            table.addCell("Total category: ", 2);
            int size = categories.size();
            table.addCell("   " + size + (size > 1 ? " category" : " user"), 2);
        } else {
            table.addCell("There are no category matching your search criteria", 2);
        }
        System.out.println(table.render());
    }
    public static void readManufacturerData(List<Manufacturer> manufacturers) {
        org.nocrala.tools.texttablefmt.CellStyle cellStyle = new org.nocrala.tools.texttablefmt.CellStyle(CellStyle.HorizontalAlign.center);
        org.nocrala.tools.texttablefmt.Table table = new Table(5, BorderStyle.UNICODE_BOX_HEAVY_BORDER_WIDE, ShownBorders.ALL);
        table.setColumnWidth(0, 3, 50);
        table.setColumnWidth(1, 12, 50);
        table.setColumnWidth(2, 25, 50);
        table.setColumnWidth(3, 25, 50);
        table.setColumnWidth(4, 7, 50);
        table.addCell("Manu_ID", cellStyle);
        table.addCell("Manu_Name", cellStyle);
        table.addCell(" Description ", cellStyle);
        table.addCell(" Address ", cellStyle);
        table.addCell(" License ", cellStyle);

        if ((manufacturers != null) && !manufacturers.isEmpty() && (manufacturers.get(0).getId() > 0)) {
            for (Manufacturer manufacturer : manufacturers) {
                table.addCell(manufacturer.getId() + " ", cellStyle);
                table.addCell(manufacturer.getName(), cellStyle);
                table.addCell(manufacturer.getDescription(), cellStyle);
                table.addCell(manufacturer.getAddress()+ " ", cellStyle);
                table.addCell(manufacturer.getLicense()+ " ", cellStyle);
            }
            table.addCell("Total manufacturer: ", 2);
            int size = manufacturers.size();
            table.addCell("   " + size + (size > 1 ? " manufacturers" : " manufacturer"), 2);
        } else {
            table.addCell("There are no manufacturer matching your search criteria", 3);
        }
        System.out.println(table.render());
    }
    public static void readProductData(List<Products> products) {
        org.nocrala.tools.texttablefmt.CellStyle cellStyle = new org.nocrala.tools.texttablefmt.CellStyle(CellStyle.HorizontalAlign.center);
        org.nocrala.tools.texttablefmt.Table table = new Table(9, BorderStyle.UNICODE_BOX_HEAVY_BORDER_WIDE, ShownBorders.ALL);
        table.setColumnWidth(0, 3, 50);
        table.setColumnWidth(1, 12, 50);
        table.setColumnWidth(2, 10, 50);
        table.setColumnWidth(3, 5, 50);
        table.setColumnWidth(4, 20, 50);
        table.setColumnWidth(5, 20, 50);
        table.setColumnWidth(6, 20, 50);
        table.setColumnWidth(7, 7, 50);
        table.setColumnWidth(8, 7, 50);
        table.addCell("Pro_ID", cellStyle);
        table.addCell("Pro_Name", cellStyle);
        table.addCell(" Price ", cellStyle);
        table.addCell(" Description ", cellStyle);
        table.addCell(" Made_at_date ", cellStyle);
        table.addCell(" Expiration_date ", cellStyle);
        table.addCell(" CreatedAt ", cellStyle);
        table.addCell(" Manu_id ", cellStyle);
        table.addCell(" Cat_id ", cellStyle);

        if ((products != null) && !products.isEmpty() && (products.get(0).getId() > 0)) {
            for (Products product : products) {
                table.addCell(product.getId() + " ", cellStyle);
                table.addCell(product.getName(), cellStyle);
                table.addCell(product.getPrice()+ " ", cellStyle);
                table.addCell(product.getDescription(), cellStyle);
                table.addCell(product.getMadeAtDate()+ " ", cellStyle);
                table.addCell(product.getExpirationDate()+ " ", cellStyle);
                table.addCell(product.getCreatedAt()+ " ", cellStyle);
                table.addCell(product.getManuFacturerId()+ " ", cellStyle);
                table.addCell(product.getCategoryId()+ " ", cellStyle);
            }
            table.addCell("Total product: ", 2);
            int size = products.size();
            table.addCell("   " + size + (size > 1 ? " products" : " product"), 7);
        } else {
            table.addCell("There are no manufacturer matching your search criteria", 9);
        }
        System.out.println(table.render());
    }
    public static void readStockData(List<Stocks> stocks) {
        org.nocrala.tools.texttablefmt.CellStyle cellStyle = new org.nocrala.tools.texttablefmt.CellStyle(CellStyle.HorizontalAlign.center);
        org.nocrala.tools.texttablefmt.Table table = new Table(12, BorderStyle.UNICODE_BOX_HEAVY_BORDER_WIDE, ShownBorders.ALL);
        table.setColumnWidth(0, 3, 25);
        table.setColumnWidth(1, 3, 25);
        table.setColumnWidth(2, 10, 25);
        table.setColumnWidth(3, 5, 25);
        table.setColumnWidth(4, 10, 25);
        table.setColumnWidth(5, 10, 25);
        table.setColumnWidth(6, 10, 25);
        table.setColumnWidth(7, 7, 25);
        table.setColumnWidth(8, 7, 25);
        table.setColumnWidth(9, 25, 25);
        table.setColumnWidth(10, 7, 25);
        table.setColumnWidth(11, 7, 25);
        table.addCell("ID", cellStyle);
        table.addCell("Pro_ID", cellStyle);
        table.addCell("Pro_Name", cellStyle);
        table.addCell("Cat_ID", cellStyle);
        table.addCell("Cat_Name", cellStyle);
        table.addCell("Quantity", cellStyle);
        table.addCell("Price", cellStyle);
        table.addCell("Total price", cellStyle);
        table.addCell("Manu_name", cellStyle);
        table.addCell("Created", cellStyle);
        table.addCell("User_ID", cellStyle);
        table.addCell("User_Name", cellStyle);

        if ((stocks != null) && !stocks.isEmpty() && (stocks.get(0).getId() > 0)) {
            for (Stocks stock : stocks) {
                table.addCell(stock.getId() + " ", cellStyle);
                table.addCell(stock.getPro_id()+" ", cellStyle);
                table.addCell(stock.getPro_name(), cellStyle);
                table.addCell(stock.getCat_id()+" ", cellStyle);
                table.addCell(stock.getCat_name(), cellStyle);
                table.addCell(stock.getQty()+ " ", cellStyle);
                table.addCell(stock.getPrice()+ " ", cellStyle);
                table.addCell(stock.getTotal_price()+ " ", cellStyle);
                table.addCell(stock.getManu_name(), cellStyle);
                table.addCell(stock.getCreated_at()+ " ", cellStyle);
                table.addCell(stock.getUser_id()+ " ", cellStyle);
                table.addCell(stock.getUsername(), cellStyle);
            }
            table.addCell("Total stock: ", 2);
            int size = stocks.size();
            table.addCell("   " + size + (size > 1 ? " stocks" : " stock"), 10);
        } else {
            table.addCell("There are no stock matching your search criteria", 12);
        }
        System.out.println(table.render());
    }

}
