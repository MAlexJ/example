
 Регулярные выражения (англ. regular expressions) — формальный язык поиска
 и осуществления манипуляций с подстроками в тексте, основанный на
 использовании метасимволов (символов-джокеров, англ. wildcard characters).

 Метасимволы

 Примеры основных метасимволов:
 ^     -  начало проверяемой строки
 $     -  конец проверяемой строки
 .     -  представляет собой сокращенную форму записи для символьного класса, совпадающего с любым символом
 |     -  означает «или». Подвыражения, объединенные этим способом, называются альтернативами (alternatives)
 ?     -  означает, что предшествующий ему символ является необязательным
 +     -  обозначает «один или несколько экземпляров непосредственно предшествующего элемента
 –  любое количество экземпляров элемента (в том числе и нулевое)
 \\d   –  цифровой символ
 \\D   –  не цифровой символ
 \\s   –  пробельный символ
 \\S   –  не пробельный символ
 \\w   –  буквенный или цифровой символ или знак подчёркивания
 \\W   –  любой символ, кроме буквенного или цифрового символа или знака подчёркивания


 Символьные классы

 Символьный класс - определяет перечень символов которые могут быть (или НЕ могут)
 на месте данного символа.

 Символьный класс соответствует одиночному символу обрабатываемой строки,
 причем сам символ должен содержаться в наборе, определяемым классом.
 К примеру, символьный класс [aeiou] соответствует любой гласной букве
 в нижнем регистре(Это будет только одна буква из перечня).



 Символьные классы

 Символьный класс - определяет перечень символов которые могут быть (или НЕ могут)
 на месте данного символа.

 Символьный класс соответствует одиночному символу обрабатываемой строки,
 причем сам символ должен содержаться в наборе, определяемым классом.
 К примеру, символьный класс [aeiou] соответствует любой гласной букве
 в нижнем регистре(Это будет только одна буква из перечня).


 Квантификаторы

 Регулярные выражения предоставляют инструменты позволяющие указать сколько раз может повторятся один или несколько символов. С некоторыми мы уже встречались:

 +     - Одно или более
 *     - Ноль или более
 ?     - Ноль или одно
 {n}   - Ровно n раз
 {m,n} - От m до n включительно
 {m,}  - Не менее m
 {,n}  - Не более n

 Теперь мы можем полностью понять регулярное выражение: "^[a-z0-9_-]{3,15}$" .
 Разберем её по кусочкам:
 ^ - начало строки
 [a-z0-9_-] - символ который может быть маленькой латинской буквой или цифрой или символом подчеркивания.
 {3,15} - предыдущий объект(смотри выше) может повторяться от 3х до 15раз.


