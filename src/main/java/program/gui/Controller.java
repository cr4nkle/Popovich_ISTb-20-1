package main.java.program.gui;

import program.gui.window.BarcodeInputWindow;
import program.gui.window.ReceiptOutputWindow;
import program.model.Cashier;
import program.model.Product;
import program.utility.CancelBuffer;
import program.utility.constant.Constant;
import program.database.DataRepository;
import program.utility.encryption.Encrypt;
import program.gui.window.AuthenticationWindow;
import program.gui.window.View;
import program.model.Store;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private int flag;
    private boolean pressFlag = false;//флаг для понимания нажата ли кнопка
    private String infoText = "";
    private View view;
    private Store store = Store.getInstance();//добавить поле с базой данных
    private DataRepository dataBase = DataRepository.getInstance();
    private int discountValue = 0;
    private float totalPrice = 0;
    private CancelBuffer buffer;

    public Controller(){

    }

    private void demonstration(String flag){
        if(pressFlag){//если была нажата почисть поле
            infoText = "";
            pressFlag = false;
        }
        infoText += flag;
        view.getInfoField().setText(infoText);
    }
    public void execute(){
        press();
        view.getTable().setModel(view.getBasketTableModel());
        view.getCodeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                infoText = "Введите код:";
                flag = 4;
                pressFlag = true;
                view.getInfoField().setText(infoText);
            }
        });
