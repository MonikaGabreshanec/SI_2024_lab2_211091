#  Моника Габрешанец 211091

## 2.Control Flow Graph 
Мојот нацртан CFG е во документацијата(CFG.png)

## 3.Цикломатската комплексност 
Цикломатската комплексност на дадениот код може да ја пресметаме со тоа што ќе ги пресметаме бројот на јазли N и бројот на ребра Е:

-Почетокот на функцијата. (1 јазол)

-if наредба каде се проверува условот (allItems == null). (1 јазол, 2 гранки)

-Прв for циклус кои ги итерира сите предмети од листата. (1 јазол, 2 гранки)

  - Прва if наредба во првиот for циклус кој го проверува условот (item.getName() == null || item.getName().length() == 0). (1 јазол, 2 гранки)

  - Втора if наредба во првиот for циклус кој го проверува условот (item.getBarcode() != null). (1 јазол, 2 гранки)

-Втор for  циклус во кој се итерира секој карактер во item.getBarcode(). (1 јазол, 2 гранки)

   - if наредба во вториот for циклус кој го проверува условот (allowed.indexOf(c) == -1). (1јазол, 2 гранки)

-Трета if наредба во првиот for циклус кој го проверува условот  (item.getDiscount() > 0). (1 јазол, 2 гранки).

-Четврта if наредба во првиот for циклус кој го проверува условот (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'). (1 јазол, 2 гранки)

-if наредба каде се проверува условот (sum <= payment). (1 јазол, 2 гранки)

-Крај на функцијата. (1 јазол)

N=11,E=18 
#### М = E - N + 2 P = 18 - 11 + 2 = 9

## 4.Тест случаи според Every Branch критериумот
Тест сценаријата за секоја гранка во кодот:

1.Тест кога allItems е null - Ова треба да фрли RuntimeException. 

2.Тест кога item.getName() e null - Функцијата треба од null името на предметот да го постави "unknown".

3.Тест кога item.getName().length() е 0 - Функцијата треба од празно поле за името на предметот да го постави "unknown".

4.Тест кога item.getBarcode() е null - Ова треба да фрли RuntimeException.

5.Тест кога баркодот има невалиден карактер - Ова треба да фрли RuntimeException.

6.Тест кога item.getDiscount() > 0 - Ова треба да ја зголеми sum(price*discount).

7.Тест кога item.getDiscount() <= 0 - Ова треба да ја додаде цената во sum.

8.Тест кога item.getPrice() e поголемо од 300 ,item.getDiscount() е поголемо од 0,item.getBarcode().charAt(0) == '0' - Ова треба да ја намали сумата за 30.

9.Тест кога item.getPrice() e помало или еднакво 300 ,item.getDiscount() е поголемо од 0,item.getBarcode().charAt(0) == '0' - Сумата не се намалува.

10Тест кога item.getPrice() e поголемо од 300 ,item.getDiscount() е помало или еднакво на 0,item.getBarcode().charAt(0) == '0' - Сумата не се намалува.

11.Тест кога item.getPrice() e поголемо од 300 ,item.getDiscount() е поголемо од 0,item.getBarcode().charAt(0) == '0' - Сумата не се намалува.

12.Тест кога sum <= payment - Ова треба да врати true.

13.Тест кога sum > payment - Ова треба да врати false.

## 5.Тест случаи според критериумот Multiple Condition

Во функцијата checkCart,го имаме условот if(item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0)
== '0') кој проверува три услови заедно со користење на логичкиот оператор AND (&&). Проверува дали item.getPrice() е поголемо од 300, item.getDiscount() е поголемо од 0 и item.getBarcode() дали започнува на '0'.Со Multiple Condition Test ги покривам можните комбинации на сите тест случаеви на условот.

1.Тест кога item.getPrice() e поголемо од 300 ,item.getDiscount() е поголемо од 0,item.getBarcode().charAt(0) == '0' - Ова треба да ја намали сумата за 30.

2.Тест кога item.getPrice() e помало или еднакво 300 ,item.getDiscount() е поголемо од 0,item.getBarcode().charAt(0) == '0' - Сумата не се намалува.

3.Тест кога item.getPrice() e поголемо од 300 ,item.getDiscount() е помало или еднакво на 0,item.getBarcode().charAt(0) == '0' - Сумата не се намалува.

4.Тест кога item.getPrice() e поголемо од 300 ,item.getDiscount() е поголемо од 0,item.getBarcode().charAt(0) =! '0' - Сумата не се намалува.

5.Тест кога item.getPrice() e поголемо од 300 ,item.getDiscount() е помало или еднакво на 0,item.getBarcode().charAt(0) != '0' - Сумата не се намалува.

6.Тест кога item.getPrice() e помало или еднакво 300 ,item.getDiscount()  е помало или еднакво на 0,item.getBarcode().charAt(0) == '0' - Сумата не се намалува.

7.Тест кога item.getPrice() e помало или еднакво 300 ,item.getDiscount() е поголемо од 0,item.getBarcode().charAt(0) != '0' - Сумата не се намалува.

8.7.Тест кога item.getPrice() e помало или еднакво 300 ,item.getDiscount() е помало или еднакво на 0,item.getBarcode().charAt(0) != '0'-Сумата не се намалува.

## Објаснување на напишаните unit tests
Функциите за тестирање во SILab2Test.java се поделени во testEveryBranchCriterium() каде ми се опфатени сите тест сценарија кои се опишани и дефинирани во подточката  _4.Тест случаи според Every Branch критериумот_.

Во testMultipleConditionCriterium() ми се опфатени сите тест сценарија кои се опишани и дефинирани во подточката  _5.Тест случаи според критериумот Multiple Condition_.






