package program.gui;

import program.model.Product;
import program.utility.constant.Constant;
import program.utility.database.DataBase;
import program.utility.encryption.Encrypt;
import program.gui.window.AuthenticationWindow;
import program.gui.window.View;
import program.model.Store;
import program.gui.tablemodel.BasketTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private int flag;
    private boolean pressFlag = false;//флаг для понимания нажата ли кнопка
    private String infoText = "";
    private View view;
    private Store store;//добасить поле с базой данных
    private DataBase dataBase;
    private int discountValue = 0;
    private float totalPrice = 0;

    public Controller(View view, Store store){
        this.view = view;
        this.store = store;
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
        view.getBasketTableModel().setStore(store);
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
                //запуск вычислений
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

        view.getEnterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String result = view.getInfoField().getText();
                switch (flag){
                    case 1://показ таблицы корзины с нужным кол-вом товара
                        //проверка количества продукта
                        System.out.println(result);//вывод в консоль для отладки
                        break;
                    case 2://штрих-код
                        break;
                    case 3:
                        break;
                    case 4://поиск по введенному коду показ в таблицу продукта
                        store.addProduct(dataBase.searchProduct(Integer.parseInt(result)));
                        view.getBasketTableModel().change();
                        break;
                    case 5://сделать ограничение ввода скидки
                        discountValue = Integer.parseInt(result);
                        view.getInfoField().setText("");
                        break;
                    case 6:
                        store.deleteAllProduct();
                        view.getBasketTableModel().change();//отправка запроса на удаление продуктов из бд
                        System.out.println(Float.parseFloat(result));//показ чека и очищение таблицы отправка запросов в бд
                        totalPrice = 0;
                        break;
                }
                flag = 0;
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
                try {
                    login = login(window.getLoginField().getText(), window.getPasswordField().getText());
                    if (login){
                        view.setVisible(true);
                        view.getCashierField().setText("Кассир:" + window.getLoginField().getText() + " ");
                        window.dispose();
                    }else{
                        System.out.println("no");
                        //добавить окошко с ошибкой
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("нет кассира");
                }


            }
        });
    }

    private boolean login(String fullName, String password) throws Exception{
        boolean checkFlag = false;
        if (store.getCashier(fullName).getPassword().equals(Encrypt.encrypt(password))){
            checkFlag = true;
        }
        return checkFlag;
    }

    private void getResultPrice(){
        float temp = 0;
        if(discountValue < Constant.DISCOUNT_LIMIT) {
            int price = 0;
            int quantity = 0;
            for (Product p : store.getProductList()) {
                price = p.getPrice();
                quantity = p.getQuantity();
                temp += quantity * price;
            }
            totalPrice = temp - (temp * discountValue) / 100;
        }else {
            System.out.println("слишком большая скидка");
        }
    }

    public void setDataBase(DataBase dataBase){
        this.dataBase = dataBase;
    }
}
