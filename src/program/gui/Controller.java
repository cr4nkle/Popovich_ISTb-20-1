package program.gui;

import program.tablemodel.BasketTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private static int flag;
    private boolean pressFlag = false;//флаг для понимания нажата ли кнопка
    private String infoText = "";
    private View view;

    public Controller(View view){
        this.view = view;
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
        view.setVisible(false);
        press();
        view.getTable().setModel(new BasketTableModel());
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
            public void actionPerformed(ActionEvent actionEvent) {
                infoText = "Итоговая сумма:";
                view.getInfoField().setText(infoText);
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
                        System.out.println(result);
                        break;
                    case 2://штрих-код
                        break;
                    case 3:
                        break;
                    case 4://поиск по введенному коду показ в таблицу продукта
                        System.out.println(result);
                        break;
                    case 5:
                        System.out.println(result);
                        break;
                    case 6:
                        System.out.println(Float.parseFloat(result));//показ чека и очищение таблицы отправка запросов в бд
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
                view.setVisible(true);
                window.dispose();
            }
        });

        window.getLoginField();
        window.getPasswordField();

    }
}
