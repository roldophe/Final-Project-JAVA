import Model.*;
import Repository.*;
import Utils.Invalidation;
import Utils.TableUtils;

import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean isAuthenticated = false;
        do {
            List<Users> users = UserRepository.getAllUsers();
            TableUtils.renderTable("Authenticated", null);
            String username = "radomkhoem";//Invalidation.getString("Enter username: ", scanner);
            String password = "123radom";//Invalidation.getString("Enter password: ", scanner);
            assert users != null;
            Users user = users.stream().filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password)).findFirst().orElse(null);
            if (user != null) {
                isAuthenticated = true;
            } else {
                System.out.println(("Invalid Credential!! Try again...!"));

                Integer continueOption = Invalidation.getInteger("<<Press 1 to continue and other number to exit: ", scanner);
                if (continueOption != 1) break;
            }
        } while (!isAuthenticated);
        if (!isAuthenticated) {
            System.out.println("Exit from the logging application...!");
        } else {
            int option;
            List<String> listOption = new ArrayList<>((Arrays.asList(" 1. User Management System          ", " 2. Category Management System      ", " 3. Manufacturer Management System  ", " 4. Product Management System       ", " 5. Stock Management System         ", " 6. Exit from Management System     ")));
            do {
                TableUtils.renderTable("Welcome to Stock Management System", listOption);
                option = Invalidation.getInteger("Please choose one: ", scanner);
                switch (option) {
                    case 1 -> {
                        int userOption;
                        List<String> listUserOption = new ArrayList<>((Arrays.asList(
                                " 1. Add New User    ",
                                " 2. Update Old User ",
                                " 3. Delete Old User ",
                                " 4. Show all Users   ",
                                " 5. Exit from user System")));
                        do {
                            TableUtils.renderTable("Welcome to User Management System", listUserOption);
                            userOption = Invalidation.getInteger("Please choose one: ", scanner);
                            switch (userOption) {
                                case 1 -> {
                                    TableUtils.renderTable("Add New User", null);
                                    Users user = new Users().addUser(scanner);
                                    UserRepository.setInsertUser(user);
                                    System.out.println("You have successfully added new user!!");
                                }
                                case 2 -> {
                                    TableUtils.renderTable("Update Old User", null);
                                    Integer update_id = Invalidation.getInteger("Enter id you want to update: ", scanner);
                                    List<Users> users = UserRepository.getAllUsers();
                                    assert users != null;
                                    Users update = users.stream().filter(e -> (e.getId() == update_id)).findFirst().orElse(null);
                                    if (update != null) {
                                        Users updated = new Users().addUser(scanner);
                                        UserRepository.setUpdateUser(updated, update_id);
                                        System.out.println("You have successfully updated new user!!");
                                        break;
                                    }
                                    System.out.println("Key(updated_id)=(" + update_id + ") is not present in present in table(user).");
                                }
                                case 3 -> {
                                    TableUtils.renderTable("Delete Old User", null);
                                    Integer delete_id = Invalidation.getInteger("Enter id you want to delete: ", scanner);
                                    List<Users> users = UserRepository.getAllUsers();
                                    assert users != null;
                                    Users delete = users.stream().filter(e -> e.getId() == delete_id).findFirst().orElse(null);
                                    if (delete != null) {
                                        UserRepository.setDeleteUser(delete_id);
                                        System.out.println("You have successfully deleted old user!!");
                                        break;
                                    }
                                    System.out.println("Key(delete_id)=(" + delete_id + ") is not present in present in table(user).");
                                }
                                case 4 -> {
                                    TableUtils.renderTable("Show All Users", null);
                                    List<Users> allUsers = UserRepository.getAllUsers();
                                    assert allUsers != null;
                                    TableUtils.readUserData(allUsers.stream().sorted(Comparator.comparing(Users::getId)).toList());
                                }
                                case 5 -> System.out.println("Exiting from user application...!");
                                default -> System.out.println("Invalid option! Enter valid option please...!!");
                            }
                        } while (userOption != 5);
                    }
                    case 2 -> {
                        int catetegoryOption;
                        List<String> listUserOption = new ArrayList<>((Arrays.asList(
                                " 1. Add New Category         ",
                                " 2. Update Old Category      ",
                                " 3. Delete Old Category      ",
                                " 4. Show all Categories      ",
                                " 5. Exit from Category System")));
                        do {
                            TableUtils.renderTable("Welcome to Category Management System", listUserOption);
                            catetegoryOption = Invalidation.getInteger("Please choose one : ", scanner);
                            switch (catetegoryOption) {
                                case 1 -> {
                                    TableUtils.renderTable("Add New Category", null);
                                    Category addCategory = new Category().addCategory(scanner);
                                    CategoryRepository.setInsertCategory(addCategory);
                                }
                                case 2 -> {
                                    TableUtils.renderTable("Update Old Category", null);
                                    Integer update_id = Invalidation.getInteger("Enter id you want to update: ", scanner);
                                    Category update = Objects.requireNonNull(CategoryRepository.getCategories())
                                            .stream().filter(e -> Objects.equals(e.getId(), update_id)).findFirst().orElse(null);
                                    if (update != null) {
                                        Category updateCategory = new Category().addCategory(scanner);
                                        CategoryRepository.setUpdateCategory(updateCategory, update_id);
                                        System.out.println("You have successfully updated old category!");
                                        break;
                                    }
                                    System.out.println("Key(update_id)=(" + update_id + ") is not present in present in table(category).");
                                }
                                case 3 -> {
                                    TableUtils.renderTable("Delete Old Category", null);
                                    Integer delete_id = Invalidation.getInteger("Enter id you want to delete: ", scanner);
                                    List<Category> delete = CategoryRepository.getCategories();
                                    assert delete != null;
                                    Category update = delete.stream().filter(e -> Objects.equals(e.getId(), delete_id)).findFirst().orElse(null);
                                    if (update != null) {
                                        CategoryRepository.setDeleteCategory(delete_id);
                                        System.out.println("You have successfully deleted old category!");
                                        break;
                                    }
                                    System.out.println("Key(update_id)=(" + delete_id + ") is not present in present in table(category).");

                                }
                                case 4 -> {
                                    Integer showOption;
                                    List<String> listShowOption = new ArrayList<>((Arrays.asList(
                                            " 1. Show Ascending order (by ID)    ",
                                            " 2. Show Ascending order (by Name)  ",
                                            " 3. Exit from showing system  "
                                    )));
                                    do {
                                        TableUtils.renderTable("Show All Categories", listShowOption);
                                        showOption = Invalidation.getInteger("Please choose one: ", scanner);
                                        switch (showOption) {
                                            case 1 -> {
                                                TableUtils.renderTable("Show Ascending order (by ID)", null);
                                                List<Category> showById = Objects.requireNonNull(CategoryRepository.getCategories()).stream().sorted(Comparator.comparing(Category::getId)).toList();
                                                TableUtils.readCategoryData(showById);
                                            }
                                            case 2 -> {
                                                TableUtils.renderTable("Show Ascending order (by Name)", null);
                                                List<Category> showByName = Objects.requireNonNull(CategoryRepository.getCategories()).stream().sorted(Comparator.comparing(Category::getName)).toList();
                                                TableUtils.readCategoryData(showByName);
                                            }
                                            case 3 ->
                                                System.out.println("Exit from showing application!");
                                            default ->
                                                System.out.println("Invalid input! Enter a valid option please...!");
                                        }
                                    } while (showOption != 3);
                                }
                                case 5 -> System.out.println("Exiting from user application...!");
                                default -> System.out.println("Invalid option! Enter valid option please...!!");
                            }
                        } while (catetegoryOption != 5);
                    }
                    case 3 -> {
                        int manufacurerOption;
                        List<String> listUserOption = new ArrayList<>((Arrays.asList(
                                " 1. Add New Manufacturer         ",
                                " 2. Update Old Manufacturer      ",
                                " 3. Delete Old Manufacturer      ",
                                " 4. Show all Manufacturers       ",
                                " 5. Exit from Manufacturer System")));
                        do {
                            TableUtils.renderTable("Welcome to Manufacturer Management System", listUserOption);
                            manufacurerOption = Invalidation.getInteger("Please Choose One : ", scanner);
                            switch (manufacurerOption) {
                                case 1 -> {
                                    TableUtils.renderTable("Add New Manufacturer", null);
                                    Manufacturer manufacturer = new Manufacturer().addManufacturer(scanner);
                                    ManufacturerRepository.setInsertManufacturer(manufacturer);
                                    System.out.println("You have successfully added new manufacturer!");
                                }
                                case 2 -> {
                                    TableUtils.renderTable("Update Old Manufacturer", null);
                                    Integer update_id = Invalidation.getInteger("Enter id you want to update: ", scanner);
                                    List<Manufacturer> manufacturers = ManufacturerRepository.getAllManufacturers();
                                    assert manufacturers != null;
                                    Manufacturer update = manufacturers.stream().filter(e -> Objects.equals(e.getId(), update_id)).findFirst().orElse(null);
                                    if (update != null) {
                                        Manufacturer updateManufacturer = new Manufacturer().addManufacturer(scanner);
                                        ManufacturerRepository.setUpdateManufacturer(updateManufacturer, update_id);
                                        System.out.println("You have successfully updated old manufacturer!");
                                    }
                                    {
                                        System.out.print("Error! Key(manu_id)=" + update_id + "is not present in table(manufacturer)");
                                    }

                                }
                                case 3 -> {
                                    TableUtils.renderTable("Delete Old Manufacturer", null);
                                    Integer delete_id = Invalidation.getInteger("Enter id you want to delete: ", scanner);
                                    List<Manufacturer> manufacturers = ManufacturerRepository.getAllManufacturers();
                                    assert manufacturers != null;
                                    Manufacturer delete = manufacturers.stream().filter(e -> Objects.equals(e.getId(), delete_id)).findFirst().orElse(null);
                                    if (delete != null) {
                                        ManufacturerRepository.setDeleteManufacturer(delete_id);
                                        System.out.println("You have successfully deleted old manufacturer!");
                                    } else
                                        System.out.println("Error! Key(manu_id)=" + delete_id + " is not present in table(manufacturer)");

                                }
                                case 4 -> {
                                    Integer showOption;
                                    List<String> listShowOption = new ArrayList<>((Arrays.asList(
                                            " 1. Show Ascending order (by ID)    ",
                                            " 2. Show Ascending order (by Name)  ",
                                            " 3. Exit from showing system        "
                                    )));
                                    do {
                                        TableUtils.renderTable("Show All Manufacturers", listShowOption);
                                        showOption = Invalidation.getInteger("Please choose one : ", scanner);
                                        switch (showOption) {
                                            case 1 -> {
                                                TableUtils.renderTable("Show Ascending order (by ID)", null);
                                                List<Manufacturer> showById = Objects.requireNonNull(ManufacturerRepository.getAllManufacturers()).stream().sorted(Comparator.comparing(Manufacturer::getId)).toList();
                                                TableUtils.readManufacturerData(showById);
                                            }
                                            case 2 -> {
                                                TableUtils.renderTable("Show Ascending order (by Name)", null);
                                                List<Manufacturer> showByName = Objects.requireNonNull(ManufacturerRepository.getAllManufacturers()).stream().sorted(Comparator.comparing(Manufacturer::getName)).toList();
                                                TableUtils.readManufacturerData(showByName);
                                            }
                                            case 3 -> System.out.println("Exit from showing application!!");
                                            default ->
                                                    System.out.println("Invalid input! Enter a valid option please...!");
                                        }
                                    } while (showOption != 3);
                                }
                                case 5 -> System.out.println("Exiting from Manufacturer application...!");
                                default -> System.out.println("Invalid option! Enter valid option please...!!");
                            }
                        } while (manufacurerOption != 5);
                    }
                    case 4 -> {
                        int productOption;
                        List<String> listProOption = new ArrayList<>((Arrays.asList(
                                " 1. Add New Product         ",
                                " 2. Update Old Product      ",
                                " 3. Delete Old Product      ",
                                " 4. Show all Products       ",
                                " 5. Exit from Product System")));
                        do {
                            TableUtils.renderTable("Welcome to Product Management System", listProOption);
                            productOption = Invalidation.getInteger(" Please Choose One : ", scanner);
                            switch (productOption) {
                                case 1 -> {
                                    TableUtils.renderTable("Add New Product", null);
                                    Products addProducts = new Products().addProducts(scanner);
                                    ProductRepository.setInsertProducts(addProducts);
                                    System.out.println("You have successfully added new product!");
                                }
                                case 2 -> {
                                    TableUtils.renderTable("Update Old Product", null);
                                    Integer update_id = Invalidation.getInteger("Enter id you want to update: ", scanner);
                                    List<Products> products = ProductRepository.getAllProducts();
                                    assert products != null;
                                    Products update = products.stream().filter(e -> Objects.equals(e.getId(), update_id)).findFirst().orElse(null);
                                    if (update != null) {
                                        Products updateProduct = new Products().addProducts(scanner);
                                        ProductRepository.setUpdateProducts(updateProduct, update_id);
                                        System.out.println("You have successfully updated old product!");
                                    } else
                                        System.out.println("Error! key(pro_id)=" + update_id + " is not present in table(product)!");
                                }
                                case 3 -> {
                                    TableUtils.renderTable("Delete Old Product", null);
                                    Integer delete_id = Invalidation.getInteger("Enter id you want to delete: ", scanner);
                                    List<Products> products = ProductRepository.getAllProducts();
                                    assert products != null;
                                    Products find_id = products.stream().filter(e -> Objects.equals(e.getId(), delete_id)).findFirst().orElse(null);
                                    if (find_id != null) {
                                        ProductRepository.setDeleteProducts(delete_id);
                                        System.out.println("You have successfully deleted product!!");
                                        break;
                                    }
                                    System.out.println("key(pro_id)=" + delete_id + " is not present in table(product)!");
                                }
                                case 4 -> {
                                    int showOption;
                                    List<String> listShowOption = new ArrayList<>((Arrays.asList(
                                            " 1. Show Ascending order (By ID)       ",
                                            " 2. Show Ascending order (By Price)    ",
                                            " 3. Show Descending order (By price)   ",
                                            " 4. Exit from showing application      ")));
                                    do {
                                        TableUtils.renderTable("Show All Products", listShowOption);
                                        showOption = Invalidation.getInteger("Please choose one : ", scanner);
                                        switch (showOption) {
                                            case 1 -> {
                                                TableUtils.renderTable("Show Ascending order (By ID) ", null);
                                                List<Products> showById = Objects.requireNonNull(ProductRepository.getAllProducts()).stream().sorted(Comparator.comparing(Products::getId)).toList();
                                                TableUtils.readProductData(showById);
                                            }
                                            case 2 -> {
                                                TableUtils.renderTable("Show Ascending order (By Name) ", null);
                                                List<Products> showByName = Objects.requireNonNull(ProductRepository.getAllProducts()).stream().sorted(Comparator.comparing(Products::getName)).toList();
                                                TableUtils.readProductData(showByName);
                                            }
                                            case 3 -> {
                                                TableUtils.renderTable("Show Descending order (By Price) ", null);
                                                List<Products> showByPrice = Objects.requireNonNull(ProductRepository.getAllProducts()).stream().sorted(Comparator.comparing(Products::getPrice).reversed()).toList();
                                                TableUtils.readProductData(showByPrice);
                                            }
                                            case 4 -> System.out.println("Exiting from program!!");
                                            default -> System.out.println("Invalid input!! Enter a valid option please...!!");
                                        }
                                    } while (showOption != 4);
                                }
                                case 5 -> System.out.println("Exiting from Manufacturer application...!");
                                default -> System.out.println("Invalid option! Enter valid option please...!!");
                            }
                        } while (productOption != 5);
                    }
                    case 5 -> {
                        int stockOption;
                        List<String> listUserOption = new ArrayList<>((Arrays.asList(
                                " 1. Add Old Stock         ",
                                " 2. Update Old Stock      ",
                                " 3. Delete Old Stock      ",
                                " 4. Show all Stock       ",
                                " 5. Exit from Stock System")));
                        do {
                            TableUtils.renderTable("Welcome to Stock Management System", listUserOption);
                            stockOption = Invalidation.getInteger(" Please Choose One: ", scanner);
                            switch (stockOption) {
                                case 1 -> {
                                    int addOption;
                                    List<String> listAddOption = new ArrayList<>((Arrays.asList(
                                            " 1. Add new Stock         ",
                                            " 2. Add Old Stock      ",
                                            " 3. Exit from adding System")));
                                    do {
                                        TableUtils.renderTable("Add Stock", listAddOption);
                                        addOption = Invalidation.getInteger("Please choose one: ", scanner);
                                        switch (addOption) {
                                            case 1 -> {
                                                TableUtils.renderTable("Add New Stock", null);
                                                Stocks addStock = new Stocks().AddStock(scanner);
                                                StocksRepository.setAddStock(addStock);
                                                System.out.println("You have successfully added new stock!!");
                                            }
                                            case 2 -> {
                                                TableUtils.renderTable("Add old Stock", null);
                                                Integer update_qty;
                                                Integer update_id = Invalidation.getInteger("Enter id you want to add: ", scanner);
                                                List<Stocks> updateQty = StocksRepository.getStocks();
                                                assert updateQty != null;
                                                Stocks update = updateQty.stream().filter(e -> Objects.equals(e.getId(), update_id)).findFirst().orElse(null);
                                                if (update != null) {
                                                    update_qty = Invalidation.getUpdateQty("Please enter a value you want to add: ", update_id, scanner);
                                                    StocksRepository.setUpdateQTY(update_id, update_qty);
                                                    System.out.println("You have successfully updated old stock!!");
                                                } else
                                                    System.out.println("key(stock_id)=" + update_id + " is not present in table(stock)!");
                                            }
                                            case 3 -> System.out.println("Exit from adding stock!!");
                                            default ->
                                                    System.out.println("Invalid input! Enter a valid option please..!!");
                                        }
                                    } while (addOption != 3);
                                }
                                case 2 -> {
                                    TableUtils.renderTable("Update Old Stock", null);
                                    Integer update_id = Invalidation.getInteger("Enter id you want to update: ", scanner);
                                    List<Stocks> stocks = StocksRepository.getStocks();
                                    assert stocks != null;
                                    Stocks update = stocks.stream().filter(e -> Objects.equals(e.getId(), update_id)).findFirst().orElse(null);
                                    if (update != null) {
                                        Stocks updateStock = new Stocks().AddStock(scanner);
                                        StocksRepository.setUpdateStock(updateStock, update_id);
                                        System.out.println("You have successfully updated old stock!!");
                                    } else
                                        System.out.println("key(stock_id)=" + update_id + " is not present in table(stock)!");
                                }
                                case 3 -> {
                                    TableUtils.renderTable("Delete Old Stock", null);
                                    Integer delete_id = Invalidation.getInteger("Enter id you want to delete: ", scanner);
                                    List<Stocks> stocks = StocksRepository.getStocks();
                                    assert stocks != null;
                                    Stocks s_id = stocks.stream().filter(e -> Objects.equals(e.getId(), delete_id)).findFirst().orElse(null);
                                    if (s_id != null) {
                                        StocksRepository.setDeleteStock(delete_id);
                                        System.out.println("You have successfully deleted stock!!");
                                        break;
                                    }
                                    System.out.println("key(stock_id)=" + delete_id + " is not present in table(stock)!");
                                }
                                case 4 -> {
                                    Integer showOption;
                                    List<String> listShowOption = new ArrayList<>((Arrays.asList(
                                            "1. Show Ascending order (By stock_id)    ",
                                            "2. Show Ascending order (By pro_name)    ",
                                            "3. Show Ascending order (By manu_name)   ",
                                            "4. Show Ascending order (By cat_name)    ",
                                            "5. Show Descending order (By Total Price)",
                                            "6. Exit from showing application...!     "
                                    )));
                                    do {
                                        TableUtils.renderTable("Show All Product in Stock", listShowOption);
                                        showOption = Invalidation.getInteger("Please choose one: ", scanner);
                                        switch (showOption) {
                                            case 1 -> {
                                                TableUtils.renderTable("Show Ascending order (By stock_id)", null);
                                                List<Stocks> showById = StocksRepository.getStocks();
                                                assert showById != null;
                                                List<Stocks> stocks = showById.stream().sorted(Comparator.comparing(Stocks::getId)).toList();
                                                TableUtils.readStockData(stocks);
                                            }
                                            case 2 -> {
                                                TableUtils.renderTable("Show Ascending order (By Pro_name)", null);
                                                List<Stocks> showByProductName = StocksRepository.getStocks();
                                                assert showByProductName != null;
                                                List<Stocks> stocks = showByProductName.stream().sorted(Comparator.comparing(Stocks::getPro_name)).toList();
                                                TableUtils.readStockData(stocks);
                                            }
                                            case 3 -> {
                                                TableUtils.renderTable("Show Ascending order (By Manu_name)", null);
                                                List<Stocks> showByManuName = StocksRepository.getStocks();
                                                assert showByManuName != null;
                                                List<Stocks> stocks = showByManuName.stream().sorted(Comparator.comparing(Stocks::getManu_name)).toList();
                                                TableUtils.readStockData(stocks);
                                            }
                                            case 4 -> {
                                                TableUtils.renderTable("Show Ascending order (By Pro_name)", null);
                                                List<Stocks> showByCategoryName = StocksRepository.getStocks();
                                                assert showByCategoryName != null;
                                                List<Stocks> stocks = showByCategoryName.stream().sorted(Comparator.comparing(Stocks::getCat_name)).toList();
                                                TableUtils.readStockData(stocks);
                                            }
                                            case 5 -> {
                                                TableUtils.renderTable("Show Descending order (By Total Price)", null);
                                                List<Stocks> showByTotalPrice = StocksRepository.getStocks();
                                                assert showByTotalPrice != null;
                                                List<Stocks> stocks = showByTotalPrice.stream().sorted(Comparator.comparing(Stocks::getTotal_price).reversed()).toList();
                                                TableUtils.readStockData(stocks);
                                            }
                                            case 6 -> System.out.println("Exit from showing application!!");
                                            default ->
                                                    System.out.println("Invalid input! Enter a valid option please!!");
                                        }
                                    } while (showOption != 6);
                                }
                                case 5 -> System.out.println("Exiting from Stock application...!");
                                default -> System.out.println("Invalid option! Enter valid option please...!!");
                            }
                        } while (stockOption != 5);
                    }
                    case 6 -> System.out.println("Exiting from management system  application...!");
                    default -> System.out.println("Invalid option! Enter valid option please...!!");
                }
            } while (option != 6);
        }
    }
}