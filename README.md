# Sort

Написать программу сортировки слиянием нескольких файлов.

Входные файлы содержат данные одного из двух видов: целые числа или строки. Данные записаны
в столбик (каждая строка файла – новый элемент). Строки могут содержать любые не пробельные
символы, строки с пробелами считаются ошибочными. Также считается, что файлы предварительно
отсортированы.

Результатом работы программы должен являться новый файл с объединенным содержимым
входных файлов, отсортированным по возрастанию или убыванию путем сортировки слиянием.
Если содержимое исходных файлов не позволяет произвести сортировку слиянием (например,
нарушен порядок сортировки), производится частичная сортировка (насколько возможно для этого
алгоритма, как именно обрабатывать поврежденный файл – на усмотрение разработчика).

Выходной файл должен содержать отсортированные данные даже в случае ошибок, однако
возможна потеря ошибочных данных.

Необходимо самостоятельно реализовать алгоритм сортировки методом слияния и использовать
его для сортировки содержимого файлов. Не использовать библиотечные функции сортировки.
Алгоритм должен быть устойчив к большим файлам, не помещающимся целиком в оперативную
память.

Все возможные виды ошибок должны быть обработаны. Программа не должна «падать». Если
после ошибки продолжить выполнение невозможно, программа должна сообщить об этом
пользователю с указанием причины неудачи. Частичная обработка при наличии ошибок более
предпочтительна чем останов программы. Код программы должен быть «чистым».

Параметры программы задаются при запуске через аргументы командной строки, по порядку:
1. режим сортировки (-a или -d), необязательный, по умолчанию сортируем по возрастанию;
2. тип данных (-s или -i), обязательный;
3. имя выходного файла, обязательное;
4. остальные параметры – имена входных файлов, не менее одного.

<h1>Запуск проекта</h1>
1. Клонирование репозитория на рабочий стол. Команда: git clone https://github.com/TheyCallMeZong/Sort.git
<br/>
2. Выполнение jar файла командой: java -jar Sort/out/artifacts/SHIFT_jar/SHIFT.jar -i/-s -a/-d (выходной файл) (файлы)
