import Model.*;
import Repository.*;
import Utils.Invalidation;
import Utils.TableUtils;

import java.lang.reflect.InaccessibleObjectException;
import java.net.SocketTimeoutException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TooManyListenersException;

public class Testing {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
         //used for class user
        //Create an object for adding user
        //Add user
        /*Users user = new Users().addUser(scanner);
        //Set insert user to User repository (add to DB)
        UserRepository.setInsertUser(user);
        for (Users show : UserRepository.getAllUsers()) {
            System.out.println(show.toString());
        }*/
        //Update user
        /*Integer update_id= Invalidation.getInteger("Enter id you want to update: ",scanner);
        Users updated = new Users().updateUser(scanner);
        UserRepository.setUpdateUser(updated, update_id);*/
        //Delete user
        /*Integer delete_id = Invalidation.getInteger("Enter id you want to delete: ",scanner);
        UserRepository.setDeleteUser(delete_id);
        for (Users deleted : UserRepository.getAllUsers()) {
            System.out.println(deleted.toString());
        }*/

        //used for class category
        //Show Category
        /*for (Category category: CategoryRepository.getCategories()){
            System.out.println(category.toString());
        }*/
        //Add Category
        /*Category addcCategory = new Category().addCategory(scanner);
        CategoryRepository.setInsertCategory(addcCategory);
        System.out.println("Added: ");
        for (Category category: CategoryRepository.getCategories()){
            System.out.println(category.toString());
        }*/
        //Update Category
        /*
        Integer update_id = Invalidation.getInteger("Enter id u wnat to update: ",scanner);
        Category updateCategory = new Category().updateCategory(scanner);
        CategoryRepository.setUpdateCategory(updateCategory,update_id);
        System.out.println("Updated: ");
        for (Category category: CategoryRepository.getCategories()){
            System.out.println(category.toString());
        }*/
        //Delete Category
        /*Integer delete_id =Invalidation.getInteger("Enter id u want to delete: ",scanner);
        CategoryRepository.setDeleteCategory(delete_id);
        System.out.println("Deleted: ");
        for (Category deleted: CategoryRepository.getCategories() ){
            deleted.show();
        }*/


        //used for class manufacturer
        // showing Manufacturer
        /*for (Manufacturer show:  ManufacturerRepository.getAManufacturers()){
            System.out.println(show.toString());
        }*/
        // adding Manufacturer
        /*Manufacturer add = new Manufacturer().addManufacturer(scanner);
        ManufacturerRepository.setInsertManufacturer(add);
        System.out.println("Added: ");
        for (Manufacturer show:  ManufacturerRepository.getAManufacturers()){
            System.out.println(show.toString());
        }*/
        //updating Manufacturer
        /*Integer update_id= Invalidation.getInteger("Enter id u want to update: ",scanner);
        Manufacturer update=new Manufacturer().updateManufacturer(scanner);
        ManufacturerRepository.setUpdateManufacturer(update,update_id);
        for (Manufacturer show:  ManufacturerRepository.getAManufacturers()){
            System.out.println(show.toString());
        }*/
        //deleting Manufacturer
        /*Integer delete_id= Invalidation.getInteger("Enter id u want to delete: ",scanner);
        ManufacturerRepository.setDeleteManufacturer(delete_id);
        for (Manufacturer show:  ManufacturerRepository.getAManufacturers()){
            System.out.println(show.toString());
        }*/

        //used for class products
        //showing Product
        /*for (Products show: ProductRepository.getAllProducts()){
            System.out.println(show.toString());
        }*/
        //adding Product
        /* Products addProducts = new Products().addProducts(scanner);
        ProductRepository.setInsertProducts(addProducts);*/
        //updating Product
        /*Integer update_id=Invalidation.getInteger("Enter id u want to update: ",scanner);
        Products update=new Products().updateProducts(scanner);
        ProductRepository.setUpdateProducts(update,update_id);
        for (Products show: ProductRepository.getAllProducts()){
            System.out.println(show.toString());
        }*/
        //deleting Product
        /*Integer delete_id = Invalidation.getInteger("Enter id u want to delete: ",scanner);
        ProductRepository.setDeleteProducts(delete_id);*/
        //Showing stocks
        /*for (Stocks stock: StocksRepository.getAllStocks()){
            System.out.println(stock.toString());
        }
        //adding Stock
        Stocks addStocks = new Stocks().addStock(scanner);
        StocksRepository.setAddStock(addStocks);
        for (Stocks stock: StocksRepository.getAllStocks()){
            System.out.println(stock.toString());
        }
        Integer update_id = Invalidation.getInteger("Enter id u want to update: ",scanner);
        Stocks updateStocks = new Stocks().updateStock(scanner);
        StocksRepository.setUpdateStock(updateStocks,update_id);
        for (Stocks stock: StocksRepository.getAllStocks()){
            System.out.println(stock.toString());
        }
        Integer delete_id = Invalidation.getInteger("Enter id u want to delete: ",scanner);
        StocksRepository.setDeleteStock(delete_id);
        for (Stocks stock: StocksRepository.getAllStocks()){
            System.out.println(stock.toString());
        }*/
        TableUtils.renderTable("Show All Stocks IS NULL",null);
        List<Stocks> stocks = StocksRepository.getStocksIsNUll();
        //StocksRepository.getStocks();
        TableUtils.readStockData(stocks);
    }
}
