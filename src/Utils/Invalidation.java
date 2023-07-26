package Utils;

import Model.*;
import Repository.*;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Invalidation {
    public static Integer getInteger(String message, Scanner scanner) {
        Integer number = null;
        while (true) {
            try {
                System.out.print(message);
                String value = scanner.nextLine();
                number = Integer.parseInt(value);
                if (number < 0) {
                    throw new IllegalAccessException("Number must be greater than zero.");
                }
                return number;
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException ex) {
                System.out.println("Input invalid! Only numbers & no letters please.");
            }
        }
    }

    public static Double getDouble(String message, Scanner scanner) {
        Double number = null;
        while (true) {
            try {
                System.out.print(message);
                String value = scanner.nextLine();
                number = Double.parseDouble(value);
                if (number <= 0) {
                    throw new IllegalAccessException("Number must be greater than zero.");
                }
                return number;
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException ex) {
                System.out.println("Input invalid! Only numbers & no letters please.");
            }
        }
    }

    public static String getName(String message, Scanner scanner) {
        String input = "";
        while (input.isEmpty()) {
            try {
                System.out.print(message);
                input = scanner.nextLine();
                if (input.matches("[a-zA-Z ]")) {
                    throw new IllegalAccessException("Please input only letters.");
                }

            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
        return input;
    }

    public static String getManufacturerName(String message, Scanner scanner) {
        String input = null;
        while (true) {
            try {
                System.out.print(message);
                input = scanner.nextLine();
                if (input.matches("[a-zA-Z ]")) {
                    throw new IllegalAccessException("Please input only letters.");
                }
                List<Manufacturer> manufacturers = ManufacturerRepository.getAllManufacturers();
                String finalInput = input;
                assert manufacturers != null;
                Manufacturer isNull = manufacturers.stream().filter(e -> e.getName().equals(finalInput)).findFirst().orElse(null);
                if (isNull == null) {
                    return finalInput;
                } else throw new SQLException("Error: Key (manu_name)=(" + finalInput + ") already exists.");
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String getCategoryName(String message, Scanner scanner) {
        String input = null;
        while (true) {
            try {
                System.out.print(message);
                input = scanner.nextLine();
                if (input.matches("[a-zA-Z ]")) {
                    throw new IllegalAccessException("Please input only letters.");
                }
                List<Category> categories = CategoryRepository.getCategories();
                String finalInput = input;
                assert categories != null;
                Category isNull = categories.stream().filter(e -> e.getName().equals(finalInput)).findFirst().orElse(null);
                if (isNull == null) {
                    return finalInput;
                } else throw new SQLException("Error: Key (cat_name)=(" + finalInput + ") already exists.");
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String getProductName(String message, Scanner scanner) {
        String input = null;
        while (true) {
            try {
                System.out.print(message);
                input = scanner.nextLine();
                if (input.matches("[a-zA-Z ]")) {
                    throw new IllegalAccessException("Please input only letters.");
                }
                List<Products> products = ProductRepository.getAllProducts();
                String finalInput = input;
                assert products != null;
                Products isNull = products.stream().filter(e -> e.getName().equals(finalInput)).findFirst().orElse(null);
                if (isNull == null) {
                    return finalInput;
                } else throw new SQLException("Error: Key (pro_name)=(" + finalInput + ") already exists.");
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String getUniqueName(String message, Scanner scanner) {
        String input = null;
        while (true) {
            try {
                System.out.print(message);
                input = scanner.nextLine();
                if (input.matches("[a-zA-Z ]")) {
                    throw new IllegalAccessException("Please input only letters.");
                }
                List<Users> users = UserRepository.getAllUsers();
                String finalInput = input;
                assert users != null;
                Users search_name = users.stream().filter(e -> e.getUsername().equals(finalInput)).findFirst().orElse(null);
                if (search_name == null) {
                    return finalInput;
                } else {
                    throw new SQLException("Error: Key (username)=(" + finalInput + ") already exists.");
                }
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String getString(String message, Scanner scanner) {
        String input = "";
        while (input.isEmpty()) {
            try {
                System.out.print(message);
                input = scanner.nextLine();
                if (!input.matches("[a-zA-Z0-9 ]+")) {
                    throw new IllegalAccessException("Input must contain only letters and numbers.");
                }
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }

    public static String getGender(String message, Scanner scanner) {
        String input = null;
        while (true) {
            try {
                System.out.print(message);
                input = scanner.nextLine();
                if (!(input.equalsIgnoreCase("male") || input.equalsIgnoreCase("female"))) {
                    throw new RuntimeException("Must input male or female!");
                }
                return input;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String getSignIn(String message, Scanner scanner) {
        String input;
        while (true) {
            try {
                System.out.print(message);
                input = scanner.nextLine();
                if (input.isEmpty()) {
                    throw new IllegalAccessException("Input must not be empty.");
                }
                return input;
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Boolean getBoolean(String message, Scanner scanner) {
        Boolean result = null;
        while (result == null) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                if (!input.equalsIgnoreCase("true") && !input.equalsIgnoreCase("false")) {
                    throw new IllegalArgumentException("Must input true or false");
                }
                result = Boolean.parseBoolean(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }

    // Method to set the madeAtDate field from user input and return the value
    public static Timestamp getTimestamp(String message, Scanner scanner) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            try {
                return Timestamp.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid timestamp format: " + input);
                System.out.println("Try again! yyyy-MM-dd HH:mm:ss.SS...!");
            }
        }
    }

    public static Integer getCheckProId(String message, Scanner scanner) throws SQLException {
        Integer number = null;
        List<Products> products = ProductRepository.getAllProducts();
        List<Stocks> stocks = StocksRepository.getStocks();
        while (true) {
            try {
                System.out.print(message);
                String value = scanner.nextLine();
                number = Integer.parseInt(value);
                if (number < 0) {
                    throw new IllegalAccessException("Number must be greater than zero.");
                }
                Integer finalNumber = number;
                assert products != null;
                Products pro_id = products.stream().filter(e -> Objects.equals(e.getId(), finalNumber)).findFirst().orElse(null);
                assert stocks != null;
                Stocks stock_proId = stocks.stream().filter(e -> Objects.equals(e.getPro_id(), finalNumber)).findFirst().orElse(null);
                if (pro_id != null && stock_proId == null) {
                    return number;
                } else {
                    throw new SQLException("key(pro_id)=" + number + " is not present or already exist!!");
                }
            } catch (IllegalAccessException | SQLException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException ex) {
                System.out.println("Input invalid! Only numbers & no letters please.");
            }
        }
    }

    public static Integer getCheckManuId(String message, Scanner scanner) throws SQLException {
        Integer number = null;
        List<Manufacturer> manufacturers = ManufacturerRepository.getAllManufacturers();
        while (true) {
            try {
                System.out.print(message);
                String value = scanner.nextLine();
                number = Integer.parseInt(value);
                if (number < 0) {
                    throw new IllegalAccessException("Number must be greater than zero.");
                }
                Integer finalNumber = number;
                assert manufacturers != null;
                Manufacturer pro_id = manufacturers.stream().filter(e -> Objects.equals(e.getId(), finalNumber)).findFirst().orElse(null);
                if (pro_id != null) {
                    return number;
                } else {
                    throw new SQLException("key(manu_id)=" + number + " is not present in table(manufacturer)!");
                }
            } catch (IllegalAccessException | SQLException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException ex) {
                System.out.println("Input invalid! Only numbers & no letters please.");
            }
        }
    }

    public static Integer getCheckCategoryId(String message, Scanner scanner) throws SQLException {
        Integer number = null;
        List<Category> categories = CategoryRepository.getCategories();
        while (true) {
            try {
                System.out.print(message);
                String value = scanner.nextLine();
                number = Integer.parseInt(value);
                if (number < 0) {
                    throw new IllegalAccessException("Number must be greater than zero.");
                }
                Integer finalNumber = number;
                assert categories != null;
                Category cat_id = categories.stream().filter(e -> Objects.equals(e.getId(), finalNumber)).findFirst().orElse(null);
                if (cat_id != null) {
                    return number;
                } else {
                    throw new SQLException("key(cat_id)=" + number + " is not present in table(category)!");
                }
            } catch (IllegalAccessException | SQLException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException ex) {
                System.out.println("Input invalid! Only numbers & no letters please.");
            }
        }
    }

    public static Integer getCheckUserId(String message, Scanner scanner) throws SQLException {
        Integer number = null;
        List<Users> users = UserRepository.getAllUsers();
        while (true) {
            try {
                System.out.print(message);
                String value = scanner.nextLine();
                number = Integer.parseInt(value);
                if (number < 0) {
                    throw new IllegalAccessException("Number must be greater than zero.");
                }
                Integer finalNumber = number;
                assert users != null;
                Users user_id = users.stream().filter(e -> Objects.equals(e.getId(), finalNumber)).findFirst().orElse(null);
                if (user_id != null) {
                    return number;
                } else {
                    throw new SQLException("key(user_id)=" + number + " is not present in table\"(user)\"!");
                }
            } catch (IllegalAccessException | SQLException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException ex) {
                System.out.println("Input invalid! Only numbers & no letters please.");
            }
        }
    }

    public static Integer getUpdateQty(String message, Integer update_id, Scanner scanner) throws SQLException {
        Integer number = null;
        Integer qty = null;
        List<Stocks> stocks = StocksRepository.getStocks();
        while (true) {
            try {
                System.out.print(message);
                String value = scanner.nextLine();
                number = Integer.parseInt(value);
                if (number < 0) {
                    throw new IllegalAccessException("Number must be greater than zero.");
                }
                assert stocks != null;
                Stocks stock_id = stocks.stream().filter(e -> Objects.equals(e.getId(), update_id)).findFirst().orElse(null);

                if (stock_id != null) {
                    qty = number + stock_id.getQty();
                    return qty;
                } else {
                    throw new SQLException("key(stock_id)=" + update_id + " is not present in table\"(stock)\"!");
                }
            } catch (IllegalAccessException | SQLException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException ex) {
                System.out.println("Input invalid! Only numbers & no letters please.");
            }
        }
    }
}