//запихнуть всё в список, посмотреть как узнать какая кнопка в списке была нажата
        view.getQuantityButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                infoText = "Введите кол-во:";
                flag = 1;
                pressFlag = true;
                view.getInfoField().setText(infoText);
            }
        });

        view.getResultButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {//показ итоговой суммы
                infoText = "Итоговая сумма:";
                getResultPrice();
                view.getInfoField().setText(infoText + " " + totalPrice + Constant.RUB);
                flag = 0;
                pressFlag = false;
            }
        });

        view.getDiscountButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                infoText = "Введите размер скидки:";
                flag = 5;
                pressFlag = true;
                view.getInfoField().setText(infoText);
            }
        });

        view.getPayButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                infoText = "Введите сумму оплаты:";
                flag = 6;
                pressFlag = true;
                view.getInfoField().setText(infoText);
            }
        });

        view.getCancelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int index = view.getTable().getSelectedRow();
                try {
                    if (index == -1)
                        throw new Exception("Строка не выбрана!!");
                    store.deleteProduct(store.getProduct(index).getCode());
                    view.getBasketTableModel().change();
                    flag = 3;
                    pressFlag = true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(view,
                            e.getMessage(),
                            "Ошибка", JOptionPane.WARNING_MESSAGE, null);
                }

            }
        });

        view.getEndButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{

                    dataBase.closeDB();
                    flag = 0;
                }catch (Exception e){
                    JOptionPane.showMessageDialog(view,
                            e.getMessage(),
                            "Ошибка", JOptionPane.WARNING_MESSAGE, null);
                }

            }
        });

        view.getEnterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String result = view.getInfoField().getText();
                try {
                    switch (flag){
                        case 1://показ таблицы корзины с нужным кол-вом товара кнопка кол-во
                            //проверка количества продукта
                            int index = view.getTable().getSelectedRow();
                            if (index == -1)
                                throw new Exception("Строка не выбрана!!");
                            Product product = store.getProduct(index);//получили продукт из списка магазина
                            checkQuantity(Integer.parseInt(result),product);
                            product.setQuantity(Integer.parseInt(result));//задаём новое значение количеству//одна ссылка на объект
                            view.getBasketTableModel().change();//попросили модель таблицы обновиться
                            showMessage();
                            view.getInfoField().setText("");
                            flag = 0;
                            break;
                        case 2://штрих-код
                            BarcodeInputWindow barcodeInputWindow = new BarcodeInputWindow();
                            executeInputWindow(barcodeInputWindow);
                            store.addProduct(dataBase.copyProduct(Integer.parseInt(result)));//передаём расшифрованный код
                            view.getBasketTableModel().change();
                            showMessage();
                            break;
                        case 3:

                            break;
                        case 4://поиск по введенному коду показ в таблицу продукта кнопка код
                            store.addProduct(dataBase.copyProduct(Integer.parseInt(result)));
                            view.getBasketTableModel().change();
                            showMessage();
                            view.getInfoField().setText("");
                            flag = 0;
                            break;
                        case 5://сделать ограничение ввода скидки кнопка скидка
                            discountValue = Integer.parseInt(result);
                            if (discountValue < 0 || discountValue > Constant.DISCOUNT_LIMIT)
                                throw new Exception("Не корректное значение скидки!!");
                            showMessage();
                            view.getInfoField().setText("");
                            flag = 0;
                            break;
                        case 6://отправка запроса на удаление продуктов из бд кнопка оплата
                            buffer = new CancelBuffer(store.getBasketList());
                            //запускать метод генерации текста на чеке
                            System.out.println(getChange(Float.parseFloat(result)));//сдача

                            System.out.println(totalPrice);//передавать чеку
                            //получать айди продавца
                            //dataBase.payment(store.getId(), (int) totalPrice);//
                            view.getInfoField().setText("");
                            showMessage();
                            updateQuantity();//кол-во которое осталось
                            new ReceiptOutputWindow();
                            flag = 0;
                            store.deleteAllProduct();//проверка вдруг количество товара 0
                            view.getBasketTableModel().change();//показ чека и очищение таблицы отправка запросов в бд
                            totalPrice = 0;
                            discountValue = 0;//разобраться с запросом обновления
                            break;
                    }
                }catch (NumberFormatException ne) {
                    view.getInfoField().setText("");
                    JOptionPane.showMessageDialog(view,
                            "Неверный формат ввода!!",
                            "Ошибка", JOptionPane.WARNING_MESSAGE, null);
                }catch (NullPointerException e){
                    System.out.println(e.getMessage());
                }catch(Exception e){
                    view.getInfoField().setText("");
                    JOptionPane.showMessageDialog(view,
                            e.getMessage(),
                            "Ошибка", JOptionPane.WARNING_MESSAGE, null);
                    if (e.getMessage().equals("Не корректное значение скидки!!")){
                        view.getInfoField().setText("");
                        discountValue = 0;
                    }
                }
            }
        });

        view.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                infoText = "";
                flag = 0;
                view.getInfoField().setText(infoText);
            }
        });

    }

    private int updateQuantity() throws Exception {
        int code;
        int quantity = 0;
        for (int i = 0; i < store.getProductListSize(); i ++){
            code = store.getBasketList().get(i).getCode();
            quantity = dataBase.searchProduct(code).getQuantity() - store.getBasketList().get(i).getQuantity();
            dataBase.searchProduct(code).setQuantity(quantity);
        }
        return quantity;
    }

    private void checkQuantity(int enterQuantity, Product product) throws Exception {
        Product tempProduct = dataBase.searchProduct(product.getCode());
        int temp = tempProduct.getQuantity();
        if (enterQuantity == 0)
            throw new Exception("Количество ровняется нулю!!");
        if (temp == 0)
            throw new Exception("Товар закончился на складе!!");
        if (enterQuantity >= temp)
            throw new Exception("На складе не хватает товара!!");
    }

    private void showMessage(){
        JOptionPane.showMessageDialog(view,
                "Значение успешно введено",
                "Окно сообщения", JOptionPane.INFORMATION_MESSAGE, null);
    }

    private void press(){
        view.getButton1().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    demonstration("1");
                }
            });

        view.getButton2().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    demonstration("2");
                }
            });

        view.getButton3().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    demonstration("3");
                }
            });

        view.getButton4().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    demonstration("4");
                }
            });

        view.getButton5().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    demonstration("5");
                }
            });

        view.getButton6().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    demonstration("6");
                }
            });

        view.getButton7().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    demonstration("7");
                }
            });

        view.getButton8().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    demonstration("8");
                }
            });

        view.getButton9().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    demonstration("9");
                }
            });

        view.getZeroButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    demonstration("0");
                }
            });

        view.getDoubleZeroButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    demonstration("00");
                }
            });

        view.getDotButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    demonstration(".");
                }
            });

    }

    public void executeAuthenticationWindow(AuthenticationWindow window){
        window.getAuthenticationButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                boolean login = false;
                String name = window.getLoginField().getText();
                try {
                    login = login(name, window.getPasswordField().getText());
                    if (login){
                        setView(new View());
                        execute();
                        view.getCashierField().setText("Кассир:" + dataBase.searchCashierByLogin(name).getName() + " ");
                        window.dispose();
                    }else{
                        JOptionPane.showMessageDialog(view,
                                "Вы ввели неверный пароль!!",
                                "Окно сообщения", JOptionPane.INFORMATION_MESSAGE, null);
                        window.getPasswordField().setText("");
                    }
                } catch (Exception e) {
                    window.getLoginField().setText("");
                    JOptionPane.showMessageDialog(view,
                            "Кассир не найден!!",
                            "Окно сообщения", JOptionPane.INFORMATION_MESSAGE, null);
                }
            }
        });
    }

    private void setView(View view){
        this.view =view;
    }

    private boolean login(String login, String password) throws Exception{
        boolean checkFlag = false;
        Cashier tempCashier = dataBase.searchCashierByLogin(login);
        if (tempCashier.getPassword().equals(Encrypt.encrypt(password))){
            store.setCashier(tempCashier);
            checkFlag = true;
        }
        return checkFlag;
    }

    private void getResultPrice() {
        float temp = 0;
        int price = 0;
        int quantity = 0;
        for (Product p : store.getBasketList()) {
            price = p.getPrice();
            quantity = p.getQuantity();
            temp += quantity * price;
        }
        totalPrice = temp - (temp * discountValue) / 100;
    }

    private double getChange(double enterAmount) throws Exception {
        getResultPrice();
        if(enterAmount < totalPrice)
            throw new Exception("Введено недостаточное кол-во денежных средств!!");
        double res = enterAmount - totalPrice;
        return res;
    }

    public void executeInputWindow(BarcodeInputWindow window){

    }

    public void executeOutputWindow(ReceiptOutputWindow window){

    }
    private float countDiscountValue(){
        float temp = totalPrice - (totalPrice * discountValue) / 100;
        return temp;
    }
}
