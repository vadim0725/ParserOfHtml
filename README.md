## Статистика уникальных слов на HTML- странице
Приложение, которое позволяет скачивать произвольную HTML-страницу
посредством HTTP-запроса на жесткий диск компьютера и выдает статистику по
количеству уникальных слов в консоль.
## Руководство пользователя
1. Необходимо скачать проект c GitHub: **"Download ZIP"**.
2. Далее распаковываем архив.
3. В папке с проектом, где находится файл **pom.xml**, открываем командную строку 
(на **Windows**, это делается следующим образом: зажатием клавиши **Shift** нажимаем правую кнопку мыши, из выпадающего списка выбираем "**Открыть окно команд**").
Для того чтобы все уникальные слова помещались в командной строке, нужно нажать правой кнопкой мыши в левом верхнем углу на иконку командной строки, открыть свойство, в разделе "Расположение" увеличить высоту размера буфера экрана на "9999" (для Windows).
4. Далее в командной строке выполните команду maven:

    ```mvn clean install```
5. После этого переходим в папку **target** и запускаем jar файл, для этого в командной строке выполните:

    ```cd target/```
    
    ```java -jar parserOfHtml-1.0-SNAPSHOT.jar```                      
6. Приложение запросит ввести строку с адресом web-страницы. Пример входной строки: 

    ```https://www.simbirsoft.com/```                              
7. Файл с HTML-страницей сохраняется автоматически в папку **target**.
8. Если был указан некорректный адрес web-страницы **повторно начать со второй команды пункта 5**. 
При возникновении ошибок, логирование производится через SLF4J, log4j в файл **applicationLog.log** в папке **target**.
9. При успешном выполнении команды в командную строку выведется статистика по количеству уникальных слов в тексте на HTML странице. Пример: 

``` 
готов - 1 
обязательства - 1 
медицинской - 2
Проявляют - 1
iOS - 1
найти - 1
Реализовали - 1
В - 3
включились - 1
...
``` 
                              
